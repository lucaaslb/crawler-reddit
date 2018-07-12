package com.lucaaslb.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lucaaslb.crawler.Crawler;
import com.lucaaslb.crawler.Subreddit;

public class CrawlerTest {

	@Test
	public void fillSubreddit() {
		Crawler rastrear = new Crawler();
		rastrear.search("popular");

		Subreddit sr = rastrear.getSubreddit();
		
		assertTrue(!sr.isEmpty());
	}

}
