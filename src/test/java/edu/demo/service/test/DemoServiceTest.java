package edu.demo.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.demo.model.Demo;
import edu.demo.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DemoServiceTest {

	@Autowired
	private DemoService demoService;

	@Test
	public void testAdd() {
		int size = demoService.findList().size();

		Demo entity = new Demo();
		entity.setUserId(472);
		entity.setUserName("Leefour");
		entity.setAge(99);
		demoService.add(entity);
		
		

		int finalSize = demoService.findList().size();

		Assert.assertTrue(finalSize == size + 1);
	}

}
