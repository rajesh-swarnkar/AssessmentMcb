package com.mcb.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.assessment.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//	@Query(value="select * from student where ")
	List<Student> findAllByGroupIdIn(List<Long> groups);
	@Modifying
	@Query(value="update student set group_id=?2 where student_id=?1",nativeQuery = true)
	Integer saveOrUpdate(Long student,Long grp);

}
