import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=UTC";
        String user = "root";
        String pass = "testtest";
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select p.course_name, count(p.course_name)/max(month(p.subscription_date)) as avg from purchaselist p where year(p.subscription_date) = 2018 group by p.course_name");

            while(resultSet.next()){
                String courseName = resultSet.getString("course_name");
                String avg = resultSet.getString("avg");
                System.out.println(courseName + " - " + avg);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
