package xtqh.resource.model;

import java.util.List;

import xtqh.base.model.BaseEntity;

/**
 * 资源
 * @author Daniel
 * @version 1.0
 * @created 02-九月-2016 20:53:31
 */
public class Resource extends BaseEntity {

	private String name;
	/**
	 * 资源属性值
	 */
	private List<Property> properties;
	/**
	 * 资源类型
	 */
	private ResourceType resourceType;
	/**
	 * 控制IP地址
	 */
	private String controllingIP;
	/**
	 * 跟ansible server的连通状态
	 */
	private List<ResourceConnectionStatus> connectionStatuses;
	/**
	 * 是否为从CMDB导入的资源
	 */
	private boolean fromCMDB;
	/**
	 * 在CMDB里的id
	 */
	private String idInCMDB;

}