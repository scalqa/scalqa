package scalqa; package lang; package any; import self.*; import language.implicitConversions

import Any.Self
import self.Def

object Self:
  extension[A](x: Self[A])
    /**/                      def kind                           (using t: Def.Name[A]) : String   = if(t.isRef) Z.kind(x) else t.name
    /**/                      def id                             (using t: Def.Name[A]) : String   = { var n = x.kind; if(!n.endsWith("$")) n += "@" + x.hash; n }
    /**/                      def hash                                                  : String   = Z.Hash(x.hashCode)

  extension[A](inline x: Self[A])
    private            inline def real                                                  : A        = x.cast[A]
    /**/               inline def apply[U](  inline f: A => U)                          : A        = {val v=x.real; f(v); v }
    /**/               inline def convert[B](inline f: A => B)                          : B        = f(x.real)
    /**/               inline def revise(inline f:A=>A)                                 : A        = {val v=x.real; f(v) }
    /**/               inline def reviseIf(inline filter:A=>Boolean, inline f:A=>A)     : A        = {var v=x.real; if(filter(v)) v=f(v); v }
    /**/               inline def isVoid                  (using inline t: Def.Void[A]) : Boolean  = {val v=x.real;v==null ||  t.isVoid(v)}
    /**/               inline def nonVoid                 (using inline t: Def.Void[A]) : Boolean  = {val v=x.real;v!=null && !t.isVoid(v)}
    @tn("nonEmptyOpt") inline def ? (using inline e:Def.Empty[A],inline t: Def.Void[A]) : Opt[A]   = J.illegalState() // Overtaken by root lib
    /**/               inline def isEmpty                 (using inline t:Def.Empty[A]) : Boolean  = t.isEmpty(x.real)
    /**/               inline def nonEmpty                (using inline t:Def.Empty[A]) : Boolean  = !t.isEmpty(x.real)
    @tn("pack")        inline def ><                                                    : ><[A]    = Val.><[A](x.real)

  given xxDefDoc[A](using t: Def.Doc[A]) : Def.Doc[Self[A]] with
    def tag (v: Self[A]) = doc(v).tag
    def doc(v: Self[A]) = t.doc(v.real)

  object opaque { opaque type `type`[+A] <: Ref = Ref }

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  @fast lazy val Void  = self.Void;   type Void = self.Void
  @fast lazy val Doc   = self.Doc;    type Doc  = self.Doc
  /**/       val Def  = self.Def
  /**/       val Shape = self.Shape

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