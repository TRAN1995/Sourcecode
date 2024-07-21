import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class ApiController {

    @PostMapping("/insert")
    public ResponseEntity<String> insertData(@RequestBody Data data) {
        String env = "DEV";
        Connection connection;
        try {
            connection = BaseDao.getConnection(env);
            OracleStoreProcedure oracleStoreProcedure = new OracleStoreProcedure(connection);
            String response = oracleStoreProcedure.callProcedure(data.getId(), data.getCode(), data.getStatus());
            return ResponseEntity.ok(response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}