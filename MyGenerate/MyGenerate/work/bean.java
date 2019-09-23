package cn.gameboys.generate.bean;

import java.util.Date;

/**
 * Description:玩家信息
 * 
 * @author sniper(www.gameboys.cn)
 * @date 2019年9月9日
 */
public class UserInfo {




//玩家ID
private Integer id;
//玩家名字
private String name;
//玩家年纪
private Integer age;
//玩家学校名称
private String schoolName;
//玩家生日
private Date birthDay;
//set 玩家ID
	public void setId (Integer id) {
		this.id=id;
	}

//get 玩家ID
	public Integer getId (){
		return id;
	}
//set 玩家名字
	public void setName (String name) {
		this.name=name;
	}

//get 玩家名字
	public String getName (){
		return name;
	}
//set 玩家年纪
	public void setAge (Integer age) {
		this.age=age;
	}

//get 玩家年纪
	public Integer getAge (){
		return age;
	}
//set 玩家学校名称
	public void setSchoolName (String schoolName) {
		this.schoolName=schoolName;
	}

//get 玩家学校名称
	public String getSchoolName (){
		return schoolName;
	}
//set 玩家生日
	public void setBirthDay (Date birthDay) {
		this.birthDay=birthDay;
	}

//get 玩家生日
	public Date getBirthDay (){
		return birthDay;
	}



}
