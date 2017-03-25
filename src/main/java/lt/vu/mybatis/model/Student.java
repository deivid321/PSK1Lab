package lt.vu.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {

    private Integer id;

    private String firstName;

    private String lastName;

    private Integer dormitoryId;

    private Integer roomId;
    private Integer studyProgramId;

    private String registrationNo;

    // Rankomis prirašyti:
    private Room room;
    private List<StudyProgram> studyProgramList;



}