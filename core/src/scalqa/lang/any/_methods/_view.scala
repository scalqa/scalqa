package scalqa; package lang; package any; package _methods; import language.implicitConversions

import _Methods._view
import gen.`given`. { TypeDef, VoidDef, DocDef, EmptyDef }

object _view:
  extension[A](x: _view[A])
    /**/                      def typeName                       (using d: TypeDef[A]) : String   = if(d.isRef) Z.kind(x) else d.typeName
    /**/                      def id                             (using d: TypeDef[A]) : String   = if(x == null) "null" else { var n = x.typeName; if(!n.endsWith("$")) n += "@" + x.hash; n }
    /**/                      def hash                                                 : String   = if(x == null) "null" else Z.Hash(x.hashCode)

  extension[A](inline x: _view[A])
    private            inline def real                                                 : A        = x.cast[A]
    /**/               inline def apply[U](inline f: A => U)                           : A        = {val v=x.real; f(v); v }
    /**/               inline def to[B](inline f: A => B)                              : B        = f(x.real)
    /**/               inline def revise(inline f:A=>A)                                : A        = {val v=x.real; f(v) }
    /**/               inline def reviseIf(inline filter:A=>Boolean, inline f:A=>A)    : A        = {var v=x.real; if(filter(v)) v=f(v); v }
    /**/               inline def isVoid                  (using inline d: VoidDef[A]) : Boolean  = {val v=x.real;v==null ||  d.value_isVoid(v)}
    /**/               inline def nonVoid                 (using inline d: VoidDef[A]) : Boolean  = {val v=x.real;v!=null && !d.value_isVoid(v)}
    @tn("nonEmptyOpt") inline def ? (using inline e:EmptyDef[A], inline d: VoidDef[A]) : Opt[A]   = J.illegalState() // Overtaken by root lib
    /**/               inline def isEmpty                 (using inline d:EmptyDef[A]) : Boolean  = d.value_isEmpty(x.real)
    /**/               inline def nonEmpty                (using inline d:EmptyDef[A]) : Boolean  = !d.value_isEmpty(x.real)
    @tn("pack")        inline def ><                                                   : ><[A]    = Val.><[A](x.real)

  given givenDocDef[A](using d: DocDef[A]): DocDef[_view[A]] with
    def value_tag(v: _view[A]) = value_doc(v).tag
    def value_doc(v: _view[A]) = d.value_doc(v.real)

  object OPAQUE:
    opaque type TYPE[+A] <: AnyRef = AnyRef

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
@object OPAQUE  -> ### Self View Methods

    Self view is another library available on all types, but it has to be activated by calling a universal ".^" or (".self_^") method on original value.

    Due to opaque implementation, calling "self view" methods incures no overhead as if they were called directly on base value.

    For example:
    ```
      val pack: ><[String] = "FOO".^.><
    ```

    A common use case is to manipulate an object within expression context:
    ```
      val a : Array[String] = new Array[String](2).^(_(0)="A").^(_(1)="B")
    ```
    because all calls are inlined, the above expression is equivalent to:
    ```
      val a : Array[String] = new Array[String](2)
      a(0)="A"
      a(1)="B"
    ```

@def typeName -> Type name

    Returns type name, which is class name for reference types and given tagged name for raw types

@def id -> Instance id

    Usually it is type name and hash code.

@def hash -> Hash code

    Returns alphanumeric hash code 4 characters long

    It is shorter and display friendly compared to Java hash.

@def apply -> Process

    Processes value with given function

    Returns the base value itself

    ```
      val a : Array[String] = new Array[String](2).^(a => { a(0)="A"; a(1)="B" })
    ```

@def to -> Convert To

    Converts base value with given function

    Returns the result of the conversion

@def revise -> Change value

    Changes base value with the given function

    Returns the new value

    Note. Similar to `as` conversion, but the value type stays the same

@def reviseIf -> Conditionally change value

    Changes base value with the given function, if condition is right

    Returns new value or old value

@def ? -> As option

    Returns base value as an option.

    Unlike general .? method, this method will create empty option for void or empty values

    ```
      List().?.tp    // prints: Opt(List())

      List().^.?.tp  // prints: Opt(\/)

    ```

@def >< -> Pack

    Creates a pack with this sigle value

@def isVoid -> Void check

    Returns `true` if value is void, `false` - otherwise

@def nonVoid -> Non void check

    Returns `true` if value is not void, `false` - otherwise


@def isEmpty -> Empty check

    Returns `true` if value is empty, `false` - otherwise

@def nonEmpty -> Non empty check

    Returns `true` if value is not empty, `false` - otherwise

*/