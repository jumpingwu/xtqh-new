package xtqh.business;

import java.util.Map;

import xtqh.base.paginate.Pagination;
import xtqh.base.paginate.PaginationParameter;
import xtqh.business.bean.BResource;
import xtqh.business.exception.BusinessException;

public interface BResourceService {

	public Pagination<BResource> getResourceList(Map<String, String> parMap, PaginationParameter parameter)
			throws BusinessException;

	public Pagination<BResource> getResourceList(PaginationParameter parameter) throws BusinessException;
}
