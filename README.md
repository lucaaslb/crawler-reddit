# CRAWLER-REDDIT

Development to practice

Reddit is like a forum with thousands of different categories. With your account, you can browse technical topics, view photos of kittens, discuss philosophy issues, learn some life hacks and stay on the inside of the world news!

Subreddits are like forums within Reddit and posts are called Threads.
Each thread has a title, a url, upvotes and a url for comments on the Reddit page.

The purpose of this api is to fetch Threads in requested Subreddits, the search may contain filters as the minim upvotes and Threads that are at the top.

## How to use

```
	<groupId>com.lucaaslb.crawler.reddit</groupId>
	<artifactId>crawler-reddit</artifactId>
	<version>1.1-SNAPSHOT</version>
```

```java

    Crawler cw = new Crawler();
	cw.search("worldnews");

	Subreddit sr = cw.getSubreddit();
	System.out.println(sr.printAll());

```

### Properties 

> JDK - 1.8 <br>
> Maven - 3.5.4<br>
> JSoup - 1.11.3<br>


### Author

**Lucas Lacerda** - [Linkedin](https://www.linkedin.com/in/lucaaslb/) :pizza: