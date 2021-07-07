package com.SchoolSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SchoolSystem.model.Subject;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Set<Subject> findByRoomsId(long ClassID);

    List<Subject> findByTeacherId(long TeacherID);

    List<Subject> findByTeacherIdIsNull();

    @Query(value = "select * from subject  \n"
            + "where subject.id not in (select subject.id from subject  \n"
            + "left outer join course_subject \n"
            + "on subject.id = course_subject.subject_id \n"
            + "left outer join classroom\n"
            + "on classroom.id = course_subject.class_id\n"
            + "where course_subject.class_id =?1)", nativeQuery = true)

    List<Subject> findSubjectNotInClassRoom(long ClassID);

     boolean existsByNameIgnoreCase(String name);

}
