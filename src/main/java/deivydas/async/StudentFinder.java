package deivydas.async;

import deivydas.dao.StudentDAO;

import deivydas.entities.StudentEntity;
import org.apache.deltaspike.core.api.future.Futureable;
import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.concurrent.Future;

@ApplicationScoped
public class StudentFinder implements Serializable {

    @Inject
    private StudentDAO studentDAO;

    @Futureable
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Future<String> findStudent(String name) {
        String txt = name + "'";
        System.out.println("Started registration of " + txt);
        try {
            Thread.sleep(2000); // sleep for 10 seconds
        } catch (InterruptedException e) {
        }
        StudentEntity student = studentDAO.findByName(name);
        if (student != null) {
            txt = "Welcome back "+name +"!";
        } else {
            txt = "Student "+name +"not found :((";
        }
        System.out.println("Student found: " + txt);
        return new AsyncResult<>(txt);
    }

}