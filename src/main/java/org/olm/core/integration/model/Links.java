package org.olm.core.integration.model;

public class Links {
	private String self;
	private String vnfInstance;
	
	public Links() {
		
	}
	
	public Links(String self, String vnfInstance) {
		this.self = self;
		this.vnfInstance = vnfInstance;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getVnfInstance() {
		return vnfInstance;
	}

	public void setVnfInstance(String vnfInstance) {
		this.vnfInstance = vnfInstance;
	}
	
	
}
