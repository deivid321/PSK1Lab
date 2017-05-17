package deivydas.dao;

import deivydas.entities.StudentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StudentDAO {
    @Inject
    private EntityManager em;

    public void create(StudentEntity student) {
        em.persist(student);
    }

    public List<StudentEntity> getAllStudents() {
        return em.createNamedQuery("Student.findAll", StudentEntity.class).getResultList();
    }

    public void updateAndFlush(StudentEntity student) {
        em.merge(student);
        em.flush();
    }


    public StudentEntity findById(Integer id) {
        return em.find(StudentEntity.class, id);
    }
}
