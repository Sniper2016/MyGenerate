package cn.gameboys.generate.bean;

/**
 * Description:
 * 
 * @author sniper(www.gameboys.cn)
 * @date 2019年9月9日
 */
public class TableBean {
	private String tableName;
	private String tableComment;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableComment() {
		return tableComment;
	}
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	@Override
	public String toString() {
		return "TableBean [tableName=" + tableName + ", tableComment=" + tableComment + "]";
	}

	
	
	
}
