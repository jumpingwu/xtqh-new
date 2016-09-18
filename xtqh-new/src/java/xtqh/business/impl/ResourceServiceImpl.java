package xtqh.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xtqh.base.orm.PersistService;
import xtqh.business.ResourceService;
import xtqh.business.bean.BResource;
import xtqh.business.exception.BusinessException;
import xtqh.util.BeanUtil;
import xtqh.util.HibernateTools;

@Service("ResourceService")
public class ResourceServiceImpl implements ResourceService {

	@Resource(name = "HibernateTools")
	private HibernateTools hibernate;

	@Resource(name = "JpaPersistence")
	private PersistService persist;

	@Override
	public List<BResource> getResourceList() throws BusinessException {
		// TODO Auto-generated method stub
		List<xtqh.dao.entity.Resource> listResource = hibernate.getAll(xtqh.dao.entity.Resource.class);
		List<BResource> bResourceList = null;
		if (null != listResource && !listResource.isEmpty()) {
			/**
			 * 封装 xtqh.business.bean.Resource對象返回
			 */
			bResourceList = new ArrayList<BResource>();
			for (int i = 0; i < listResource.size(); i++) {
				BResource bResource = new BResource();
				BeanUtil.copyProperties(bResource, listResource.get(i));
				bResourceList.add(bResource);
			}
		}

		return bResourceList;
	}

}
