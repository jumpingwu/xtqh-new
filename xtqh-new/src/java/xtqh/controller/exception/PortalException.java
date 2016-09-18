package xtqh.controller.exception;

public class PortalException extends RuntimeException {

	private static final long serialVersionUID = 1115913851620194039L;

	public PortalException(Object Obj) {
		super(Obj.toString());
	}
}
