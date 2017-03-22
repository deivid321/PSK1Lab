package Deivydas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vdeiv on 2017-03-05.
 */
@Entity
@Getter
@Setter
@Table(name = "ROOM", schema = "PUBLIC", catalog = "DORMITORYDB")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    private String name;
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @Basic
    @Column(name = "MAX_PEOPLE")
    private Integer maxPeople;

    @ManyToOne
    @JoinColumn(name= "dormitory_id")
    private DormitoryEntity dormitory;

    @OneToMany(mappedBy = "room")
    private List<StudentEntity> students = new ArrayList<>();

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "OPT_LOCK_VERSION")
    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    @Basic
    @Column(name = "MAX_PEOPLE")
    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

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
