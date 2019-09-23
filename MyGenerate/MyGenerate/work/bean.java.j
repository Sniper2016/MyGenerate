package cn.gameboys.generate.bean;

import java.util.Date;

/**
 * Description:<@@@@@@print(t.tableBean.getTableComment());@@@@@@>
 * 
 * @author sniper(www.gameboys.cn)
 * @date 2019年9月9日
 */
public class <@@@@@@print(this.upperFirst(t.getTableBean().getTableName().substring(5)));  @@@@@@> {




<@@@@@@
		// 属性
		for (ColumnBean column : t.getColumns()) {
			println("//" + column.getColumnComment());
			println("private " + typeChangeMap.get(column.getDataType()) + " " + column.getColumnName() + ";");
		}

		// get set
		for (ColumnBean column : t.getColumns()) {
			println("//set " + column.getColumnComment());
			println("	public void set" + upperFirst(column.getColumnName()) + " (" + typeChangeMap.get(column.getDataType()) + " " + column.getColumnName() + ") {");
			println("		this." + column.getColumnName() + "=" + column.getColumnName() + ";");
			println("	}");

			println("");

			println("//get " + column.getColumnComment());
			println("	public "+typeChangeMap.get(column.getDataType())+" get" + upperFirst(column.getColumnName())  + " (){");
			println("		return " + column.getColumnName()+";");
			println("	}");

		}

@@@@@@>


}
