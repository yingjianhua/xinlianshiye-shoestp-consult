package com.xinlianshiye.shoestp.consult.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xinlianshiye.shoestp.user.api.entity.Purchase;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ConsultRepositoryTest {
	
	@Autowired
	private ConsultRepository consultRepository;
	
	@Test
//	@Ignore
	public void testGetLimit() {
		Purchase purchase = new Purchase();
		purchase.setPkey(1);
		Byte type = (byte)1;
		String keyword = "";
		Boolean unread = false;
		Integer lastRelation = 1;
		Integer start = 0;
		Integer limit = 10;
		Integer limit2 = consultRepository.getLimit(purchase, type, keyword, unread, lastRelation, start, limit);
		System.out.println(limit2 ); 
	}
	
	@Test
	@Ignore
	public void testFindAll() {
		consultRepository.findAll();
	}
	
	@Test
	public void testTest() {
		consultRepository.test();
	}
}
