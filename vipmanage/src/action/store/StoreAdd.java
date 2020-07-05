package action.store;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.logdao.Log;
import dao.logdao.LogDAO;
import dao.storedao.Store;
import dao.storedao.StoreDAO;

public class StoreAdd extends ActionSupport {
	String address;
	String boss;
	String bossTel;
	String remark;
	StoreDAO storeDAO;
	LogDAO logDAO;
	
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getBoss() {
		return boss;
	}


	public void setBoss(String boss) {
		this.boss = boss;
	}


	public String getBossTel() {
		return bossTel;
	}


	public void setBossTel(String bossTel) {
		this.bossTel = bossTel;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public StoreDAO getStoreDAO() {
		return storeDAO;
	}


	public void setStoreDAO(StoreDAO storeDAO) {
		this.storeDAO = storeDAO;
	}

	public LogDAO getLogDAO() {
		return logDAO;
	}


	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}


	public String execute() {
		Store store = new Store();
		store.setAddress(address);
		store.setBoss(boss);
		store.setBossTel(bossTel);
		store.setRemark(remark);
		storeDAO.save(store);
		Log log2 = new Log();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String)request.getSession().getAttribute("username");
		log2.setUserName(username);
		log2.setTime(new Timestamp(new Date().getTime()));
		log2.setAction("添加店铺信息");
		logDAO.save(log2);
		return SUCCESS;
	}
}