package xtqh.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import xtqh.framework.base.BaseEntity;

@Entity
@Table(name = "USER")
public class User extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MANAGEMENT")
	@SequenceGenerator(sequenceName = "SEQ_MANAGEMENT", name = "SEQ_MANAGEMENT")
	private String userId;

	@Column(name = "USER_NAME", columnDefinition = "VARCHAR(500)")
	private String userName;

	@Column(name = "PASSWORD", columnDefinition = "VARCHAR(50)")
	private String password;

	@Column(name = "GROUP_ID",columnDefinition = "VARCHAR(25)")
	private String groupId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
