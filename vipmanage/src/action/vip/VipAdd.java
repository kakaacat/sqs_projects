package action.vip;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.logdao.Log;
import dao.logdao.LogDAO;
import dao.userdao.User;
import dao.userdao.UserDAO;

public class VipAdd extends ActionSupport {
	Integer vipID;
	String username;
	String password;
	String gender;
	String telphone;
	String email;
	String birthday;
	UserDAO userDAO;
	LogDAO logDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Integer getVipID() {
		return vipID;
	}

	public void setVipID(Integer vipID) {
		this.vipID = vipID;
	}

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



	public String  getGender() {
		return gender;
	}



	public void setGender(String  gender) {
		this.gender = gender;
	}



	public String getTelphone() {
		return telphone;
	}



	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String  birthday) {
		this.birthday = birthday;
	}
	
	
	public LogDAO getLogDAO() {
		return logDAO;
	}

	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	public String execute() {
		User user = new User();
		try {
			user.setVipId(vipID);
			user.setName(username);
			user.setPassword(password);
			user.setGender(gender);	
			user.setTelphone(telphone);
			user.setEmail(email);
			long date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday).getTime();
			Timestamp tBirthday = new Timestamp(date);
			user.setBirthday(tBirthday);
			//开户时间
			Timestamp sTimestamp = new Timestamp(new Date().getTime());
			user.setStartTime(sTimestamp);
			//过期时间-1年
			Timestamp eTimestamp = new Timestamp(sTimestamp.getTime() + 31536000000L);
			user.setEndTime(eTimestamp);
			user.setStatus(2);
			user.setLevel(0);
			user.setExp(0);
			user.setPoint(0);
			userDAO.save(user);
			Log log2 = new Log();
			HttpServletRequest request = ServletActionContext.getRequest();
			String username = (String)request.getSession().getAttribute("username");
			log2.setUserName(username);
			log2.setTime(new Timestamp(new Date().getTime()));
			log2.setAction("添加VIP信息");
			logDAO.save(log2);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}