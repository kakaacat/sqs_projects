package action.vip;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.logdao.Log;
import dao.userdao.User;
import dao.userdao.UserDAO;

public class MargeVip extends ActionSupport {
	Integer id;
	UserDAO userDAO;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public UserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public String execute() {
		List<User> users = userDAO.findByVipId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = users.get(0);
		if (user != null && id.equals(user.getVipId())) {
			request.setAttribute("user", user);
			return SUCCESS;
		}
		return ERROR;
	}
}