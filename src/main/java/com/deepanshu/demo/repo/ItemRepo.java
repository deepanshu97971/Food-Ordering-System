package com.deepanshu.demo.repo;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import com.deepanshu.demo.model.Items;

public interface ItemRepo extends CrudRepository<Items, Integer>
{
	
	@Query("select price from Items where Sno=?1")
	int findPrice(int Sno);

}
