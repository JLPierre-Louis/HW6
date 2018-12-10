
public class Main {

	public static void main(String[] args) throws CandidateExistsException, UnknownCandidateException, DuplicateVotesException {
		ElectionData ED = new ElectionData();
		ED.addCandidate("Gompei");
		ED.addCandidate("Husky");
		ED.addCandidate("Kanye");
		VotingMachine VM = new VotingMachine(ED);
		VM.screen();
	}

}
