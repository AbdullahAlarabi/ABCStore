package com.warba.abcstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warba.abcstore.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
