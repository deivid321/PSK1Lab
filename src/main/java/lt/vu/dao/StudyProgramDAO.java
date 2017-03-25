package lt.vu.dao;

import Deivydas.StudyProgramEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StudyProgramDAO {
    @Inject
    private EntityManager em;

    public void create(StudyProgramEntity program) {
        em.persist(program);
    }
}
