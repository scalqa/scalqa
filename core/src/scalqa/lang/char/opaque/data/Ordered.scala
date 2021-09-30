package scalqa; package lang; package char; package opaque; package data; import language.implicitConversions

abstract class Ordered[A<:Opaque](name: String) extends Data[A](name) with Ordered._methods:

  @fast given ordering: Ordering[A] = z.Math.cast[Ordering[A]]

object Ordered:

  transparent trait _methods extends Data._methods with zMethodsBase:
    extension[THIS_OPAQUE <: Opaque](inline x: THIS_OPAQUE)
      @tn("less")           inline def <  (inline v: THIS_OPAQUE)    : Boolean           = x.real <  v.real
      @tn("lessOrEqual")    inline def <= (inline v: THIS_OPAQUE)    : Boolean           = x.real <= v.real
      @tn("greater")        inline def >  (inline v: THIS_OPAQUE)    : Boolean           = x.real >  v.real
      @tn("greaterOrEqual") inline def >= (inline v: THIS_OPAQUE)    : Boolean           = x.real >= v.real

  transparent trait zMethodsBase:
    extension[THIS_OPAQUE <: Opaque](inline x: THIS_OPAQUE)
      @tn("range")          inline def <> (inline to: THIS_OPAQUE)   : G.<>[THIS_OPAQUE] = new G.<>[THIS_OPAQUE](x,to,true)
      @tn("rangeX")         inline def <>>(inline to: THIS_OPAQUE)   : G.<>[THIS_OPAQUE] = new G.<>[THIS_OPAQUE](x,to,false)
      @tn("rangeOfSize")    inline def <>=(inline sz:Int)            : G.<>[THIS_OPAQUE] = new G.<>[THIS_OPAQUE](x,sz)
      /**/            infix inline def max(inline v: THIS_OPAQUE)    : THIS_OPAQUE       = {val y=x; val w=v; if(y.real > w.real) y else w }
      /**/            infix inline def min(inline v: THIS_OPAQUE)    : THIS_OPAQUE       = {val y=x; val w=v; if(y.real < w.real) y else w }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Ordered -> ### Char Opaque Ordered Data Companion Object Base

  Opaque Ordered Data element is provided with default ordering and can be compared with comparison operators.

  See [sample type definition](https://github.com/scalqa/samples/blob/master/src/example/opaque/all/OrderedCharData.scala).

@trait _methods -> Default methods for all Char.Opaque.Data.Ordered defined types

@def <>      -> Range \n\n  Returns Range from current to given value \n\n  Note. Range uses base primitive natural ordering
@def <>>     -> Exclusive end range \n\n Returns Range from current to given value exclusive \n\n Note. Range uses base primitive natural ordering
@def <>=     -> Range by size \n\n  Returns Range from current value to current plus given size exclusive \n\n  Note. Range uses base primitive natural ordering
@def max     -> Max value \n\n Returns maximum of current or given value
@def min     -> Min value \n\n Returns minimun of current or given value
@def <       -> Less \n\n Returns `true` if current value is less than given, `false` - otherwise
@def <=      -> Less or equal \n\n Returns `true` if current value is less or equal to given, `false` - otherwise
@def >       -> Greater \n\n Returns `true` if current value is greater than given, `false` - otherwise
@def >=      -> Greater or equal \n\n Returns `true` if current value is greater or equal to given, `false` - otherwise
*/