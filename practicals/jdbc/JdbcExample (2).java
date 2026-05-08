package jdbc;

import java.sql.*;

public class JdbcExample {

    // Database credentials
    static final String URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database!");

            // 3. Insert Data
            String insertQuery = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);

            pstmt.setInt(1, 1);
            pstmt.setString(2, "John");
            pstmt.setInt(3, 20);

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

            // 4. Retrieve Data
            String selectQuery = "SELECT * FROM student";
            pstmt = conn.prepareStatement(selectQuery);
            rs = pstmt.executeQuery();

            System.out.println("\nStudent Records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + " | " + name + " | " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 5. Close Resources
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
