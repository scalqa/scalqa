package scalqa; package `val`; import language.implicitConversions;

object Opt extends zValOptDefailts:
  def apply[A](v: A)                        : Opt[A] = v.cast[AnyRef].cast[Opt[A]]
  def fromScala[A](v: scala.Option[A])      : Opt[A] = if (v.isEmpty) \/ else v.get
  def fromJava [A](v: java.util.Optional[A]): Opt[A] = if (v.isPresent) v.get else \/
  @tn("getVoid") def void[A]                : Opt[A] = ZZ.None.cast[Opt[A]]

  extension[A](inline x:Opt[A])
    /**/               inline def isEmpty                                     : Boolean    = x eq ZZ.None
    /**/               inline def nonEmpty                                    : Boolean    = x ne ZZ.None
    /**/               inline def take( inline f: A => Boolean)               : Opt[A]     = {var o=x; if(o.nonEmpty && !f(o.`val`)) o= \/; o}
    /**/               inline def takeOnly(inline v: A)                       : Opt[A]     = {val o=x; if(o == v.?) x else \/ }
    /**/               inline def takeType[B](using inline t:ClassTag[B])     : Opt[B]     = {var o:Opt[B]= \/; if(t.unapply(x).isEmpty.not) o=x.cast[Opt[B]]; o}
    /**/               inline def drop(inline f: A => Boolean)                : Opt[A]     = {var o=x; if(o.nonEmpty &&  f(o.`val`)) o= \/; o}
    /**/               inline def dropOnly(inline v: A)                       : Opt[A]     = {val o=x; if(o == v.?) \/ else x }
    /**/               inline def dropVoid (using inline d: Any.Def.Void[A])  : Opt[A]     = {var o=x; if(o != null && o.nonEmpty && d.value_isVoid(o.`val`)) o= \/; o}
    /**/               inline def default(inline dv: => A)                    : Opt[A]     = {val o=x; if(o.isEmpty)  dv  else o}
    /**/               inline def contains(value: A)                          : Boolean    = x == value.?
    /**/               inline def foldAs[B](inline v: =>B)(inline f: A=>B)    : B          = x.map(f) or v
    /**/         infix inline def or(inline default: => A)                    : A          = opt.z.Macro.or(x,default)
    @tn("or_Opt")infix inline def or_?(inline that: => Opt[A])                : Opt[A]     = {val X=x; if(X.isEmpty) that else X}
    /**/               inline def forval[U]( inline f: A=>U)                  : Opt[A]     = {val X=x; if(X.nonEmpty) f(X.`val`); X}
    /**/               inline def foreach[U](inline f: A=>U)                  : Opt[A]     = {val X=x; if(X.nonEmpty) f(X.`val`); X}
    /**/         infix inline def fornil[U]( inline f: => U)                  : Opt[A]     = {val X=x; if(X.isEmpty){ val u:U=f}; X}
    /**/               inline def process[U,W](inline f:A=>U,inline fNil: =>W): Opt[A]     = {val X=x; if(X.isEmpty){ val w:W=fNil} else f(X.`val`); X}
    /**/               inline def filter( inline f: A => Boolean)             : Opt[A]     = x.take(f)
    /**/               inline def withFilter(inline f: A => Boolean)          : Opt[A]     = x.take(f)
    /**/               inline def map[T](inline f:A=>T)                                                       (using inline T:Specialized[T]): T.Opt = opt.Z.map(x,f)
    /**/               inline def mapmap[T](inline f:A=>T)                                                       (using inline T:Specialized[T]): T.Opt = opt.Z.map(x,f)
    @tn("map_Opt")     inline def map_?  [T,OPT<:Any.Opt[T]](inline f: A=>OPT)(using inline o:Specialized.Opt[T,OPT],inline T:Specialized[T]): T.Opt = opt.Z.mapOpt(x,f)
    /**/               inline def flatMap[T,OPT<:Any.Opt[T]](inline f: A=>OPT)(using inline o:Specialized.Opt[T,OPT],inline T:Specialized[T]): T.Opt = opt.Z.mapOpt(x,f)
    /**/               inline def mix[B,T](inline o:Any.Opt[B],inline f:(A,B)=>T)                             (using inline T:Specialized[T]): T.Opt = opt.Z.mix(x,o,f)
    /**/               inline def raw                                                               (using inline A:Specialized.Primitive[A]): A.Opt = opt.Z.raw(x)
  extension[A](x:Opt[A])
    /**/                      def collect[B](f: PartialFunction[A,B])         : Opt[B]     = {var o:Opt[B]= \/; if(x.nonEmpty){val w=x.`val`; if(f.isDefinedAt(w)) o=f(w)}; o}
    @tn("stream")             def ~                                           : ~[A]       = if(x.nonEmpty) ~~(x.`val`) else Stream.void
    /**/                      def get                                         : A          = {if(x.isEmpty) throw new ZZ.EO(); x.cast[A]}
    /**/                      def toScala                                : scala.Option[A] = if(x.nonEmpty) scala.Some(x.`val`) else scala.None
    /**/                      def toJava                           : java.util.Optional[A] = if(x.nonEmpty) java.util.Optional.of(x.`val`) else java.util.Optional.empty

  object TYPE:
    opaque type DEF[+A] <: AnyRef.Opaque = AnyRef.Opaque

  inline given givenSummonAnyOfAny[A[B],B]      (using inline v: A[B])                : Opt[A[B]] = v.cast[Opt[A[B]]]
  inline given zzOrderingOfByte  [A<:Any.Byte  ](using inline v: Byte  .G.Ordering[A]): Opt[Byte  .G.Ordering[A]] = v.cast[Opt[Byte  .G.Ordering[A]]]
  inline given zzOrderingOfByte  [A<:Any.Char  ](using inline v: Char  .G.Ordering[A]): Opt[Char  .G.Ordering[A]] = v.cast[Opt[Char  .G.Ordering[A]]]
  inline given zzOrderingOfByte  [A<:Any.Short ](using inline v: Short .G.Ordering[A]): Opt[Short .G.Ordering[A]] = v.cast[Opt[Short .G.Ordering[A]]]
  inline given zzOrderingOfInt   [A<:Any.Int   ](using inline v: Int   .G.Ordering[A]): Opt[Int   .G.Ordering[A]] = v.cast[Opt[Int   .G.Ordering[A]]]
  inline given zzOrderingOfByte  [A<:Any.Long  ](using inline v: Long  .G.Ordering[A]): Opt[Long  .G.Ordering[A]] = v.cast[Opt[Long  .G.Ordering[A]]]
  inline given zzOrderingOfByte  [A<:Any.Float ](using inline v: Float .G.Ordering[A]): Opt[Float .G.Ordering[A]] = v.cast[Opt[Float .G.Ordering[A]]]
  inline given zzOrderingOfDouble[A<:Any.Double](using inline v: Double.G.Ordering[A]): Opt[Double.G.Ordering[A]] = v.cast[Opt[Double.G.Ordering[A]]]

  given givenCanEqualOpt[A,B](using CanEqual[A,B])  : CanEqual[Opt[A], Opt[B]] = CanEqual.derived
  given givenClassTag[A]  (using t: ClassTag[A])    : ClassTag[Opt[A]]         = t.cast[ClassTag[Opt[A]]]
  given givenNameDef [A]                            : Any.Def.TypeName[Opt[A]] = Any.Def.TypeName("Opt")
  given givenVoidDef [A]                            : Any.Def.Void[Opt[A]]     = opt.z.Def.cast[Any.Def.Void[Opt[A]]]
  given givenDocDef[A](using t: Any.Def.Doc[A])     : Any.Def.Doc[Opt[A]]      = new opt.z.Def.Doc

  implicit inline def implicitFromAny    [A](inline v: A)                    : Opt[A]    = v.cast[Opt[A]]
  implicit inline def implicitFromVoidRequest[A](inline v: \/)               : Opt[A]    = ZZ.None.cast[Opt[A]]
  implicit inline def implicitFromScala  [A](inline v: scala.Option[A])      : Opt[A]    = fromScala[A](v)
  implicit inline def implicitFromJava   [A](inline v: java.util.Optional[A]): Opt[A]    = fromJava[A](v)
  implicit inline def implicitFromResult [A](inline v: Result[A])            : Opt[A]    = v.value_?
  implicit inline def implicitToBoolean  [A](inline v: Opt[A])               : Boolean   = v.nonEmpty

//  // These will push boxing to JVM, making decompiled byte code clearer
//  implicit   inline def zzImplicitFromRaw[A<:Any.Boolean](inline v: A)        : Opt[A]    = java.lang.Boolean  .valueOf(v.cast[Boolean]).cast[Opt[A]]
//  implicit   inline def zzImplicitFromRaw[A<:Any.Byte]   (inline v: A)        : Opt[A]    = java.lang.Byte     .valueOf(v.cast[Byte]   ).cast[Opt[A]]
//  implicit   inline def zzImplicitFromRaw[A<:Any.Char]   (inline v: A)        : Opt[A]    = java.lang.Character.valueOf(v.cast[Char]   ).cast[Opt[A]]
//  implicit   inline def zzImplicitFromRaw[A<:Any.Short]  (inline v: A)        : Opt[A]    = java.lang.Short    .valueOf(v.cast[Short]  ).cast[Opt[A]]
//  implicit   inline def zzImplicitFromRaw[A<:Any.Int]    (inline v: A)        : Opt[A]    = java.lang.Integer  .valueOf(v.cast[Int]    ).cast[Opt[A]]
//  implicit   inline def zzImplicitFromRaw[A<:Any.Long]   (inline v: A)        : Opt[A]    = java.lang.Long     .valueOf(v.cast[Long]   ).cast[Opt[A]]
//  implicit   inline def zzImplicitFromRaw[A<:Any.Float]  (inline v: A)        : Opt[A]    = java.lang.Float    .valueOf(v.cast[Float]  ).cast[Opt[A]]
//  implicit   inline def zzImplicitFromRaw[A<:Any.Double] (inline v: A)        : Opt[A]    = java.lang.Double   .valueOf(v.cast[Double] ).cast[Opt[A]]

// ******************************************************
class zValOptDefailts:
  inline given givenNoneAnyOfAny[C<:A[B],A[B],B] : Opt[C]           = \/
  inline given givenOrdering[T<:Comparable[T]]   : Opt[Ordering[T]] = gen.math.z.Ordering.OrderingComparable.cast[Ordering[T]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ### Value Option

      [[Opt]] is a container, which can hold a single value or be empty

      Option can be converted to value with method `or`, which also takes default value for the case when option is empty

      Option is often used as Boolean, where ''Option'' with value is converted to 'true' and empty option is converted to 'false'

      By Scalqa convention, method names, which return [[Opt]] type, are ended with '_?' instead of word 'Option'

      ```
      val l: Lookup[Int,String] = ?_?_?

      val o: Opt[String] = l.get_?(12)

      if(o) println("Value found.")
      else  println("Value not found.")
      ```

@def void  -> Get void instance

@def ~ ->  Stream

           Returns single value stream or empty stream, if option is void

@def foldAs -> Convert or default

     This is a synthetic operation:
     ```
      val o: Opt[String] = \/

      o.foldAs(0)(_.length)

      // same as

      o.map(_.length) or 0
     ```

     foldAs is more readable if mapping code is substantial:

     ```
      o.foldAs(0){ v =>
        var l = v.length
        if     (l > 1000) l = 1000
        else if(l < 0)    l = 0
        l
      }
     ```

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
      "a"  .?.map_?(s => if(s.length > 2) s.toUpperCase else Opt.void).tp         // Prints Opt(\/)
      "abc".?.map_?(s => if(s.length > 2) s.toUpperCase else Opt.void).tp         // Prints Opt(ABC)
      "a"  .?.map_?[Opt[String]](s => if(s.length > 2) s.toUpperCase else \/).tp  // Prints Opt(\/)
      "abc".?.map_?[Opt[String]](s => if(s.length > 2) s.toUpperCase else \/).tp  // Prints Opt(ABC)

      "a"  .?.map_?(s => if(s.length > 2) s.length.? else Int.Opt.void).tp        // Prints Int.Opt(\/)
      "abc".?.map_?(s => if(s.length > 2) s.length.? else Int.Opt.void).tp        // Prints Int.Opt(3)
      "a"  .?.map_?[Int.Opt](s => if(s.length > 2) s.length else \/).tp           // Prints Int.Opt(\/)
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