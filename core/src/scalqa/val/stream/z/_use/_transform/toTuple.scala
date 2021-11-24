package scalqa; package `val`; package stream; package z; package _use; package _transform; import language.implicitConversions


object toTuple:
  extension[A](inline x: Stream[A]) private inline def v: A = x.read

  def tuple2 [A](x: Stream[A]): (A,A)                                         = (x.v,x.v)
  def tuple3 [A](x: Stream[A]): (A,A,A)                                       = (x.v,x.v,x.v)
  def tuple4 [A](x: Stream[A]): (A,A,A,A)                                     = (x.v,x.v,x.v,x.v)
  def tuple5 [A](x: Stream[A]): (A,A,A,A,A)                                   = (x.v,x.v,x.v,x.v,x.v)
  def tuple6 [A](x: Stream[A]): (A,A,A,A,A,A)                                 = (x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple7 [A](x: Stream[A]): (A,A,A,A,A,A,A)                               = (x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple8 [A](x: Stream[A]): (A,A,A,A,A,A,A,A)                             = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple9 [A](x: Stream[A]): (A,A,A,A,A,A,A,A,A)                           = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple10[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A)                         = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple11[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A)                       = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple12[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A)                     = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple13[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A,A)                   = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple14[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A,A,A)                 = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple15[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)               = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple16[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)             = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple17[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)           = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple18[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)         = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple19[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)       = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple20[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)     = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple21[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)   = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)
  def tuple22[A](x: Stream[A]): (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A) = (x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v,x.v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
