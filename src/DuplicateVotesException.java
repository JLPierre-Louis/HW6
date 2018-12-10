public class DuplicateVotesException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String duplicateName;
	
	DuplicateVotesException(String name) {
		this.duplicateName = name;
	}
	
	public String getDuplicateName() {
		return this.duplicateName;
	}
}
