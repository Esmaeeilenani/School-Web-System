package com.SchoolSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SchoolSystem.model.ClassRoom;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

    @Transactional
    List<ClassRoom> findBySubjectsId(long subject_id);

    
    ClassRoom findByClassName(String name);

    public boolean existsByClassName(String className);

}
