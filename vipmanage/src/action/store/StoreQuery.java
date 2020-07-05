package action.store;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.logdao.Log;
import dao.logdao.LogDAO;
import dao.storedao.Store;
import dao.storedao.StoreDAO;


public class StoreQuery extends ActionSupport {
	String boss;
	Store store;
	StoreDAO storeDAO;
	LogDAO logDAO;
	
	
	public String getBoss() {
		return boss;
	}


	public void setBoss(String boss) {
		this.boss = boss;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
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
		List<Store> stores = storeDAO.findByBoss(boss);
		HttpServletRequest request = ServletActionContext.getRequest();
		store = stores.get(0);
		if (store != null && boss.equals(store.getBoss())) {
			request.setAttribute("store", store);
			Log log2 = new Log();
			String username = (String)request.getSession().getAttribute("username");
			log2.setUserName(username);
			log2.setTime(new Timestamp(new Date().getTime()));
			log2.setAction("查看店铺信息");
			logDAO.save(log2);
			return SUCCESS;
		}	
		return ERROR;
	}
}