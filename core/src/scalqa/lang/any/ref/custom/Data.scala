package scalqa; package lang; package any; package ref; package custom; import language.implicitConversions

abstract class Data[A<:Opaque.Ref,BASE<:Ref:ClassTag](typeName: String) extends Type[A,BASE](typeName) with Containers[A]

object Data:

  // ******************************************************************************************************************
  abstract class Ordered[A<:Opaque.Ref, BASE<:Ref:ClassTag](typeName: String, c: Ordering  [BASE]) extends Data[A,BASE](typeName) with Ordered._methods[A,BASE]:

    given ordering : Ordering  [A] = c.cast[Ordering  [A]]

  object Ordered:

    trait _methods[A,BASE]:
      extension(inline x: A)(using o : Ordering  [A])
        /**/            infix inline def atLeast(v: A)    : A         = {val w=x; if(w > v) w else v }
        /**/            infix inline def atMost (v: A)    : A         = {val w=x; if(w < v) w else v }
        @tn("less")           inline def <  (inline v: A) : Boolean   = o.compare(x,v) <  0
        @tn("lessOrEqual")    inline def <= (inline v: A) : Boolean   = o.compare(x,v) <= 0
        @tn("greater")        inline def >  (inline v: A) : Boolean   = o.compare(x,v) >  0
        @tn("greaterOrEqual") inline def >= (inline v: A) : Boolean   = o.compare(x,v) >= 0


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### AnyRef Custom Data Setup

@class Ordered -> ###

  Custom Ordered Data element is provided with default ordering and can be compared with comparison operators.

@def atLeast -> Max \n\n Returns maximum of current or given value
@def atMost  -> Min \n\n Returns minimun of current or given value
@def <       -> Less \n\n Returns `true` if current value is less than given, `false` - otherwise
@def <=      -> Less or equal \n\n Returns `true` if current value is less or equal to given, `false` - otherwise
@def >       -> Greater \n\n Returns `true` if current value is greater than given, `false` - otherwise
@def >=      -> Greater or equal \n\n Returns `true` if current value is greater or equal to given, `false` - otherwise
*/