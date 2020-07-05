package action.vip;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.userdao.User;
import dao.userdao.UserDAO;

public class ModifyVip extends ActionSupport {
	Integer vipId;
	String name;
	String password;
	String gender;
	String telphone;
	Integer level;
	Integer exp;
	Integer point;
	UserDAO userDAO;
	
	
	public Integer getVipId() {
		return vipId;
	}


	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getTelphone() {
		return telphone;
	}


	public void setTelphone(String telphone) {
		this.telphone = telphone;
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
		List<User> users = userDAO.findByVipId(vipId);
		User user = users.get(0);
		if (user != null && vipId.equals(user.getVipId())) {
			user.setName(name);
			user.setPassword(password);
			user.setGender(gender);
			user.setTelphone(telphone);
			user.setLevel(level);
			user.setExp(exp);
			user.setPoint(point);
			userDAO.merge(user);
			return SUCCESS;
		}
		return ERROR;
	}
}