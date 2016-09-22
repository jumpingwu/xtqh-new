package xtqh.service;

import java.util.List;

import xtqh.service.exception.ServiceException;

public interface SResourceService {

	public List<xtqh.dao.entity.Resource> getResourceList() throws ServiceException;
}
