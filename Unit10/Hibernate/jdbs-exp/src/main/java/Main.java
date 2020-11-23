import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.PkDrivenByDefaultMapsIdSecondPass;

import static org.hibernate.id.PersistentIdentifierGenerator.PK;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Teacher teacher = session.get(Teacher.class, 1);
        Student student = session.get(Student.class, 1);
        Course course = session.get(Course.class, 1);

        System.out.println("Переподаватель - " + teacher.getName());
        teacher.getCoursesList().forEach(el -> System.out.println(el.getName()));
        System.out.println();

        System.out.println("Студент - " + student.getName());
        student.getCourses().forEach(el -> System.out.println(el.getName()));
        System.out.println();

        System.out.println("Курс - " + course.getName());
        course.getStudents().forEach(el -> System.out.println(el.getName()));

        Subscription subscription = session.get(Subscription.class, new KeyId(2, 1));
        System.out.println(subscription.getCourse().getName());

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
}
