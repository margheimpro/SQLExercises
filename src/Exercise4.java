import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise4 {

    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere");

            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE newdb.students SET country='Italy' WHERE  student_id=1");
            statement.executeUpdate("UPDATE newdb.students SET country='Italy' WHERE  student_id=2");
            statement.executeUpdate("UPDATE newdb.students SET country='Germany' WHERE  student_id=3");
            statement.executeUpdate("UPDATE newdb.students SET country='Germany' WHERE  student_id=4");
            statement.executeUpdate("ALTER TABLE newdb.students MODIFY COLUMN country VARCHAR(30)");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("country"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
