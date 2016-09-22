package xtqh.controller.exception;

import xtqh.base.exception.BaseException;

public class PortalException extends BaseException {

	private static final long serialVersionUID = 1115913851620194039L;

	public PortalException(Object Obj) {
		super(Obj.toString());
	}

	public PortalException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PortalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PortalException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PortalException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PortalException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
