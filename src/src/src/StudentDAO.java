import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDAO {

    Scanner sc = new Scanner(System.in);

    // Add Student
    public void addStudent() {

        try {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Year: ");
            int year = sc.nextInt();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            String sql = "INSERT INTO students " +
                    "(name, email, phone, department, year, marks) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, department);
            ps.setInt(5, year);
            ps.setDouble(6, marks);

            ps.executeUpdate();

            System.out.println("Student added successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View All Students
    public void viewStudents() {

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n========== ALL STUDENTS ==========");

            boolean found = false;

            while (rs.next()) {

                found = true;

                double marks = rs.getDouble("marks");

                System.out.println("\nID          : " + rs.getInt("id"));
                System.out.println("Name        : " + rs.getString("name"));
                System.out.println("Email       : " + rs.getString("email"));
                System.out.println("Phone       : " + rs.getString("phone"));
                System.out.println("Department  : " + rs.getString("department"));
                System.out.println("Year        : " + rs.getInt("year"));
                System.out.println("Marks       : " + marks);
                System.out.println("Grade       : " + calculateGrade(marks));
                System.out.println("----------------------------------");
            }

            if (!found) {
                System.out.println("No students found.");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Search Student
    public void searchStudent() {

        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            String sql = "SELECT * FROM students WHERE id = ?";

            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                double marks = rs.getDouble("marks");

                System.out.println("\n========== STUDENT FOUND ==========");
                System.out.println("ID          : " + rs.getInt("id"));
                System.out.println("Name        : " + rs.getString("name"));
                System.out.println("Email       : " + rs.getString("email"));
                System.out.println("Phone       : " + rs.getString("phone"));
                System.out.println("Department  : " + rs.getString("department"));
                System.out.println("Year        : " + rs.getInt("year"));
                System.out.println("Marks       : " + marks);
                System.out.println("Grade       : " + calculateGrade(marks));

            } else {
                System.out.println("Student not found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update Student
    public void updateStudent() {

        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Email: ");
            String email = sc.nextLine();

            System.out.print("Enter New Phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter New Department: ");
            String department = sc.nextLine();

            System.out.print("Enter New Year: ");
            int year = sc.nextInt();

            System.out.print("Enter New Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            String sql = "UPDATE students SET name=?, email=?, phone=?, " +
                    "department=?, year=?, marks=? WHERE id=?";

            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, department);
            ps.setInt(5, year);
            ps.setDouble(6, marks);
            ps.setInt(7, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Delete Student
    public void deleteStudent() {

        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            String sql = "DELETE FROM students WHERE id=?";

            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Grade Calculation
    private String calculateGrade(double marks) {

        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }
}
