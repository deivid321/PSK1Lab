package deivydas.mybatis.model;

public class StudentStudyProgram {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENT_STUDY_PROGRAM.STUDENT_ID
     *
     * @mbg.generated Sat Mar 25 11:19:21 EET 2017
     */
    private Integer studentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENT_STUDY_PROGRAM.STUDY_PROGRAM_ID
     *
     * @mbg.generated Sat Mar 25 11:19:21 EET 2017
     */
    private Integer studyProgramId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENT_STUDY_PROGRAM.STUDENT_ID
     *
     * @return the value of PUBLIC.STUDENT_STUDY_PROGRAM.STUDENT_ID
     *
     * @mbg.generated Sat Mar 25 11:19:21 EET 2017
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENT_STUDY_PROGRAM.STUDENT_ID
     *
     * @param studentId the value for PUBLIC.STUDENT_STUDY_PROGRAM.STUDENT_ID
     *
     * @mbg.generated Sat Mar 25 11:19:21 EET 2017
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENT_STUDY_PROGRAM.STUDY_PROGRAM_ID
     *
     * @return the value of PUBLIC.STUDENT_STUDY_PROGRAM.STUDY_PROGRAM_ID
     *
     * @mbg.generated Sat Mar 25 11:19:21 EET 2017
     */
    public Integer getStudyProgramId() {
        return studyProgramId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENT_STUDY_PROGRAM.STUDY_PROGRAM_ID
     *
     * @param studyProgramId the value for PUBLIC.STUDENT_STUDY_PROGRAM.STUDY_PROGRAM_ID
     *
     * @mbg.generated Sat Mar 25 11:19:21 EET 2017
     */
    public void setStudyProgramId(Integer studyProgramId) {
        this.studyProgramId = studyProgramId;
    }
}