import javax.persistence.*;

@Entity
@Table(name = "LinkPurchaselist")
public class LinkPurchase {

    @EmbeddedId
    private LinkPurchaseId id;

    @MapsId("studentId")
    private Student student;

    @MapsId("courseId")
    private Course course;



}
