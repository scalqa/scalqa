package scalqa; package lang; package anyref; package opaque; package data; import language.implicitConversions

abstract class Ordered[A<:Opaque, REAL<:AnyRef](name: String)(using realOrdering: Ordering[REAL], ct: ClassTag[REAL]) extends Data[A,REAL](name) with Ordered._methods[A,REAL]:

  given ordering: Ordering[A] = realOrdering.cast[Ordering[A]]

object Ordered:

  transparent trait _methods[A<:Opaque,REAL<:AnyRef] extends Data._methods[A,REAL]:
    self: Ordered[A, REAL] =>
    extension(x: A)
      /**/            infix def max(v: A) : A         = if(ordering.compare(x,v) >= 0) x else v
      /**/            infix def min(v: A) : A         = if(ordering.compare(x,v) <= 0) x else v
      @tn("less")           def <  (v: A) : Boolean   = ordering.compare(x,v) <  0
      @tn("lessOrEqual")    def <= (v: A) : Boolean   = ordering.compare(x,v) <= 0
      @tn("greater")        def >  (v: A) : Boolean   = ordering.compare(x,v) >  0
      @tn("greaterOrEqual") def >= (v: A) : Boolean   = ordering.compare(x,v) >= 0

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Ordered -> ### AnyRef Opaque Ordered Data Companion Object Base

  Opaque Ordered Data element is provided with default ordering and can be compared with comparison operators.

  See [sample type definition](https://github.com/scalqa/samples/blob/master/src/example/opaque/all/OrderedAnyRefData.scala).

@trait _methods -> Default methods for all AnyRef.Opaque.Data.Ordered defined types

@def max     -> Max value \n\n Returns maximum of current or given value
@def min     -> Min value \n\n Returns minimun of current or given value
@def <       -> Less \n\n Returns `true` if current value is less than given, `false` - otherwise
@def <=      -> Less or equal \n\n Returns `true` if current value is less or equal to given, `false` - otherwise
@def >       -> Greater \n\n Returns `true` if current value is greater than given, `false` - otherwise
@def >=      -> Greater or equal \n\n Returns `true` if current value is greater or equal to given, `false` - otherwise
*/