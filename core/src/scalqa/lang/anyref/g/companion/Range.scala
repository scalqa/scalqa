package scalqa; package lang; package anyref; package g; package companion; import language.implicitConversions

class Range[A]:

  def apply(start: A, end: A, endIsIn: Boolean = true)(using Ordering[A]): Val.Range[A] = Val.Range(start, end, endIsIn)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

