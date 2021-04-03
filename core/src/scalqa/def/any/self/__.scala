package scalqa; package `def`; package any; import self.*; import language.implicitConversions

import Any.Self
import self.info.Tag

object Self:
  extension[A](x: Self[A])
    /**/                      def kind                           (using t: Tag.Type[A]) : String   = if(t.isRef) Z.kind(x) else t.name
    /**/                      def id                             (using t: Tag.Type[A]) : String   = { var n = x.kind; if(!n.endsWith("$")) n += "@" + x.hash; n }
    /**/                      def hash                                                  : String   = Z.Hash(x.hashCode)

  extension[A](inline x: Self[A])
    private            inline def real                                                  : A        = x.cast[A]
    /**/               inline def apply[U](  inline f: A => U)                          : A        = {val v=x.real; f(v); v }
    /**/               inline def convert[B](inline f: A => B)                          : B        = f(x.real)
    /**/               inline def revise(inline f:A=>A)                                 : A        = {val v=x.real; f(v) }
    /**/               inline def reviseIf(inline filter:A=>Boolean, inline f:A=>A)     : A        = {var v=x.real; if(filter(v)) v=f(v); v }
    /**/               inline def isVoid                  (using inline t: Tag.Void[A]) : Boolean  = {val v=x.real;v==null ||  t.isVoid(v)}
    /**/               inline def nonVoid                 (using inline t: Tag.Void[A]) : Boolean  = {val v=x.real;v!=null && !t.isVoid(v)}
    @tn("nonEmptyOpt") inline def ? (using inline e:Tag.Empty[A],inline t: Tag.Void[A]) : Opt[A]   = J.illegalState() // Overtaken by root lib
    /**/               inline def isEmpty                 (using inline t:Tag.Empty[A]) : Boolean  = t.isEmpty(x.real)
    /**/               inline def nonEmpty                (using inline t:Tag.Empty[A]) : Boolean  = !t.isEmpty(x.real)
    @tn("pack")        inline def ><                                                    : ><[A]    = Val.><[A](x.real)

  given xxTagDoc[A](using t: Info.Tag.Doc[A]) : Info.Tag.Doc[Self[A]] with
    def tag (v: Self[A]) = info(v).tag
    def info(v: Self[A]) = t.info(v.real)

  object opaque { opaque type `type`[+A] <: Ref = Ref }

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Void = self.Void;  @fast lazy val Void  = self.Void
  type Info = self.Info;  @fast lazy val Info  = self.Info
  /**/                               val Shape = self.Shape

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
@def isEmpty -> Empty check

    Returns `true`` if value is empty, `false` - otherwise

@def nonEmpty -> Non empty check

    Returns `true`` if value is not empty, `false` - otherwise

*/