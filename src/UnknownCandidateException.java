public class UnknownCandidateException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String unknownName;
	
	UnknownCandidateException(String name) {
		this.unknownName = name;
	}
	
	public String getUnknownName() {
		return this.unknownName;
	}
}
