package org.olm.core.integration.model;

public class VNFServiceModelResponse {
	
	/* define fields */
	private String id;
	private String operationState;
	private String vnfInstanceId;
	private String stateEnteredTime;
	private String startTime;
	private String operation;
	private String isAutomaticInvocation;
	private String operationParams;
	private String isCancelPending;
	private String resourceChanges;
	private Links _links;
	
	/* define fields */
	
	public VNFServiceModelResponse() {
		
	}
	
	
	public VNFServiceModelResponse(String id, String operationState, String vnfInstanceId, String stateEnteredTime,
			String startTime, String operation, String isAutomaticInvocation, String operationParams,
			String isCancelPending, String resourceChanges, Links _links) {
		this.id = id;
		this.operationState = operationState;
		this.vnfInstanceId = vnfInstanceId;
		this.stateEnteredTime = stateEnteredTime;
		this.startTime = startTime;
		this.operation = operation;
		this.isAutomaticInvocation = isAutomaticInvocation;
		this.operationParams = operationParams;
		this.isCancelPending = isCancelPending;
		this.resourceChanges = resourceChanges;
		this._links = _links;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getOperationState() {
		return operationState;
	}


	public void setOperationState(String operationState) {
		this.operationState = operationState;
	}


	public String getVnfInstanceId() {
		return vnfInstanceId;
	}


	public void setVnfInstanceId(String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
	}


	public String getStateEnteredTime() {
		return stateEnteredTime;
	}


	public void setStateEnteredTime(String stateEnteredTime) {
		this.stateEnteredTime = stateEnteredTime;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public String getIsAutomaticInvocation() {
		return isAutomaticInvocation;
	}


	public void setIsAutomaticInvocation(String isAutomaticInvocation) {
		this.isAutomaticInvocation = isAutomaticInvocation;
	}


	public String getOperationParams() {
		return operationParams;
	}


	public void setOperationParams(String operationParams) {
		this.operationParams = operationParams;
	}


	public String getIsCancelPending() {
		return isCancelPending;
	}


	public void setIsCancelPending(String isCancelPending) {
		this.isCancelPending = isCancelPending;
	}


	public String getResourceChanges() {
		return resourceChanges;
	}


	public void setResourceChanges(String resourceChanges) {
		this.resourceChanges = resourceChanges;
	}


	public Links get_links() {
		return _links;
	}


	public void set_links(Links _links) {
		this._links = _links;
	}
	
		
}
