import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class InsertDataDao {
    public static Connection conn = null;
    public static ResultSet rs = null;
    public static PreparedStatement preStmt = null;
    private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);

    public String InserData(Connection conn) {
        try {
            String sql = " insert into TTTD_LICH_SU (MA_YEU_CAU, TRANG_THAI) values (?, ?)";
            PreparedStatement preStmt = conn.prepareCall(sql);
            preStmt.setString(1, "ABC2");
            preStmt.setString(2,"abc3");
            preStmt.executeUpdate();

        } catch (Exception e) {
            logger.error("err: "+e);
        } finally {
            BaseDao.releaseConnect(conn, preStmt, rs);
            logger.info("insert success");

        }
        return null;
    }
}