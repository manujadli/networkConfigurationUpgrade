package org.olm.core.integration.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.olm.core.integration.constants.ApplicationConstants;
import org.olm.core.integration.constants.Operation;
import org.olm.core.integration.constants.OperationState;
import org.olm.core.integration.constants.RandomOperationState;
import org.olm.core.integration.data.model.ALMInventory;
import org.olm.core.integration.model.AuthModel;
import org.olm.core.integration.model.Links;
import org.olm.core.integration.model.VNFInstanceRequest;
import org.olm.core.integration.model.VNFServiceModelResponse;
import org.olm.core.integration.utility.InstanceInfo;
import org.olm.core.integration.utility.OperationStateFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/vnflcm/v1")
public class ALMRestController {	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	static Map<Integer, String> operationStateMap;
	Map<String, ALMInventory>  almInventoryData;
	static Map<String, String> sessionSecurity;
	static List<String> securityList;
	
	static {
		operationStateMap = new HashMap<>();
		sessionSecurity = new HashMap<>();
		securityList = new ArrayList<>();
		int i = 1;
		for (RandomOperationState state : RandomOperationState.values()) {
			operationStateMap.put(i, state.name());
			++i;
		}
	}
	
	@PostMapping("/vnf_instances")
	public ResponseEntity<Object> vnf_instances(@RequestBody VNFInstanceRequest vnfInstanceRequest, @RequestHeader("Set-Cookie") String sessionId) {		
		logger.info("ALMRestController.vnf_instances() \n  {} " , vnfInstanceRequest);
		HttpHeaders httpHeaders = new HttpHeaders();		
		if (securityList.contains(sessionId)) {
			httpHeaders.add("alm-ansibler", ApplicationConstants.REQUESTHEADERSUCCESS);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(InstanceInfo.getInstanceId())
					.toUri();
			
			return ResponseEntity.created(location).build();
		}else {
			httpHeaders.add("alm-ansibler", ApplicationConstants.unauthorized);
			return new ResponseEntity<>("", httpHeaders, HttpStatus.UNAUTHORIZED);	
		}
		
					
	}
	
		
	@PostMapping("vnf_instances/{vnfInstanceId}/instantiate")
	public ResponseEntity<Object> instantiate(@PathVariable("vnfInstanceId") String vnfInstanceId, @RequestHeader("Set-Cookie") String sessionId) {		
		logger.info("ALMRestController.instantiate()");
		HttpHeaders httpHeaders = new HttpHeaders();		
		if (securityList.contains(sessionId)) {
			httpHeaders.add("Location",  ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(InstanceInfo.getInstanceId())
					.toUri().toString());
			return new ResponseEntity<>("", httpHeaders, HttpStatus.ACCEPTED);
		}else {
			httpHeaders.add("alm-ansibler", ApplicationConstants.unauthorized);
			return new ResponseEntity<>("", httpHeaders, HttpStatus.UNAUTHORIZED);
		}
						
	}
	
	@GetMapping("/vnf_lcm_op_occs/{vnfLcmOpOccId}")
	public ResponseEntity<VNFServiceModelResponse> vnf_lcm_op_occs(@PathVariable("vnfLcmOpOccId") String vnfLcmOpOccId, @RequestHeader("Set-Cookie") String sessionId) {		
		logger.info("ALMRestController.vnf_lcm_op_occs() GET invoked at {}", new Date());
		HttpHeaders httpHeaders = new HttpHeaders();	
		if (securityList.contains(sessionId)) {
			if (null!= almInventoryData && !almInventoryData.isEmpty()) {
				if (almInventoryData.containsKey(vnfLcmOpOccId)) {
					logger.info("Inventory {} is present in repository " , vnfLcmOpOccId);
					int counterValue = almInventoryData.get(vnfLcmOpOccId).getStateCounter();
					almInventoryData.get(vnfLcmOpOccId).setStateCounter(counterValue+1);
					}else {
						logger.info("Inventory {} is not present in repository. Writing inventory in repository " , vnfLcmOpOccId);
						almInventoryData = new HashMap<>();
						ALMInventory inventory = new ALMInventory();
						inventory.setVnfLcmOpOccId(vnfLcmOpOccId);
						inventory.setStateCounter(1);		
						inventory.setVnfPkgId(UUID.randomUUID().toString());
						inventory.setVnfProvider("Ericsson");
						inventory.setVnfInstanceId("CXP123456_1-R1A01");
						inventory.setVnfInstanceName("CSCF-1");
						inventory.setVnfProductName("CSCF");
						inventory.setVnfSoftwareVersion("R1A01");
						inventory.setVnfInstanceDescription("A fine VNF");
						inventory.setUser("ALM");
						inventory.setInstantiationState("NOT_INSTANTIATED");
						almInventoryData.put(vnfLcmOpOccId, inventory);
					}
				
			}else {
				logger.info("almInventoryData is Null. Writing vnfLcmOpOccId {} inventory in repository " , vnfLcmOpOccId);
				almInventoryData = new HashMap<>();
				ALMInventory inventory = new ALMInventory();
				inventory.setVnfLcmOpOccId(vnfLcmOpOccId);
				inventory.setStateCounter(1);		
				inventory.setVnfPkgId(UUID.randomUUID().toString());
				inventory.setVnfProvider("Ericsson");
				inventory.setVnfInstanceId("CXP123456_1-R1A01");
				inventory.setVnfInstanceName("CSCF-1");
				inventory.setVnfProductName("CSCF");
				inventory.setVnfSoftwareVersion("R1A01");
				inventory.setVnfInstanceDescription("A fine VNF");
				inventory.setUser("ALM");
				inventory.setInstantiationState("NOT_INSTANTIATED");
				almInventoryData.put(vnfLcmOpOccId, inventory);
			}
			
			
			
			logger.info("inventory is {} " , almInventoryData);
			
			String operationState = null;
			
			if (1 == almInventoryData.get(vnfLcmOpOccId).getStateCounter()) {
				operationState = OperationState.STARTING.name();
			}else if (2 == almInventoryData.get(vnfLcmOpOccId).getStateCounter()) {
				operationState = OperationState.PROCESSING.name();
			}else {
				operationState = operationStateMap.get(OperationStateFinder.getOperationState(operationStateMap.size()));
			}
			
			Links _links = new Links();
			String vnfLcmOpOccIdAddress = ApplicationConstants.apiRoot+"vnflcm/v1/vnf_lcm_op_occs/"+vnfLcmOpOccId;
			String vnfInstanceAddress = ApplicationConstants.apiRoot+"vnflcm/v1/vnf_instances/"+vnfLcmOpOccId;
			_links.setSelf(vnfLcmOpOccIdAddress);
			_links.setVnfInstance(vnfInstanceAddress);
			VNFServiceModelResponse response = new VNFServiceModelResponse(InstanceInfo.getInstanceId(),
																		   operationState,
																		   InstanceInfo.getInstanceId(),
																		   "", 
																		   "",
																		   Operation.INSTANTIATE.name(),
																		   "false",
																		   "", 
																		   "false",
																		   "{ }",
																		   _links);
			
			
				
			httpHeaders.add("alm-ansible", ApplicationConstants.REQUESTHEADERSUCCESS);
			return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
		}else {
			httpHeaders.add("alm-ansibler", ApplicationConstants.unauthorized);
			return new ResponseEntity<>(httpHeaders, HttpStatus.UNAUTHORIZED);
		}
		
					
	}
	
	@PostMapping("/auth/v1/apitoken")
	public ResponseEntity<AuthModel> authServer(@RequestBody AuthModel authModel, HttpServletResponse response){
		logger.info("securityList {}", securityList.size());
		if (null!=securityList && !securityList.isEmpty()) {
			securityList.clear();
		}
		AuthModel model = new AuthModel();
		String sessionId = UUID.randomUUID().toString();
		model.setAccess_token("SessionAuthorization");
		HttpHeaders httpHeaders = new HttpHeaders();		
		httpHeaders.add("alm-ansible", ApplicationConstants.REQUESTHEADERSUCCESS);
		httpHeaders.add("Set-Cookie", sessionId);		
		securityList.add(sessionId);
		return new ResponseEntity<>(model, httpHeaders, HttpStatus.OK);	
	}
	
	@GetMapping("/testHit")
	public ResponseEntity<String> showTestLogs(@RequestHeader("Set-Cookie") String sessionId) {		
		logger.info(" ALMRestController.showTestLogs() invoked {} " ,sessionId);		
		logger.info("securityList contains {} ", securityList);
		HttpHeaders httpHeaders = new HttpHeaders();
		if (securityList.contains(sessionId)) {
					
			//logger.info("JSESSIONID is {}", getSessionId());
			httpHeaders.add("alm-ansibler", ApplicationConstants.REQUESTHEADERSUCCESS);
			
			return new ResponseEntity<>("Hello!  ** TEST SUCCEEDED ** ",httpHeaders, HttpStatus.OK);
		}else {
			httpHeaders.add("alm-ansibler", ApplicationConstants.unauthorized);
			return new ResponseEntity<>("UNAUTHORIZED",httpHeaders, HttpStatus.UNAUTHORIZED);
		}
					
	}
}