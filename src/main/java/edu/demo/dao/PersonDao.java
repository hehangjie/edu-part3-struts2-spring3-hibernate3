package edu.demo.dao;

import org.springframework.stereotype.Repository;

import edu.common.dao.BaseDao;
import edu.demo.model.Person;

@Repository
public class PersonDao extends BaseDao<Person, Integer> {

}
