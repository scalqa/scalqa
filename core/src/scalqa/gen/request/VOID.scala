package scalqa; package gen; package request; import language.implicitConversions

class VOID private() extends Request

object VOID extends VOID with z_VOIDDefaults:
  implicit def implicitToString                (v: VOID) : String            = ""
  implicit def implicitToException             (v: VOID) : Exception         = z.Void.Exception
  implicit def implicitToJavaList[A]           (v: VOID) : java.util.List[A] = z.Void.JavaList.cast[java.util.List[A]]
  implicit def implicitToFunction0             (v: VOID) : () => Unit        = z.Void.Function0
  implicit def implicitToFunction1[A]          (v: VOID) : (A) => Unit       = z.Void.Function1
  implicit def implicitToFunction2[A,B]        (v: VOID) : (A,B) => Unit     = z.Void.Function2
  implicit def implicitToFunction3[A, B, C]    (v: VOID) : (A,B,C) => Unit   = z.Void.Function3
  implicit def implicitToFunction4[A, B, C, D] (v: VOID) : (A,B,C,D) => Unit = z.Void.Function4
  implicit def implicitToOrdering[A]           (v: VOID) : Ordering[A]       = z.Void.Ordering.cast[Ordering[A]]

  override def toString = "VOID"

  inline given givenToMath    : Numeric[VOID]      = z.Void.Math
  inline given givenToAverage : Math.Average[VOID] = z.Void.Math

private trait z_VOIDDefaults extends z_VOIDDefaults1:
  implicit def implicitToFunctionToOptDouble[A](v: VOID) : A => Opt[Double]  = z.Void.Function1Opt.cast[A => Opt[Double]]
  implicit def implicitToBooleanFunction[A]    (v: VOID) : A => Boolean      = z.Void.Filter
  //implicit inline def implicitToValOpt[A](v: VOID): Opt[A]    = ZZ.None.cast[Opt[A]]

private trait z_VOIDDefaults1 extends z_VOIDDefaults2:
  implicit def implicitToFunctionToOpt[A,B]    (v: VOID) : A => Opt[B]       = z.Void.Function1Opt.cast[A => Opt[B]]

private trait z_VOIDDefaults2:
  implicit def implicitToVector[A]             (v: VOID) : scala.collection.immutable.Vector[A] = Vector.empty[A]
  implicit def implicitToScalaList[A]          (v: VOID) : scala.collection.immutable.List[A]   = Nil
  implicit def implicitToScalaSet[A]           (v: VOID) : scala.collection.immutable.Set[A]    = scala.collection.immutable.Set.empty
  implicit def implicitToScalaOption[A]        (v: VOID) : scala.Option[A]                      = scala.None
  implicit def implicitToAnyFunction[A,B]      (v: VOID) : A => B                               = z.Void.Function1_Any.cast[A => B]

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

    Types with void values have to define implicit conversions from VOID

    ```
    class Foo

    object Foo:
      val void = new Foo with Gen.Void
      implicit inline def implicitRequest(v: VOID): Foo = void

    // Standard void assignment is:
    var v: Foo = VOID
    ```

    VOID is a shortcut to assign void instances for many types

    ```
    var s: Stream[Int]  = VOID     // Assigning empty stream of Ints
    var o: Opt[String]  = VOID     // Assigning empty optional value of String
    var i: Long.Idx     = VOID     // Assigning empty indexed collection of Long
    ```
*/
