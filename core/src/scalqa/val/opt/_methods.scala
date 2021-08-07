package scalqa; package `val`; package opt; import language.implicitConversions;

import gen.`given`.OptShape

abstract class _methods extends _givens:
  self: Opt.type =>

  extension[A](inline x:Opt[A])
    @tn("is_Void")     inline def isEmpty                                     : Boolean    = x eq ZZ.None
    @tn("not_Void")    inline def nonEmpty                                    : Boolean    = x ne ZZ.None
    /**/               inline def filter( inline f: A => Boolean)             : Opt[A]     = take(f)
    /**/               inline def take( inline f: A => Boolean)               : Opt[A]     = {var o=x; if(o.nonEmpty && !f(o.`val`)) o= \/; o}
    /**/               inline def takeOnly(inline v: A)                       : Opt[A]     = {val o=x; if(o == v.?) x else \/ }
    /**/               inline def takeType[B](using inline t:ClassTag[B])     : Opt[B]     = {var o:Opt[B]= \/; if(t.unapply(x).isEmpty.not) o=x.cast[Opt[B]]; o}
    /**/               inline def drop(inline f: A => Boolean)                : Opt[A]     = {var o=x; if(o.nonEmpty &&  f(o.`val`)) o= \/; o}
    /**/               inline def dropOnly(inline v: A)                       : Opt[A]     = {val o=x; if(o == v.?) \/ else x }
    /**/               inline def dropVoid(using inline d: Given.VoidDef[A])  : Opt[A]     = {var o=x; if(o != null && o.nonEmpty && d.value_isVoid(o.`val`)) o= \/; o}
    /**/               inline def default(inline dv: => A)                    : Opt[A]     = {val o=x; if(o.isEmpty)  dv  else o}
    @tn("or_Opt")infix inline def or_?(inline that: => Opt[A])                : Opt[A]     = {val o=x; if(o.isEmpty) that else o}
    /**/         infix inline def or(inline default: => A)                    : A          = z.Macro.or(x,default)
    /**/               inline def contains(value: A)                          : Boolean    = x == value.?
  extension[A](x:Opt[A])
    /**/                      def collect[B](f: PartialFunction[A,B])         : Opt[B]     = {var o:Opt[B]= \/; if(x.nonEmpty){val w=x.`val`; if(f.isDefinedAt(w)) o=f(w)}; o}
    @tn("stream")             def ~                                           : ~[A]       = if(x.nonEmpty) ~~(x.`val`) else Stream.void
    /**/                      def get                                         : A          = {if(x.isEmpty) throw new ZZ.EO(); x.cast[A]}
    /**/               inline def withFilter(inline f: A => Boolean)          : Opt[A]     = {var o:Opt[A]= \/; if(x.nonEmpty){val w=x.cast[A]; if(f(w)) o=x}; o}
    /**/               inline def forval[U](inline  f: A => U)                : Opt[A]     = { if(x.nonEmpty){ f(x.`val`)}; x}
    /**/         infix inline def fornil[U](inline f: => U)                   : Opt[A]     = { if(x.isEmpty){ var u:U=f };  x}
    /**/               inline def foreach[U](inline f: A => U)                : Opt[A]     = { if(x.nonEmpty){ f(x.`val`)}; x}
    /**/               inline def process[U,W](inline f:A=>U,inline fNil: =>W): Opt[A]     = { if(x.isEmpty){ val w:W=fNil} else f(x.`val`); x}
    /**/               inline def toScala                                : scala.Option[A] = if(x.nonEmpty) scala.Some(x.`val`) else scala.None
    /**/               inline def toJava                           : java.util.Optional[A] = if(x.nonEmpty) java.util.Optional.of(x.`val`) else java.util.Optional.empty
    /**/               inline def foldAs[B](inline v: =>B)(inline f: A=>B)    : B          = x.map(f) or v

  //------------ Mapping ---------------------------------------------------------------------------------------------------------------------------------
  extension[A,T,OPT<:AnyType[T]](inline x:Opt[A])
    /**/               inline def map    [B>:T](inline f: A => B)                        (using inline s: OptShape[B,OPT])     : OPT    = z.map(x,f,s)
  extension[A,T](inline x:Opt[A])
    @tn("map_Opt")     inline def map_?  [OPT<:AnyType[T]](inline f: A=>OPT)             (using inline s: OptShape[T,OPT])     : OPT    = z.mapOpt(x,f,s)
    /**/               inline def flatMap[OPT<:AnyType[T]](inline f: A=>OPT)             (using inline s: OptShape[T,OPT])     : OPT    = z.mapOpt(x,f,s)
  extension[A, OPT<:RawType[A]](inline x:Opt[A])
    /**/               inline def raw                                                    (using inline s: OptShape.Raw[A,OPT]) : OPT    = z.raw(x,s)
  extension[A,B,C](inline x:Opt[A])
    /**/               inline def mix[OPT<:AnyType[C]](inline o:AnyType[B],inline f:(A,B)=>C) (using inline s: OptShape[C,OPT]): OPT    = z.mixOpt(x,o,f,s)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def ~ ->  Stream

           Returns single value stream or empty stream, if option is void

@def forval -> Process option value

     Executes given function with option value

     Does nothing if option is void

     Returns option itself

@def contains -> Check contains

     Returns 'true' if option contains given value

     'false' - otherwise

     ```
        val o : Opt[String] = "foo"

        o.contains("foo").TP  // Prints: true

        o.contains("bar").TP  // Prints: false
     ```

@def default -> Default value

     Does nothing if option already contains a value

     For void option, returns a new option with given value

      ```
         var o : Opt[String] = "foo"

         o.default("bar").TP // Prints: Opt(foo)

         o = \/

         o.default("bar").TP // Prints: Opt(bar)
      ```

@def take -> Filter

      Discards value if it does not satisfy given predicate

      ```
        val o : Opt[String] = "foo"

        o.take(_.length < 2).TP  // Prints: Opt(\/)

        o.take(_.length > 2).TP  // Prints: Opt(foo)
      ```

@def drop ->   Reversed filter

      Discards value if it satisfies given predicate

      ```
        val o : Opt[String] = "foo"

        o.drop(_.length > 2).TP  // Prints: Opt(\/)

        o.drop(_.length > 3).TP  // Prints: Opt(foo)
      ```

@def takeOnly ->  Value filter

      Discards value if it is not equal to given value

      ```
        val o : Opt[String] = "foo"

        o.takeOnly("foo").TP  // Prints: Opt(foo)

        o.takeOnly("bar").TP  // Prints: Opt(\/)
      ```

@def dropOnly ->  Reversed value filter

      Discards value if it is equal to given value

      ```
        val o : Opt[String] = "foo"

        o.dropOnly("foo").TP  // Prints: Opt(\/)

        o.dropOnly("bar").TP  // Prints: Opt(foo)
      ```

@def dropVoid ->  Reversed void filter

      Discards value if it is void, so the option itself becomes void

      ```
        val s : ~[String]      = \/

        var o : Opt[~[String]] = s

        o.TP  // Prints: Opt(~())

        o = o.dropVoid

        o.TP  // Prints: Opt(\/)
      ```

@def filter ->  Legacy filter

    Discards value if it does not pass given filter function

    Note: [[take]] is usually used instead.


@def process -> Process value or no value

     Executes given function with option value or second given function if option is void

     Returns option itself

@def fornil -> Process nonexistent value

     Executes given function if option is void

     Returns option itself

@def get -> Get value

     Returns value or fails if option is void

     Note: This method is not widely used except for debugging and examples. [[or]] is the main way to resolve value

@def isEmpty -> Void check

     Returns `true` if value is void and `false` otherwise

     Note: This operation is implicitly available for all types. It is explicit here to indicate efficient implementation.

@def nonEmpty -> Not void check

     Returns `true` if value is not void and `false` otherwise

     Note: This operation is implicitly available for all types. It is explicit here to indicate efficient implementation.

@def map -> Convert value

      Creates new option with value converted by the given function

      Void option allways yeilds void option

      ```
         "Abc".?.map(_.length)  // Prints: Int.Opt(3)
      ```

     Note. Operation returns specialized options for primitive values

@def map_? -> Optional map

      Creates new option with value converted by optional function.

      Void option allways yeilds void option

      ```
      "a".?  .map_?(s => if(s.length > 2) s.toUpperCase else Opt.void).tp         // Prints Opt(\/)
      "abc".?.map_?(s => if(s.length > 2) s.toUpperCase else Opt.void).tp         // Prints Opt(ABC)
      "a".?  .map_?[Opt[String]](s => if(s.length > 2) s.toUpperCase else \/).tp  // Prints Opt(\/)
      "abc".?.map_?[Opt[String]](s => if(s.length > 2) s.toUpperCase else \/).tp  // Prints Opt(ABC)

      "a".?  .map_?(s => if(s.length > 2) s.length.? else Int.Opt.void).tp        // Prints Int.Opt(\/)
      "abc".?.map_?(s => if(s.length > 2) s.length.? else Int.Opt.void).tp        // Prints Int.Opt(3)
      "a".?  .map_?[Int.Opt](s => if(s.length > 2) s.length else \/).tp           // Prints Int.Opt(\/)
      "abc".?.map_?[Int.Opt](s => if(s.length > 2) s.length else \/).tp           // Prints Int.Opt(3)
      ```

      Note: The void option type has to be given explicitly unless target option type is given explicitly

     ```
     "abc".?.map_?{
        case s if s.length > 2 => s.toUpperCase
        case _                 => Opt.void
     }.TP
     ```
     Note. In case of matching, the last default case must be given, so it becomes regular (not a partial) function

@def mix -> Mix two option values

      If either option is void, the void option is returned

      Otherwise, the given function is applied with both values, resulting in a valued option

      ```
        val io: Int.Opt = 4

        var so: Opt[String] = \/


        so.mix(io, _ * _).TP  // Prints Opt(\/)

        so = "abc_"

        so.mix(io, _ * _).TP // Prints Opt(abc_abc_abc_abc_)
      ```

@def takeType -> Value filter and type converter

      Discards value if it does not belong to the given type

      Note, the result is mapped to the given type
      ```
         val o: Opt[Any] = "1"

         println(o.takeType[String]) // Prints: Opt(1)

         println(o.takeType[Int])    // Prints: \/
      ```
      Note: If **this** is empty, it is returned as is

@def collect -> Value filter and converter

      Discards value if given partial function is not defined

      Otherwise value is converted to the function result

      ```
         val o: Opt[String] = "foo"

         o.collect { case v if v.startsWith("a") => "bar" }.TP // Prints: \/

         o.collect { case v if v.startsWith("f") => "bar" }.TP // Prints: Opt(bar)
      ```
      Note: If **this** is empty, it is returned as is

      Note: `collect` is similar to `map_?`, but is less efficient, because PartialFunction has to be evaluated twice

@def or ->  Value or default

       Returns option value, or if option is void, given default value

       ```
       var o : Opt[String] = "foo"

       (o or "bar").TP     // Prints foo

       o = \/

       (o or "bar").TP     // Prints bar
       ```

@def or_? ->  Default option

       Returns this option if it is not void or given option otherwise

       ```
       var o  : Opt[String] = "foo"
       var o2 : Opt[String] = "bar"

       (o or_? o2).TP     // Prints Opt(foo)

       o = \/

       (o or_? o2).TP     // Prints Opt(bar)
       ```

@def raw -> Make specialized option

    Converts this option to specialized on primitive type

    The operation will not compile if converting to a reference type

    ```
      var o  : Opt[Int] = 12
      var io : Int.Opt  = o.raw
    ```

@def toScala -> Make Scala Option

    Converts this option to scala.Option

@def toJava -> Make Java Optional

    Converts this option to java.util.Optional
*/
