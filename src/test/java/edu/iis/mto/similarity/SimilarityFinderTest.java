package edu.iis.mto.similarity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.search.dublers.SequenceSearcherMockStubDubler;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {

	SequenceSearcherMockStubDubler searcher;
	SimilarityFinder finder;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		searcher = new SequenceSearcherMockStubDubler();
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
	public void testResult_checkCommutativeProperty() {
		double res1 = finder.calculateJackardSimilarity(searcher.sets[0], searcher.sets[1]);
		double res2 = finder.calculateJackardSimilarity(searcher.sets[1], searcher.sets[0]);
		assertThat(res1, is(res2));
	}

	@Test
	public void testResult_emptyIntersect_shoultBe0() {
		double res = finder.calculateJackardSimilarity(searcher.sets[0], searcher.sets[2]);
		assertEquals(res, 0, 1e-5);
	}

	@Test
	public void testResult_bothEmpty_shoultBe1() {
		double res = finder.calculateJackardSimilarity(searcher.sets[2], searcher.sets[3]);
		assertEquals(res, 1, 1e-5);
	}

	@Test
	public void testResult_sameSetsButWithDiffrentElementOrder_shoultBe1() {
		double res = finder.calculateJackardSimilarity(searcher.sets[0], searcher.sets[4]);
		assertEquals(res, 1, 1e-5);
	}

	@Test
	public void testState_checkIfsearchIsInvokedProperTimes() {
		finder.calculateJackardSimilarity(searcher.sets[0], searcher.sets[1]);

		int expectedInvokeCounter = searcher.sets[0].length;
		assertThat(searcher.getSearchInvokeCounter(), is(expectedInvokeCounter));
	}

}
