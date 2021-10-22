package com.mcb.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.assessment.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
	
	@Modifying
	@Query(value="update grup set name=?2 where group_Id=?1",nativeQuery = true)
	void saveOrUpdate(Long group,String name);
	

}
