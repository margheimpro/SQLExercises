import java.sql.*;


public class Exercise2 {

    public static void main(String[] args) {

        String createTableSQL = "CREATE TABLE newdb.students ("
                + "student_id INT(5) NOT NULL AUTO_INCREMENT, "
                + "last_name VARCHAR(30),"
                + "first_name VARCHAR(30), "
                + "PRIMARY KEY (student_id) "
                + ")";

        String insertSQL = "INSERT INTO newdb.students (last_name, first_name) VALUES "
                + "('Rossi', 'Rossana'), "
                + "('Esposito', 'Armando'),"
                + "('Lampa', 'Dino'), "
                + "('Gialli', 'Anna')";

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere");

            Statement statement = connection.createStatement();

            //statement.execute(createTableSQL);

            //statement.execute(insertSQL);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}