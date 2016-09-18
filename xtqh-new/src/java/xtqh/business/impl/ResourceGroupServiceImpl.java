package xtqh.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xtqh.base.orm.PersistService;
import xtqh.business.ResourceGroupService;
import xtqh.business.bean.BResourceGroup;
import xtqh.dao.entity.ResourceGroup;
import xtqh.util.HibernateTools;

@Service("ResourceGroupService")
public class ResourceGroupServiceImpl implements ResourceGroupService {

	@Resource(name = "HibernateTools")
	private HibernateTools hibernate;

	@Resource(name = "JpaPersistence")
	private PersistService persist;

	@Override
	public List<BResourceGroup> getResourceGroupList() {
		// TODO Auto-generated method stub
		List<ResourceGroup> listResource = hibernate.getAll(ResourceGroup.class);
		if (null != listResource && !listResource.isEmpty()) {
			/**
			 * 封装 xtqh.business.bean.Resource對象返回
			 */

		}

		return null;
	}

}
