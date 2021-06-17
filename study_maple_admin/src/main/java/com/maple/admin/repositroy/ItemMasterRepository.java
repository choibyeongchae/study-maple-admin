package com.maple.admin.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maple.admin.entity.ItemMaster;
import com.maple.admin.entity.ItemMasterKey;

@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, ItemMasterKey>{

}
