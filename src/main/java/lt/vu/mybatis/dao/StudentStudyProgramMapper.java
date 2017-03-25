package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.StudentStudyProgram;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface StudentStudyProgramMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT_STUDY_PROGRAM
     *
     * @mbg.generated Sat Mar 25 11:19:21 EET 2017
     */
    int deleteByPrimaryKey(@Param("studentId") Integer studentId, @Param("studyProgramId") Integer studyProgramId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT_STUDY_PROGRAM
     *
     * @mbg.generated Sat Mar 25 11:19:21 EET 2017
     */
    int insert(StudentStudyProgram record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT_STUDY_PROGRAM
     *
     * @mbg.generated Sat Mar 25 11:19:21 EET 2017
     */
    List<StudentStudyProgram> selectAll();
}