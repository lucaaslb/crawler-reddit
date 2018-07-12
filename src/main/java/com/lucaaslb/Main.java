package com.lucaaslb;

import com.lucaaslb.crawler.*;

class Main {

	private static final String SUBREDDITS = "popular";

	public static void main(String[] args) {
		String subreddit = SUBREDDITS;

		switch (args.length) {
		case 1:
			subreddit = args[0];
			break;
		}

		Crawler rastrear = new Crawler();
		rastrear.searchTop(subreddit, 1, 5000);

		Subreddit sr = rastrear.getSubreddit();
		System.out.println(sr.printAll());

	}

}
