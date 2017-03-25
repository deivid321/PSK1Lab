package deivydas;

import deivydas.dao.StudentDAO;
import deivydas.dao.StudyProgramDAO;
import deivydas.entities.StudentEntity;
import deivydas.entities.StudyProgramEntity;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

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
        boolean create = true;
        if (!studyProgramDAO.getStudyProgramByTitle(program.getTitle()).isEmpty()){
            program = studyProgramDAO.getStudyProgramByTitle(program.getTitle()).get(0);
            create = false;
        }
        student.getStudyProgramList().add(program);
        program.getStudentList().add(student);
        if (create) studyProgramDAO.create(program);
        studentDAO.create(student);
        log.info("Maybe OK...");
    }

    public List<StudentEntity> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public List<StudyProgramEntity> getAllStudyPrograms(){
        return studyProgramDAO.getAllStudyPrograms();
    }
}
