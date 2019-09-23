package cn.gameboys.generate.dao;

import java.sql.SQLException;
import java.util.List;

import cn.gameboys.generate.bean.ColumnBean;
import cn.gameboys.generate.bean.TableBean;
import cn.gameboys.generate.jdbc.ResultSetRow;
import cn.gameboys.generate.jdbc.ResultSetRowHandler;

/**
 * Description:
 * 
 * @author sniper(www.gameboys.cn)
 * @date 2019年9月9日
 */
public class GenDao extends BaseDao {

	private static final ResultSetRowHandler<TableBean> tableRowHandler = new ResultSetRowHandler<TableBean>() {
		public TableBean handleRow(ResultSetRow row) throws SQLException {
			TableBean bean = new TableBean();
			bean.setTableComment(row.getString("tableComment"));
			bean.setTableName(row.getString("tableName"));
			return bean;
		}
	};

	private static final ResultSetRowHandler<ColumnBean> columnRowHandler = new ResultSetRowHandler<ColumnBean>() {
		public ColumnBean handleRow(ResultSetRow row) throws SQLException {
			ColumnBean bean = new ColumnBean();
			bean.setColumnComment(row.getString("columnComment"));
			bean.setColumnKey(row.getString("columnKey"));
			bean.setColumnName(row.getString("columnName"));
			bean.setDataType(row.getString("dataType"));
			bean.setExtra(row.getString("extra"));
			return bean;
		}
	};

	public TableBean queryTable(String tableName) {
		String sql = "select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables where table_schema = (select database()) and table_name ='"
				+ tableName + "';";
		return queryForListFromCfgDB(0, sql, tableRowHandler).get(0);

	}

	
	public List<ColumnBean> queryColumns(String tableName) {
		String sql = "	select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra from information_schema.columns\r\n"
				+ " 			where table_name = '" + tableName + "' and table_schema = (select database()) order by ordinal_position;";
		return queryForListFromCfgDB(0, sql, columnRowHandler);

	}

}
