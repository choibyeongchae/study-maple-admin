package com.maple.admin.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maple.admin.entity.EventMaster;

@Repository
public interface EventRepository extends JpaRepository<EventMaster, Integer>{

}
