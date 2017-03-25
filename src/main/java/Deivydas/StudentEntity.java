package Deivydas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vdeiv on 2017-03-25.
 */
@Getter
@Setter
@Entity
@Table(name = "STUDENT", schema = "PUBLIC", catalog = "DORMITORYDB")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM StudentEntity s"),
        @NamedQuery(name = "Student.findById", query = "SELECT s FROM StudentEntity s WHERE s.id = :id"),
        @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM StudentEntity s WHERE s.firstName LIKE :firstName"),
        @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM StudentEntity s WHERE s.lastName LIKE :lastName"),
        @NamedQuery(name = "Student.findByRegistrationNo", query = "SELECT s FROM StudentEntity s WHERE s.registrationNo = :registrationNo")
})
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 20)
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME", nullable = true, length = 20)
    private String lastName;
    @Basic
    @Column(name = "REGISTRATION_NO", nullable = true, length = 20)
    private String registrationNo;

    @Version
    @Column(name = "OPT_LOCK_VERSION", nullable = true)
    private Integer optLockVersion;

    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ID")
    @ManyToOne
    private RoomEntity room;

    @JoinTable(name = "STUDENT_STUDY_PROGRAM", joinColumns = {
            @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "STUDY_PROGRAM_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<StudyProgramEntity> studyProgramList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (registrationNo != null ? !registrationNo.equals(that.registrationNo) : that.registrationNo != null)
            return false;
        if (optLockVersion != null ? !optLockVersion.equals(that.optLockVersion) : that.optLockVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (registrationNo != null ? registrationNo.hashCode() : 0);
        result = 31 * result + (optLockVersion != null ? optLockVersion.hashCode() : 0);
        return result;
    }
}
