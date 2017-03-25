package deivydas.dao;

import deivydas.entities.StudentEntity;
import deivydas.entities.StudyProgramEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StudyProgramDAO {
    @Inject
    private EntityManager em;

    public void create(StudyProgramEntity program) {
        em.persist(program);
    }

    public List<StudyProgramEntity> getAllStudyPrograms() {
        return em.createNamedQuery("StudyProgram.findAll", StudyProgramEntity.class).getResultList();
    }

    public List<StudyProgramEntity> getStudyProgramByTitle(String title) {
        return em.createNamedQuery("StudyProgram.findByTitle", StudyProgramEntity.class).setParameter("title", title).getResultList();
    }
}
