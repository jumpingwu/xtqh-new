package xtqh.execution.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtqh.base.service.BaseService;
import xtqh.execution.model.*;

@Service
public class TaskInstanceService extends BaseService{

	@Autowired
	private StepInstanceService stepInstanceService;
	
	public void saveCascadingly(TaskInstance taskInstance){
		for (StepInstance stepInstance : taskInstance.getStepInstances()) {
			stepInstanceService.saveCascadingly(stepInstance);
		}
		this.save(taskInstance);
	}

	public StepInstanceService getStepInstanceService() {
		return stepInstanceService;
	}

	public void setStepInstanceService(StepInstanceService stepInstanceService) {
		this.stepInstanceService = stepInstanceService;
	}

}
