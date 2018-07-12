/*
 *  Created by Lucas Lacerda (@lucaaslb) on 02/06/2018
 */

package com.lucaaslb.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {

	private Document doc = null;
	private final String URLMAIN = "https://old.reddit.com/r/";
	private final String URLTOP = "/top/?t=";
	private final String DAY = "day";
	private final String WEEK = "week";
	private final String MONTH = "month";

	private Subreddit subreddit = new Subreddit();

	/**
	 * Receives a string containing subreddits separated by ";" the method will
	 * populate a subreddit list of each threads informed (PAGE 1). To recover use
	 * getSubreddit()
	 * 
	 * @param subreddit
	 * 
	 * 
	 */
	public void search(String subreddit) {
		Thread thread;

		String subredditTitle;
		String title;
		int upvotes;
		String url;
		String comments;

		String[] link = subreddit.split(";");

		this.subreddit.clear();
		try {
			for (int i = 0; i < link.length; i++) {
				doc = Jsoup.connect(URLMAIN + link[i]).get();

				Elements articles = doc.select("div.thing.link");

				for (Element article : articles) {

					Elements eUpvotes = article.select("div.thing.link div div[class=score unvoted]");

					if (!eUpvotes.attr("title").equalsIgnoreCase("")) {
						upvotes = Integer.parseInt(eUpvotes.attr("title"));

						Elements ePost = article.select("div.thing.link div div p a.title");
						Elements eComments = article.select("div.thing.link div div ul li a");

						subredditTitle = link[i].toUpperCase();
						title = ePost.text();
						url = ePost.attr("href");
						comments = eComments.attr("href");

						thread = new Thread(subredditTitle, title, upvotes, url, comments);
						this.subreddit.add(thread);
					}
				}
			}

		} catch (IOException exc) {
			exc.printStackTrace();
		} catch (NumberFormatException exc) {
			exc.printStackTrace();
		}

	}

	/**
	 * Receives a string containing subreddits separated by ";" the method will
	 * populate a subreddit list of each threads informed (TOP). To recover use
	 * getSubreddit()
	 * 
	 * @param subreddit
	 * @param top
	 *            1 - day, 2 - week, 3 - month;
	 * 
	 */
	public void searchTop(String subreddit, int top) {
		Thread thread;

		String subredditTitle;
		String title;
		int upvotes;
		String url;
		String comments;

		String[] link = subreddit.split(";");

		String where;

		switch (top) {
		case 1:
			where = DAY;
			break;
		case 2:
			where = WEEK;
			break;
		case 3:
			where = MONTH;
			break;
		default:
			where = DAY;
			break;
		}

		this.subreddit.clear();
		try {
			for (int i = 0; i < link.length; i++) {
				doc = Jsoup.connect(URLMAIN + link[i] + URLTOP + where).get();

				Elements articles = doc.select("div.thing.link");

				for (Element article : articles) {

					Elements eUpvotes = article.select("div.thing.link div div[class=score unvoted]");

					if (!eUpvotes.attr("title").equalsIgnoreCase("")) {
						upvotes = Integer.parseInt(eUpvotes.attr("title"));

						Elements ePost = article.select("div.thing.link div div p a.title");
						Elements eComments = article.select("div.thing.link div div ul li a");

						subredditTitle = link[i].toUpperCase();
						title = ePost.text();
						url = ePost.attr("href");
						comments = eComments.attr("href");

						thread = new Thread(subredditTitle, title, upvotes, url, comments);
						this.subreddit.add(thread);

					}
				}
			}

		} catch (IOException exc) {
			exc.printStackTrace();
		} catch (NumberFormatException exc) {
			exc.printStackTrace();
		}

	}
	
	/**
	 * Receives a string containing subreddits separated by ";" the method will
	 * populate a subreddit list of each threads with min UPVOTES nformed (TOP) . To recover use
	 * getSubreddit()
	 * 
	 * @param subreddit
	 * @param top
	 *            1 - day, 2 - week, 3 - month;
	 * @param limitUpvote
	 * 
	 */
	public void searchTop(String subreddit, int top, int limitUPVote) {
		Thread thread;

		String subredditTitle;
		String title;
		int upvotes;
		String url;
		String comments;

		String where;
		
		
		String[] link = subreddit.split(";");
		
		
		switch (top) {
		case 1:
			where = DAY;
			break;
		case 2:
			where = WEEK;
			break;
		case 3:
			where = MONTH;
			break;
		default:
			where = DAY;
			break;
		}

		this.subreddit.clear();
		try {
			for (int i = 0; i < link.length; i++) {
				doc = Jsoup.connect(URLMAIN + link[i] + URLTOP + where).get();

				Elements articles = doc.select("div.thing.link");

				for (Element article : articles) {

					Elements eUpvotes = article.select("div.thing.link div div[class=score unvoted]");

					if (!eUpvotes.attr("title").equalsIgnoreCase("")) {
						upvotes = Integer.parseInt(eUpvotes.attr("title"));

						Elements ePost = article.select("div.thing.link div div p a.title");
						Elements eComments = article.select("div.thing.link div div ul li a");

						subredditTitle = link[i].toUpperCase();
						title = ePost.text();
						url = ePost.attr("href");
						comments = eComments.attr("href");

						thread = new Thread(subredditTitle, title, upvotes, url, comments);
						this.subreddit.add(thread);

					}
				}
			}

		} catch (IOException exc) {
			exc.printStackTrace();
		} catch (NumberFormatException exc) {
			exc.printStackTrace();
		}

	}
	

	public Subreddit getSubreddit() {
		return subreddit;
	}

}
