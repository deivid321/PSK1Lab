package lt.vu;

import Deivydas.RoomEntity;
import Deivydas.StudentEntity;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.mybatis.dao.RoomMapper;
import lt.vu.mybatis.dao.StudentMapper;
import lt.vu.mybatis.model.Room;
import lt.vu.mybatis.model.Student;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerMyBatis {

    @Getter
    private Room room = new Room();
    @Getter
    private Student student = new Student();

    @Inject
    private StudentMapper studentMapper;
    @Inject
    private RoomMapper roomMapper;
    //@Inject
    //private StudentRoomMapper studentRoomMapper;

    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    @Transactional
    public void createRoomStudent() {
        student.setRoom(room);
        roomMapper.insert(room);
        studentMapper.insert(student);

        //StudentCourse studentCourse = new StudentCourse();
        //studentCourse.setCourseId(course.getId());
        //studentCourse.setStudentId(student.getId());
        //studentCourseMapper.insert(studentCourse);
        log.info("Maybe OK...");
    }
}
