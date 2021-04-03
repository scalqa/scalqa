package scalqa; package gen; package request; import language.implicitConversions

object VOID extends Request with zVoidDefaults:
  inline given xxSelf : VOID.type = this

  implicit def xx_String                (v: \/) : String            = ""
  implicit def xx_Exception             (v: \/) : Exception         = z.Void.Exception
  implicit def xx_JavaList[A]           (v: \/) : java.util.List[A] = z.Void.JavaList.cast[java.util.List[A]]
  implicit def xx_Function0             (v: \/) : () => Unit        = z.Void.Function0
  implicit def xx_Function1[A]          (v: \/) : (A) => Unit       = z.Void.Function1
  implicit def xx_Function2[A,B]        (v: \/) : (A,B) => Unit     = z.Void.Function2
  implicit def xx_Function3[A, B, C]    (v: \/) : (A,B,C) => Unit   = z.Void.Function3
  implicit def xx_Function4[A, B, C, D] (v: \/) : (A,B,C,D) => Unit = z.Void.Function4
  implicit def xx_Ordering[A]           (v: \/) : Ordering[A]       = z.Void.Ordering.cast[Ordering[A]]
//  implicit def xx_IntFunToDouble        (v: \/) : Int.Fun.ToDouble  = z.Void.IntFunToDouble
//  implicit def xx_IntFunToLong          (v: \/) : Int.Fun.ToLong    = z.Void.IntFunToLong

  override def toString = "\\/"

  given xxMath    : Math[\/]                   = z.Void.Math
  given xxAverage : ~~.Custom.Math.Average[\/] = z.Void.Math

private trait zVoidDefaults extends zVoidDefaults1:
  implicit def xx_FunctionToOptDouble[A](v: \/) : A => Opt[Double]  = z.Void.Function1_Opt.cast[A => Opt[Double]]
  implicit def xx_BooleanFunction[A]    (v: \/) : A => Boolean    = z.Void.Filter

private trait zVoidDefaults1 extends zVoidDefaults2:
  implicit def xx_FunctionToOpt[A,B]    (v: \/) : A => Opt[B]     = z.Void.Function1_Opt.cast[A => Opt[B]]

private trait zVoidDefaults2:
  implicit def xx_Vector[A]             (v: \/) : Vector[A]       = Vector.empty[A]
  implicit def xx_ScalaList[A]          (v: \/) : scala.List[A]   = Nil
  implicit def xx_ScalaOption[A]        (v: \/) : scala.Option[A] = scala.None
  //implicit def xx_FunctionToUnit[A]     (v: \/) : Unit            = z.Void.Function1_Unit
  implicit def xx_AnyFunction[A,B]      (v: \/) : A => B          = z.Void.Function1_Any.cast[A => B]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
    @object VOID -> ###

    Scalqa supports a concept of "void object" ("empty object"), which can be defined for many types.
    This is similar to [[https://en.wikipedia.org/wiki/Null_object_pattern 'Null Object Pattern']]

    Unlike 'null', void object can have methods invoked, getting some behavior pertinent to 'voidness'

    Examples:

    - Void Stream can be a singleton empty stream, which can be re-used for any type
    - Void String is a string of zero length, which can be re-used for String type instead of null

    Types with void values have to define implicit conversions from `\/`

    ```
    class Foo

    object Foo{
      val void = new Foo with Void

      implicit inline def xxRequest(inline v: \/) = void
    }

    var v: Foo = \/   // Standard void assignment
    ```

    \/ is a shortcut to assign empty implementations for many types

    ```
    var s: ~[Int]       = \/     // Assigning empty [[Stream]] of Ints
    var o: Opt[String]  = \/     // Assigning empty optional value of String
    var i: Long.Idx     = \/     // Assigning empty indexed collection of Long
    ```

    Also see [[Any.Self.Void]]

    A standard way to test for voidness is universal `.isEmpty` method.
*/
