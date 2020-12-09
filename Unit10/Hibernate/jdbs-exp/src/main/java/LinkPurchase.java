import javax.persistence.*;

@Entity
@Table(name = "LinkPurchaselist")
public class LinkPurchase {

    @EmbeddedId
    private KeyId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("studentId")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("courseId")
    private Course course;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setId(KeyId id) {
        this.id = id;
    }

}
