package xtqh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xtqh.base.orm.PersistService;
import xtqh.service.SResourceService;
import xtqh.service.exception.ServiceException;
import xtqh.util.HibernateTools;

/**
 * 
 * @author Yan Fugen
 *
 */
@Service("ResourceServiceImpl")
public class SResourceServiceImpl implements SResourceService {

	@Resource(name = "HibernateTools")
	private HibernateTools hibernate;

	@Resource(name = "JpaPersistence")
	private PersistService persist;

	@Override
	public List<xtqh.dao.entity.Resource> getResourceList() throws ServiceException {
		// TODO Auto-generated method stub
		
		List<xtqh.dao.entity.Resource> listResource = hibernate.getAll(xtqh.dao.entity.Resource.class);

		return listResource;
	}

}
