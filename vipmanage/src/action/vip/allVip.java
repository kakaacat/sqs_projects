package action.vip;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.logdao.LogDAO;
import dao.userdao.User;
import dao.userdao.UserDAO;

public class allVip extends ActionSupport {
	User user;
	List<User> users;
	UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String execute() {
		users = userDAO.findAll();
		return SUCCESS;
	}
}