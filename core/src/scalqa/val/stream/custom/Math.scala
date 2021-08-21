package scalqa; package `val`; package stream; package custom; import language.implicitConversions

trait Math[A] :
  @tn("calculateSum_Opt") def calculateSum_?(s: ~[A]) : Opt[A]
  @tn("min_Opt")          def min_?  (s: ~[A])        : Opt[A]
  @tn("max_Opt")          def max_?  (s: ~[A])        : Opt[A]
  @tn("range_Opt")        def range_?(s: ~[A])        : Opt[<>[A]]

object Math:

  trait Average[A]:
    def average   (s: ~[A]): A
    def averageOpt(s: ~[A]): Opt[A]
    def averageLogic       : Average.Logic[A]

  object Average:

    trait Logic[A]:
      def add(v: A) : Unit
      def result    : A
      def resultOpt : Opt[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Math -> ###

   Custom Math implementations can provide more efficient ways for Streams to calculate `sum`.

   Apparently primitive based numeral data elements use it a lot

@trait Average -> ###

   Given instance of [[Math.Average]] for a particular type, enables this type to participate in calculating average value for streamed instances.

   By default Double, Float and opaque numericals of Double and Float allow averaging.

*/

