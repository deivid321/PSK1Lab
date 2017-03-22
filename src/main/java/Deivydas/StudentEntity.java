package Deivydas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by vdeiv on 2017-03-05.
 */
@Entity
@Table(name = "STUDENT", schema = "PUBLIC", catalog = "DORMITORYDB")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM StudentEntity s"),
        @NamedQuery(name = "Student.findById", query = "SELECT s FROM StudentEntity s WHERE s.id = :id"),
        @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM StudentEntity s WHERE s.firstName LIKE :firstName"),
        @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM StudentEntity s WHERE s.lastName LIKE :lastName"),
        @NamedQuery(name = "Student.findByRegistrationNo", query = "SELECT s FROM StudentEntity s WHERE s.registrationNo = :registrationNo")
})
@Getter
@Setter
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic
    @Column(name = "REGISTRATION_NO")
    private String registrationNo;
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;

    @ManyToOne
    @JoinColumn(name="ROOM_ID")
    private RoomEntity room;

    @OneToOne
    @JoinColumn(name="HISTORY_ID")
    private StudentHistoryEntity history;

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "REGISTRATION_NO")
    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    @Basic
    @Column(name = "OPT_LOCK_VERSION")
    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

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
