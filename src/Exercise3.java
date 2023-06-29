import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            List<String> lastName = new ArrayList<>();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name"));

                lastName.add(resultSet.getString("last_name"));
            }

            System.out.println(lastName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}