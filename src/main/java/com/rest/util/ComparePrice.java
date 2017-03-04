package com.rest.util;

import java.util.Comparator;

import com.rest.to.SearchResult;

public class ComparePrice implements Comparator<SearchResult> {

	@Override
	public int compare(SearchResult o1, SearchResult o2) {
		if (null != o1.getPrice() && null != o2.getPrice()) {
			/*if (o1.getPrice().equals("125") || o2.getPrice().equals("125")) {
				System.out.println(o1.getPrice());
				System.out.println(o2.getPrice());
				Long l1 = Long.valueOf(o1.getPrice());
				Long l2 = Long.valueOf(o2.getPrice());
				System.out.println(l2.compareTo(l1));
			}*/
			Long l1 = Long.valueOf(o1.getPrice());
			Long l2 = Long.valueOf(o2.getPrice());
			return l2.compareTo(l1);
		}
		return 0;
	}

}
