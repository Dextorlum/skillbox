import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        String sql = "from " + LinkPurchase.class.getSimpleName();

        System.out.println(sql);
        //List<Purchase> purchaselist = session.createQuery().list();

        //System.out.println(purchase.getStudentName());
//        System.out.println(course.getName() + " Преподаватель = " + course.getTeacher().getName() + " Количество студентов = " + course.getStudents().size());
//        course.getStudents().forEach(System.out::println);
        sessionFactory.close();
    }
}
