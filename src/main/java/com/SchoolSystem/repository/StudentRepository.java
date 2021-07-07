package com.SchoolSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SchoolSystem.model.Student;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByRoomId(long id);

}
