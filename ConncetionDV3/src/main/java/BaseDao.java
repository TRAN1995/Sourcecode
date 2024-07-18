import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oracle.jdbc.pool.OracleDataSource;

public class BaseDao {
	private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);


	public static Connection getConnection(String env) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		if (conn == null || conn.isClosed()) {
			OracleDataSource ds;

			try {
				ds = DBConnection.getDataSource(env);
				conn = ds.getConnection();
				logger.info("connected: ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("err: "+e);
			}
		}
		return conn;
	}
	public static void releaseConnect(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			logger.error("err: "+e);
		}
	}
// Purpose: Test connection DB
//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		getConnection();
//	}

}