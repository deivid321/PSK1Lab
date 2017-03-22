package lt.vu;

import Deivydas.RoomEntity;
import Deivydas.StudentEntity;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.dao.RoomDAO;
import lt.vu.dao.StudentDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerJPA {

    @Getter
    private RoomEntity room = new RoomEntity();
    @Getter
    private StudentEntity student = new StudentEntity();

    @Inject
    private RoomDAO roomDAO;
    @Inject
    private StudentDAO studentDAO;

    @Transactional
    public void createRoomStudent() {
        student.setRoom(room);
        room.getStudents().add(student);
        roomDAO.create(room);
        studentDAO.create(student);
        log.info("Maybe OK...");
    }

    public List<StudentEntity> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
