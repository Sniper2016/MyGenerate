#!/bin/sh
ShellPath=$(cd "$(dirname "$0")"; pwd)


<@@@@@@println("我爱mygenerate模板服务框架，i am gameboys ："+t.getId());@@@@@@>


if [ $# == 0 ]
then
        Date=`date +%Y%m%d --date="-1 day"`
else
        Date=$1
fi


#下面是动态生成的语句
<@@@@@@
		println(t.getId());
		println(t.getIntList());
		for (int i = 0; i < 20; i++) {
			print(i + " ");
			println("sniper");
		}
@@@@@@>

