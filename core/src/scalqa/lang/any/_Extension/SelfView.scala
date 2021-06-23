package scalqa; package lang; package any; package _Extension; import language.implicitConversions

import _extension.SelfView
import gen.`given`. { NameTag, VoidTag, InTag, DocTag, EmptyTag }

object SelfView:
  extension[A](x: SelfView[A])
    /**/                      def typeName                       (using d: NameTag[A]) : String   = if(d.isRef) Z.kind(x) else d.name
    /**/                      def id                             (using d: NameTag[A]) : String   = if(x == null) "null" else { var n = x.typeName; if(!n.endsWith("$")) n += "@" + x.hash; n }
    /**/                      def hash                                                 : String   = if(x == null) "null" else Z.Hash(x.hashCode)

  extension[A](inline x: SelfView[A])
    private            inline def real                                                 : A        = x.cast[A]
    /**/               inline def apply[U](inline f: A => U)                           : A        = {val v=x.real; f(v); v }
    /**/               inline def as[B](inline f: A => B)                              : B        = f(x.real)
    /**/               inline def revise(inline f:A=>A)                                : A        = {val v=x.real; f(v) }
    /**/               inline def reviseIf(inline filter:A=>Boolean, inline f:A=>A)    : A        = {var v=x.real; if(filter(v)) v=f(v); v }
    /**/               inline def isVoid                  (using inline d: VoidTag[A]) : Boolean  = {val v=x.real;v==null ||  d.isVoid(v)}
    /**/               inline def nonVoid                 (using inline d: VoidTag[A]) : Boolean  = {val v=x.real;v!=null && !d.isVoid(v)}
    @tn("nonEmptyOpt") inline def ? (using inline e:EmptyTag[A], inline d: VoidTag[A]) : Opt[A]   = J.illegalState() // Overtaken by root lib
    /**/               inline def isEmpty                 (using inline d:EmptyTag[A]) : Boolean  = d.isEmpty(x.real)
    /**/               inline def nonEmpty                (using inline d:EmptyTag[A]) : Boolean  = !d.isEmpty(x.real)
    @tn("pack")        inline def ><                                                   : ><[A]    = Val.><[A](x.real)

  given givenDocTag[A](using d: DocTag[A]): DocTag[SelfView[A]] with
    def tag(v: SelfView[A]) = doc(v).tag
    def doc(v: SelfView[A]) = d.doc(v.real)

  object opaque { opaque type `type`[+A] <: Ref = Ref }


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
@object opaque -> SelfView extension is a universal library available for all types.

    SelfView is activated by calling a universal ".^" or (".self_^") method, which has zero cost, because SelfView is an opaque type.


    For example:
    ```
      val pack: ><[String] = "FOO".^.><
    ```

    A common use case is to manipulate an object within expression context:
    ```
      val a : Array[String] = new Array[String](2).^(a => { a(0)="A"; a(1)="B" })
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

@def as -> Convert

    Converts base value with given function

    Returns the result of conversion

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