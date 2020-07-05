package action.log;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.logdao.Log;
import dao.logdao.LogDAO;

public class LogManage extends ActionSupport {
	Log log;
	LogDAO logDAO;
	List<Log> logs;

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public LogDAO getLogDAO() {
		return logDAO;
	}

	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}
	public String execute() {
		logs = logDAO.findAll();		
		return SUCCESS;
	}

}