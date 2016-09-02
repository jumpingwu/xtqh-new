package xtqh.execution.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtqh.base.service.BaseService;
import xtqh.execution.model.*;

@Service
public class ProcessInstanceService extends BaseService{
	
	@Autowired
	private TaskInstanceService taskInstanceService;
	
	public List<ProcessInstance> getAll() {
		return super.getAll(ProcessInstance.class);
	}
	
	public ProcessInstance get(String uid) {
		return super.get(ProcessInstance.class, uid);
	}
		
	public ProcessInstance getEagerly(String uid) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("SELECT pi FROM ProcessInstance pi "
				+ "LEFT JOIN FETCH pi.taskInstances ti "
				+ "LEFT JOIN FETCH ti.stepInstances si "
				+ "LEFT JOIN FETCH si.operationInstances "
				+ "WHERE pi.id = :uid");
		query.setString("uid", uid);
		ProcessInstance processInstance = (ProcessInstance) query.uniqueResult();
		return processInstance;
	}
	
	public void saveCascadingly(ProcessInstance processInstance){
		for (TaskInstance taskInstance : processInstance.getTaskInstances()) {
			taskInstanceService.saveCascadingly(taskInstance);
		}
		this.save(processInstance);
	}

	public TaskInstanceService getTaskInstanceService() {
		return taskInstanceService;
	}

	public void setTaskInstanceService(TaskInstanceService taskInstanceService) {
		this.taskInstanceService = taskInstanceService;
	}
}
