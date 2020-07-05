package dao.logdao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log", catalog = "vip_manage")
public class Log implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String action;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** minimal constructor */
	public Log(String userName, String action) {
		this.userName = userName;
		this.action = action;
	}

	/** full constructor */
	public Log(String userName, String action, Timestamp time) {
		this.userName = userName;
		this.action = action;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_name", nullable = false, length = 40)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "action", nullable = false, length = 100)
	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}