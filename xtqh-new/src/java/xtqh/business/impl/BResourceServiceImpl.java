package xtqh.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xtqh.base.orm.PersistService;
import xtqh.base.paginate.Pagination;
import xtqh.base.paginate.PaginationParameter;
import xtqh.business.BResourceService;
import xtqh.business.bean.BResource;
import xtqh.business.exception.BusinessException;
import xtqh.dao.ResourceDao;
import xtqh.util.BeanUtil;

@Service("BResourceService")
public class BResourceServiceImpl implements BResourceService {

	@Resource(name = "JpaPersistence")
	private PersistService persist;

	@Resource(name = "ResourceDao")
	private ResourceDao resourceDao;

	@Override
	public Pagination<BResource> getResourceList(PaginationParameter parameter, Map<String, String> parMap)
			throws BusinessException {
		// TODO Auto-generated method stub
		Pagination<BResource> viewList = null;
		List<BResource> bResourceList = null;
		String searchKey = parMap.get("searchKey");

		try {
			List<xtqh.dao.entity.Resource> listResource = null;
			if (null != searchKey && !"".equals(searchKey)) {
				Map<String, String> filterFields = new HashMap<String, String>();
				filterFields.put("name", searchKey);
				filterFields.put("hostname", searchKey);
				filterFields.put("controlling_ip", searchKey);
				filterFields.put("resource_id", searchKey);
				/**
				 * hiberante 查询数据
				 */
				listResource = persist.findListByFields(xtqh.dao.entity.Resource.class, filterFields, true);
			} else {
				/**
				 * hiberante 查询数据
				 */
				listResource = persist.findListByField(xtqh.dao.entity.Resource.class);
			}

			/**
			 * 封装成BResource 返回
			 */
			bResourceList = converResourceToBResource(listResource);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getStackTrace().toString());
		}

		if (null != bResourceList) {
			viewList = new Pagination<BResource>(bResourceList, bResourceList.size(), parameter.getPageSize(),
					parameter.getStart());
		}

		return viewList;
	}

	@Override
	public Pagination<BResource> getResourceList(PaginationParameter parameter) throws BusinessException {
		// TODO Auto-generated method stub
		List<BResource> bResourceList = null;
		Pagination<BResource> viewList = null;

		List<xtqh.dao.entity.Resource> listResource = resourceDao.fetchResourceList();
		/**
		 * 封装成BResource 返回
		 */
		bResourceList = converResourceToBResource(listResource);

		if (null != bResourceList) {
			viewList = new Pagination<BResource>(bResourceList, bResourceList.size(), parameter.getPageSize(),
					parameter.getStart());
		}
		return viewList;
	}

	/**
	 * 将Resource List转换成BResource List
	 * @param listResource
	 * @return
	 */
	private List<BResource> converResourceToBResource(List<xtqh.dao.entity.Resource> listResource) {
		List<BResource> bResourceList = null;
		/**
		 * 封装成BResource 返回
		 */
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
