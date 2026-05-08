package jdbc;

import java.sql.*;

public class DatabaseApp {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try {

            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            // 3. Insert Data
            String insertQuery = "INSERT INTO student VALUES(?,?,?)";

            PreparedStatement pst = con.prepareStatement(insertQuery);

            pst.setInt(1, 101);
            pst.setString(2, "Sanket");
            pst.setInt(3, 21);

            int result = pst.executeUpdate();

            System.out.println(result + " Record Inserted");

            // 4. Retrieve Data
            String selectQuery = "SELECT * FROM student";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(selectQuery);

            System.out.println("\nStudent Records:");

            while(rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + " " + name + " " + age);
            }

            // 5. Close Connection
            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
