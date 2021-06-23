package com.maple.admin.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maple.admin.entity.MainBoard;
import com.maple.admin.entity.MainBoardKey;

public interface BoardRepository extends JpaRepository<MainBoard, MainBoardKey>{

}
