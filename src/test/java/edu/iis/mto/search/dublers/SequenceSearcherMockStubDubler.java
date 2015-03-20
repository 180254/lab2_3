package edu.iis.mto.search.dublers;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherMockStubDubler implements SequenceSearcher {

	public final int[][] sets = new int[][] {
			new int[] { 1, 2, 3, 4 },
			new int[] { 1, 2, 5, 4, 8, 12, -4 },
			new int[] {},
			new int[] {},
			new int[] { 3, 1, 4, 2 },
	};

	private int searchInvokeCounter = 0;

	public SearchResult search(int key, int[] seq) {
		searchInvokeCounter++;

		if (seq == sets[0] || seq == sets[4]) {
			if (key == 1 || key == 2 || key == 3 || key == 4) {
				return new SearchResultFakeDubler(true);
			} else {
				return new SearchResultFakeDubler(false);
			}

		} else if (seq == sets[1]) {
			if (key == 1 || key == 2 || key == 5 || key == 4 ||
					key == 8 || key == 12 || key == -4) {
				return new SearchResultFakeDubler(true);
			} else {
				return new SearchResultFakeDubler(false);

			}
		} else {
				return new SearchResultFakeDubler(false);
		}
	}

	public int getSearchInvokeCounter() {
		return searchInvokeCounter;
	}

}
