package edu.iis.mto.search.dublers;

import edu.iis.mto.search.SearchResult;

public class SearchResultDubler implements SearchResult {

	boolean result;

	public SearchResultDubler(boolean result) {
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
