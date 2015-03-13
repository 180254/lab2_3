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

	SequenceSearcherDubler searcher;
	SimilarityFinder finder;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		searcher = new SequenceSearcherDubler();
		finder = new SimilarityFinder(searcher);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testResult_shouldBe3_8() {
		double res = finder.calculateJackardSimilarity(searcher.sets[0], searcher.sets[1]);
		assertEquals(res, 3 / 8d, 1e-5);
	}

	@Test
	public void testState_checkIfsearchIsInvokedProperTimes() {
		finder.calculateJackardSimilarity(searcher.sets[0], searcher.sets[1]);

		int expectedInvokeCounter = searcher.sets[0].length;
		assertThat(searcher.getSearchInvokeCounter(), is(expectedInvokeCounter));
	}
	
	@Test
	public void testResult_checkCommutativeProperty() {
		double res1 = finder.calculateJackardSimilarity(searcher.sets[0], searcher.sets[1]);
		double res2 = finder.calculateJackardSimilarity(searcher.sets[1], searcher.sets[0]);
		assertThat(res1, is(res2));
	}

}
