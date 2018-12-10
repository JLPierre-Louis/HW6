import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Examples {
	
	ElectionData ED = new ElectionData();
	ElectionData ED2 = new ElectionData();

	@Before
	public void setUp() throws Exception {
		ED.addCandidate("Gompei");
		ED.addCandidate("Husky");
		ED.addCandidate("Kanye");
		ED.processVote("Kanye", "Gompei", "Husky");
		ED.processVote("Kanye", "Gompei", "Husky");
		ED.processVote("Kanye", "Gompei", "Husky");
		ED.processVote("Kanye", "Gompei", "Husky");
		ED.processVote("Kanye", "Gompei", "Husky");
		ED.processVote("Kanye", "Gompei", "Husky");
		ED.processVote("Kanye", "Gompei", "Husky");
		ED.processVote("Kanye", "Gompei", "Husky");
		ED.processVote("Kanye", "Gompei", "Husky");
		ED.processVote("Kanye", "Gompei", "Husky");
		ED.processVote("Gompei", "Kanye", "Husky");
		ED.processVote("Gompei", "Kanye", "Husky");
		ED.processVote("Husky", "Kanye", "Gompei");
		ED.processVote("Gompei", "Husky", "Kanye");
		ED2.addCandidate("Gompei");
		ED2.addCandidate("Husky");
		ED2.addCandidate("Kanye");
		ED2.processVote("Kanye", "Gompei", "Husky");
		ED2.processVote("Kanye", "Gompei", "Husky");
		ED2.processVote("Kanye", "Gompei", "Husky");
		ED2.processVote("Gompei", "Kanye", "Husky");
		ED2.processVote("Gompei", "Kanye", "Husky");
		ED2.processVote("Husky", "Kanye", "Gompei");
		ED2.processVote("Gompei", "Husky", "Kanye");
	}

	@Test
	public void testFindWinnerMostVotes() {
		assertEquals(ED.findWinnerMostFirstVotes(), "Kanye");
	}
	
	@Test
	public void testFindWinnerMostVotes2() {
		assertEquals(ED2.findWinnerMostFirstVotes(), "Runoff required");
	}

	@Test
	public void testFindWinnerMostPoints() {
		assertEquals(ED.findWinnerMostPoints(), "Kanye");
	}
	
	@Test
	public void testFindWinnerMostPoints2() {
		assertEquals(ED2.findWinnerMostPoints(), "Gompei");
	}

}
