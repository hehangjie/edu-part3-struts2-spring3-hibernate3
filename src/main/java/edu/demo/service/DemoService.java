package edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.demo.dao.DemoDao;
import edu.demo.model.Demo;

@Service
public class DemoService {

	@Autowired
	private DemoDao demoDao;

	public List<Demo> findList() {
		return demoDao.findList();
	}

	public Demo get(Integer userId) {
		return demoDao.get(userId);
	}

	public void add(Demo user) {
		demoDao.add(user);
		demoDao.flush();
	}

	public void delete(Integer userId) {
		demoDao.delete(userId);
		demoDao.flush();
	}

	public void update(Demo user) {
		demoDao.update(user);
		demoDao.flush();
	}
}
