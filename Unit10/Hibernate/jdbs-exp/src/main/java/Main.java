import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Teacher teacher = session.get(Teacher.class, 1);
        Student student = session.get(Student.class, 1);
        Course course = session.get(Course.class, 2);

        System.out.println("Переподаватель - " + teacher.getName());
        teacher.getCoursesList().forEach(el -> System.out.println(el.getName()));
        System.out.println();

        System.out.println("Студент - " + student.getName());
        student.getCourses().forEach(el -> System.out.println(el.getName()));
        System.out.println();

        System.out.println("Курс - " + course.getName());
        course.getStudents().forEach(el -> System.out.println(el.getName()));

        ResultSet purchases = getResultSet();

        while(purchases.next()){
            String courseName = purchases.getString("course_name");
            String studentName = purchases.getString("student_name");
            int courseId = getIdByCourseName(courseName, session);
            int studentId = getIdByStudentName(studentName, session);

            LinkPurchase linkPurchase = session.get(LinkPurchase.class, new KeyId(courseId, studentId));
            if (courseId > 0) {
                if (linkPurchase == null) {
                   System.out.println(courseName + " " + courseId + " " + studentName + " " + studentId);
                    Transaction transaction = session.beginTransaction();
                    Student student1 = session.get(Student.class, studentId);
                    Course course1 = session.get(Course.class, courseId);
                    LinkPurchase saveLinkPurchase = new LinkPurchase();
                    saveLinkPurchase.setStudent(student1);
                    saveLinkPurchase.setCourse(course1);
                    saveLinkPurchase.setId(new KeyId(courseId, studentId));
                    session.save(saveLinkPurchase);
                    session.flush();
                    transaction.commit();
                }
            }


        }

//        System.out.println(teacher.getName());
//        String sql = "from " + LinkPurchase.class.getSimpleName();
//
//        System.out.println(sql);
        //List<Purchase> purchaselist = session.createQuery().list();

        //System.out.println(purchase.getStudentName());
//        System.out.println(course.getName() + " Преподаватель = " + course.getTeacher().getName() + " Количество студентов = " + course.getStudents().size());
//        course.getStudents().forEach(System.out::println);
        sessionFactory.close();
    }

    public static ResultSet getResultSet(){
        String url = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=UTC";
        String user = "root";
        String pass = "testtest";
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery("Select * from purchaselist;");
        } catch (Exception e) {
            e.printStackTrace();
        }



        return resultSet;
    }

    public static int getIdByCourseName(String courseName, Session session){

        String hql = "from " + Course.class.getSimpleName();
        List<Course> courseList = session.createQuery(hql).getResultList();
        int id = -1;

        for(Course course : courseList){
//            System.out.println(course.getName() + " " + course.getId());
            if (course.getName().contains(courseName)){
                id = course.getId();
                break;
            }
        }
        return id;
    }
    public static int getIdByStudentName(String studentName, Session session){

        String hql = "from " + Student.class.getSimpleName();
        List<Student> studentsList = session.createQuery(hql).getResultList();
        int id = -1;

        for(Student student : studentsList){
            if (student.getName().contains(studentName) ){
                id = student.getId();
                break;
            }
        }
//        System.out.println(id);
        return id;
    }
}
