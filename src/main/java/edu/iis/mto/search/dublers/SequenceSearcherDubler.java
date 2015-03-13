package edu.iis.mto.search.dublers;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDubler implements SequenceSearcher {

	public final int[][] sets = new int[][] {
			new int[] { 1, 2, 3, 4 },
			new int[] { 1, 2, 5, 4, 8, 12, -4}
	};
	
	private int searchInvokeCounter = 0;

	public SearchResult search(int key, int[] seq) {
		searchInvokeCounter++;
		
		if (seq == sets[0]) {
			if (key == 1 || key == 2 || key == 3 || key == 4) {
				return new SearchResultDubler(true);
			} else {
				return new SearchResultDubler(false);
			}

		} else {
			if (key == 1 || key == 2 || key == 5 || key == 4) {
				return new SearchResultDubler(true);
			} else {
				return new SearchResultDubler(false);

			}
		}
	}

	public int getSearchInvokeCounter() {
		return searchInvokeCounter;
	}

}