package scalqa; package lang; package int; package opaque; package data; import language.implicitConversions

abstract class Sequential[A<:Opaque](name: String) extends Ordered[A](name) with Sequential._methods:
  self =>

  @fast given givenAbleSequence: Able.Sequence[A] = Able.Sequence.int.cast[Able.Sequence[A]]

object Sequential:

  transparent trait _methods extends Ordered._methods:
    extension[THIS_OPAQUE <: Opaque](inline x: THIS_OPAQUE)
      @tn("plus")  inline def +(inline i: Int): THIS_OPAQUE = (x.real + i).cast[THIS_OPAQUE]
      @tn("minus") inline def -(inline i: Int): THIS_OPAQUE = (x.real - i).cast[THIS_OPAQUE]
      /**/         inline def next            : THIS_OPAQUE = (x.real + 1).cast[THIS_OPAQUE]
      /**/         inline def prior           : THIS_OPAQUE = (x.real - 1).cast[THIS_OPAQUE]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Sequential -> ###

   See [sample type definition](https://github.com/scalqa/samples/blob/master/src/example/opaque/all/SequentialIntData.scala).

@def +       -> Get further in sequance \n\n Returns value, which is given number of position further in sequence
@def -       -> Get before in sequance  \n\n Returns value, which is given number of position before in sequence
@def next    -> Next in sequance  \n\n Returns next value in sequance
@def prior   -> Prior in sequance \n\n Returns prior value in sequance

@trait _methods -> Default methods for all Int.Opaque.Data.Sequential defined types

*/