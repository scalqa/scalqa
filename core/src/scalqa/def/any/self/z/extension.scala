package scalqa; package `def`; package any; package self; package z; import language.implicitConversions

import Info.Tag. { Void, Empty }

transparent trait extension:

  extension[A](x: Any.Self[A])
    @tn("selfOpt")     inline def ? (using inline e:Empty[A], inline v:Void[A]) : Opt[A]    = if(v.isVoid(x.cast[A]) || e.isEmpty(x.cast[A])) \/ else x.cast[Opt[A]]
    @tn("selfIsVoid")  inline def isVoid              (using inline t: Void[A]) : Boolean   = x==null ||  t.isVoid(x.cast[A])
    @tn("selfNonVoid") inline def nonVoid             (using inline t: Void[A]) : Boolean   = x!=null && !t.isVoid(x.cast[A])

  extension[A](x: Any.Self[~[A]]) // This is override for Stream
    @tn("selfOpt")     inline def ?                                             : Opt[~[A]] = {val p=x.cast[~[A]].enablePreview; p.preview_?.map[~[A]](_ => p) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/