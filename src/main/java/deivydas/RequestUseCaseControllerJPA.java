package deivydas;

import deivydas.dao.RoomDAO;
import deivydas.dao.StudentDAO;
import deivydas.dao.StudyProgramDAO;
import deivydas.entities.RoomEntity;
import deivydas.entities.StudentEntity;
import deivydas.entities.StudyProgramEntity;
import deivydas.interceptors.DeivydoInterceptor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named // tas pats kaip: @Named ir @RequestScoped
@ViewScoped
@Slf4j
public class RequestUseCaseControllerJPA implements Serializable{

    @Getter private StudentEntity selectedStudent;
    @Getter private StudentEntity conflictingStudent;
    @Getter private List<StudentEntity> allStudents;

    @Getter
    private StudyProgramEntity program = new StudyProgramEntity();
    @Getter
    private StudentEntity student = new StudentEntity();

    @Getter List<StudyProgramEntity> allStudyPrograms = new ArrayList<>();

    @Inject
    private StudyProgramDAO studyProgramDAO;
    @Inject
    private StudentDAO studentDAO;

    @Inject
    private RoomDAO roomDAO;


    @Getter List<RoomEntity> allRooms = new ArrayList<>();

    @PostConstruct
    public void init() {
        reloadAll();
    }

    @DeivydoInterceptor
    public void prepareForEditing(StudentEntity student) {
        selectedStudent = student;
        conflictingStudent = null;
    }

    @Transactional
    public void updateSelectedStudent() {
        try {
            studentDAO.updateAndFlush(selectedStudent);
            reloadAll();
        } catch (OptimisticLockException ole) {
            conflictingStudent = studentDAO.findById(selectedStudent.getId());
            // Pavyzdys, kaip inicializuoti LAZY ryšį, jei jo reikia HTML puslapyje:
            Hibernate.initialize(conflictingStudent.getStudyProgramList());
            // Pranešam PrimeFaces dialogui, kad užsidaryti dar negalima:
            RequestContext.getCurrentInstance().addCallbackParam("validationFailed", true);
        }
    }

    @Transactional
    public void overwriteStudent() {
        selectedStudent.setOptLockVersion(conflictingStudent.getOptLockVersion());
        updateSelectedStudent();
    }

    public void reloadAll() {
        allStudents = studentDAO.getAllStudents();
        for (StudentEntity s : allStudents){
            Hibernate.initialize(s.getStudyProgramList());
        }
        allStudyPrograms = studyProgramDAO.getAllStudyPrograms();
        for (StudyProgramEntity e : allStudyPrograms){
            Hibernate.initialize(e.getStudentList());
        }
        allRooms = roomDAO.getAllRooms();
    }

    @Transactional
    public void createProgramStudent() {
        boolean create = true;
        if (!studyProgramDAO.getStudyProgramByTitle(program.getTitle()).isEmpty()){
            program = studyProgramDAO.getStudyProgramByTitle(program.getTitle()).get(0);
            create = false;
        }
        student.getStudyProgramList().add(program);
        program.getStudentList().add(student);
        studentDAO.create(student);
        log.info("Maybe OK...");
    }

   }
