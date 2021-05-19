package scalqa; package `val`; import language.implicitConversions;

object Result extends result._givens:
  /**/     inline def apply[A](inline v: A | Problem)    : Result[A]   = v.cast[Result[A]]
  /**/            def fail [A](message: String)          : Result[A]   = (if(message eq null) Problem.noMessage else message.Problem).cast[Result[A]]

  implicit inline def implicitFromValue   [A](inline v: A)      : Result[A]   = apply(v)
  implicit inline def implicitFromProblem [A](inline v: Problem): Result[A]   = apply(v)
  implicit inline def implicitToBoolean[A](inline v: Result[A]) : Boolean     = v.isValue

  object opaque:
    opaque type `type`[+A]<: Opaque.Ref = Opaque.Ref

  // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  extension[A](inline x: Result[A])
    /**/              inline def take(inline f: A=>Boolean, inline p:A=>Problem)  : Result[A]    = {var r=x; if(r.isValue){   val v=r.cast[A]; if(!f(v)) r=p(v)}; r}
    /**/              inline def drop(inline f: A=>Boolean, inline p:A=>Problem)  : Result[A]    = {var r=x; if(r.isValue){   val v=r.cast[A]; if( f(v)) r=p(v)}; r}
    /**/              inline def recover(inline f: Problem => Opt[A])             : Result[A]    = {var r=x; if(r.isProblem){ val v=r.cast[Problem]; val o=f(v); if(o.nonEmpty) r=o.`val`}; r}
    @tn("or_Result")
    /**/        infix inline def or_??(  inline default: => Result[A])            : Result[A]    = {var r=x; if(r.isProblem){ r=default                     }; r}
    /**/        infix inline def or(inline default: => A)                         : A            = if(x.isValue) x.cast[A] else default
    /**/              inline def isValue                                          : Boolean      = x.isInstanceOf[Problem].not
    /**/              inline def isProblem                                        : Boolean      = x.isInstanceOf[Problem]
    /**/              inline def contains(value: Any)                             : Boolean      = x == value.cast[Ref]
  extension[A](x: Result[A])
    /**/                     def value                                            : A            = {if(x.isProblem) throw Problem("Method 'value' is called on 'Result' with problem"); x.cast[A] }
    @tn("value_Opt")  inline def value_?                                          : Opt[A]       = {var o:Opt[A]      = \/;  if(x.isValue) o=x.cast[A];       o}
    /**/                     def problem                                          : Problem      = {if(x.isValue) throw Problem("Method 'problem' is called on 'Result' with value"); x.cast[Problem] }
    @tn("problem_Opt")inline def problem_?                                        : Opt[Problem] = {var o:Opt[Problem]= \/;  if(x.isProblem) o=x.cast[Problem]; o}
    @tn("stream")            def ~                                                : ~[A]         = {var s: ~[A]= \/; if(x.isValue){ val v=x.cast[A]; s= ~~(v)}; s}
    /**/                     def toTry                                            : util.Try[A]  = x match
      /**/                                                                                           case v: Problem => {val o=v.exception_?; util.Failure(if(o.nonEmpty) o.`val` else new Exception(v.message))}
      /**/                                                                                           case _ => util.Success(x.cast[A])
    /**/              inline def map[B](     inline f: A => B)                    : Result[B]    = {var r=x.cast[Result[B]]; if(r.isValue){ val v=r.cast[A]; r=f(v)       }; r}
    @tn("map_Result") inline def map_??[B](  inline f: A => Result[B])            : Result[B]    = {var r=x.cast[Result[B]]; if(r.isValue){ val v=r.cast[A]; r=f(v)       }; r}
    /**/              inline def flatMap[B]( inline f: A=>Result[B])              : Result[B]    = x.map_??(f)
    /**/              inline def forval[U](  inline f: A => U)                    : Result[A]    = {val r=x;                 if(r.isValue){ val v=r.cast[A]; f(v)         }; r}
    /**/              inline def fornil[U](  inline f: Problem => U)              : Result[A]    = {val r=x;                 if(r.isProblem){ val v=r.cast[Problem]; f(v)   }; r}
    /**/              inline def process[U,W](inline f: A=>U,inline pf:Problem=>W): Result[A]    = {if(x.isValue){ val v=x.cast[A]; f(v)} else { val v=x.cast[Problem]; pf(v)}; x}

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def Problem = result.Problem; type Problem = result.Problem

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ### Value Result

    [[Result]] is a container, which holds either 'value' or 'problem', which explains why value is not available.

    Unlike [[scalqa.val.Opt$.opaque Opt]], [[Result]] is never void, even if there is no value, then, there must be a problem

    By Scalqa convention, method names, which return [[Result]] type, are ended with '_??' instead of word 'Result'

    ```
    val r1: Result[Int] = "123".toInt_??

    r1.TP   // Prints Result(123)

    val r2: Result[Int] = "ABC".toInt_??

    r2.TP   // Prints Result(Problem(For input string: "ABC"))
    ```
@type Problem ->  Type alias      \n\n Shortcut to [[scalqa.val.result.Problem  Result.Problem]]
@def  Problem ->  Companion alias \n\n Shortcut to [[scalqa.val.result.Problem$ Result.Problem]]

@def ~ ->  Stream

     Returns single value stream or empty stream, if there is a problem

@def forval -> Process value

     Executes given function with value

     Does nothing if there is a problem

     Returns result itself

@def contains -> Check contains

     Returns 'true' if result contains given value

     'false' - otherwise

     ```
        val r : Result[String] = "foo"

        r.contains("foo").TP  // Prints: true

        r.contains("bar").TP  // Prints: false
     ```

@def take -> Filter

      If the result value does not satisfy given predicate, the problem is created with given function

      The result with problem is not affected at all

      ```
      val r : Result[String] = "foo"

      r.take(_.length < 2, "'" + _ + "' is too long").TP  // Prints Result(Problem('foo' is too long))

      r.take(_.length < 4, "'" + _ + "' is too long").TP  // Prints Result(foo)
      ```

@def drop ->  Reversed filter

      If the result value does satisfy given predicate, the problem is created with given function

      The result with problem is not affected at all

      ```
      val r : Result[String] = "foo"

      r.drop(_.length < 2, "'" + _ + "' is too short").TP  // Prints Result(foo)

      r.drop(_.length < 4, "'" + _ + "' is too short").TP  // Prints Result(Problem('foo' is too short))
      ```

@def process -> Process value or problem

     Executes either given function for value or problem

     Returns result itself

@def fornil -> Process problem

     Executes given function if there is a problem

     Returns option itself

@def isValue -> Value check

     Returns `true` if there is a value, `false` if there is a problem

@def value -> Get value

     Returns result value, fails if there is a problem

     Generally use [[value_?]] instead

@def value_? -> Optional value

     Returns value option, which is void if there is a problem

@def isProblem -> Problem check

     Returns `true` if there is a problem, `false` if there is a value

@def problem -> Get problem

     Returns problem, fails if there is a value

     Generally use [[problem_?]] instead

@def problem_? -> Optional problem

     Returns problem option, which is void if there is a value

@def map -> Convert value

      Creates new result with value converted by the given function

      Results with problem are cast to a new type without change

      ```
         "Abc".??.map(_.length).TP  // Prints: Result(3)
      ```
@def map_?? -> Map result

     Results with problem are cast to a new type without change

     Otherwise, value is converted to a new result by given function.

@def recover -> Optionally fix problem

     Results with value are not affected

     Given function is run with problem and optional value is returned. If option is not void, result value is restored

@def toTry -> Make Scala Try

     Result is converted to scala.util.Try, which is a natural fit

@def or -> Value or default

     Returns result value, or if there is a problem, then given default value

@def or_?? ->  Default result

     Returns this result if it has value or given result otherwise
*/

