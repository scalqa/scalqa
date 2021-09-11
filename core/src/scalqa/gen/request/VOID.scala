package scalqa; package gen; package request; import language.implicitConversions

class VOID private() extends Request

object VOID extends VOID with zVOIDDefaults:
  implicit def implicitToString                (v: \/) : String            = ""
  implicit def implicitToException             (v: \/) : Exception         = z.VOID.Exception
  implicit def implicitToJavaList[A]           (v: \/) : java.util.List[A] = z.VOID.JavaList.cast[java.util.List[A]]
  implicit def implicitToFunction0             (v: \/) : () => Unit        = z.VOID.Function0
  implicit def implicitToFunction1[A]          (v: \/) : (A) => Unit       = z.VOID.Function1
  implicit def implicitToFunction2[A,B]        (v: \/) : (A,B) => Unit     = z.VOID.Function2
  implicit def implicitToFunction3[A, B, C]    (v: \/) : (A,B,C) => Unit   = z.VOID.Function3
  implicit def implicitToFunction4[A, B, C, D] (v: \/) : (A,B,C,D) => Unit = z.VOID.Function4
  implicit def implicitToOrdering[A]           (v: \/) : Ordering[A]       = z.VOID.Ordering.cast[Ordering[A]]

  override def toString = "\\/"

  inline given givenToMath    : Math[\/]                   = z.VOID.Math
  inline given givenToAverage : ~~.Custom.Math.Average[\/] = z.VOID.Math

private trait zVOIDDefaults extends zVOIDDefaults1:
  implicit def implicitToFunctionToOptDouble[A](v: \/) : A => Opt[Double]  = z.VOID.Function1_Opt.cast[A => Opt[Double]]
  implicit def implicitToBooleanFunction[A]    (v: \/) : A => Boolean      = z.VOID.Filter
  //implicit inline def implicitToValOpt[A](inline v: \/): Opt[A]    = ZZ.None.cast[Opt[A]]

private trait zVOIDDefaults1 extends zVOIDDefaults2:
  implicit def implicitToFunctionToOpt[A,B]    (v: \/) : A => Opt[B]       = z.VOID.Function1_Opt.cast[A => Opt[B]]

private trait zVOIDDefaults2:
  implicit def implicitToVector[A]             (v: \/) : Vector[A]         = Vector.empty[A]
  implicit def implicitToScalaList[A]          (v: \/) : scala.List[A]     = Nil
  implicit def implicitToScalaOption[A]        (v: \/) : scala.Option[A]   = scala.None
  implicit def implicitToAnyFunction[A,B]      (v: \/) : A => B            = z.VOID.Function1_Any.cast[A => B]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
@object VOID -> ### VOID Request Object

       Singleton implementation of [[VOID]] request type

@class VOID -> ### VOID Request Type

    Scalqa supports a concept of "void object" ("empty object"), please see [[scalqa.gen.Void Gen.Void]].

    Types with void values have to define implicit conversions from `\/`

    ```
    class Foo

    object Foo:
      val void = new Foo with Gen.Void
      implicit inline def implicitFrom(v: \/): Foo = void

    // Standard void assignment is:
    var v: Foo = \/
    ```

    \\/ is a shortcut to assign void instances for many types

    ```
    var s: ~[Int]       = \/     // Assigning empty stream of Ints
    var o: Opt[String]  = \/     // Assigning empty optional value of String
    var i: Long.Idx     = \/     // Assigning empty indexed collection of Long
    ```
*/
