package com.lucaaslb;

import com.lucaaslb.crawler.*;

public class Main {

	private static final String SUBREDDITS = "dog;cat;popular";

	public static void main(String[] args) {
		String subreddit = SUBREDDITS;

		switch (args.length) {
		case 1:
			subreddit = args[0];
			break;
		default:
			subreddit = args[0];
			break;
		}

		Crawler rastrear = new Crawler();
		rastrear.search(subreddit);

		Subreddit sr = rastrear.getSubreddit();
		System.out.println(sr.printAll());

	}

}
