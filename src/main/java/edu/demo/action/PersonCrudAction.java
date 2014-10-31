package edu.demo.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.demo.model.Person;
import edu.demo.service.PersonService;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value = "/example")
public class PersonCrudAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private PersonService personService;
	private int i;
	private Person person;
	private List<Person> result;
	
	@Action(value = "personCrud_list", results = { @Result(name = "success", location = "/example/personCrud.jsp") })
	public String list() throws Exception {
		result = personService.findList();
		return SUCCESS;
	}

	@Action(value = "personCrud_add", results = { @Result(name = "success", location = "/example/personCrud.jsp") })
	public String add() throws Exception {
		personService.add(person);
		return list();
	}

	public String remove() throws Exception {
		//personService.;
		return list();
	}

	public String update() throws Exception {
		//personService.update(i, person);
		return list();
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getResult() {
		return result;
	}

	public void setResult(List<Person> result) {
		this.result = result;
	}

}
