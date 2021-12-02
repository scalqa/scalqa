package scalqa; package `val`; import language.implicitConversions;

object Result:
  /**/     inline def apply[A](inline v: A | Problem)            : Result[A]   = ZZ.result(v).cast[Result[A]]
  /**/            def fail [A](message: String)                  : Result[A]   = (if(message==null) Problem.noMessage else message.Problem).cast[Result[A]]

  implicit inline def implicitFromAny    [A](inline v: A)        : Result[A]   = apply(v)
  implicit inline def implicitFromProblem[A](inline v: Problem)  : Result[A]   = apply(v)
  implicit inline def implicitToBoolean  [A](inline v: Result[A]): Boolean     = v.isValue
  /**/            def unapply[A](v: Result[A])                   : Option[A]   = v.valueOpt.toScala
  // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  extension[A](inline x: Result[A])
    /**/  inline def take(inline f: A=>Boolean, inline p:A=>Problem)  : Result[A]    = {var r=x; if(r.isValue){   val v=r.cast[A]; if(!f(v)) r=p(v)}; r}
    /**/  inline def drop(inline f: A=>Boolean, inline p:A=>Problem)  : Result[A]    = {var r=x; if(r.isValue){   val v=r.cast[A]; if( f(v)) r=p(v)}; r}
    /**/  inline def recover(inline f: Problem => Opt[A])             : Result[A]    = {var r=x; if(r.isProblem){ val v=r.cast[Problem]; val o=f(v); if(o) r=o.`val`}; r}
    infix inline def orResult(inline default: => Result[A])           : Result[A]    = {val r=x; if(r.isValue) r         else default }
    infix inline def or(inline default: => A)                         : A            = {val r=x; if(r.isValue) r.cast[A] else default }
    /**/  inline def isProblem                                        : Boolean      = x.isInstanceOf[Problem]
    /**/  inline def isValue                                          : Boolean      = !x.isProblem
    /**/  inline def contains(v: A)                                   : Boolean      = result.Z.contains(x,v)
    /**/  inline def value                                            : A            = result.Z.value(x)
    /**/  inline def problem                                          : Problem      = result.Z.problem(x)
    /**/  inline def valueOpt                                         : Opt[A]       = {val r=x; if(r.isValue)   r.cast[A]       else VOID }
    /**/  inline def problemOpt                                       : Opt[Problem] = {val r=x; if(r.isProblem) r.cast[Problem] else VOID }
    /**/  inline def stream                                           : Stream[A]    = result.Z.stream(x)
    /**/  inline def toTry                                            : util.Try[A]  = result.Z.toTry(x)
    /**/  inline def map[B](      inline f: A => B)                   : Result[B]    = {var r=x.cast[Result[B]]; if(r.isValue)  { val v=r.cast[A]; r=f(v)       }; r}
    /**/  inline def mapResult[B](inline f: A => Result[B])           : Result[B]    = {var r=x.cast[Result[B]]; if(r.isValue)  { val v=r.cast[A]; r=f(v)       }; r}
    /**/  inline def forval[U](   inline f: A => U)                   : Result[A]    = {val r=x;                 if(r.isValue)  { val v=r.cast[A]; f(v)         }; r}
    /**/  inline def fornil[U](   inline f: Problem => U)             : Result[A]    = {val r=x;                 if(r.isProblem){ val v=r.cast[Problem]; f(v)   }; r}
    /**/  inline def flatMap[B](  inline f: A=>Result[B])             : Result[B]    = x.mapResult(f)
    /**/  inline def process[U,W](inline f: A=>U,inline pf:Problem=>W): Result[A]    = {val r=x; if(r.isValue){ val v=r.cast[A]; f(v)} else { val v=r.cast[Problem]; pf(v)}; r}

  given z_NameDef[A]                              : Any.Def.TypeName[Result[A]]    = Any.Def.TypeName("Result")
  given z_ClassTag[A]  (using t: ClassTag[A])     : ClassTag[Result[A]]            = t.cast[ClassTag[Result[A]]]
  given z_CanEqualResult[A,B](using CanEqual[A,B]): CanEqual[Result[A], Result[B]] = CanEqual.derived
  given z_Doc[A](using t: Any.Def.Tag[A])         : Any.Def.Doc[Result[A]]         = new result.Z.Doc
  given givenFilter                               : result.Z.Filter                = new result.Z.Filter

  object TYPE:
    opaque type DEF[+A]<: AnyRef.Opaque = AnyRef.Opaque

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Problem = result.Problem; type Problem = result.Problem

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ### Value Result

    Result is a container, which holds either 'value' or 'problem', which explains why value is not available.

    Unlike [[scalqa.val.Opt Opt]], Result is never void, even if there is no value, then, there must be a problem.

    By Scalqa convention, method names, which return [[Result]] type, are ended with 'Result' instead of word 'Result'

    ```
    val r1: Result[Int] = "123".toIntResult

    r1.TP   // Prints Result(123)

    val r2: Result[Int] = "ABC".toIntResult

    r2.TP   // Prints Result(Problem(For input string: "ABC"))
    ```
@type Problem ->  Type alias      \n\n Shortcut to [[scalqa.val.result.Problem  Result.Problem]]
@def  Problem ->  Companion alias \n\n Shortcut to [[scalqa.val.result.Problem$ Result.Problem]]

@def stream ->  Stream

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

     Generally use [[valueOpt]] instead

@def valueOpt -> Optional value

     Returns value option, which is void if there is a problem

@def isProblem -> Problem check

     Returns `true` if there is a problem, `false` if there is a value

@def problem -> Get problem

     Returns problem, fails if there is a value

     Generally use [[problemOpt]] instead

@def problemOpt -> Optional problem

     Returns problem option, which is void if there is a value

@def map -> Convert value

      Creates new result with value converted by the given function

      Results with problem are cast to a new type without change

      ```
         Result("Abc").map(_.length).TP  // Prints: Result(3)
      ```
@def mapResult -> Map result

     Results with problem are cast to a new type without change

     Otherwise, value is converted to a new result by given function.

@def recover -> Optionally fix problem

     Results with value are not affected

     Given function is run with problem and optional value is returned. If option is not void, result value is restored

@def toTry -> Make Scala Try

     Result is converted to scala.util.Try, which is a natural fit

@def or -> Value or default

     Returns result value, or if there is a problem, then given default value

@def orResult ->  Default result

     Returns this result if it has value or given result otherwise
*/

