package scalqa; package `val`; package idx

object X:

  abstract class Base[A] extends Idx[A] with Able.Contain[A]:
    def contains(v:A) : Boolean = (this:Idx[A]).contains(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extention
*/