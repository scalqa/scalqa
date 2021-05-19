package scalqa; package lang; package any; package self; package z; import language.implicitConversions

import Self.Given. { VoidTag, EmptyTag }

transparent trait extension:

  extension[A](x: Self.View[A])
    @tn("selfOpt")     inline def ? (using inline e:EmptyTag[A], inline v:VoidTag[A]) : Opt[A]    = if(x==null || v.isVoid(x.cast[A]) || e.isEmpty(x.cast[A])) \/ else x.cast[Opt[A]]
    @tn("selfIsVoid")  inline def isVoid                 (using inline t: VoidTag[A]) : Boolean   = x==null ||  t.isVoid(x.cast[A])
    @tn("selfNonVoid") inline def nonVoid                (using inline t: VoidTag[A]) : Boolean   = x!=null && !t.isVoid(x.cast[A])

  extension[A](x: Self.View[~[A]]) // This is override for Stream
    @tn("selfOpt")     inline def ?                                             : Opt[~[A]] = {val p=x.cast[~[A]].enablePreview; p.preview_?.map[~[A]](_ => p) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/