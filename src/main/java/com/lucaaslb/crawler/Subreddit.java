/*
 *  Created by Lucas Lacerda (@lucaaslb) on 02/06/2018
 */

package com.lucaaslb.crawler;

import java.util.ArrayList;

public class Subreddit {

	private ArrayList<Thread> threads = new ArrayList<Thread>();

	public void add(Thread thread) {
		threads.add(thread);
	}

	public boolean isEmpty() {
		return threads.isEmpty();
	}

	public void clear() {
		threads.clear();
	}

	public String printAll() {
		StringBuffer print = new StringBuffer();
		if (!this.isEmpty()) {
			for (Thread reddit : threads) {
				print.append(reddit.toString());
			}
		} else {
			print.append("Subreddits NO FOUND");
		}
		return print.toString();
	}

	public String printEspecific(String subreddit) {
		StringBuffer print = new StringBuffer();
		if (!this.isEmpty()) {
			for (Thread reddit : threads) {
				if (reddit.getSubreddit().equalsIgnoreCase(subreddit)) {
					print.append(reddit.toString());
				}
			}
		} else {
			print.append("Subreddits NO FOUND");
		}
		return print.toString();
	}
	

}
