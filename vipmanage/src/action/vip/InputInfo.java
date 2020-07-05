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

public class InputInfo extends ActionSupport {
	Integer vipID;
	Integer level;
	Integer exp;
	Integer point;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String execute() {
		List<User> userImp = userDAO.findByVipId(vipID);
		User user = userImp.get(0);
		if (user != null && vipID.equals(user.getVipId())) {
			user.setLevel(level);
			user.setExp(exp);
			user.setPoint(point);
			userDAO.merge(user);
			Log log2 = new Log();
			HttpServletRequest request = ServletActionContext.getRequest();
			String username = (String)request.getSession().getAttribute("username");
			log2.setUserName(username);
			log2.setTime(new Timestamp(new Date().getTime()));
			log2.setAction("添加店铺信息");
			logDAO.save(log2);
			return SUCCESS;
		}
		return ERROR;
	}
}