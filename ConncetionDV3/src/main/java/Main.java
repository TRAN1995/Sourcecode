import java.sql.Connection;
import java.sql.SQLException;

public class Main {
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String env = "DEV";
//        InsertDataDao insertDataDao = new InsertDataDao();
//        insertDataDao.InserData(BaseDao.getConnection(env));
//        System.out.println("Hello World");
//
//
//   }
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            String env = "DEV";
            Connection connection = BaseDao.getConnection(env);
            OracleStoreProcedure oracleStoreProcedure = new OracleStoreProcedure(connection);
           String reponse= oracleStoreProcedure.callProcedure(0, "The average English score during the 2024 national high school graduation", "status");
            System.out.println("reponse: "+reponse);
        }

}
