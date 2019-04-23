package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Ebook;
import com.baizhi.service.impl.EbookServiceImpl;

public class TestEbook {

	@Test
	public void testEbook(){
		EbookServiceImpl impl = new EbookServiceImpl();
		List<Ebook> list = impl.findByLikeNum("1315ab503138489cb4d3a9926528c029");
		for(Ebook ebook:list){
			System.out.println(ebook);
		}
	}
}
