package deivydas.entities;

import lombok.Getter;
import lombok.Setter;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vdeiv on 2017-03-25.
 */
@Getter
@Setter
@Entity
@Table(name = "ROOM", schema = "PUBLIC", catalog = "DORMITORYDB")
@NamedQueries({
        @NamedQuery(name = "Room.findAll", query = "SELECT r FROM RoomEntity r"),
})
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "NAME", nullable = true, length = 4)
    private String name;
    @Version
    @Column(name = "OPT_LOCK_VERSION", nullable = true)
    private Integer optLockVersion;
    @Basic
    @Column(name = "MAX_PEOPLE", nullable = true)
    private Integer maxPeople;

    @JohnzonIgnore
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "room")
    private List<StudentEntity> studentList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (optLockVersion != null ? !optLockVersion.equals(that.optLockVersion) : that.optLockVersion != null)
            return false;
        if (maxPeople != null ? !maxPeople.equals(that.maxPeople) : that.maxPeople != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (optLockVersion != null ? optLockVersion.hashCode() : 0);
        result = 31 * result + (maxPeople != null ? maxPeople.hashCode() : 0);
        return result;
    }
}
