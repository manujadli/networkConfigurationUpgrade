package org.olm.core.integration.model;

public class VNFInstanceRequest {
	
	private String vnfdId;
	private String vnfInstanceName;
	private String vnfInstanceDescription;
	private AdditionalParams additionalParams;
	
	public VNFInstanceRequest() {
		
	}
	
	
	public VNFInstanceRequest(String vnfdId, String vnfInstanceName, String vnfInstanceDescription,
			AdditionalParams additionalParams) {
		this.vnfdId = vnfdId;
		this.vnfInstanceName = vnfInstanceName;
		this.vnfInstanceDescription = vnfInstanceDescription;
		this.additionalParams = additionalParams;
	}


	public String getVnfdId() {
		return vnfdId;
	}


	public void setVnfdId(String vnfdId) {
		this.vnfdId = vnfdId;
	}


	public String getVnfInstanceName() {
		return vnfInstanceName;
	}


	public void setVnfInstanceName(String vnfInstanceName) {
		this.vnfInstanceName = vnfInstanceName;
	}


	public String getVnfInstanceDescription() {
		return vnfInstanceDescription;
	}


	public void setVnfInstanceDescription(String vnfInstanceDescription) {
		this.vnfInstanceDescription = vnfInstanceDescription;
	}


	public AdditionalParams getAdditionalParams() {
		return additionalParams;
	}


	public void setAdditionalParams(AdditionalParams additionalParams) {
		this.additionalParams = additionalParams;
	}


	@Override
	public String toString() {
		return "VNFInstanceRequest [vnfdId=" + vnfdId + ", vnfInstanceName=" + vnfInstanceName
				+ ", vnfInstanceDescription=" + vnfInstanceDescription + ", additionalParams=" + additionalParams + "]";
	}
	
	
}
