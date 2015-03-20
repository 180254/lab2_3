package edu.iis.mto.search.dublers;

import edu.iis.mto.search.SearchResult;

public class SearchResultFakeDubler implements SearchResult {

	boolean result;

	public SearchResultFakeDubler(boolean result) {
		super();
		this.result = result;
	}

	public boolean isFound() {
		return result;
	}

	public int getPosition() {
		return 0;
	}

}
