package com.mcb.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.assessment.entity.Marks;


@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {
	
	@Query(value="select * from marks where student_id=?1 group by student_id,mark_id",nativeQuery = true)
	List<Marks> getListOfMarksInEachSubjectForStudent(Long id);

	@Query(value="select sum(marks) from marks where student_id=?1",nativeQuery = true)
	Long findByStudentId(Long id);

	@Modifying
	@Query(value="update marks m set m.marks=?2 , date=sysdate where mark_id=?1",nativeQuery = true)
	Integer saveOrUpdate(Long mark_id,Long marks);

}
