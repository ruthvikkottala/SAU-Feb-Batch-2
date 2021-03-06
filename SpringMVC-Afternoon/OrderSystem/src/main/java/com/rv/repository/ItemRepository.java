package com.rv.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rv.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	

}
