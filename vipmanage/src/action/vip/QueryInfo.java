package action.vip;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.logdao.Log;
import dao.logdao.LogDAO;
import dao.userdao.User;
import dao.userdao.UserDAO;

public class QueryInfo extends ActionSupport {
	Integer vipID;
	UserDAO userDAO;
	User user;
	LogDAO logDAO;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getVipID() {
		return vipID;
	}

	public void setVipID(Integer vipID) {
		this.vipID = vipID;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public LogDAO getLogDAO() {
		return logDAO;
	}

	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	public String execute() {
		List<User> users = userDAO.findByVipId(vipID);
		HttpServletRequest request = ServletActionContext.getRequest();
		user = users.get(0);
		if (user != null && vipID.equals(user.getVipId())) {
			request.setAttribute("user", user);
			Log log2 = new Log();
			String username = (String)request.getSession().getAttribute("username");
			log2.setUserName(username);
			log2.setTime(new Timestamp(new Date().getTime()));
			log2.setAction("查询VIP信息");
			logDAO.save(log2);
			return SUCCESS;
		}
		return ERROR;
	}
}