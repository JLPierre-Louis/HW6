import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

class ElectionData {
  LinkedList<String> ballot = new LinkedList<String>();
  LinkedList<String> votes = new LinkedList<String>();
  Scanner keyboard = new Scanner(System.in);
  
  HashMap<String, Integer> candidateFirstVotes = new HashMap<String, Integer>();
  HashMap<String, Integer> candidateSecondVotes = new HashMap<String, Integer>();
  HashMap<String, Integer> candidateThirdVotes = new HashMap<String, Integer>();
  
  ElectionData() {
    this.ballot.add("Gompei");
    this.ballot.add("Husky");
    this.ballot.add("Kanye");
  }
  
  public void printBallot() {
    System.out.println("The candidates are ");
    for (String s : ballot) {
      System.out.println(s);
    }
  }
  
  public void screen() {
    this.printBallot();
    System.out.println("Who is your primary choice to vote for?");
    String candidate = keyboard.next();
    votes.add(candidate);
    System.out.println("You voted first for " + candidate);
    System.out.println("Who is your secondary choice to vote for?");
    String candidate2 = keyboard.next();
    votes.add(candidate2);
    System.out.println("You voted second for " + candidate);
    System.out.println("Who is your third choice to vote for?");
    String candidate3 = keyboard.next();
    votes.add(candidate3);
    System.out.println("You voted third for " + candidate);
  }
  
  public int countVotes(String forcand) {
    int numvotes = 0;
    for (String s : votes) {
      if (s.equals(forcand))
        numvotes = numvotes+1;
    }
    return numvotes;
    }
  
  
 
}