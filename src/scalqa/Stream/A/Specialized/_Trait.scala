package scalqa; package Stream; package A; package Specialized

trait _Trait[@specialized(DATA) A] { self: Stream[A] =>

  def prime: Boolean

  def pump: A

  def foreach(f: Consumer[A])

  // -----------------------------------------------------------------
  def ilkOpt: Opt[Any.Class.Ilk] = Opt.Void

  def sizeOpt: Opt.Int = Opt.Int.Void

  def sortedOpt: Opt[Ordering[A]] = Opt.Void

  def sortedByOpt[B]: Opt[(Ordering[B], A => B)] = Opt.Void

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Stream Definition`
 *
 *
 */
