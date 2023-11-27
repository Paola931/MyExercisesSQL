import java.sql.*;
import java.util.ArrayList;

public class Student {
    static String URL = "jdbc:mysql://localhost:3306/myjdbc";
    static String USER = "root";
    static String PASSWORD = "Rengoku.25";
    private String first_name, last_name;

    public Student(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    public static void viewItStudents() throws SQLException {
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement s = c.createStatement();

            String q = "CREATE VIEW `italian_students`  AS SELECT first_name, last_name FROM students WHERE country = 'Italy'";

            int result = s.executeUpdate(q);
        }
    }
    public static void viewGeStudents() throws SQLException {
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement s = c.createStatement();

            String q = "CREATE VIEW `german_students`  AS SELECT first_name, last_name FROM students WHERE country = 'Germany'";

            int result = s.executeUpdate(q);
        }
    }
 public static ArrayList<String> getItStudents ()throws RuntimeException {
        ArrayList<String> italianStudents = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement s = c.createStatement();

            String q1 = "SELECT * FROM italian_students";
            ResultSet result = s.executeQuery(q1);

            while (result.next()) {
                String name = result.getString("first_name");
                String surname = result.getString("last_name");
                italianStudents.add(name);
                italianStudents.add(surname);
            }

            for (String student : italianStudents) {
                System.out.println(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return italianStudents;
    }
    public static ArrayList<String> getGeStudents ()throws RuntimeException {
        ArrayList<String> germanStudents = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement s = c.createStatement();

            String q1 = "SELECT * FROM german_students";
            ResultSet result = s.executeQuery(q1);

            while (result.next()) {
                String name = result.getString("first_name");
                String surname = result.getString("last_name");
                germanStudents.add(name);
                germanStudents.add(surname);
            }

            for (String student : germanStudents) {
                System.out.println(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return germanStudents;
    }
}
