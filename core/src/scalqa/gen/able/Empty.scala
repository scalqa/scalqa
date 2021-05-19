package scalqa; package gen; package able

trait Empty:
  def isEmpty: Boolean

object Empty:

  extension(inline x: Empty)
    inline def nonEmpty: Boolean = !x.isEmpty


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Empty ->

@def isEmpty -> Empty check

   Returns true if instance is empty.

@def nonEmpty -> Not empty check

   Returns true if instance is not empty.

*/
