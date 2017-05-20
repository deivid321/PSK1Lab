package deivydas.dao;

import deivydas.entities.StudentEntity;

import javax.enterprise.inject.Alternative;
import javax.transaction.Transactional;

/**
 * Created by vdeiv on 2017-05-20.
 */
@Alternative
public class StudentDAOAlt extends StudentDAO {

    @Transactional(Transactional.TxType.REQUIRES_NEW)
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
