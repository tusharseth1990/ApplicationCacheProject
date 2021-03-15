package cache.exception;

public class CacheException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public CacheException(String message) {
		super(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
