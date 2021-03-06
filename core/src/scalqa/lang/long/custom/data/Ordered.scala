package scalqa; package lang; package long; package custom; package data; import language.implicitConversions

abstract class Ordered[A<:Opaque.Long](typeName:String) extends Data[A](typeName) with Ordered._methods[A]:

  @fast given ordering : G.Ordering[A] = Long.ordering.cast[G.Ordering[A]]

object Ordered:

  trait _methods[A<:RAW] extends zMethodsBase[A]:
    extension(inline x: A)
      @tn("less")           inline def <  (inline v: A)   : Boolean = x.real <  v.real
      @tn("lessOrEqual")    inline def <= (inline v: A)   : Boolean = x.real <= v.real
      @tn("greater")        inline def >  (inline v: A)   : Boolean = x.real >  v.real
      @tn("greaterOrEqual") inline def >= (inline v: A)   : Boolean = x.real >= v.real

  trait zMethodsBase[A<:RAW] extends Type._methods[A]:
    extension(inline x: A)
      @tn("range")          inline def <> (inline to:A)   : G.<>[A] = new G.<>[A](x,to,true)
      @tn("rangeX")         inline def <>>(inline to:A)   : G.<>[A] = new G.<>[A](x,to,false)
      /**/            infix inline def atLeast(v: A)      : A       = {val a=x; if(a.real > v.real) a else v }
      /**/            infix inline def atMost (v: A)      : A       = {val a=x; if(a.real < v.real) a else v }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Ordered -> ###

  Custom Ordered Data element is provided with default ordering and can be compared with comparison operators.

@def <>      -> Range \n\n  Returns Range from current to given value \n\n  Note. Range uses base primitive natural ordering
@def <>>     -> Exclusive end range \n\n Returns Range from current to given value exclusive \n\n Note. Range uses base primitive natural ordering
@def atLeast -> Max \n\n Returns maximum of current or given value
@def atMost  -> Min \n\n Returns minimun of current or given value
@def <       -> Less \n\n Returns `true` if current value is less than given, `false` - otherwise
@def <=      -> Less or equal \n\n Returns `true` if current value is less or equal to given, `false` - otherwise
@def >       -> Greater \n\n Returns `true` if current value is greater than given, `false` - otherwise
@def >=      -> Greater or equal \n\n Returns `true` if current value is greater or equal to given, `false` - otherwise
*/