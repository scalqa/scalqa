package scalqa; package `def`; package any; import language.implicitConversions

import self.info.Tag
import self.info.tag. { Void, Empty, In }
import self.shape.{ OfOpt, OfRange as R }
import scala.{ Ordering as O }

transparent trait _extension:
  extension[A](inline x:A)
    /**/             inline def isVoid                                                   (using inline t: Void[A]) : Boolean      = t.isVoid(x)
    /**/             inline def nonVoid                                                  (using inline t: Void[A]) : Boolean      = !t.isVoid(x)
    @tn("opt")       inline def ?[OPT<:OfOpt.Any[A]]                         (using inline t:OfOpt.Tag[A,OPT]) : OPT          = z.opt(x,t)
    @tn("result")    inline def ??                                                                                 : Result[A]    = Result(x)
    @tn("range")     inline def <> [RNG<:R.Any[A]](inline to: A)(using inline c:O[A])(using inline t:R.Tag[A,RNG]) : RNG          = z.range(x,to,c,t)
    @tn("rangeX")    inline def <>>[RNG<:R.Any[A]](inline to: A)(using inline c:O[A])(using inline t:R.Tag[A,RNG]) : RNG          = z.range.exclusive(x,to,c,t)
    infix            inline def in   [CONTAINER](inline c: CONTAINER)             (using inline t:In[A,CONTAINER]) : Boolean      = t.in(x,c)
    /**/             inline def info                                                      (using inline dt:Tag[A]) : Info         = dt.info(x)
    /**/             inline def tag                                                       (using inline dt:Tag[A]) : String       = dt.tag(x)
    /**/             inline def tp                                                        (using inline dt:Tag[A]) : Unit         = ZZ.tp(x,dt)
    @tn("plusSpaced")inline def +- [B](v: B)                             (using inline ta:Tag[A],inline tb:Tag[B]) : String       = ta.tag(x) + ' ' + tb.tag(v)
    @tn("selfView")  inline def ^                                                                                  : Any.Self[A]  = x.cast[Any.Self[A]]
    @tn("self_View") inline def self_^                                                                             : Any.Self[A]  = x.cast[Any.Self[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _extension -> ### Every Type Extension Methods

    Extension methods universaly avaialble for all types

    Note. SELF based types often override these general implementations for efficiency

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

@def in -> Is contained

    Returns true if this instance is within given container.

    ```
      val range = 1 <> 10

      (5 in range).TP   // Prints true

      val list = (1 <> 10).~.><

      5 in list.TP      // Prints true
    ```

    Note. This operation is heavily overloaded, to provide performance close to directly written efficient comparison code

@def info -> Get Info

    Returns [[scalqa.gen.Info Info]] object describing current instance

    Referance types can implement [[scalqa.def.able.Info Able.Info]], opaque types can provide implicit [[scalqa.gen.Tag Tag]],
    in any case this operation will retrieve [[scalqa.gen.Info Info]] or will create a basic one, if none is found.

@def tag -> To String

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

    Returns additional [[scalqa.def.any.type.SelfView$.opaque Self]] library available to this instance

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

@def ?? ->  To result

    Returns [[scalqa.val.Result$.opaque Result]] for current value
    ```
      val o : Result[String] = "Foo".??
    ```

@def <> ->  Range

    Returns Range from current to given value

    ```
      ("AAA" <> "BBB").TP  // Prints  AAA <> BBB
    ```

    Note. A type comparator must be implicitly available

@def <>> ->  Exclusive end range

    Returns Byte.Range from current to given value exclusive
    ```
      ("AAA" <>> "BBB").TP  // Prints  AAA <>> BBB
    ```

    Note. A type comparator must be implicitly available


def +- -> Any to String add with space

    Concatenates this and given object string tags with one space in between

    ```
    true +- 1 +- 2 +- 3 +- 'A' +- 10.Percent tp() // Prints true 1 2 3 A 10%
    ```

    Note. Java supports AnyRef + AnyRef, resulting in their String representation concatenation.
    Scala 2 also used to support this, which was a huge mistake, because this not importent `+` operation, due to it global nature,
    would interfere with all attempts to use `+` for anything else.
    Scala 3 got rid of this for good.
    Scalqa re-introduces this usefull functionality with such a weired name "+-", hoping it will not pose naming conflits




*/