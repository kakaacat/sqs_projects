package dao.storedao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Store entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "store", catalog = "vip_manage")
public class Store implements java.io.Serializable {

	// Fields

	private Integer id;
	private String address;
	private String boss;
	private String bossTel;
	private String remark;

	// Constructors

	/** default constructor */
	public Store() {
	}

	/** minimal constructor */
	public Store(String address) {
		this.address = address;
	}

	/** full constructor */
	public Store(String address, String boss, String bossTel, String remark) {
		this.address = address;
		this.boss = boss;
		this.bossTel = bossTel;
		this.remark = remark;
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

	@Column(name = "address", nullable = false, length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "boss", length = 20)
	public String getBoss() {
		return this.boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	@Column(name = "boss_tel", length = 50)
	public String getBossTel() {
		return this.bossTel;
	}

	public void setBossTel(String bossTel) {
		this.bossTel = bossTel;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}