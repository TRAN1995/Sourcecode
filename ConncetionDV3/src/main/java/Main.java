import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String env = "DEV";
        InsertDataDao insertDataDao = new InsertDataDao();
        insertDataDao.InserData(BaseDao.getConnection(env));
        
        System.out.println("Hello World");
}
}
