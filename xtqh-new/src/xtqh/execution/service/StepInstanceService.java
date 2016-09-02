package xtqh.execution.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtqh.base.service.BaseService;
import xtqh.execution.model.*;

@Service
public class StepInstanceService extends BaseService{
	
	@Autowired
	private OperationInstanceService operationInstanceService;
	
	public void saveCascadingly(StepInstance stepInstance){
		for (OperationInstance operationInstance : stepInstance.getOperationInstances()) {
			operationInstanceService.save(operationInstance);
		}
		this.save(stepInstance);
	}

	public OperationInstanceService getOperationInstanceService() {
		return operationInstanceService;
	}

	public void setOperationInstanceService(OperationInstanceService operationInstanceService) {
		this.operationInstanceService = operationInstanceService;
	}
}
