import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class OracleStoreProcedure {
    public static Connection conn = null;
    public static ResultSet rs = null;
    public static PreparedStatement preStmt = null;
    private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);
    private Connection connection;

    public OracleStoreProcedure(Connection connection) {
        this.connection = connection;
    }

    public String callProcedure(int id, String code, String status) {
        String response = null;
        try {
            String storedProcedure = Const.PROCEDURE_NAME;
            CallableStatement callableStatement = connection.prepareCall(storedProcedure);

            callableStatement.setInt(1, id); // setting input parameter
            callableStatement.setString(2, code); // setting input parameter
            callableStatement.setString(3, status); // setting input parameter
            callableStatement.registerOutParameter(4, Types.VARCHAR); // registering output
            callableStatement.execute(); // call stored procedure
            response = callableStatement.getString(4); // get the output parameter
        } catch (SQLException e) {
            e.printStackTrace();
            response = "Error: " + e.getMessage();
        }finally {
            try {
                BaseDao.releaseConnect(connection, preStmt, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }
}