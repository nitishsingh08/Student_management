package Students_db;
import java.sql.*;
public class StudentsDAO {
    public void addStudents(Students s) {
        String query = "INSERT INTO students values (?,?,?,?,?,?,?)";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, s.roll);
            preparedStatement.setString(2, s.name);
            preparedStatement.setInt(3, s.age);
            preparedStatement.setString(4, s.course);
            preparedStatement.setInt(5, s.maths);
            preparedStatement.setInt(6, s.physics);
            preparedStatement.setInt(7, s.chemistry);
            preparedStatement.executeUpdate();
            System.out.println("\n Student added successfully...!!\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchStudent(int roll) {
        String query = "SELECT * FROM students WHERE roll_no = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, roll);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int m = rs.getInt("maths");
                int p = rs.getInt("physics");
                int c = rs.getInt("chemistry");

                double percentage = (m + c + p) / 3;
                System.out.println("\n Student Found \n");
                System.out.printf("%-8s %-10s %-6s %-8s %-10s %-14s %-10s %-10s \n", "Roll", "Name","Age", "Course", "Maths", "Chemistry", "Physics", "Percentage");
                System.out.println("--------------------------------------------------------------------------------------------------------");
                System.out.printf("%-8d %-10s %-6d %-8s %-10d %-14d %-10d %-10.2f\n", rs.getInt("roll_no"), rs.getString("name"),rs.getInt("age"), rs.getString("course"),m, c, p, percentage);
            } else {
                System.out.println("Students not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showAllStudents() {
        String query = "SELECT * FROM students";
        try (Connection connection = DBConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("\n =============== STUDENTS RECORD ===============");
            System.out.printf("%-8s %-15s %-6s %-10s %-8s %-8s %-8s %-10s\n", "Roll", "Name", "Age", "Course", "Maths", "Chem", "Phy", "Percent");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                int m = resultSet.getInt("maths");
                int p = resultSet.getInt("physics");
                int c = resultSet.getInt("chemistry");
                double percentage = (m + c + p) / 3;
                System.out.printf("%-8d %-15s %-6d %-10s %-8d %-8d %-8d %-10.2f\n",
                        resultSet.getInt("roll_no"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("course"),
                        m,c,p,percentage);            }
            System.out.println("--------------------------------------------------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateMarks(int roll, int maths, int phy, int chem) {
        String query = "UPDATE students SET maths = ?, physics = ?, chemistry = ? WHERE roll_no = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maths);
            preparedStatement.setInt(2, phy);
            preparedStatement.setInt(3, chem);
            preparedStatement.setInt(4, roll);
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Marks are updated ");
            } else {
                System.out.println("Marks are not updated as student is not Found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent(int roll) {

        String query = "DELETE FROM students WHERE roll_no = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, roll);
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                System.out.println("Student is deleted");
            } else {
                System.out.println("Student not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}