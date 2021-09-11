package scalqa; package lang; package any; package z; package _methods; import language.implicitConversions

transparent trait view:

  extension[A](x: any._Methods._view[A])
    @tn("selfIsVoid")   inline def isVoid                  (using inline d:Def.Void[A]) : Boolean   = x==null ||  d.value_isVoid(x.cast[A])
    @tn("selfNonVoid")  inline def nonVoid                 (using inline d:Def.Void[A]) : Boolean   = x!=null && !d.value_isVoid(x.cast[A])

  extension[A](inline x: any._Methods._view[A])
    @tn("nonEmpty_Opt") inline def ? (using inline e:Def.Empty[A],inline d:Def.Void[A]) : Opt[A]    = {var o:Opt[A] = \/; val v=x.cast[A&AnyRef]; if(v!=null && !d.value_isVoid(v) && !e.value_isEmpty(v)) o=v; o}
  extension[A](inline x: any._Methods._view[~[A]]) // ~ has to be treated differently from others
    @tn("nonEmpty_Opt") inline def ?                                                    : Opt[~[A]] = view.nonEmptyStream_Opt(x.cast[~[A]])


object view:

  def nonEmptyStream_Opt[A](s: ~[A]): Opt[~[A]] = s.sizeLong_?.take(_ > 0).map(_ => s) or_? s.enablePreview.^.to(p => p.preview_?.map[~[A]](_ => p))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/