//package org.demo.web.tags;
//
//import javax.servlet.jsp.tagext.TagSupport;
//
//import org.demo.api.constant.SysConstant;
//import org.demo.api.entity.dto.TbSysUserEntityDto;
//
//public class PrivilegeTag extends TagSupport  {
//	private static final long serialVersionUID = 1L;
//    private String privilege; //标签属性
//    public String getPrivilege() {
//        return privilege;
//    }
//
//    public void setPrivilege(String privilege) {
//        this.privilege = privilege;
//    }
//    @Override
//    public int doStartTag() {
//        user.setId("1");
//        if(user == null) return SKIP_BODY;
//        if (isManager(user)) return EVAL_BODY_INCLUDE;  //超级管理员获取所有权限
//        //boolean bResult = SecurityUtils.getSubject().isPermitted(privilege);//根据标签属性判断用户是否有此菜单功能权限，isPermitted的调用会触发doGetAuthorizationInfo方法
//       //判断是否有访问权限
//        if(privilege.equals("aaa")){
//        	
//            return EVAL_BODY_INCLUDE;
//        }
//        return SKIP_BODY;
//    }
//    /**
//     * 判断用户是否超级管理员
//     * @return
//     */
//    private boolean isManager(User user){
//    	Role role = new Role();
//    	role.setId(0);
//    	if(role.getId()==1){
//    		 return true;
//    	}
//    	
//        return false;
//
//    }
