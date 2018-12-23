package Download

/**
 *  Scalqa is just a standard package within Scala, so a [[http://scala-ide.org/ standard Scala setup]] is required
 *
 *  Scalqa `JAR` should be [[Download downloaded]] and added to the project as any other Java JAR
 *
 *  In your code there should be a statement `import scalqa._`
 *
 *  {{{
 *     package MyPackage
 *
 *     import scalqa._
 *
 *     object MyApp extends App {
 *
 *       // All Fri the 13th for this century
 *
 *       "Total Count: " + (2000 <<> 2100).all
 *         .map(_.Year)
 *         .flatMap(_.days)
 *         .let(_.weekDay.isFri)
 *         .let(_.number == 13)
 *         .peek(_ lp)
 *         .count lp
 *     }
 *  }}}
 *
 *  Upon compilation MyApp is a standard executable Java program
 */
class How_To_Use { val sort_60 = () }
