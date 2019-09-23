#!/bin/sh
ShellPath=$(cd "$(dirname "$0")"; pwd)


if [ $# == 0 ]
then
        Date=`date +%Y%m%d --date="-1 day"`
else
        Date=$1
fi


#更新语句
<@@@@@@
		StringBuilder updateSb = new StringBuilder();
		updateSb.append("updateSql=\"update ");
		updateSb.append(t.getTableBean().getTableName() + " set ");
		boolean isFirst = true;
		for (ColumnBean columnBean : t.getColumns()) {
			if (!columnBean.getColumnKey().equals("PRI")) {
				if (!isFirst) {
					updateSb.append(",");
				}
				updateSb.append(columnBean.getColumnName() + "='${" + columnBean.getColumnName() + "}'");
				isFirst = false;
			}
		}
		updateSb.append(" where ");
		isFirst = true;
		for (ColumnBean columnBean :  t.getColumns()) {
			if (columnBean.getColumnKey().equals("PRI")) {
				if (!isFirst) {
					updateSb.append("and ");
				}
				updateSb.append(columnBean.getColumnName() + "='${" + columnBean.getColumnName() + "}'");
				isFirst = false;
			}
		}
		updateSb.append(";\"");
		println(updateSb);

@@@@@@>


#查找语句
<@@@@@@

		StringBuilder selectSql = new StringBuilder();
		selectSql.append("selectSql=\"select * from  ");
		selectSql.append(t.getTableBean().getTableName() + " where ");
		boolean isFirst = true;
		for (ColumnBean columnBean :  t.getColumns()) {
			if (columnBean.getColumnKey().equals("PRI")) {
				if (!isFirst) {
					selectSql.append("and ");
				}
				selectSql.append(columnBean.getColumnName() + "='${" + columnBean.getColumnName() + "}'");
				isFirst = false;
			}
		}
		selectSql.append(";\"");
		println(selectSql);

@@@@@@>	
		
		
		
#插入语句	
<@@@@@@
		StringBuilder insertSql = new StringBuilder();
		insertSql.append("insertSql=\"INSERT INTO ");
		insertSql.append(t.getTableBean().getTableName() + "(");

		boolean isFirst = true;
		for (ColumnBean columnBean : t.getColumns()) {
			if (!isFirst) {
				insertSql.append(",");
			}
			insertSql.append(columnBean.getColumnName());
			isFirst = false;
		}
		insertSql.append(") VALUES (");
		isFirst = true;
		for (ColumnBean columnBean : t.getColumns()) {
			if (!isFirst) {
				insertSql.append(",");
			}
			insertSql.append("'${" + columnBean.getColumnName() + "}'");
			isFirst = false;
		}
		insertSql.append(";\"");
		println(insertSql);

@@@@@@>









