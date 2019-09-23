package cn.gameboys.generate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.gameboys.generate.jdbc.C3P0ConnentionProvider;
import cn.gameboys.generate.jdbc.JDBCUtil;
import cn.gameboys.generate.jdbc.ResultSetRow;
import cn.gameboys.generate.jdbc.ResultSetRowHandler;

/**
 * @author Sniper
 * @date 2017年11月29日
 */
public class BaseDao {

	/**
	 * 从配置备库读
	 * 
	 * @param sql
	 * @param rowHandler
	 * @param parameters
	 * @return
	 */
	protected final <T> List<T> queryForListFromCfgDB(int hashCode, String sql, ResultSetRowHandler<T> rowHandler, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> result = new ArrayList<T>();
		try {
			conn = C3P0ConnentionProvider.getConnection();
			ps = conn.prepareStatement(sql);
			JDBCUtil.set(conn, ps, parameters);
			rs = ps.executeQuery();
			while (rs.next()) {
				ResultSetRow row = new ResultSetRow(rs);
				result.add(rowHandler.handleRow(row));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}
		return result;
	}

	/**
	 * Method execute.
	 * 
	 * @param sql
	 *            String
	 * @param parameters
	 *            Object[]
	 * @return boolean
	 */
	protected final boolean execute(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = C3P0ConnentionProvider.getConnection();
			ps = conn.prepareStatement(sql);
			JDBCUtil.set(conn, ps, parameters);
			return ps.execute();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBCUtil.close(null, ps, conn);
		}
		return false;
	}

}
