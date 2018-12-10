import java.util.LinkedList;
import java.util.HashMap;

/**
 * Class that handles election data
 * @author Jean-Luc Pierre-Louis & Roman Wicky van Doyer
 *
 */
class ElectionData {
  private LinkedList<String> ballot = new LinkedList<String>();
  
  private HashMap<String, Integer> candidateFirstVotes = new HashMap<String, Integer>();
  private HashMap<String, Integer> candidateSecondVotes = new HashMap<String, Integer>();
  private HashMap<String, Integer> candidateThirdVotes = new HashMap<String, Integer>();
  
  ElectionData() {
  }
  
  public void printBallot() {
    System.out.println("The candidates are ");
    for (String s : ballot) {
      System.out.println(s);
    }
  }

  public void updateBallot() {
	  for(String n : candidateFirstVotes.keySet()) {
		if(ballot.indexOf(n) < 0) ballot.add(n);
	}
  }
  
  
  /**
   * method checks if name is present on ballot
   * @param name : string of name to be checked
   * @return boolean indicating if the name is present on the ballot
   */
  private Boolean namePresent(String name) {
	  Boolean present = false;
	  for(String b : ballot) {
		  if(b.equals(name)) present = true;
	  } return present;
  }
  
  public void processVote(String first, String second, String third) throws UnknownCandidateException, DuplicateVotesException {
	  if(!namePresent(first)) {
		  throw new UnknownCandidateException(first);
	  }
	  if(!namePresent(second)) {
		  throw new UnknownCandidateException(second);
	  }
	  if(!namePresent(third)) {
		  throw new UnknownCandidateException(third);
	  }
	  if(first.equals(second) || first.equals(third)) {
		  throw new DuplicateVotesException(first);
	  } 
	  if(second.equals(third)) {
		  throw new DuplicateVotesException(second);
	  }
	  else {
		  candidateFirstVotes.put(first, candidateFirstVotes.get(first) + 1);
		  candidateSecondVotes.put(second, candidateSecondVotes.get(second) + 1);
		  candidateThirdVotes.put(third, candidateThirdVotes.get(third) + 1);
	  }
  } 
  
  public void addCandidate(String name) throws CandidateExistsException{
	  if(this.candidateFirstVotes.containsKey(name)) {
		  throw new CandidateExistsException(name);
	  } else{
		  candidateFirstVotes.put(name, 0);
		  candidateSecondVotes.put(name, 0);
		  candidateThirdVotes.put(name, 0);
	  }
  }
  
  public String findWinnerMostFirstVotes() {
	  int totalVotes = 0;
	  for(Integer i : candidateFirstVotes.values()) {
		  totalVotes += i;
	  }
	  String winner = "Runoff required";
	  for(String name : candidateFirstVotes.keySet()) {
		  if(candidateFirstVotes.get(name) > (totalVotes / 2)) {
			  winner = name;
		  }
	  }
	  return winner;
  } 
  
  public String findWinnerMostPoints() {
	  HashMap<String, Integer> points = new HashMap<String, Integer>();
	  for(String name : candidateFirstVotes.keySet()) {
		  points.put(name, candidateFirstVotes.get(name) * 3);
	  }
	  for(String name : candidateFirstVotes.keySet()) {
		  points.put(name, points.get(name) + (candidateFirstVotes.get(name) * 2));
	  }
	  for(String name : candidateThirdVotes.keySet()) {
		  points.put(name, points.get(name) + candidateThirdVotes.get(name));
	  }
	  String winner = "none";
	  int max = 0;
	  for(String name : points.keySet()) {
		  if(points.get(name) > max) {
			  max = points.get(name);
			  winner = name;
		  }
	  }
	  return winner;
  }
 
}