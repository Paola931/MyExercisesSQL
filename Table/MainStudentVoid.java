import java.sql.*;
import java.util.ArrayList;

public class MainStudentVoid {
    static String URL = "jdbc:mysql://localhost:3306/myjdbc";
    static String USER = "root";
    static String PASSWORD = "Rengoku.25";

    public static void main(String[] args) {
        try {
            Statement s = createDBStatement();
            getLastName();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static Statement createDBStatement() {
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            return c.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createStudentsTable() {
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement s = c.createStatement();
            String q1 = "CREATE TABLE IF NOT EXISTS students";
            s.executeUpdate(q1);
            String q2 = "ALTER TABLE students ADD student_id INTEGER(10) NOT NULL AUTO_INCREMENT";
            s.executeUpdate(q2);
            String q3 = "ALTER TABLE students ADD PRIMARY KEY (student_id);";
            s.executeUpdate(q3);
            String q4 = "ALTER TABLE students ADD first_name VARCHAR(30) NOT NULL";
            s.executeUpdate(q4);
            String q5 = "ALTER TABLE students ADD last_name VARCHAR(30) NOT NULL";
            s.executeUpdate(q5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void populateTable() {
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement s = c.createStatement();
            String q1 = "INSERT INTO students (first_name, last_name) VALUES ('Mario', 'Rossi');";
            s.executeUpdate(q1);
            String q2 = "INSERT INTO students (first_name, last_name) VALUES ('Lucia', 'Bianchi');";
            s.executeUpdate(q2);
            String q3 = "INSERT INTO students (first_name, last_name) VALUES ('Luigi', 'Verdi');";
            s.executeUpdate(q3);
            String q4 = "INSERT INTO students (first_name, last_name) VALUES ('Alice', 'Rossini');";
            s.executeUpdate(q4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getLastName() throws RuntimeException {
        ArrayList<String> lastNames = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement s = c.createStatement();

            String q1 = "SELECT last_name FROM students";
            ResultSet result = s.executeQuery(q1);

            while (result.next()) {
                String ln = result.getString("last_name");
                lastNames.add(ln);
            }

            for (String lastname : lastNames) {
                System.out.println(lastname);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastNames;
    }
}

