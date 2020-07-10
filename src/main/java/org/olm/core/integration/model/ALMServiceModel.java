package org.olm.core.integration.model;

public class ALMServiceModel {
	
	/* define fields */
	private Properties properties;
	private String vnfLcmOpOccId;
	private String description;
	private String projectId;
	private String lastModifiedAt;
	private String descriptorName;
	private String name;
	private String createdAt;
	private String message;
	private String status;
	
	/* define fields */
	
	public ALMServiceModel() {		
		
	}

	public ALMServiceModel(Properties properties, String vnfLcmOpOccId, String description, String projectId,
			String lastModifiedAt, String descriptorName, String name, String createdAt, String message,
			String status) {
		this.properties = properties;
		this.vnfLcmOpOccId = vnfLcmOpOccId;
		this.description = description;
		this.projectId = projectId;
		this.lastModifiedAt = lastModifiedAt;
		this.descriptorName = descriptorName;
		this.name = name;
		this.createdAt = createdAt;
		this.message = message;
		this.status = status;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getVnfLcmOpOccId() {
		return vnfLcmOpOccId;
	}

	public void setVnfLcmOpOccId(String vnfLcmOpOccId) {
		this.vnfLcmOpOccId = vnfLcmOpOccId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(String lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public String getDescriptorName() {
		return descriptorName;
	}

	public void setDescriptorName(String descriptorName) {
		this.descriptorName = descriptorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
		
}
