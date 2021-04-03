package scalqa; package `val`; package collection

trait ObservableMutable[A] extends Observable[A] with Mutable[A]

object ObservableMutable:
  inline def apply[A](inline initSize: Int = J.initSize) : ObservableMutable[A] = Idx.OM[A](initSize)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait ObservableMutable -> ### Observable Mutable Collection


*/
