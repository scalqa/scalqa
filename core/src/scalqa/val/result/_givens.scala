package scalqa; package `val`; package result; import language.implicitConversions;

class _givens:
  self: Result.type =>

  given xxTagType[A]                         : Info.Tag.Type[Result[A]]       = Info.Tag.Type("Result")
  given xxTagClass[A]  (using t: ClassTag[A]): ClassTag[Result[A]]            = t.cast[ClassTag[Result[A]]]
  given xxCanEqual[A,B](using CanEqual[A,B]) : CanEqual[Result[A], Result[B]] = CanEqual.derived

  given xxTagDoc[A](using t: Info.Tag.Doc[A]) : Info.Tag.Doc[Result[A]] with
    def tag(v: Result[A]) : String = if(v.isValue) "Result("+t.tag(v.cast[A])+")" else "Result(Problem("+v.problem.message+"))"
    def info(v: Result[A]): Info   = Info("Result@"+v.self_^.hash)

  given xxFilter : Ref with
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
