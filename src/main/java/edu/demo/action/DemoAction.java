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

import edu.demo.model.Demo;
import edu.demo.service.DemoService;

//声明此类为控制层的类
@Controller
@Scope("prototype")
// 支持多例
@ParentPackage("struts-default")
// 表示继承的父包
@Namespace(value = "/demo")
// 表示当前Action所在命名空间
public class DemoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private DemoService demoService;
	private List<Demo> users;

	@Action(value = "demo_list", results = { @Result(name = "success", location = "/hello.jsp") })
	public String userList() {
		users = demoService.findList();
		return SUCCESS;
	}

	public List<Demo> getUsers() {
		return users;
	}

	public void setUsers(List<Demo> users) {
		this.users = users;
	}

}
