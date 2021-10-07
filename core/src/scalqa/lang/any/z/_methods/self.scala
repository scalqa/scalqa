package scalqa; package lang; package any; package z; package _methods; import language.implicitConversions

import any._Methods.Self

transparent trait self:

  extension[A](inline x: Self[A])
    @tn("selfIsVoid")   inline def isVoid   (using inline d:Def.Void[A]) : Boolean     = {val v=x.cast[A]; v==null ||  d.value_isVoid(v) }
    @tn("selfNonVoid")  inline def nonVoid  (using inline d:Def.Void[A]) : Boolean     = !x.isVoid
    @tn("nonEmpty_Opt") inline def ?  (using inline o:Opt[Def.Empty[A]])
                                            (using inline d:Def.Void[A]) : Opt[A]      = z.opt.nonEmpty(x,o,d)

  extension(inline x: Self[String])
    @tn("nonEmpty_Opt") inline def ?                                     : Opt[String] = x.cast[String].^.map(v => (v != null && v.length > 0) ? v )

  extension[A](inline x: Self[~[A]])
    @tn("nonEmpty_Opt") inline def ?                                     : Opt[~[A]]   = z.opt.nonEmptyStream(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/