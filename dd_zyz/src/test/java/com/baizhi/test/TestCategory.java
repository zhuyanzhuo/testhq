package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Category;
import com.baizhi.service.impl.CategoryServiceImpl;

public class TestCategory {
	@Test
	public void testCategory(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		List<Category> list = impl.findAll();
		for (Category category : list) {
			System.out.println(category);
		}
	}
	
	@Test
	public void testAddSecound(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		impl.addSecoundService(new Category("123456789","waiguo","6469fc75-0588-490e-86db-90486abefac4","2"));
		
	}
}
