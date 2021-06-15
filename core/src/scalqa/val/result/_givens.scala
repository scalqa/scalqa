package scalqa; package `val`; package result; import language.implicitConversions;

class _givens:
  self: Result.type =>

  given givenNameTag[A]                              : Given.NameTag[Result[A]]       = Given.NameTag("Result")
  given givenClassTag[A]  (using t: ClassTag[A])     : ClassTag[Result[A]]            = t.cast[ClassTag[Result[A]]]
  given givenCanEqualResult[A,B](using CanEqual[A,B]): CanEqual[Result[A], Result[B]] = CanEqual.derived

  given givenDocTag[A](using t: Given.DocTag[A])     : Given.DocTag[Result[A]] with
    def tag(v: Result[A]) : String   = if(v.isValue) "Result("+t.tag(v.cast[A])+")" else "Result(Problem("+v.problem.message+"))"
    def doc(v: Result[A]) : Doc      = Doc("Result@"+v.self_^.hash)

  given givenFilter : Ref with
    extension[A](x: Result[A])
      inline def foreach[U](inline f: A=>U)         : Unit      = x.forval(f)
      inline def flatMap[B](inline f: A=>Result[B]) : Result[B] = x.map_??(f)
      /**/   def withFilter(       f: A=>Boolean)   : Result[A] = x.take(f,_ => "For-Comprehension predicate is not satisfied".Problem)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
