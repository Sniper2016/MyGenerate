package cn.gameboys.generate;

import java.util.HashMap;
import java.util.List;

import cn.gameboys.frame.BaseGenerateHandler;
import cn.gameboys.generate.bean.ColumnBean;
import cn.gameboys.generate.bean.TableBean;
import cn.gameboys.generate.dao.GenDao;
import cn.gameboys.generate.MyGenerateDBHandler.AllBeanInfo;

public class MyGenerateDBHandler extends BaseGenerateHandler<AllBeanInfo> {
	@Override
	protected void resolveLogic() {
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


	}

	@Override
	protected AllBeanInfo initCfg() {
		AllBeanInfo bean = new AllBeanInfo();

		String tableName = "test_userInfo";
		// 查询表信�?
		TableBean tableBean = queryTable(tableName);
		// 查询列信�?
		List<ColumnBean> columns = queryColumns(tableName);
		bean.setColumns(columns);
		bean.setTableBean(tableBean);

		bean.setTablePrefix("test_");

		return bean;
	}

	private List<ColumnBean> queryColumns(String tableName) {
		GenDao genDao = new GenDao();
		List<ColumnBean> list = genDao.queryColumns(tableName);
		return list;
	}

	private TableBean queryTable(String tableName) {
		GenDao genDao = new GenDao();
		TableBean tableBean = genDao.queryTable(tableName);
		return tableBean;
	}

	private static HashMap<String, String> typeChangeMap = new HashMap<>();
	static {
		typeChangeMap.put("tinyint", "Integer");
		typeChangeMap.put("smallint", "Integer");
		typeChangeMap.put("mediumint", "Integer");
		typeChangeMap.put("int", "Integer");
		typeChangeMap.put("integer", "Integer");
		typeChangeMap.put("bigint", "Long");
		typeChangeMap.put("float", "float");
		typeChangeMap.put("double", "double");
		typeChangeMap.put("decimal", "double");
		typeChangeMap.put("char", "String");
		typeChangeMap.put("varchar", "String");
		typeChangeMap.put("tinytext", "String");
		typeChangeMap.put("text", "String");
		typeChangeMap.put("mediumtext", "String");
		typeChangeMap.put("longtext", "String");
		typeChangeMap.put("date", "Date");
		typeChangeMap.put("datetime", "Date");
		typeChangeMap.put("timestamp", "Date");
	}



	/**
	 * 大写首字�?
	 * 
	 * @param str
	 * @return
	 */
	public String upperFirst(String str) {
		String newStr = str.substring(0, 1).toUpperCase() + str.substring(1);
		return newStr;
	}

	public static class AllBeanInfo {
		private List<ColumnBean> columns;
		private TableBean tableBean;
		// 表前�?
		private String tablePrefix;

		public String getTablePrefix() {
			return tablePrefix;
		}

		public void setTablePrefix(String tablePrefix) {
			this.tablePrefix = tablePrefix;
		}

		public List<ColumnBean> getColumns() {
			return columns;
		}

		public void setColumns(List<ColumnBean> columns) {
			this.columns = columns;
		}

		public TableBean getTableBean() {
			return tableBean;
		}

		public void setTableBean(TableBean tableBean) {
			this.tableBean = tableBean;
		}

		@Override
		public String toString() {
			return "AllBeanInfo [columns=" + columns + ", tableBean=" + tableBean + ", tablePrefix=" + tablePrefix + "]";
		}


	}

}
