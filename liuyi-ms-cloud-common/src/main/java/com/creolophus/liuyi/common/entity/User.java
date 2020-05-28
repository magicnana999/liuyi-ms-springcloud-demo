package com.creolophus.liuyi.common.entity;

import com.creolophus.liuyi.common.base.AbstractEntity;
import io.swagger.annotations.ApiModelProperty;
import org.beetl.sql.core.annotatoin.AssignID;

import java.util.Date;


/**
* @author magicnana
* @date 2019-07-25
*/

public class User extends AbstractEntity {

	@AssignID
	private Long id ;
	private Integer decorate ;
	@ApiModelProperty(notes = "0：无效，1：有效")
	private Integer state ;
	@ApiModelProperty(notes = "1:付费会员 0：普通用户")
	private Integer type ;
	@ApiModelProperty(notes = "生日")
	private String birthday ;
	@ApiModelProperty(notes = "性别")
	private String gender ;
	@ApiModelProperty(notes = "头像")
	private String headImg ;
	@ApiModelProperty(notes = "昵称")
	private String nickName ;
	@ApiModelProperty(notes = "密码")
	private String password ;
	@ApiModelProperty(notes = "付费会员有效期截止")
	private Long payEnd ;
	@ApiModelProperty(notes = "手机号")
	private String phone ;
	private String platformKey ;
	@ApiModelProperty(notes = "备注信息")
	private String remarks ;
	@ApiModelProperty(notes = "创建时间")
	private Date createTime ;
	@ApiModelProperty(notes = "更新时间")
	private Date updateTime ;

	public User() {
	}

	public Long getId(){
		return  id;
	}
	public void setId(Long id ){
		this.id = id;
	}

	public Integer getDecorate(){
		return  decorate;
	}
	public void setDecorate(Integer decorate ){
		this.decorate = decorate;
	}

	public Integer getState(){
		return  state;
	}
	public void setState(Integer state ){
		this.state = state;
	}

	public Integer getType(){
		return  type;
	}
	public void setType(Integer type ){
		this.type = type;
	}

	public String getBirthday(){
		return  birthday;
	}
	public void setBirthday(String birthday ){
		this.birthday = birthday;
	}

	public String getGender(){
		return  gender;
	}
	public void setGender(String gender ){
		this.gender = gender;
	}

	public String getHeadImg(){
		return  headImg;
	}
	public void setHeadImg(String headImg ){
		this.headImg = headImg;
	}

	public String getNickName(){
		return  nickName;
	}
	public void setNickName(String nickName ){
		this.nickName = nickName;
	}

	public String getPassword(){
		return  password;
	}
	public void setPassword(String password ){
		this.password = password;
	}

	public Long getPayEnd(){
		return  payEnd;
	}
	public void setPayEnd(Long payEnd ){
		this.payEnd = payEnd;
	}

	public String getPhone(){
		return  phone;
	}
	public void setPhone(String phone ){
		this.phone = phone;
	}

	public String getPlatformKey(){
		return  platformKey;
	}
	public void setPlatformKey(String platformKey ){
		this.platformKey = platformKey;
	}

	public String getRemarks(){
		return  remarks;
	}
	public void setRemarks(String remarks ){
		this.remarks = remarks;
	}

	public Date getCreateTime(){
		return  createTime;
	}
	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}

	public Date getUpdateTime(){
		return  updateTime;
	}
	public void setUpdateTime(Date updateTime ){
		this.updateTime = updateTime;
	}

}
