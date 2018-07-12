package com.lucaaslb.crawler;

public class Thread {

	private String subreddit;
	private String title;
	private int upvotes;
	private String url;
	private String comments;

	public Thread(String subreddit, String title, int upvotes, String url, String comments) {
		this.subreddit = subreddit;
		this.title = title;
		this.upvotes = upvotes;
		this.url = url;
		this.comments = comments;
	}

	public String getSubreddit() {
		return subreddit;
	}

	@Override
	public String toString() {
		return "=====================" 
				+ "\n| Subreddit: " + this.subreddit
				+ "\n| Title    : " + this.title 
				+ "\n| Upvotes  : " + this.upvotes 
				+ "\n| URL      : "	+ this.url 
				+ "\n| Comments : " + this.comments 
				+ "\n====================="
				+ "\n\n";
	}
}
