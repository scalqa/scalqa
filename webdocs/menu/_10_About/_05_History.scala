package About

/**
 *  Since Datamata Corporation has a single developer, I will write here from my first name, which is Evgeny Dolgy
 *
 *  In 2005 I started trading stocks with a simple proprietary program written in Java, and by 2008 I was running quite sophisticated application
 *
 *  Being mostly programmer, not a trader, I decided to get 'market advantage' in better code. I started a quest to re-factor existing
 *  application to a quintecential state, where it cannot be improved anymore
 *
 *  Very quickly I arrived to an idea of [[POP.H2O Hierarchical objects organization]], the only structure with enough name space to accommodate
 *  "write once, call from everywhere" idea for every smallest piece of functionality. Later on I started writing complex classes in pieces,
 *  which lead to [[POP Package-Oriented Programming]]
 *
 *  Few years down the road Java API was pronounced "not perfect" and I started using custom collections and my own "perfect" wrappers to
 *  access what is in Java. This would also include java.swing and later javafx
 *
 *  In 2014, with Java8 released, I started massive switch to Streams processing and moving code to interfaces. Java interfaces, unlike traits in Scala,
 *  do not allow data (logic only). This "feature" makes all the interface code truly functional. I did not know this, but found out that interface code
 *  almost never had bugs, therefore would make the system better
 *
 *  In May 2016 I discovered Scala. I found that many things I was struggling with in Java, are actually part of the language and are
 *  done way better than my abilities would ever allow. Within a week I decided to ditch 15 years of Java experience and go all in on Scala
 *
 *  I was fascinated by the beauty of the language, but could not find a good fit for my code in Scala API,
 *  especially in GUI part. Therefore, like in Java, I had to create my own closed framework
 *
 *  It took a year to rewrite all the code and to get enough of Scala experience to see the big picture. And it looked bright,
 *  Scala had a natural fit to my hierarchical API, so I got an idea to release it as Scalqa
 *
 *  After another year of work, by May 2018, I had something to put on Github. At this time I realized, that to make any difference, Scalqa needed to deliver better performance
 *
 *  It took another 6 month to fully rewrite collections with specialized primitives and performance in mind. So, at the end of 2018 it feels like it is ready for public review
 */
class History { val sort_05 = () }
