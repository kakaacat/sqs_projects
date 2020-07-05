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

public class DeletedVip extends ActionSupport {
	Integer vipID;
	UserDAO userDAO;
	LogDAO logDAO;
	
	
	public LogDAO getLogDAO() {
		return logDAO;
	}


	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
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

	public String execute() {
		try {
			List<User> users = userDAO.findByVipId(vipID);
			User user = users.get(0);
			userDAO.delete(user);
			Log log2 = new Log();
			HttpServletRequest request = ServletActionContext.getRequest();
			String username = (String)request.getSession().getAttribute("username");
			log2.setUserName(username);
			log2.setTime(new Timestamp(new Date().getTime()));
			log2.setAction("删除VIP信息");
			logDAO.save(log2);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}