package scalqa; package `def`; package any; package ref; package custom; package framework; package companion; import language.implicitConversions

class Buffer[A]:

  def apply(initSize: Int = J.initSize): Val.Buffer[A] = Val.Buffer(initSize)

private[scalqa] object Buffer extends Buffer[AnyRef]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
