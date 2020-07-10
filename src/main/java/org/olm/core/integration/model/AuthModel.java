package org.olm.core.integration.model;

public class AuthModel {
	private String grant_type;
	private String access_token;
	private String expires_in;

	public AuthModel() {
		
	}

	public AuthModel(String grant_type, String access_token) {
		this.grant_type = grant_type;
		this.access_token = access_token;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	
	
}
