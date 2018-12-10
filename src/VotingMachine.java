import java.util.Scanner;

public class VotingMachine {

	ElectionData data;
	
	private Scanner keyboard = new Scanner(System.in);
	
	VotingMachine(ElectionData data) {
		this.data = data;
	}
	
	public void screen() throws UnknownCandidateException, DuplicateVotesException, CandidateExistsException {
	    data.updateBallot();
		data.printBallot();
	    System.out.println("Who is your primary choice to vote for?");
	    String candidate1 = keyboard.next();
	    System.out.println("You voted first for " + candidate1);
	    System.out.println("Who is your secondary choice to vote for?");
	    String candidate2 = keyboard.next();
	    System.out.println("You voted second for " + candidate2);
	    System.out.println("Who is your third choice to vote for?");
	    String candidate3 = keyboard.next();
	    System.out.println("You voted third for " + candidate3);
	    try { data.processVote(candidate1, candidate2, candidate3); } 
	    catch (UnknownCandidateException e) { 
	    	System.out.println("Unknown candidate, " + e.getUnknownName() + ", entered. Would you like to add them to the ballot? (Yes = Y/y).");
	    	String k = keyboard.next();
	    	if( k.equals("Y") || k.equals("y") ) {
	    		System.out.println(addWriteIn(e.getUnknownName()));
	    	}
	    	screen(); 
	    }
	    catch (DuplicateVotesException e) { 
	    	System.out.println("You cannot vote for candidates more than once. Please vote again.");
	    	screen(); 
	    }
	  }
	
	private String addWriteIn(String name) throws CandidateExistsException {
		String message = "Candidate added successfully.";
		try { data.addCandidate(name); }
		catch (CandidateExistsException e) {
			message = "Candidate already exists";
		}
		return message;
	}
}
