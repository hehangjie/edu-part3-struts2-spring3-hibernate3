package edu.demo.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.demo.dao.DemoDao;
import edu.demo.model.Demo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DemoDaoTest {
	@Autowired
	private DemoDao demoDao;

	@Test
	public void testFindList() {
		List<Demo> list = demoDao.findList();

		for (Demo user : list) {
			System.out.println(user.getUserName());
		}
	}

	@Test
	public void testAdd() {
		List<Demo> list = demoDao.findList();
		int size = list.size();
		Demo user = new Demo();
		user.setUserId(77);
		user.setUserName("zhangs");
		user.setAge(31);
		demoDao.add(user);
		demoDao.flush();
		list = demoDao.findList();
		int finalSize = list.size();
		Assert.assertTrue(finalSize == size + 1);
	}

}
