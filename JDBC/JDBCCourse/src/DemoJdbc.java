import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "JSR#3306monty";
        String selectQuery = "select * from student";
        String inputQuery = "insert into student values(7, 'kartik', 75)";
        String updateQuery = "update student set sname='Kiran' where sid =7";
        String deleteQuery = "delete from student where sid = 6";

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection Established");

        Statement st = con.createStatement();

        // Create
        // execute() is to insert, update and delete but gives false when inserting data but works fine
        boolean status = st.execute(inputQuery);
        System.out.println(!status?"Data inserted":"Insert failed");

        // Update
        boolean updateStatus = st.execute(updateQuery);
        System.out.println(!updateStatus?"Updated successfully":"Update failed");

        // Delete
        boolean deleted = st.execute(deleteQuery);

        // Fetching data
        // executeQuery() is for fetching data
        ResultSet rs = st.executeQuery(selectQuery);

        while (rs.next()){
            System.out.print(rs.getInt(1)+ " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));
        };

        con.close();
        System.out.println("Connection Closed");

    }
}
