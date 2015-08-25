package com.opencode.common;

public class BaseException extends Exception {
	
    private String position = null;
    
	public BaseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message) {
		super(message);
		System.out.println(message);
	}
	
	
	public BaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param position 异常发生地，面对用户的提示
	 * @param message　异常中文描述
	 */
	public BaseException(String position, String message) {
		super(message);
		this.position = position;
	}
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		// TODO Auto-generated method stub
		if (position!=null){
			return position + super.getMessage();
		}
		else{
			return super.getMessage();
		}
	}

	public String toString() {
		if (position!=null){
			return position + super.toString();
		}
		else
		{
			return super.toString();
		}
	}

}
