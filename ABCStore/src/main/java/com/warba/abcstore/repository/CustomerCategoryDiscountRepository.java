package com.warba.abcstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.warba.abcstore.entity.CustomerCategoryDiscount;

@Repository
public interface CustomerCategoryDiscountRepository extends JpaRepository<CustomerCategoryDiscount,Long> {

	@Query(value = "SELECT discount FROM customer_category_discount  WHERE category_id = :categoryId and customer_type_id = :customerTypeId", nativeQuery = true)
	int getDiscountPercentage(@Param("categoryId") long categoryId,@Param("customerTypeId") long customerTypeId);


}
