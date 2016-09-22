
package xtqh.resource.model;

import java.util.Date;

import xtqh.base.model.BaseEntity;
import xtqh.execution.model.AnsibleServer;

/**
 * 资源对ansible server可达情况
 * @author Daniel
 * @version 1.0
 * @created 02-九月-2016 20:57:37
 */
public class ResourceConnectionStatus extends BaseEntity {

	private Resource resource;
	
	private AnsibleServer ansibleServer;
	/**
	 * 该ansible server对该资源是否可达
	 */
	private boolean isReachable;
	/**
	 * 最后可达时间点
	 */
	private Date lastReachableTime;
	/**
	 * 最后一次连接测试时间
	 */
	private Date lastConnectionTestTime;

}