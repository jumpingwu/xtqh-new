package xtqh.business.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 3182422599699618026L;

	public BusinessException(Object Obj) {
		super(Obj.toString());
	}

}
