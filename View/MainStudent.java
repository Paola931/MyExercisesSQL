import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;
import java.util.ArrayList;

public class MainStudent {
    static String URL = "jdbc:mysql://localhost:3306/newdb";
    static String USER = "root";
    static String PASSWORD = "Rengoku.25";

    public static void main(String[] args) {
        try {
            Statement s = DBManager.createDBStatement();

            //DBManager.createStudentsTable();

            Student s1 = new Student("Mario", "Rossi");
            Student s2 = new Student("Lucia","Bianchi");
            Student s3 = new Student("Luigi", "Verdi");
            Student s4 = new Student("Alice", "Rossini");
            ArrayList<Student> studentsToInsert = new ArrayList<>();
            studentsToInsert.add(s1);
            studentsToInsert.add(s2);
            studentsToInsert.add(s3);
            studentsToInsert.add(s4);
            //DBManager.populateTable(studentsToInsert);

            System.out.println("Lastnames of students are: ");
            DBManager.getLastName();

           // DBManager.addCountryCol();
            ArrayList<Student> italianStudents = new ArrayList<>();
            italianStudents.add(s1);
            italianStudents.add(s2);
            ArrayList<Student> germanStudents = new ArrayList<>();
            germanStudents.add(s3);
            germanStudents.add(s4);
           // DBManager.updateCountry(italianStudents,germanStudents);

            System.out.println("Students are from: ");
            DBManager.getCountry();

            //DBManager.viewItStudents();
            //DBManager.viewGeStudents();

            System.out.println("Italian students are: ");
            DBManager.getItStudents();

            System.out.println("German students are: ");
            DBManager.getGeStudents();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

