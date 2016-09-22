package xtqh.business;

import java.util.List;

import xtqh.business.bean.BResource;
import xtqh.business.exception.BusinessException;

public interface BResourceService {

	public List<BResource> getResourceList() throws BusinessException;
}
