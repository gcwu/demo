package org.demo.api.util;



/** 
 * 实体生成器
* @author  wugongchang 
* @date 创建时间：2016年2月22日 上午10:24:19 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;



public class ReflectBean {
	//表名 
	private static String table = "tb_sys_menu";
	//列对应的注释
	private static Map<String, Object> res = new HashMap<String, Object>();
	
	private static Connection connection;
	/**
	 * 数据库链接
	 */
	private static String url = "jdbc:mysql://localhost:3306/mywork?useUnicode=true&characterEncoding=utf-8&useOldAliasMetadataBehavior=true";
	/**
	 * 用户名
	 */
	private static String user = "root";
	
	/**
	 * 密码
	 */
	private static String password = "root";
	//mysql jdbc
	private String driverClassName = "com.mysql.jdbc.Driver";
	
	private String[] colnames; 
	private String[] colTypes;
	public ReflectBean(){
		try {
			Class.forName(driverClassName);
			if (connection == null || connection.isClosed())
				connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				System.out.println("Oh,not");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Oh,not");
			}
	}
	
	public static Connection getConnection() {
		return connection;
	}

	public void doAction(){
		String sql = "select * from "+table;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSetMetaData metadata = statement.getMetaData();
			int len = metadata.getColumnCount();
			colnames = new String[len+1];
			colTypes = new String[len+1];
			for(int i= 1;i<=len;i++){
				//System.out.println(metadata.getColumnName(i)+":"+metadata.getColumnTypeName(i)+":"+sqlType2JavaType(metadata.getColumnTypeName(i).toLowerCase())+":"+metadata.getColumnDisplaySize(i));
				//metadata.getColumnDisplaySize(i);
				colnames[i] = metadata.getColumnName(i); 
				colTypes[i] = sqlType2JavaType(metadata.getColumnTypeName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private String sqlType2JavaType(String sqlType) {  
       
       if(sqlType.equalsIgnoreCase("bit")){  
           return "Boolean";  
       }else if(sqlType.equalsIgnoreCase("tinyint")){  
           return "Byte";  
       }else if(sqlType.equalsIgnoreCase("smallint")){  
           return "Short";  
       }else if(sqlType.equalsIgnoreCase("int")){  
           return "Integer";  
       }else if(sqlType.equalsIgnoreCase("bigint")){  
           return "Long";  
       }else if(sqlType.equalsIgnoreCase("float")){  
           return "Float";  
       }else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")   
               || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")   
               || sqlType.equalsIgnoreCase("smallmoney")){  
           return "Double";  
       }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")   
               || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")   
               || sqlType.equalsIgnoreCase("text")){  
           return "String";  
       }else if(sqlType.equalsIgnoreCase("datetime") ||sqlType.equalsIgnoreCase("date")){  
           return "Date";  
       }else if(sqlType.equalsIgnoreCase("image")){  
           return "Blod";  
       }  
         
       return null;  
   }

	public  StringBuffer getClassStr(){
		StringBuffer str = new StringBuffer("");
		this.doAction();
		if(null == colnames && null == colTypes) return null;
		
		str.append("\r\nimport java.util.Date;\n");
		//str.append("import javax.persistence.Column;\n");
		//str.append("import javax.persistence.Entity;\n");
		//str.append("import javax.persistence.Id;\r\n");
		str.append("\r\n");
		
		//str.append("@Entity(name = \""+table+"\")\n");
		String names[]=table.split("_");
		String className="";
		for(String s:names){
			className+=GetTuoFeng(s);
		}
		className+="Entity";
		str.append("public class "+className+"  implements java.io.Serializable{\r\n");
		for(int index=1; index < colnames.length ; index++){
			str.append(getAttrbuteString(colnames[index],colTypes[index]));
		}
		for(int index=1; index < colnames.length ; index++){
			str.append(getGetMethodString(colnames[index],colTypes[index]));
			str.append(getSetMethodString(colnames[index],colTypes[index]));
		}
		str.append("}\r\n");
		File file = new File(className+".java");
		BufferedWriter write = null;

		try {
			write = new BufferedWriter(new FileWriter(file));
			write.write(str.toString());
			write.close();
		} catch (IOException e) {

			e.printStackTrace();
			if (write != null)
				try {
					write.close();
				} catch (IOException e1) {			
					e1.printStackTrace();
				}
		}
		return str;
	}
	public StringBuffer getAttrbuteString(String name, String type) {
		if(!check(name,type)) {
			System.out.println("列名和类型为空");
			return null;
		};
		String format ="    /**\n";
		format+="     * ";
		format+=res.get(name)==null?name:res.get(name);
		format+="\n     */\n ";
		format += String.format("    private %s %s;\n\r", new String[]{type,name});
		return new StringBuffer(format);
	}
	public boolean check(String name, String type) {
		if("".equals(name) || name == null || name.trim().length() ==0){
			return false;
		}
		if("".equals(type) || type == null || type.trim().length() ==0){
			return false;
		}
		return true;
		
	}
	private StringBuffer getGetMethodString(String name, String type) {
		if(!check(name,type)) {
			System.out.println("列名和类型为空");
			return null;
		};
		String Methodname = "get"+GetTuoFeng(name);
		//String format = "    @Column(name = \""+name+"\")\n";
		String format =String.format("    public %s %s(){\n\r", new Object[]{type,Methodname});
		format += String.format("        return this.%s;\r\n", new Object[]{name});
		format += "    }\r\n";
		return new StringBuffer(format);
	}
	 String GetTuoFeng(String name) {
		name = name.trim();
		if(name.length() > 1){
			name = name.substring(0, 1).toUpperCase()+name.substring(1);
		}else
		{
			name = name.toUpperCase();
		}
		return name;
	}
	private Object getSetMethodString(String name, String type) {
		if(!check(name,type)) {
			System.out.println("列名和类型为空");
			return null;
		};
		String Methodname = "set"+GetTuoFeng(name);
		
		String format = String.format("    public void %s(%s %s){\n\r", new Object[]{Methodname,type,name});
		format += String.format("        this.%s = %s;\r\n", new Object[]{name,name});
		format += "    }\r\n";
		return new StringBuffer(format);
	}
	 /** 
     * 获得某表中所有字段的注释 
     * @param tableName 
     * @return 
     * @throws Exception 
     */  
    public static Map<String, Object> getColumnCommentByTableName(String table) throws Exception {  
        Map<String, Object> res = new HashMap<String, Object>();  
        Connection conn = getConnection();  
        Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery("show full columns from " + table);  
          if (rs != null && rs.next()) {  
            while (rs.next()) {     
                res.put(rs.getString("Field"), rs.getString("Comment"));
            }   
          }  
        rs.close();  
        stmt.close();  
      return res;  
    }  
	public static void main(String[] args) throws Exception {
		ReflectBean bean = new ReflectBean();
		res=getColumnCommentByTableName(table);
		
		System.err.println(bean.getClassStr());
	}
	
}
