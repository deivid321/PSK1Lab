package deivydas;

import deivydas.mybatis.dao.RoomMapper;
import deivydas.mybatis.dao.StudentMapper;
import deivydas.mybatis.dao.StudentStudyProgramMapper;
import deivydas.mybatis.model.Room;
import deivydas.mybatis.model.StudentStudyProgram;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import deivydas.mybatis.dao.StudyProgramMapper;
import deivydas.mybatis.model.Student;
import deivydas.mybatis.model.StudyProgram;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerMyBatis {

    @Getter
    private StudyProgram program = new StudyProgram();
    @Getter
    private Student student = new Student();

    @Getter
    private Room room = new Room();

    @Inject
    private StudentMapper studentMapper;
    @Inject
    private StudyProgramMapper programMapper;
    @Inject
    private RoomMapper roomMapper;
    @Inject
    private StudentStudyProgramMapper studentProgramMapper;

    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    public List<Room> getAllRooms() {
        return roomMapper.selectAll();
    }

    @Transactional
    public void createStudentStudyProgramRoom() {
        boolean createRoom = true;
        List<Room> rooms = getAllRooms();
        Optional<Room> rm = rooms.stream().filter(o -> o.getName().equals(room.getName())).findFirst();
        if (rm.isPresent()) {
            room = rm.get();
            createRoom = false;
        }
        if (createRoom) roomMapper.insert(room);
        student.setRoom(room);
        student.setRoomId(room.getId());//PROBLEM??
        programMapper.insert(program);
        studentMapper.insert(student);
        StudentStudyProgram studentProgram = new StudentStudyProgram();
        studentProgram.setStudyProgramId(program.getId());
        studentProgram.setStudentId(student.getId());
        studentProgramMapper.insert(studentProgram);
        log.info("Maybe OK...");
    }
}
