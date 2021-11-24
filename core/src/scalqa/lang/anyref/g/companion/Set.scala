package scalqa; package lang; package anyref; package g; package companion; import language.implicitConversions

class Set[A]:
  /**/           def apply(v: A *)          : Val.Set[A] = apply(v)
  /**/           def apply(v: Val.Stream[A]): Val.Set[A] = Val.Set.fromStream(v)
  @tn("getVoid") def void                   : Val.Set[A] = Val.Set.void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/