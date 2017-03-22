package Deivydas;

import javax.persistence.*;

/**
 * Created by vdeiv on 2017-03-05.
 */
@Entity
@Table(name = "STUDENT_HISTORY", schema = "PUBLIC", catalog = "DORMITORYDB")
public class StudentHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    private String history;
    @Version
    private Integer optLockVersion;

    @Basic
    @Column(name = "HISTORY")
    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
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

        StudentHistoryEntity that = (StudentHistoryEntity) o;

        if (id != that.id) return false;
        if (history != null ? !history.equals(that.history) : that.history != null) return false;
        if (optLockVersion != null ? !optLockVersion.equals(that.optLockVersion) : that.optLockVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (history != null ? history.hashCode() : 0);
        result = 31 * result + (optLockVersion != null ? optLockVersion.hashCode() : 0);
        return result;
    }
}
