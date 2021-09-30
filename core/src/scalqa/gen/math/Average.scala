package scalqa; package gen; package math; import language.implicitConversions

trait Average[A]:
  /**/               def average  (s: ~[A]): A
  @tn("average_Opt") def average_?(s: ~[A]): Opt[A]
  /**/               def averageCalculation: Average.Calculation[A]

object Average:

  trait Calculation[A]:
    def add(v: A): Unit
    def average  : A

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Average -> ###

   Given instance of [[Math.Average]] for a particular type, enables this type to participate in calculating average value for streamed instances.

   By default Double, Float and opaque numericals of Double and Float allow averaging.

*/
