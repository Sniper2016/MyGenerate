#!/bin/sh
ShellPath=$(cd "$(dirname "$0")"; pwd)


if [ $# == 0 ]
then
        Date=`date +%Y%m%d --date="-1 day"`
else
        Date=$1
fi


#�������
updateSql="update test_userInfo set name='${name}',age='${age}',schoolName='${schoolName}',birthDay='${birthDay}' where id='${id}';"



#�������
selectSql="select * from  test_userInfo where id='${id}';"
	
		
		
		
#�������	
insertSql="INSERT INTO test_userInfo(id,name,age,schoolName,birthDay) VALUES ('${id}','${name}','${age}','${schoolName}','${birthDay}';"










