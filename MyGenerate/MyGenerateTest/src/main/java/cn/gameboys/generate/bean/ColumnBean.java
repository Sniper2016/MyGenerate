package cn.gameboys.generate.bean;
/**  
* Description: 
* @author sniper(www.gameboys.cn)  
* @date 2019年9月9日  
*/
public class ColumnBean {

	private String columnName;
	private String dataType;
	private String columnComment;
	private String columnKey;
	private String extra;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getColumnComment() {
		return columnComment;
	}
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	@Override
	public String toString() {
		return "ColumnBean [columnName=" + columnName + ", dataType=" + dataType + ", columnComment=" + columnComment + ", columnKey=" + columnKey + ", extra=" + extra + "]";
	}
	
	
	
}
