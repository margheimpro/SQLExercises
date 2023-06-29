import java.sql.*;

public class Exercise2 {

    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}