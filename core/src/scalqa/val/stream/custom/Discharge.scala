package scalqa; package `val`; package stream; package custom; import language.implicitConversions

trait Discharge[A]:
  self: Stream[A] =>

  def dischargeTo(v: Buffer[A]): Unit

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
@trait Discharge -> ###

   Stream inmplementations can define custom, more efficient ways to export their elements into a Buffer.

   This feature is heavily used in Array and primitive based streams

*/