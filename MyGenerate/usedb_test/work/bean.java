package cn.gameboys.generate.bean;

import java.util.Date;

/**
 * Description:�����Ϣ
 * 
 * @author sniper(www.gameboys.cn)
 * @date 2019��9��9��
 */
public class UserInfo {




//���ID
private Integer id;
//�������
private String name;
//������
private Integer age;
//���ѧУ����
private String schoolName;
//�������
private Date birthDay;
//set ���ID
	public void setId (Integer id) {
		this.id=id;
	}

//get ���ID
	public Integer getId (){
		return id;
	}
//set �������
	public void setName (String name) {
		this.name=name;
	}

//get �������
	public String getName (){
		return name;
	}
//set ������
	public void setAge (Integer age) {
		this.age=age;
	}

//get ������
	public Integer getAge (){
		return age;
	}
//set ���ѧУ����
	public void setSchoolName (String schoolName) {
		this.schoolName=schoolName;
	}

//get ���ѧУ����
	public String getSchoolName (){
		return schoolName;
	}
//set �������
	public void setBirthDay (Date birthDay) {
		this.birthDay=birthDay;
	}

//get �������
	public Date getBirthDay (){
		return birthDay;
	}



}
