package lt.vu;

import Deivydas.RoomEntity;
import Deivydas.StudentEntity;
import Deivydas.StudyProgramEntity;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.dao.RoomDAO;
import lt.vu.dao.StudentDAO;
import lt.vu.dao.StudyProgramDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerJPA {

    @Getter
    private StudyProgramEntity program = new StudyProgramEntity();
    @Getter
    private StudentEntity student = new StudentEntity();

    @Inject
    private StudyProgramDAO studyProgramDAO;
    @Inject
    private StudentDAO studentDAO;

    @Transactional
    public void createProgramStudent() {
        student.getStudyProgramList().add(program);
        program.getStudentList().add(student);
        studyProgramDAO.create(program);
        studentDAO.create(student);
        log.info("Maybe OK...");
    }

    public List<StudentEntity> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
