package scalqa; package lang; package anyref; package opaque; package data; import language.implicitConversions

abstract class Ordered[A<:Opaque, REAL<:AnyRef:ClassTag](typeName: String, c: Ordering  [REAL]) extends Data[A,REAL](typeName) with Ordered._methods[A,REAL]:

  given ordering : Ordering  [A] = c.cast[Ordering  [A]]

object Ordered:

  transparent trait _methods[A<:Opaque,REAL<:AnyRef] extends Data._methods[A,REAL]:
    extension(inline x: A)(using o : Ordering  [A])
      /**/            infix inline def max(inline v: A) : A         = {val w=x; if(w > v) w else v }
      /**/            infix inline def min(inline v: A) : A         = {val w=x; if(w < v) w else v }
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
@class Ordered -> ### AnyRef Opaque Ordered Data Companion Object Base

  Opaque Ordered Data element is provided with default ordering and can be compared with comparison operators.

@def max     -> Max value \n\n Returns maximum of current or given value
@def min     -> Min value \n\n Returns minimun of current or given value
@def <       -> Less \n\n Returns `true` if current value is less than given, `false` - otherwise
@def <=      -> Less or equal \n\n Returns `true` if current value is less or equal to given, `false` - otherwise
@def >       -> Greater \n\n Returns `true` if current value is greater than given, `false` - otherwise
@def >=      -> Greater or equal \n\n Returns `true` if current value is greater or equal to given, `false` - otherwise
*/