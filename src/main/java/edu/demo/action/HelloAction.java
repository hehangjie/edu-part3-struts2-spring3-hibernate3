package edu.demo.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

//声明此类为控制层的类
@Controller
@Scope("prototype")//支持多例  
@ParentPackage("struts-default")  //表示继承的父包  
@Namespace(value="/demo") //表示当前Action所在命名空间  
public class HelloAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	@Action(value = "helloworld", results = { @Result(name = "success", location = "/hello.jsp") })
	public String execute() throws Exception {
		return SUCCESS;
	}

}
