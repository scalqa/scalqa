package Design_Patterns

/**
 * `Single LIne Methods`
 *
 * Most methods in Scalqa are written as a single line of code
 *
 * This allows to understand the entire program unit in a glance, because method signatures are not obstructed by implementations
 *
 * For example, here is definition of [[scalqa.Util.Calendar.Year Year]]
 *
 * {{{
 *   class Year private[scalqa] (protected val real: Int) extends AnyVal with Int.Data.Sequential[Year] {
 *     protected def setup = Year
 *
 *     def number: Int = real
 *
 *     def start: Time = Month.make(real, 1).start
 *
 *     def period = Time.Period.make(start, next.start)
 *
 *     def isLeap = java.time.Year.isLeap(real)
 *
 *     def months: Idx[Month] = new Idx[Month] { def size = 12; def apply(i: Int) = Month.make(number, i + 1) }
 *
 *     def days: Idx[Day] = new Idx[Day] { val from = Day.make(number, 1, 1); val size = if (isLeap) 366 else 365; def apply(i: Int) = from + i }
 *
 *     override def toString = real.toString
 *   }
 * }}}
 *
 * This is unconventional and will surely bring criticism, but this is `enabling` technology for Scalqa project.
 * Thanks to [[SLIM]] and [[POP.H2O H2O]] virtually all program units fit on a single screen (with no scrolling),
 * facilitating different kind of non-linear thinking about program development
 */
class SLIM { val sort_10 = () }
