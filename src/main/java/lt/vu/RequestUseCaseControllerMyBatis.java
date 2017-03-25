package lt.vu;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.mybatis.dao.RoomMapper;
import lt.vu.mybatis.dao.StudentMapper;
import lt.vu.mybatis.dao.StudentStudyProgramMapper;
import lt.vu.mybatis.dao.StudyProgramMapper;
import lt.vu.mybatis.model.Room;
import lt.vu.mybatis.model.Student;
import lt.vu.mybatis.model.StudentStudyProgram;
import lt.vu.mybatis.model.StudyProgram;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerMyBatis {

    @Getter
    private StudyProgram program = new StudyProgram();
    @Getter
    private Student student = new Student();

    @Inject
    private StudentMapper studentMapper;
    @Inject
    private StudyProgramMapper programMapper;
    @Inject
    private StudentStudyProgramMapper studentProgramMapper;

    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    @Transactional
    public void createStudentStudyProgram() {
        programMapper.insert(program);
        studentMapper.insert(student);
        StudentStudyProgram studentProgram = new StudentStudyProgram();
        studentProgram.setStudyProgramId(program.getId());
        studentProgram.setStudentId(student.getId());
        studentProgramMapper.insert(studentProgram);
        log.info("Maybe OK...");
    }
}
