package xtqh.business.bean;

/**
 * 
 * @author Yan Fugen
 *
 */

public class BResource {

	private String resource_id;

	private String name;

	private String resource_type;

	private String hostname;

	private String applicationNames;

	private String applicationIDs;

	// private List<Application> applicatoinList;

	private String controlling_ip;

	private String resource_ip;

	private String location;

	private String status;

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
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

	public String getResource_ip() {
		return resource_ip;
	}

	public void setResource_ip(String resource_ip) {
		this.resource_ip = resource_ip;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getResource_type() {
		return resource_type;
	}

	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getApplicationNames() {
		return applicationNames;
	}

	public void setApplicationNames(String applicationNames) {
		this.applicationNames = applicationNames;
	}

	public String getApplicationIDs() {
		return applicationIDs;
	}

	public void setApplicationIDs(String applicationIDs) {
		this.applicationIDs = applicationIDs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
