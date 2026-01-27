package com.project.fitness.repository;

import com.project.fitness.dto.ActivityRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityRequest,String> {

}
