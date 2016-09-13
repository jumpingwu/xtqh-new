package xtqh.dao.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import xtqh.base.BaseEntity;
import xtqh.dao.entity.mapping.M_Resource_Property;
import xtqh.dao.entity.mapping.M_Resource_ResourceConnectionStatus;

/**
 * 

  * @ClassName: Resource

  * @Description: TODO

  * @author Comsys-Yan Fugen

  * @date Sep 13, 2016 3:29:46 PM

  *
 */
@Entity
@Table(name = "RESOURCE")
public class Resource extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "ID", columnDefinition = "CHAR(36)")
	private String resource_id;

	@Column(name = "NAME", columnDefinition = "VARCHAR(50)")
	private String name;

	@Column(name = "CONTROLLING_IP", columnDefinition = "VARCHAR(50)")
	private String controlling_ip;

	@Column(name = "FROM_CMDB")
	@org.hibernate.annotations.Type(type = "yes_no")
	private boolean fromCMDB;

	@Column(name = "ID_IN_CMDB", columnDefinition = "VARCHAR(50)")
	private String idInCMDB;

	@Column(name = "RESOURCE_TYPE", columnDefinition = "VARCHAR(50)")
	private String resourceType;

	@OneToMany(mappedBy = "resource", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private Set<M_Resource_Property> resourceProperty = new HashSet<M_Resource_Property>();;

	@OneToMany(mappedBy = "resourceConnectionStatus", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<M_Resource_ResourceConnectionStatus> connectionStatus;


	public Set<M_Resource_Property> getResourceProperty() {
		return resourceProperty;
	}

	public void setResourceProperty(Set<M_Resource_Property> resourceProperty) {
		this.resourceProperty = resourceProperty;
	}

	public List<M_Resource_ResourceConnectionStatus> getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(List<M_Resource_ResourceConnectionStatus> connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getControlling_ip() {
		return controlling_ip;
	}

	public void setControlling_ip(String controlling_ip) {
		this.controlling_ip = controlling_ip;
	}

	public boolean isFromCMDB() {
		return fromCMDB;
	}

	public void setFromCMDB(boolean fromCMDB) {
		this.fromCMDB = fromCMDB;
	}

	public String getIdInCMDB() {
		return idInCMDB;
	}

	public void setIdInCMDB(String idInCMDB) {
		this.idInCMDB = idInCMDB;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}

	// public List<Property> getProperties() {
	// return properties;
	// }
	//
	// public void setProperties(List<Property> properties) {
	// this.properties = properties;
	// }
	//
	// public List<ResourceConnectionStatus> getConnectionStatus() {
	// return connectionStatus;
	// }
	//
	// public void setConnectionStatus(List<ResourceConnectionStatus>
	// connectionStatus) {
	// this.connectionStatus = connectionStatus;
	// }

}
