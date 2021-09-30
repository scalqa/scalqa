package scalqa; package `val`; package stream; package custom; import language.implicitConversions

trait Ordering[A]:
  self: Math.Ordering[A] =>

  @tn("min_Opt")   def min_?  (s: ~[A]): Opt[A]
  @tn("max_Opt")   def max_?  (s: ~[A]): Opt[A]
  @tn("range_Opt") def range_?(s: ~[A]): Opt[<>[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Math -> ###

   Custom Math implementations can provide more efficient ways for Streams to calculate `min`,`max`, and `range`.

   Apparently primitive based numeral data elements use it a lot

*/
