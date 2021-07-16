package scalqa; package `val`; package result; import problem.*; import language.implicitConversions

trait Problem:
  /**/                 def message     : String
  @tn("exception_Opt") def exception_? : Opt[java.lang.Exception]
  override             def toString    : String                     = "Problem(" + message + ")"

object Problem:
  val nullValue   : Problem = new z.DefaultProblem("Null value")
  val noMessage   : Problem = new z.DefaultProblem("No Message")
  val failedFilter: Problem = new z.DefaultProblem("For-Comprehension predicate is not satisfied")

  /**/     inline def apply(inline message: String = \/)    : Problem        = ZZ.problem(message)
  /**/            def apply(t: Throwable)                   : Problem        = t match{ case v: Problem => v; case v: z.ExceptionProblem.Wrap => v.deficiency; case v => z.ExceptionProblem(v)}
  implicit inline def implicitFromString(inline v: String)  : Problem        = ZZ.problem(v)
  implicit inline def implicitToThrowable(inline v: Problem): Throwable      = z.ExceptionProblem.Wrap(v)
  /**/            def unapply(v: Problem)                   : Option[String] = Some(v.message)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Timeout  = problem.Timeout
  type NotValid = problem.NotValid

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

@def exception_? -> Optional exception

    A problem may or may not be triggered by an exception, which can be optionally retrieved.

*/
