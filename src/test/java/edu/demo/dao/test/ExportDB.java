package edu.demo.dao.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.demo.model.Demo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ExportDB {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void test() {
//		sessionFactory.
//		SchemaExport export = new SchemaExport(cfg);
//		/*
//		 * 开始导出 第一个参数： script 是否打印DDL信息 第二个参数： export 是否导出到数据库中生成表
//		 */
//		export.create(true, true);
//		
//		System.out.println("Exprot Success");
	}

}
