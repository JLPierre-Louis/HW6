public class CandidateExistsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String foundName;
	
	CandidateExistsException(String name){
		this.foundName = name;
	}
}
