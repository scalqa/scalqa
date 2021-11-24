package scalqa; package `val`; package stream; package custom; import language.implicitConversions

trait Ordering[A]:
  self: Math.Ordering[A] =>

  def minOpt  (s: Stream[A]): Opt[A]
  def maxOpt  (s: Stream[A]): Opt[A]
  def rangeOpt(s: Stream[A]): Opt[Range[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Ordering -> ###

   This trait can be mixed with existing Ordering inplementations to provide more efficient ways for Streams to calculate `min`,`max`, and `range`.

   Apparently primitive based numeral data elements use it a lot

*/
