package scalqa; package lang; package any; package _methods; import language.implicitConversions

import _Methods.Self

object Self:
  extension[A](x: Self[A])
    /**/                      def typeName            (using d: Def.TypeName[A]) : String   = if(d.isInstanceOf[`def`.z.ReferenceNameDef[_]]) Z.refName(x) else d.typeName
    /**/                      def id                  (using d: Def.TypeName[A]) : String   = if(x == null) "null" else x.typeName.^.mapIf(!_.endsWith("$"), _ + "@" + x.hash)
    /**/                      def hash                                           : String   = if(x == null) "null" else Z.Hash(x.hashCode)

  extension[A](inline x: Self[A])
    private            inline def real                                           : A        = x.cast[A]
    /**/               inline def apply[U](inline f: A => U)                     : A        = {val v=x.real; f(v); v }
    /**/               inline def map[B](inline f: A => B)                       : B        = {val v=x.real; f(v) }
    /**/               inline def mapIf(inline filter:A=>Boolean, inline f:A=>A) : A        = {var v=x.real; if(filter(v)) v=f(v); v }
    /**/               inline def isVoid           (using inline d: Def.Void[A]) : Boolean  = {val v=x.real; v==null || d.value_isVoid(v)}
    /**/               inline def nonVoid          (using inline d: Def.Void[A]) : Boolean  = !x.isVoid
    /**/               inline def isEmpty          (using inline d:Def.Empty[A]) : Boolean  = d.value_isEmpty(x.real)
    /**/               inline def nonEmpty         (using inline d:Def.Empty[A]) : Boolean  = !x.isEmpty
    @tn("pack")        inline def ><                                             : ><[A]    = Val.><(x.real)
    @tn("stream")      inline def ~                                              : ~[A]     = Val.~(x.real)
    @tn("nonEmptyOpt") inline def ?           (using inline e:Opt[Def.Empty[A]])
                                                   (using inline d: Def.Void[A]) : Opt[A]   = J.illegalState() // Overtaken by root lib

  given z_Tag[A](using Any.Def.Tag[A]): Any.Def.Tag[Self[A]] = new Z.TagDef
  given z_Doc[A](using Any.Def.Doc[A]): Any.Def.Doc[Self[A]] = new Z.DocDef

  object TYPE:
    opaque type DEF[+A] <: AnyRef = AnyRef

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
@type DEF  -> ### Self View Methods

    Self view is another library available for all types, but it has to be activated by calling a universal ".^" or (".self_^") method on original value.

    For example:
    ```
      val pack: ><[String] = "FOO".^.><
    ```
    Due to opaque implementation, calling self view methods incures no overhead as if they were called directly on base value.

    A common use case is to manipulate an object within expression context:
    ```
      val a : Array[String] = new Array[String](1).^(_(0)="A")
    ```
    because all calls are inlined, the above expression is equivalent to:
    ```
      val a : Array[String] = new Array[String](1)
      a(0)="A"
    ```

@def typeName -> Type name

    Returns type name, which is class name for reference types and given tagged name for raw types

@def id -> Instance id

    Id is usually type name + "@" + hash code.

@def hash -> Hash code

    Returns alphanumeric hash code 4 characters long

    It is shorter and display friendly compared to Java hash.

    It is not meant to be used for calculations, like in Hashtable, but rather for display purposes.

@def apply -> Process

    Processes value with given function

    Returns the base value itself

    ```
      val a : Array[String] = new Array[String](2).^(a => { a(0)="A"; a(1)="B" })
    ```

@def map -> Convert To

    Converts base value with given function

    Returns the result of the conversion

@def mapIf -> Conditionally change value

    Changes base value with the given function, if condition is right

    Returns new value or old value

    Note:
    ````
    var s = "AB"

    s = s.^.mapIf(_.length == 2, _ + "C")

    // gets compiled into

    s = if(s.length == 2) s + "C" else s
    ```

@def ? -> Self as option

    Returns base value as an option.

    Unlike general .? method, this method will create empty option for void or empty values

    ```
      val p: ~[Int] = \/

      p.?.tp    // prints: Opt(scalqa.val.pack.z.Void)

      p.^.?.tp  // prints: Opt(\/)
    ```

    This method can even safely check ~ for emptiness, returning ~ with original values
    ```
    def s : ~[Int] = (1 <> 3).~.dropFirst(3)

    s.^.?.tp  // prints: Opt(\/)
    s.?.tp    // prints: Opt(~())
    ```

@def >< -> Self pack

    Creates a pack with this sigle value

@def ~ -> Self stream

    Creates a stream with this sigle value

    The following lines are inlined and produce same JVM code:

    ```
    val s1 : ~[String] = "Foo".^.~
    // same as
    val s2 : ~[String] = ~~("Foo")
    ```

@def isVoid -> Void check

    Returns `true` if value is null or void, `false` - otherwise

    Note. This method includes 'null' check compared to 'isVoid' on base value.

@def nonVoid -> Non void check

    Returns `true` if value is not null and not void, `false` - otherwise

    Note. This method includes 'null' check compared to 'nonVoid' on base value.

@def isEmpty -> Empty check

    Returns `true` if value is empty, `false` - otherwise.

    Any.Def.Empty is available for most known types, but can be defined for new.

@def nonEmpty -> Non empty check

    Returns `true` if value is not not empty, `false` - otherwise

    Any.Def.Empty is available for most known types, but can be defined for new.

*/