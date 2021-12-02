package scalqa; package `val`; import language.implicitConversions;

object Opt extends z_ValOptDefailts:
  def apply[A](v: A)                            : Opt[A]    = v.cast[AnyRef].cast[Opt[A]]
  def fromScala[A](v: scala.Option[A])          : Opt[A]    = if (v.isEmpty) VOID else v.get
  def fromJava [A](v: java.util.Optional[A])    : Opt[A]    = if (v.isPresent) v.get else VOID
  @tn("getVoid") def void[A]                    : Opt[A]    = ZZ.None.cast[Opt[A]]
  /**/    inline def unapply[A](inline v:Opt[A]): Option[A] = v.toScala

  extension[A](inline x:Opt[A])
    /**/  inline def isEmpty                                     : Boolean    = x eq ZZ.None
    /**/  inline def nonEmpty                                    : Boolean    = x ne ZZ.None
    /**/  inline def take( inline f: A => Boolean)               : Opt[A]     = {var o=x; if(o.nonEmpty && !f(o.`val`)) o=VOID;o}
    /**/  inline def takeOnly(inline v: A)                       : Opt[A]     = {val o=x; if(o == v.?) x else VOID }
    /**/  inline def takeType[B](using inline t:ClassTag[B])     : Opt[B]     = {var o:Opt[B]=VOID;if(t.unapply(x).isEmpty.not) o=x.cast[Opt[B]]; o}
    /**/  inline def drop(inline f: A => Boolean)                : Opt[A]     = {var o=x; if(o.nonEmpty &&  f(o.`val`)) o=VOID;o}
    /**/  inline def dropOnly(inline v: A)                       : Opt[A]     = {val o=x; if(o == v.?) VOID else x }
    /**/  inline def dropVoid (using inline d: Any.Def.Void[A])  : Opt[A]     = {var o=x; if(o != null && o.nonEmpty && d.value_isVoid(o.`val`)) o=VOID;o}
    /**/  inline def default(inline dv: => A)                    : Opt[A]     = {val o=x; if(o.isEmpty)  dv  else o}
    /**/  inline def contains(value: A)                          : Boolean    = x == value.?
    /**/  inline def foldAs[B](inline v: =>B)(inline f: A=>B)    : B          = x.map(f) or v
    infix inline def or(inline default: => A)                    : A          = opt.z.Macro.or(x,default)
    infix inline def orOpt(inline that: => Opt[A])               : Opt[A]     = {val X=x; if(X.isEmpty) that else X}
    /**/  inline def forval[U]( inline f: A=>U)                  : Opt[A]     = {val X=x; if(X.nonEmpty) f(X.`val`); X}
    /**/  inline def foreach[U](inline f: A=>U)                  : Opt[A]     = {val X=x; if(X.nonEmpty) f(X.`val`); X}
    infix inline def fornil[U]( inline f: => U)                  : Opt[A]     = {val X=x; if(X.isEmpty){ val u:U=f}; X}
    /**/  inline def process[U,W](inline f:A=>U,inline fNil: =>W): Opt[A]     = {val X=x; if(X.isEmpty){ val w:W=fNil} else f(X.`val`); X}
    /**/  inline def filter( inline f: A => Boolean)             : Opt[A]     = x.take(f)
    /**/  inline def withFilter(inline f: A => Boolean)          : Opt[A]     = x.take(f)
    /**/  inline def collect[B](inline f: PartialFunction[A,B])  : Opt[B]     = opt.Z.collect(x,f)
    /**/  inline def stream                                      : Stream[A]  = opt.Z.stream(x)
    /**/  inline def get                                         : A          = opt.Z.get(x)
    /**/  inline def toScala                                     : Option[A]  = opt.Z.toScala(x)
    /**/  inline def toJava                           : java.util.Optional[A] = opt.Z.toJava(x)
    /**/  inline def mapIf(inline f:A=>Boolean,inline m:A=>A)                                                                   : Opt[A] = x.map[A](v => if(f(v)) m(v) else v)
    /**/  inline def map[B](inline f:A=>B)                                                       (using inline B:Specialized[B]): B.Opt  = opt.z.specialized.map(x,f)
    /**/  inline def mapOpt [B,OPT<:Any.Opt[B]](inline f: A=>OPT)(using inline o:Specialized.Opt[B,OPT],inline B:Specialized[B]): B.Opt  = opt.z.specialized.mapOpt(x,f)
    /**/  inline def flatMap[B,OPT<:Any.Opt[B]](inline f: A=>OPT)(using inline o:Specialized.Opt[B,OPT],inline B:Specialized[B]): B.Opt  = opt.z.specialized.mapOpt(x,f)
    /**/  inline def mix[B,C](inline o:Any.Opt[B],inline f:(A,B)=>C)                             (using inline C:Specialized[C]): C.Opt  = opt.z.specialized.mix(x,o,f)
    /**/  inline def raw                                                               (using inline A:Specialized.Primitive[A]): A.Opt  = opt.z.specialized.raw(x)

  object TYPE:
    opaque type DEF[+A] <: AnyRef.Opaque = AnyRef.Opaque

  implicit inline def implicitFromAny    [A](inline v: A)                    : Opt[A]    = v.cast[Opt[A]]
  implicit inline def implicitFromScala  [A](inline v: scala.Option[A])      : Opt[A]    = fromScala[A](v)
  implicit inline def implicitFromJava   [A](inline v: java.util.Optional[A]): Opt[A]    = fromJava[A](v)
  implicit inline def implicitFromResult [A](inline v: Result[A])            : Opt[A]    = v.valueOpt
  implicit inline def implicitRequest    [A](v:VOID)                         : Opt[A]    = ZZ.None.cast[Opt[A]]
  implicit inline def implicitToBoolean  [A](inline v: Opt[A])               : Boolean   = v.nonEmpty

  given z_CanEqualOpt[A,B](using CanEqual[A,B])  : CanEqual[Opt[A], Opt[B]] = CanEqual.derived
  given z_ClassTag[A]     (using t: ClassTag[A]) : ClassTag[Opt[A]]         = t.cast[ClassTag[Opt[A]]]
  given z_NameDef [A]                            : Any.Def.TypeName[Opt[A]] = Any.Def.TypeName("Opt")
  given z_VoidDef [A]                            : Any.Def.Void[Opt[A]]     = opt.Z.Def.cast[Any.Def.Void[Opt[A]]]
  given z_Doc[A](using t: Any.Def.Tag[A])        : Any.Def.Doc[Opt[A]]      = new opt.Z.Doc

  inline given z_GivenAnyOfAnyOpt[A[B],B](using inline v: A[B]) : Opt[A[B]] = v.cast[Opt[A[B]]] // allowing optional Ordering[A], Numeric[A], etc., like (using o: Opt[Ordering[A]])
  inline given z_GivenAnyDefEmptyOpt[A](using inline d: Any.Def.Empty[A]=ZZ.None.cast[Any.Def.Empty[A] & Opt[Any]]): Opt[Any.Def.Empty[A]] = d.cast[Opt[Any.Def.Empty[A]]] // Contra-varient Empty has be dealt explicitly

class z_ValOptDefailts:
  inline given z_OrderingComparable[B<:Comparable[B]] : Opt[Ordering[B]] = gen.math.z.Ordering.OrderingComparable.cast[Ordering[B]]
  inline given z_GivenAnyOfAnyNone[C<:A[B],A[B],B]    : Opt[C]          =VOID

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

      By Scalqa convention, method names, which return [[Opt]] type, are ended with 'Opt' instead of word 'Option'

      ```
      val l: Lookup[Int,String] = ?_?_?

      val o: Opt[String] = l.getOpt(12)

      if(o) println("Value found.")
      else  println("Value not found.")
      ```

@def void  -> Get void instance

@def stream ->  Stream

           Returns single value stream or empty stream, if option is void

@def foldAs -> Convert or default

     This is a synthetic operation:
     ```
      val o: Opt[String]=VOID

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

         o=VOID

         o.default("bar").TP // Prints: Opt(bar)
      ```

@def take -> Filter

      Discards value if it does not satisfy given predicate

      ```
        val o : Opt[String] = "foo"

        o.take(_.length < 2).TP  // Prints: Opt(VOID)

        o.take(_.length > 2).TP  // Prints: Opt(foo)
      ```

@def drop ->   Reversed filter

      Discards value if it satisfies given predicate

      ```
        val o : Opt[String] = "foo"

        o.drop(_.length > 2).TP  // Prints: Opt(VOID)

        o.drop(_.length > 3).TP  // Prints: Opt(foo)
      ```

@def takeOnly ->  Value filter

      Discards value if it is not equal to given value

      ```
        val o : Opt[String] = "foo"

        o.takeOnly("foo").TP  // Prints: Opt(foo)

        o.takeOnly("bar").TP  // Prints: Opt(VOID)
      ```

@def dropOnly ->  Reversed value filter

      Discards value if it is equal to given value

      ```
        val o : Opt[String] = "foo"

        o.dropOnly("foo").TP  // Prints: Opt(VOID)

        o.dropOnly("bar").TP  // Prints: Opt(foo)
      ```

@def dropVoid ->  Reversed void filter

      Discards value if it is void, so the option itself becomes void

      ```
        val s : Stream[String]     =VOID

        var o : Opt[Stream[String]] = s

        o.TP  // Prints: Opt(Stream())

        o = o.dropVoid

        o.TP  // Prints: Opt(VOID)
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

@def mapOpt -> Optional map

      Creates new option with value converted by optional function.

      Void option allways yeilds void option

      ```
      "a"  .?.mapOpt(s => if(s.length > 2) s.toUpperCase else VOID).TP      // Prints Opt(VOID)
      "abc".?.mapOpt(s => if(s.length > 2) s.toUpperCase else VOID).TP      // Prints Opt(ABC)

      "a"  .?.mapOpt(s => if(s.length > 2) s.length else VOID).TP           // Prints Int.Opt(VOID)
      "abc".?.mapOpt(s => if(s.length > 2) s.length else VOID).TP           // Prints Int.Opt(3)
      ```

     ```
     "abc".?.mapOpt{
        case s if s.length > 2 => s.toUpperCase
        case _                 => VOID
     }.TP
     ```
     Note. In case of matching, the last default case must be given, so it becomes regular (not a partial) function

@def mix -> Mix two option values

      If either option is void, the void option is returned

      Otherwise, the given function is applied with both values, resulting in a valued option

      ```
        val io: Int.Opt = 4

        var so: Opt[String]=VOID


        so.mix(io, _ * _).TP  // Prints Opt(VOID)

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
      Note: If Opt is empty, it is returned as is

@def collect -> Value filter and converter

      Discards value if given partial function is not defined

      Otherwise value is converted to the function result

      ```
         val o: Opt[String] = "foo"

         o.collect { case v if v.startsWith("a") => "bar" }.TP // Prints: \/

         o.collect { case v if v.startsWith("f") => "bar" }.TP // Prints: Opt(bar)
      ```
      Note: If Opt is empty, it is returned as is

      Note: `collect` is similar to `mapOpt`, but is less efficient, because PartialFunction has to be evaluated twice

@def or ->  Value or default

       Returns option value, or if option is void, given default value

       ```
       var o : Opt[String] = "foo"

       (o or "bar").TP     // Prints foo

       o=VOID

       (o or "bar").TP     // Prints bar
       ```

@def orOpt ->  Default option

       Returns this option if it is not void or given option otherwise

       ```
       var o  : Opt[String] = "foo"
       var o2 : Opt[String] = "bar"

       (o orOpt o2).TP     // Prints Opt(foo)

       o=VOID

       (o orOpt o2).TP     // Prints Opt(bar)
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