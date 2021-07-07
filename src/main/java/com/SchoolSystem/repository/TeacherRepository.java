package com.SchoolSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SchoolSystem.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
