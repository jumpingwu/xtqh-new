package xtqh.resource.model;

import java.util.List;
import java.util.Map;

import xtqh.base.model.BaseEntity;

/**
 * 璧勬簮缁�
 * @author Daniel
 * @version 1.0
 * @created 02-涔濇湀-2016 20:57:54
 */
public class ResourceGroup extends BaseEntity {

	private String name;
	/**
	 * 鍖呭惈璧勬簮锛堝惈鏍囩锛�
	 */
	private Map<Resource,List<ResourceTag>> taggedResources;
	/**
	 * 璧勬簮缁勫睘鎬у��
	 */
	private List<Property> properties;
//	public ProcessVersion m_ProcessVersion;

}