package Exercise5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Exercise5 {

    public static void main(String[] args) {

        String italianStudentsView = "CREATE OR REPLACE VIEW italianStudents AS SELECT first_name, last_name FROM students WHERE country = 'Italy'";
        String germanStudentsView = "CREATE OR REPLACE VIEW germanStudents AS SELECT first_name, last_name FROM students WHERE country = 'Germany'";

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere");
            Statement statement = connection.createStatement();

            // - Italian Students

            statement.executeUpdate(italianStudentsView);

            ArrayList<Student> italianStudents = new ArrayList<>();

            ResultSet resultSetItaly = statement.executeQuery("SELECT * FROM italianStudents");

            while(resultSetItaly.next()) {

                String name = resultSetItaly.getString("first_name");
                String lastName = resultSetItaly.getString("last_name");

                Student italianStudent = new Student(name, lastName);
                italianStudents.add(italianStudent);
            }

            for(Student student : italianStudents) {
                System.out.println("italian: " + student.getName() + " " + student.getSurname());
            }

            // - German Students

            statement.executeUpdate(germanStudentsView);

            ArrayList<Student> germanStudents = new ArrayList<>();

            ResultSet resultSetGermany = statement.executeQuery("SELECT * FROM germanStudents");

            while(resultSetGermany.next()) {

                String name = resultSetGermany.getString("first_name");
                String lastName = resultSetGermany.getString("last_name");

                Student germanStudent = new Student(name, lastName);
                germanStudents.add(germanStudent);
            }

            for(Student germanStudent : germanStudents) {
                System.out.println("german: " + germanStudent.getName() + " " + germanStudent.getSurname());
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}


