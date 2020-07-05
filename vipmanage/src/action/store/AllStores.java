package action.store;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.storedao.Store;
import dao.storedao.StoreDAO;

public class AllStores extends ActionSupport {
	Store store;
	StoreDAO storeDAO;
	List<Store> stores;
	
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

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public String execute() {
		stores = storeDAO.findAll();
		return SUCCESS;
	}
}