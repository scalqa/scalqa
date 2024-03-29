package scalqa; package lang; package any; import language.implicitConversions

import scala.{ Ordering as O }
import _Methods.Self

transparent trait _Methods:
  extension[A](inline x:A)
    /**/              inline def isVoid                                           (using inline d: Def.Void[A]) : Boolean      = d.value_isVoid(x)
    /**/              inline def nonVoid                                          (using inline d: Def.Void[A]) : Boolean      = !x.isVoid
    @tn("opt")        inline def ?                                              (using inline s:Specialized[A]) : s.Opt        = z.opt.make(x)
    @tn("nonEmptyOpt")inline def ??             (using inline e:Opt[Def.Empty[A]])(using inline d: Def.Void[A]) : Opt[A]       = z.opt.nonEmpty(x,e,d)

    @tn("range")      inline def <> (inline to:A)(using inline o:O[A])          (using inline s:Specialized[A]) : s.Range      = z.range(x,to)
    @tn("rangeX")     inline def <>>(inline to:A)(using inline o:O[A])          (using inline s:Specialized[A]) : s.Range      = z.range.exclusive(x,to)
    infix             inline def in   [CONTAINER](inline c: CONTAINER)(using inline d:Def.Contains[CONTAINER,A]): Boolean      = z.containsMacro(c,x,d)
    infix             inline def notIn[CONTAINER](inline c: CONTAINER)(using inline d:Def.Contains[CONTAINER,A]): Boolean      = !in(c)
    /**/              inline def doc                                                (using inline d:Def.Doc[A]) : Doc          = d.value_doc(x)
    /**/              inline def tag                                                (using inline t:Def.Tag[A]) : String       = t.value_tag(x)
    /**/              inline def tp                                                 (using inline t:Def.Tag[A]) : Unit         = ZZ.tp(x,t)
    @tn("addSpaced")  inline def +- [B](v: B)                 (using inline ta:Def.Tag[A],inline tb:Def.Tag[B]) : String       = ta.value_tag(x) + ' ' + tb.value_tag(v)
    /**/              inline def self                                                                           : Self[A]      = x.cast[Self[A]]

object _Methods:
  transparent inline def Self = _methods.Self; type Self[+A] = _methods.Self.TYPE.DEF[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _Methods -> ### Universal Extension Methods

    Extension methods avaialble for all types

@def isVoid -> Void check

    Returns true if target is void

    Note: Operation can fail for null value, use .self.isVoid if null check is required

@def nonVoid -> Not void check

    Returns true if target is non void

    Note: Operation can fail for null value, use .self.nonVoid if null check is required

@def tp -> Tag print

    `tp` should be pronounced as "tip"

    `tp` is a functional equivalent to `println` for debugging, education and demonstration purposes

    `tp` should never be inside a production program, `println` should be used instead. Searching code for `tp` should immediately locate debugging fragments.

     ```
     // Compare:

     1.tp
     // vs.
     println(1.tag)

     (1 <> 10).stream.TP
     // vs.
     println((1 <> 10).stream.tag)

     100.Seconds.TP
     // vs.
     println(100.Seconds.tag)
     ```

     Also, there is postfix like overload of `tp` on String type
     ```
     "Results:" +- 1 +- 2 +- 3 +- 4.Percent tp()
     // vs.
     println("Results:" +- 1 +- 2 +- 3 +- 4.Percent)
     ```

@def notIn -> Is not within

    Reverse "in" method

@def in -> Is within

    Returns true if this instance is contained by given container.

    ```
      val range = 1 <> 10

      (5 in range).TP   // Prints true

      val pack = (1 <> 10).stream.pack

      (5 in pack).TP    // Prints true
    ```

    Note. This operation is Macro optimized for Tuples from 2 to 12, so the following check will be ultimatly efficent with no Tuple allocation:

    ```
      val s = "ABC"

      s in ("XYZ","BBC","CBC")
    ```

@def doc -> Get Doc

    Returns [[scalqa.any.self.Doc Doc]] object describing current instance

    Reference types can implement [[scalqa.gen.able.Doc Able.Doc]], opaque types can provide implicit [[scalqa.any.def.Doc Any.Def.Doc]],
    in any case this operation will retrieve [[scalqa.any.self.Doc Doc]] or will create a default one, if none is found.

@def tag -> Make String

    Returns String representation of base value.

    `.tag` has to universally be used instead of Java `.toString`. This is due to opaque types,
    which by definition cannot override `.toString`, but have facility to provide correct `.tag`.

    In traditional objects, `.tag` by default calls `.toString`.

    ```
    val v: Time.Length =  100.Seconds

    v.tag.TP       // Prints 1 min 40 secs

    // Compare to

    v.toString.TP  // Prints 100000000000
    ```

@def self -> Self view

    Returns additional ["self"](_methods/Self.html) library available to this instance

    The most popular feature is doing some processing within context of an anonimous function

    ```
    val a: Array[Int] = new Array[Int](3).self(_.fill(5))

    // Compare to

    val b: Array[Int] = { val a = new Array[Int](3); a.fill(5); a }
    ```

    Note. Due to opaque implementation and inlining, there is no performance difference in the above two cases

@def ? ->  To option

    Returns [[scalqa.val.Opt.toOpaque Opt]] for current value
    ```
      val o : Opt[String] = "Foo".?
    ```

    Result will be empty option if value is 'null', but non empty for void values.  Use .?? instead if void or empty check is required.

@def ?? -> To non-empty value option

    Returns base value as an option.

    Unlike general .? method, this method will create empty option for void or empty values

    ```
      val p: Stream[Int]=VOID

      p.?.tp    // prints: Opt(scalqa.val.pack.z.Void)

      p.??.tp  // prints: Opt(VOID)
    ```

    This method can even safely check Stream for emptiness, returning Stream with original values
    ```
    def s : Stream[Int] = (1 <> 3).stream.dropFirst(3)

    s.??.tp  // prints: Opt(VOID)
    s.?.tp   // prints: Opt(Stream())
    ```
@def <> ->  Range

    Returns Range from current to given value

    ```
      ("AAA" <> "BBB").TP  // Prints  AAA <> BBB
    ```

    Note. An Ordering must be implicitly available

@def <>> ->  Exclusive end range

    Returns <> from current to given value exclusive
    ```
      ("AAA" <>> "BBB").TP  // Prints  AAA <>> BBB
    ```

    Note. An Ordering must be implicitly available


@def +- -> Any to String add with space

    Concatenates this and given object string tags with one space in between

    ```
    true +- 1 +- 2 +- 3 +- 'A' +- 10.Percent tp() // Prints true 1 2 3 A 10%
    ```

    Note. Java supports AnyRef + AnyRef, resulting in their String representation concatenation.
    Scala 2 also used to support this, which was a big mistake, because this not really important `+` operation, due to it global nature,
    would interfere with all attempts to use `+` for anything else.
    Scala 3 got rid of this for good.
    Scalqa re-introduces this usefull functionality with such a weired name "+-", hoping it will not pose naming conflits

*/