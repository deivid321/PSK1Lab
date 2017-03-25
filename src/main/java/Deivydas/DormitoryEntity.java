package Deivydas;

import javax.persistence.*;

/**
 * Created by vdeiv on 2017-03-25.
 */
@Entity
@Table(name = "DORMITORY", schema = "PUBLIC", catalog = "DORMITORYDB")
public class DormitoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "STREET", nullable = true, length = 50)
    private String street;
    @Basic
    @Column(name = "STREET_NUMBER", nullable = true)
    private Integer streetNumber;
    @Basic
    @Column(name = "OPT_LOCK_VERSION", nullable = true)
    private Integer optLockVersion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DormitoryEntity that = (DormitoryEntity) o;

        if (id != that.id) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (streetNumber != null ? !streetNumber.equals(that.streetNumber) : that.streetNumber != null) return false;
        if (optLockVersion != null ? !optLockVersion.equals(that.optLockVersion) : that.optLockVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (streetNumber != null ? streetNumber.hashCode() : 0);
        result = 31 * result + (optLockVersion != null ? optLockVersion.hashCode() : 0);
        return result;
    }
}
