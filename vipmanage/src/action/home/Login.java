package action.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.admindao.Admin;
import dao.admindao.AdminDAO;

public class Login extends ActionSupport {
	String username;
	String password;
	AdminDAO adminDAO;
	
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public AdminDAO getAdminDAO() {
		return adminDAO;
	}



	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}


	public String execute() {
		List<Admin> admin = adminDAO.findByName(username);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		while (!admin.isEmpty() && password.equals(admin.get(0).getPassword())) {
			return SUCCESS;
		}
		return ERROR;
	}
}