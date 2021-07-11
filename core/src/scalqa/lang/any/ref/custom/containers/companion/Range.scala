package scalqa; package lang; package any; package ref; package custom;  package containers; package companion; import language.implicitConversions

class Range[A]:

  def apply(start: A, end: A, endIsIn: Boolean = true)(using Ordering  [A]) : <>[A] = Val.<>(start, end, endIsIn)

object Range extends Range[AnyRef]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

