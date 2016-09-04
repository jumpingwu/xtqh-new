package daniel.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xtqh.execution.model.*;
import xtqh.execution.service.*;

@Controller
@RequestMapping("/ProcessInstances")
public class ProcessInstanceController {
	
	@Autowired
	private ProcessInstanceService processInstanceService;
	
	
	@Autowired
	private TaskInstanceService taskInstanceService;

	@Autowired
	private StepInstanceService stepInstanceService;

	@Autowired
	private OperationInstanceService operationInstanceService;

	/**
	 * Lists all the process instances.
	 */
	@RequestMapping("/List")
	public String showProcessInstanceList(Model model) {
		processInstanceService.beginTransaction();
		List<ProcessInstance> processInstanceList = processInstanceService.getAll();
		processInstanceService.commitTransaction();
		model.addAttribute("processInstanceList", processInstanceList);
		return "ProcessInstanceList";
	}
	
	@RequestMapping("/Show/{uid}")
	public String showProcessInstanceDetail(Model model, @PathVariable String uid){
		processInstanceService.beginTransaction();
		ProcessInstance processInstance = processInstanceService.getEagerly(uid);
		model.addAttribute("processInstance", processInstance);
		processInstanceService.commitTransaction();
		return "ProcessInstanceDetail";
	}
	
	/**
	 * Creates a sample process instance
	 */
	@RequestMapping("/CreateSampleProcess")
	public String saveTaskInstance(Model model){
		ProcessInstance pi = new ProcessInstance("娴嬭瘯娴佺▼");
		
		TaskInstance ti1 = new TaskInstance("鍋滄搴旂敤绋嬪簭");
		pi.addTaskInstance(ti1);
		
		StepInstance si1 = new StepInstance("鍋滃簲鐢ㄧ▼搴�");
		si1.setAutomatic(true);
		si1.setOperationExecutionOrder(OperationExecutionOrder.PARALLE);
		ti1.addStepInstance(si1);
		OperationInstance oi1= new OperationInstance("鍋渁pp1搴旂敤绋嬪簭");
		OperationInstance oi2= new OperationInstance("鍋渁pp2搴旂敤绋嬪簭");
		si1.addOperationInstance(oi1);
		si1.addOperationInstance(oi2);
		
		StepInstance si2 = new StepInstance("妫�鏌ュ簲鐢ㄧ▼搴忓仠姝㈡儏鍐�");
		si2.setAutomatic(true);
		si2.setOperationExecutionOrder(OperationExecutionOrder.PARALLE);
		si1.addSuccessor(si2);
		ti1.addStepInstance(si2);
		OperationInstance oi3= new OperationInstance("妫�鏌pp1搴旂敤鍋滄鎯呭喌");
		OperationInstance oi4= new OperationInstance("妫�鏌pp2搴旂敤鍋滄鎯呭喌");
		si2.addOperationInstance(oi3);
		si2.addOperationInstance(oi4);
		
		TaskInstance ti2 = new TaskInstance("鍋滄鏁版嵁搴�");
		pi.addTaskInstance(ti2);
		ti1.addSuccessor(ti2);
		
		StepInstance si3 = new StepInstance("鍋滄暟鎹簱");
		si3.setAutomatic(true);
		si3.setOperationExecutionOrder(OperationExecutionOrder.SERIAL);
		ti2.addStepInstance(si3);
		OperationInstance oi5= new OperationInstance("鍋渄b1鐨勬暟鎹簱");
		OperationInstance oi6= new OperationInstance("鍋渄b2鐨勬暟鎹簱");
		si3.addOperationInstance(oi5);
		si3.addOperationInstance(oi6);
		
		StepInstance si4 = new StepInstance("妫�鏌ユ暟鎹簱鐘舵��");
		si4.setAutomatic(true);
		si4.setOperationExecutionOrder(OperationExecutionOrder.PARALLE);
		ti2.addStepInstance(si4);
		si3.addSuccessor(si4);
		OperationInstance oi7= new OperationInstance("妫�鏌b1鐨勬暟鎹簱鐘舵��");
		OperationInstance oi8= new OperationInstance("妫�鏌b2鐨勬暟鎹簱鐘舵��");
		si4.addOperationInstance(oi7);
		si4.addOperationInstance(oi8);
			
		processInstanceService.beginTransaction();
		processInstanceService.saveCascadingly(pi);
		processInstanceService.commitTransaction();
		
		return "redirect:./List";
	}
	
	@RequestMapping("/Remove/{uid}")
	public String removeProcessInstance(Model model, @PathVariable String uid){
		processInstanceService.beginTransaction();
		ProcessInstance processInstance = processInstanceService.get(uid);
		processInstanceService.delete(processInstance);
		processInstanceService.commitTransaction();
		return "redirect:../List";
	}


	public ProcessInstanceService getProcessInstanceService() {
		return processInstanceService;
	}



	public void setProcessInstanceService(ProcessInstanceService processInstanceService) {
		this.processInstanceService = processInstanceService;
	}



	public TaskInstanceService getTaskInstanceService() {
		return taskInstanceService;
	}



	public void setTaskInstanceService(TaskInstanceService taskInstanceService) {
		this.taskInstanceService = taskInstanceService;
	}



	public StepInstanceService getStepInstanceService() {
		return stepInstanceService;
	}



	public void setStepInstanceService(StepInstanceService stepInstanceService) {
		this.stepInstanceService = stepInstanceService;
	}



	public OperationInstanceService getOperationInstanceService() {
		return operationInstanceService;
	}



	public void setOperationInstanceService(OperationInstanceService operationInstanceService) {
		this.operationInstanceService = operationInstanceService;
	}



	public TaskInstanceService getUserService() {
		return taskInstanceService;
	}

	public void setUserService(TaskInstanceService taskInstanceService) {
		this.taskInstanceService = taskInstanceService;
	}
}
