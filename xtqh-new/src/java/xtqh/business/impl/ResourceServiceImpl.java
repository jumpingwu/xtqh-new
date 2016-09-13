package xtqh.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xtqh.base.orm.PersistService;
import xtqh.business.ResourceService;
import xtqh.util.HibernateTools;

@Service("ResourceService")
public class ResourceServiceImpl implements ResourceService {

	@Resource(name = "HibernateTools")
	private HibernateTools hibernate;

	@Resource(name = "JpaPersistence")
	private PersistService persist;

	@Override
	public List<xtqh.business.bean.BResource> getResourceList() {
		// TODO Auto-generated method stub
		List<xtqh.dao.entity.Resource> listResource = hibernate.getAll(xtqh.dao.entity.Resource.class);

		if (null != listResource && !listResource.isEmpty()) {
			/**
			 * 封装 xtqh.business.bean.Resource對象返回
			 */
		}

		return null;
	}

}
