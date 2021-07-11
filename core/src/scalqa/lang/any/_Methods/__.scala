package scalqa; package lang; package any; import language.implicitConversions

import gen.`given`. { VoidTag, InTag, DocTag, RangeTag, OptTag }
import scala.{ Ordering as O }
import _methods._view

transparent trait _methods:
  extension[A](inline x:A)
    /**/             inline def isVoid                                                     (using inline t: VoidTag[A]) : Boolean      = t.isVoid(x)
    /**/             inline def nonVoid                                                    (using inline t: VoidTag[A]) : Boolean      = !t.isVoid(x)
    @tn("opt")       inline def ?[OPT<:Opt.AnyType[A]]                                   (using inline t:OptTag[A,OPT]) : OPT          = z.opt(x,t)
    @tn("result")    inline def ??                                                                                      : Result[A]    = Result(x)
    @tn("range")     inline def <> [RNG<: Val.<>.AnyType[A]](inline to:A)(using inline o:O[A], inline t:RangeTag[A,RNG]): RNG          = z.range(x,to,o,t)
    @tn("rangeX")    inline def <>>[RNG<: Val.<>.AnyType[A]](inline to:A)(using inline o:O[A], inline t:RangeTag[A,RNG]): RNG          = z.range.exclusive(x,to,o,t)
    infix            inline def in   [CONTAINER](inline c: CONTAINER)               (using inline t:InTag[A,CONTAINER]) : Boolean      = t.in(x,c)
    /**/             inline def doc                                                         (using inline dd:DocTag[A]) : Doc          = dd.doc(x)
    /**/             inline def tag                                                         (using inline dd:DocTag[A]) : String       = dd.tag(x)
    /**/             inline def tp                                                          (using inline dd:DocTag[A]) : Unit         = ZZ.tp(x,dd)
    @tn("addSpaced") inline def +- [B](v: B)                            (using inline ta:DocTag[A],inline tb:DocTag[B]) : String       = ta.tag(x) + ' ' + tb.tag(v)
    @tn("selfView")  inline def ^                                                                                       : _view[A]     = x.cast[_view[A]]
    @tn("self_View") inline def self_^                                                                                  : _view[A]     = x.cast[_view[A]]


object _methods:
  transparent inline def _view = _Methods._view; type _view[+A] = _Methods._view.opaque.`type`[A]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Every Type Extension Methods

    Extension methods universaly avaialble for all types

    Note. For primitives these methods often have efficient overrides.

@def isVoid -> Void check

    Returns true if target is void

@def notVoid -> Not void check

    Returns true if target is non void

@def tp -> Tag print

    `tp` should be pronounced as "tip"

    `tp` is a functional equivalent to `println` for debugging, education and demonstration purposes

    `tp` should never be inside a production program, `println` should be used instead. Searching code for `tp` should immediately locate debugging fragments.

     ```
      // Compare:

      1.tp
      // vs.
      println(1.tag)

      (1 <> 10).~.TP
      // vs.
      println((1 <> 10).~.tag)

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

@def in -> Is within

    Returns true if this instance is contained by given container.

    ```
      val range = 1 <> 10

      (5 in range).TP   // Prints true

      val pack = (1 <> 10).~.><

      (5 in pack).TP    // Prints true
    ```

    Note. This operation is heavily overloaded, to provide performance close to directly written efficient comparison code

@def doc -> Get Doc

    Returns [[scalqa.any.self.Doc Doc]] object describing current instance

    Reference types can implement [[scalqa.gen.able.Doc Able.Doc]], opaque types can provide implicit [[scalqa.any.self.given.DocTag DocTag]],
    in any case this operation will retrieve [[scalqa.any.self.Doc Doc]] or will create a basic one, if none is found.

@def tag -> Make String

    Returns String representation of base type value.

    `.tag` has to universally be used instead of Java `.toString`. This is due opaque types,
    which by definition cannot overwrite `.toString`, but have facility to provide correct `.tag`.

    In traditional objects, `.tag` by default calls `.toString`.

    ```
    val v: Time.Length =  100.Seconds

    v.tag.TP       // Prints 1 min 40 secs

    // Compare to

    v.toString.TP  // Prints 100000000000
    ```

@def self_^ -> Self view

    `self_^` is functionally identical to `^`, and should be used when `^` struggles

     `^` occasionally does not work, because it is locally overridden with other functionality (for example on Int, Long it does some bit ops)

@def ^ -> Self view

    Returns additional [extra](_Methods/extra.html) library available to this instance

    The most popular feature is doing some processing within context of an anonimous function

    ```
    val a: Array[Int] = new Array[Int](3).^(_.fill(5))

    // Compare to

    val b: Array[Int] = { val a = new Array[Int](3); a.fill(5); a }
    ```

    Note. Due to opaque implementation and inlining, there is no performance difference in the above two cases

@def ? ->  To option

    Returns [[scalqa.val.Opt.opaque Opt]] for current value
    ```
      val o : Opt[String] = "Foo".?
    ```

    Note. Option will be empty if value is 'null'


@def ?? ->  To result

    Returns [[scalqa.val.Result Result]] for current value
    ```
      val o : Result[String] = "Foo".??
    ```

@def <> ->  Range

    Returns Range from current to given value

    ```
      ("AAA" <> "BBB").TP  // Prints  AAA <> BBB
    ```

    Note. An Ordering be implicitly available

@def <>> ->  Exclusive end range

    Returns Byte.Range from current to given value exclusive
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
    Scala 2 also used to support this, which was a huge mistake, because this not important `+` operation, due to it global nature,
    would interfere with all attempts to use `+` for anything else.
    Scala 3 got rid of this for good.
    Scalqa re-introduces this usefull functionality with such a weired name "+-", hoping it will not pose naming conflits

*/