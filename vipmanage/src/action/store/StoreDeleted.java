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

public class StoreDeleted extends ActionSupport {
	Integer id;
	StoreDAO storeDAO;
	LogDAO logDAO;
	
	public LogDAO getLogDAO() {
		return logDAO;
	}

	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StoreDAO getStoreDAO() {
		return storeDAO;
	}

	public void setStoreDAO(StoreDAO storeDAO) {
		this.storeDAO = storeDAO;
	}

	public String execute() {
		Store store = storeDAO.findById(id);
		storeDAO.delete(store);
		return SUCCESS;
	}
}