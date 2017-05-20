package deivydas.dao;

import deivydas.RescueOrAsync;
import deivydas.entities.StudentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Alternative
public class StudentDAO {
    @Inject
    @RescueOrAsync
    protected EntityManager em;

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

    public StudentEntity findByName(String name) {
        try {
            StudentEntity s = em.createNamedQuery("Student.findByFirstName", StudentEntity.class).
                    setParameter("firstName", name).getSingleResult();
            return s;
        }catch(Exception e){
            return null;
        }
    }

}
