package lab2_3;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.search.dublers.SequenceSearcherDubler;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testResult_shouldBe3_8() {
		SequenceSearcherDubler searcher = new SequenceSearcherDubler();
		SimilarityFinder finder = new SimilarityFinder(searcher);
		double res = finder.calculateJackardSimilarity(searcher.sets[0], searcher.sets[1]);
		assertEquals(res, 3 / 8d, 1e-5);
	}

	@Test
	public void testResult_checkIfsearchIsInvokedProperTimes() {
		SequenceSearcherDubler searcher = new SequenceSearcherDubler();
		SimilarityFinder finder = new SimilarityFinder(searcher);
		finder.calculateJackardSimilarity(searcher.sets[0], searcher.sets[1]);
		
		int expectedInvokeCounter = searcher.sets[0].length;
		assertThat(searcher.getSearchInvokeCounter(), is(expectedInvokeCounter));
	}

}
