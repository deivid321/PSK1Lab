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
@Table(name = "STUDY_PROGRAM", schema = "PUBLIC", catalog = "DORMITORYDB")
public class StudyProgramEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "TITLE", nullable = true, length = 250)
    private String title;
    @Basic
    @Column(name = "FACULTY", nullable = true, length = 250)
    private String faculty;
    @Version
    @Column(name = "OPT_LOCK_VERSION", nullable = true)
    private Integer optLockVersion;

    @ManyToMany(mappedBy = "studyProgramList")
    private List<StudentEntity> studentList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudyProgramEntity that = (StudyProgramEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (faculty != null ? !faculty.equals(that.faculty) : that.faculty != null) return false;
        if (optLockVersion != null ? !optLockVersion.equals(that.optLockVersion) : that.optLockVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (optLockVersion != null ? optLockVersion.hashCode() : 0);
        return result;
    }
}
