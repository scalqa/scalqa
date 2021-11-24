package scalqa; package `val`; package idx; package observable; package event; import language.implicitConversions

abstract class Reposition[A] extends Event[A]("Reposition"):
  def permutation             : Idx.Permutation
  def range                   : Int.Range          = permutation.range
  def positions               : Int.Pack           = permutation.positions
  def convert[B](f: A => B)   : Reposition[B]      = this.cast[Reposition[B]]
  def projectOpt(i: Int.Range): Opt[Reposition[A]] = i.overlapOpt(range).map(v => Reposition.apply[A](Idx.Permutation(v, positions.takeRange(v))))
  override def doc            : Doc                = super.doc += ("changes", permutation.pairStream.makeString(""))

object Reposition:
  def apply[A](v: Idx.Permutation)               : Reposition[A] = Z.Reposition[A](v)
  def apply[A](i: Int.Range, positions: Int.Pack): Reposition[A] = apply(Idx.Permutation(i,positions))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
