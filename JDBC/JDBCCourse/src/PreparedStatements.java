import java.sql.*;
import java.util.Scanner;

public class PreparedStatements {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the id: ");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the Name: ");
        String sname = sc.nextLine();

        System.out.println("Enter the Marks: ");
        int marks = sc.nextInt();

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "JSR#3306monty";
        String query =  "insert into student values(?,?,?)";
        String selectQuery = "select * from student";

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection Established");

        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, sid);
        pst.setString(2, sname);
        pst.setInt(3, marks);

        pst.execute();

        try (PreparedStatement selectPst = con.prepareStatement(selectQuery);
             ResultSet rs = selectPst.executeQuery()) {
            while (rs.next()) {
                System.out.print(rs.getInt(1) + " - ");
                System.out.print(rs.getString(2) + " - ");
                System.out.println(rs.getInt(3));
            }
        }

        con.close();
        System.out.println("Connection Closed");
    }
}
