package xtqh.framework.log.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import xtqh.framework.base.orm.JpaPersistence;
import xtqh.framework.log.dao.OperationLogDao;
import xtqh.framework.log.dao.entity.OperationLog;

@Repository
public class OperationLogDaoImpl extends JpaPersistence implements OperationLogDao {

	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void insertLog(OperationLog operLog) {
		logger.debug("用户操作日志插入数据:" + operLog.toString());
		entityManager.persist(operLog);
	}

}
