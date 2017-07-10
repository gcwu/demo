package org.demo.api.entity;


import java.util.Date;
public class TbSysUserEntity  implements java.io.Serializable{

	private static final long serialVersionUID = 8375863634191864998L;

	/**
     * id
     */
     private Integer id;

    /**
     * 用户名
     */
     private String loginName;

    /**
     * 登录密码
     */
     private String password;

    /**
     * 用户类型; 1-系统管理员，2-普通用户
     */
     private String userType;

    /**
     * 状态  0-冻结 1-正常
     */
     private String status;

    /**
     * 最后一次登录时间
     */
     private Date lastLoginTime;

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
     private String updateUser;

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
    public String getLoginName(){

        return this.loginName;
    }
    public void setLoginName(String loginName){

        this.loginName = loginName;
    }
    public String getPassword(){

        return this.password;
    }
    public void setPassword(String password){

        this.password = password;
    }
    public String getUserType(){

        return this.userType;
    }
    public void setUserType(String userType){

        this.userType = userType;
    }
    public String getStatus(){

        return this.status;
    }
    public void setStatus(String status){

        this.status = status;
    }
    public Date getLastLoginTime(){

        return this.lastLoginTime;
    }
    public void setLastLoginTime(Date lastLoginTime){

        this.lastLoginTime = lastLoginTime;
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
    public String getUpdateUser(){

        return this.updateUser;
    }
    public void setUpdateUser(String updateUser){

        this.updateUser = updateUser;
    }
    public Date getUpdateTime(){

        return this.updateTime;
    }
    public void setUpdateTime(Date updateTime){

        this.updateTime = updateTime;
    }
}

