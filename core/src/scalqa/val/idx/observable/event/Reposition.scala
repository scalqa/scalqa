package scalqa; package `val`; package idx; package observable; package event; import language.implicitConversions

abstract class Reposition[A] extends Event[A]("Reposition"):
  /**/               def permutation          : Idx.Permutation
  /**/               def range                : Int.<>             = permutation.range
  /**/               def positions            : Int.><             = permutation.positions
  /**/               def convert[B](f: A => B): Reposition[B]      = this.cast[Reposition[B]]
  @tn("project_Opt") def project_?(i: Int.<>) : Opt[Reposition[A]] = i.overlap_?(range).map(v => Reposition.apply[A](Idx.Permutation(v, positions.take_<>(v))))
  override           def doc                  : Doc                = super.doc += ("changes", permutation.pair_~.makeString(""))

object Reposition:
  def apply[A](v: Idx.Permutation)            : Reposition[A] = Z.Reposition[A](v)
  def apply[A](i: Int.<>, positions: Int.><)  : Reposition[A] = apply(Idx.Permutation(i,positions))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
