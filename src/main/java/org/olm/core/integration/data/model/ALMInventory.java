package org.olm.core.integration.data.model;


public class ALMInventory {

	private int id;
	private String user;
	private String vnfLcmOpOccId;
	private String vnfInstanceId;
	private String vnfInstanceName;
	private String vnfInstanceDescription;
	private String instantiationState;
	private String vnfProvider;
	private String vnfProductName;
	private String vnfPkgId;
	private String vnfSoftwareVersion;
	private int  stateCounter;

	/* constructors starts*/
	public ALMInventory() {
		
	}

	public ALMInventory(String user, String vnfLcmOpOccId, String vnfInstanceId, String vnfInstanceName,
			String vnfInstanceDescription, String instantiationState, String vnfProvider, String vnfProductName,
			String vnfPkgId, String vnfSoftwareVersion, int stateCounter) {
		this.user = user;
		this.vnfLcmOpOccId = vnfLcmOpOccId;
		this.vnfInstanceId = vnfInstanceId;
		this.vnfInstanceName = vnfInstanceName;
		this.vnfInstanceDescription = vnfInstanceDescription;
		this.instantiationState = instantiationState;
		this.vnfProvider = vnfProvider;
		this.vnfProductName = vnfProductName;
		this.vnfPkgId = vnfPkgId;
		this.vnfSoftwareVersion = vnfSoftwareVersion;
		this.stateCounter = stateCounter;
	}
	
	/* constructors Ends*/

	/* getters and setters starts */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getVnfLcmOpOccId() {
		return vnfLcmOpOccId;
	}

	public void setVnfLcmOpOccId(String vnfLcmOpOccId) {
		this.vnfLcmOpOccId = vnfLcmOpOccId;
	}

	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	public void setVnfInstanceId(String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
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

	public String getInstantiationState() {
		return instantiationState;
	}

	public void setInstantiationState(String instantiationState) {
		this.instantiationState = instantiationState;
	}

	public String getVnfProvider() {
		return vnfProvider;
	}

	public void setVnfProvider(String vnfProvider) {
		this.vnfProvider = vnfProvider;
	}

	public String getVnfProductName() {
		return vnfProductName;
	}

	public void setVnfProductName(String vnfProductName) {
		this.vnfProductName = vnfProductName;
	}

	public String getVnfPkgId() {
		return vnfPkgId;
	}

	public void setVnfPkgId(String vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
	}

	public String getVnfSoftwareVersion() {
		return vnfSoftwareVersion;
	}

	public void setVnfSoftwareVersion(String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
	}

	public int getStateCounter() {
		return stateCounter;
	}

	public void setStateCounter(int stateCounter) {
		this.stateCounter = stateCounter;
	}
	
	/* getters and setters ends */
	
	
	/* toString */
	
	@Override
	public String toString() {
		return "ALMInventory [id=" + id + ", user=" + user + ", vnfLcmOpOccId=" + vnfLcmOpOccId + ", vnfInstanceId="
				+ vnfInstanceId + ", vnfInstanceName=" + vnfInstanceName + ", vnfInstanceDescription="
				+ vnfInstanceDescription + ", instantiationState=" + instantiationState + ", vnfProvider=" + vnfProvider
				+ ", vnfProductName=" + vnfProductName + ", vnfPkgId=" + vnfPkgId + ", vnfSoftwareVersion="
				+ vnfSoftwareVersion + ", stateCounter=" + stateCounter + "]";
	}
}
