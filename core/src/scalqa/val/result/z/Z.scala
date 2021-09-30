package scalqa; package `val`; package result; import language.implicitConversions

object Z:

  class Doc[A](using t: Any.Def.Tag[A]) extends Any.Def.Doc[Result[A]]:
    def value_tag(v: Result[A])                   : String   = if(v.isValue) "Result("+t.value_tag(v.cast[A])+")" else "Result(Problem("+v.problem.message+"))"
    def value_doc(v: Result[A])                   : Gen.Doc  = Gen.Doc("Result@"+v.self_^.hash)

  class Filter:
    extension[A](x: Result[A])
      inline def foreach[U](inline f:A=>U)        : Unit      = x.forval(f)
      inline def flatMap[B](inline f:A=>Result[B]): Result[B] = x.map_??(f)
      /**/   def withFilter(       f:A=>Boolean)  : Result[A] = x.take(f,_ => "For-Comprehension predicate is not satisfied".Problem)

  // ****************************************************************************************************************************
  class ExceptionProblem(v: Throwable) extends RuntimeException(v) with Problem:
    @tn("exception_Opt") def exception_? = this
    /**/                    def message = v.getMessage
    override                def getCause = v

  object ExceptionProblem:

    class Wrap(val deficiency: Problem) extends RuntimeException(deficiency.message)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
