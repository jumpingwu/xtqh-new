
package xtqh.resource.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

//import xtqh.execution.model.AnsibleServer;
import xtqh.dao.entity.Resource;
import xtqh.framework.base.BaseEntity;

/**
 * 资源对ansible server可达情况
 * 
 * @author Daniel
 * @version 1.0
 * @created 02-九月-2016 20:57:37
 */
@Entity
@Table(name = "TB_RESOURCECONNECTIONSTATUS")
public class ResourceConnectionStatus extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "ID", columnDefinition = "CHAR(36)")
	private String resourceConnectionStatus_id;
	@Transient
	private Resource resource;

	// private AnsibleServer ansibleServer;
	/**
	 * 该ansible server对该资源是否可达
	 */
	@Transient
	private boolean isReachable;
	/**
	 * 最后可达时间点
	 */
	@Transient
	private Date lastReachableTime;
	/**
	 * 最后一次连接测试时间
	 */
	@Transient
	private Date lastConnectionTestTime;

}