package org.demo.api.entity;


import java.util.Date;

public class TbSysMenuEntity  implements java.io.Serializable{
	private static final long serialVersionUID = -2176671153983888631L;

	/**
     * id
     */
     private Integer id;

    /**
     * 菜单编码
     */
     private String code;

    /**
     * 菜单名称
     */
     private String name;

    /**
     * 菜单请求路径
     */
     private String url;

    /**
     * 父菜单主键
     */
     private Integer parentId;

    /**
     * 菜单级别
     */
     private Integer level;

    /**
     * 顺序号
     */
     private Integer seq;

    /**
     * 状态;1-有效，0-无效
     */
     private String status;

    /**
     * 描述 
     */
     private String remark;

    /**
     * 创建人 
     */
     private String createUser;

    /**
     * 创建时间 
     */
     private Date createTime;

    /**
     * 更新人
     */
     private String updeteUser;

    /**
     * 更新时间
     */
     private Date updateTime;

    public Integer getId(){

        return this.id;
    }
    public void setId(Integer id){

        this.id = id;
    }
    public String getCode(){

        return this.code;
    }
    public void setCode(String code){

        this.code = code;
    }
    public String getName(){

        return this.name;
    }
    public void setName(String name){

        this.name = name;
    }
    public String getUrl(){

        return this.url;
    }
    public void setUrl(String url){

        this.url = url;
    }
    public Integer getParentId(){

        return this.parentId;
    }
    public void setParentId(Integer parentId){

        this.parentId = parentId;
    }
    public Integer getLevel(){

        return this.level;
    }
    public void setLevel(Integer level){

        this.level = level;
    }
    public Integer getSeq(){

        return this.seq;
    }
    public void setSeq(Integer seq){

        this.seq = seq;
    }
    public String getStatus(){

        return this.status;
    }
    public void setStatus(String status){

        this.status = status;
    }
    public String getRemark(){

        return this.remark;
    }
    public void setRemark(String remark){

        this.remark = remark;
    }
    public String getCreateUser(){

        return this.createUser;
    }
    public void setCreateUser(String createUser){

        this.createUser = createUser;
    }
    public Date getCreateTime(){

        return this.createTime;
    }
    public void setCreateTime(Date createTime){

        this.createTime = createTime;
    }
    public String getUpdeteUser(){

        return this.updeteUser;
    }
    public void setUpdeteUser(String updeteUser){

        this.updeteUser = updeteUser;
    }
    public Date getUpdateTime(){

        return this.updateTime;
    }
    public void setUpdateTime(Date updateTime){

        this.updateTime = updateTime;
    }
}

