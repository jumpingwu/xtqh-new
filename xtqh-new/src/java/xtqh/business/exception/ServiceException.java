package xtqh.business.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 3182422599699618026L;

	public ServiceException(Object Obj) {
		super(Obj.toString());
	}

}
