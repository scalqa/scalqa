package scalqa; package lang; package int; package custom; package data; import language.implicitConversions

abstract class Sequential[A<:Opaque.Int](typeName:String) extends Ordered[A](typeName):
  self =>

  extension[A<:RAW](inline x: A)
    @tn("plus")  inline def +(inline i: Int) : A = (x.real + i).cast[A]
    @tn("minus") inline def -(inline i: Int) : A = (x.real - i).cast[A]
    /**/         inline def next             : A = (x.real + 1).cast[A]
    /**/         inline def prior            : A = (x.real - 1).cast[A]

  @fast given givenAbleSequence : Able.Sequence[A] = Able.Sequence.int.cast[Able.Sequence[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Sequential -> ###

@def +       -> Get further in sequance \n\n Returns value, which is given number of position further in sequence
@def -       -> Get before in sequance  \n\n Returns value, which is given number of position before in sequence
@def next    -> Next in sequance  \n\n Returns next value in sequance
@def prior   -> Prior in sequance \n\n Returns prior value in sequance

*/