package cn.gameboys.test;

import java.util.ArrayList;
import java.util.List;

import cn.gameboys.frame.BaseGenerateHandler;
import cn.gameboys.test.MyGenerateHandler.TestBean;

public class MyGenerateHandler extends BaseGenerateHandler<TestBean> {
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
	protected TestBean initCfg() {
		TestBean bean = new TestBean();
		bean.setId(1);
		bean.setIntList(new ArrayList<Integer>());
		bean.getIntList().add(1);
		bean.getIntList().add(2);
		bean.getIntList().add(3);

		//System.out.println("initCfg"+bean);
		return bean;
	}

/*	@Override
	protected void resolveLogic() {
		println(t.getId());
		println(t.getIntList());
		for (int i = 0; i < 20; i++) {
			print(i + " ");
			println("sniper");
		}
	}*/

	public static class TestBean {

		private int id;
		private List<Integer> intList;
		private List<TestSubBean> subBeanList;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public List<Integer> getIntList() {
			return intList;
		}

		public void setIntList(List<Integer> intList) {
			this.intList = intList;
		}

		public List<TestSubBean> getSubBeanList() {
			return subBeanList;
		}

		public void setSubBeanList(List<TestSubBean> subBeanList) {
			this.subBeanList = subBeanList;
		}
	}

	public static class TestSubBean {
		private int id;
		private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
