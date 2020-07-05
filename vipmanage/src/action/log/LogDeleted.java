package action.log;

import com.opensymphony.xwork2.ActionSupport;

import dao.logdao.LogDAO;
import dao.logdao.Log;

public class LogDeleted extends ActionSupport {
	Integer id;
	LogDAO logDAO;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LogDAO getLogDAO() {
		return logDAO;
	}

	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	public String execute() {
		Log log = logDAO.findById(id);
		logDAO.delete(log);
		return SUCCESS;
	}
}