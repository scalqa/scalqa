package scalqa; package `val`; package result; import language.implicitConversions

trait Problem:
  /**/     def message      : String
  /**/     def exceptionOpt : Opt[java.lang.Exception]
  override def toString     : String                     = "Problem(" + message + ")"

object Problem:
  val nullValue   : Problem = ZZ.NULL_VALUE
  val noMessage   : Problem = new z.DefaultProblem("No Message")
  val failedFilter: Problem = new z.DefaultProblem("For-Comprehension predicate is not satisfied")

  /**/     inline def apply(inline message: String =VOID)   : Problem        = ZZ.problem(message)
  /**/            def apply(t: Throwable)                   : Problem        = t match{ case v: Problem => v; case v: Z.ExceptionProblem.Wrap => v.deficiency; case v => Z.ExceptionProblem(v)}
  implicit inline def implicitFromString(inline v: String)  : Problem        = ZZ.problem(v)
  implicit inline def implicitToThrowable(inline v: Problem): Throwable      = Z.ExceptionProblem.Wrap(v)
  /**/            def unapply(v: Problem)                   : Option[String] = Some(v.message)

  // ************************************************************************************************
  object X:

    class NotValid(val message: String =VOID)extends Problem:
      def exceptionOpt : Opt[Exception]=VOID
    object NotValid:
      def unapply(v: NotValid): Option[String] = Some(v.message)

    // ******************************************************************
    class Timeout(val message: String =VOID)extends Problem:
      def exceptionOpt : Opt[Exception]=VOID

    object Timeout:
      def unapply(v: Timeout): Option[String] = Some(v.message)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Problem -> ###

    Problem explaining why result value is not available.

@def message -> Description

    Returns the problem description

@def exceptionOpt -> Optional exception

    A problem may or may not be triggered by an exception, which can be optionally retrieved.

@object X -> ### Type Extentions \n\n This object contains all provided base type implementations

@class NotValid -> ###

    A standard problem indicating not valid state

@class Timeout -> ###

       A standard problem indicating failure related to insufficient time

*/
