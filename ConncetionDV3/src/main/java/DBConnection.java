import com.mysql.cj.jdbc.MysqlDataSource;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.SQLException;

public class DBConnection {
    // Method 1
    public static OracleDataSource getDataSource(String env) throws SQLException {
        OracleDataSource ds = new OracleDataSource();
        String param = env+".database";
        ds.setUser(Configuration.getParam(param + ".username"));
        ds.setPassword(Configuration.getParam(param + ".password"));
        ds.setURL(Configuration.getParam(param + ".serviceName"));
        return ds;
    }
    // Method 2: it is not correct if the param is not "config.database"
//    public static OracleDataSource getDataSource(String param) throws SQLException {
//        OracleDataSource ds = new OracleDataSource();
//        ds.setUser(Configuration.getParam("config.database.username"));
//        ds.setPassword(Configuration.getParam("config.database.password"));
//        ds.setURL(Configuration.getParam("config.database.serviceName"));
//        return ds;
//    }

    // Method3:it is same method 2 but it uses StringBuilder and it is not correct if the param is not "config.database"
//    public static OracleDataSource getDataSource(String param) throws SQLException {
//        OracleDataSource ds = new OracleDataSource();
//        StringBuilder sb = new StringBuilder(param);
//        ds.setUser(Configuration.getParam(sb.append(".username").toString()));
//        sb.setLength(param.length()); // reset the StringBuilder
//        ds.setPassword(Configuration.getParam(sb.append(".password").toString()));
//        sb.setLength(param.length()); // reset the StringBuilder
//        ds.setURL(Configuration.getParam(sb.append(".serviceName").toString()));
//        return ds;
//    }

}
