package com.warba.abcstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.warba.abcstore.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
