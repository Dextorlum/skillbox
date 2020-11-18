import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url = "jdbs:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("Select * from Courses");

            while(resultSet.next()){
                String courseName = resultSet.getString("name");
                System.out.println(courseName);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
