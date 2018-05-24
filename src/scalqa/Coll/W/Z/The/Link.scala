package scalqa; package Coll; package W; package Z; package The

private[Coll] trait Link[A] extends Coll.Z.The.Link[A] /*with W[A] */ {

  def child: Link[A]

  def split(f: A => Boolean): (Link[A], Link[A])

}

private[Coll] object Link extends Able.Void.Companion.Typed[Link](new Link[Nothing] with Void { def child = Fail(); def value = Fail(); override lazy val size = 0; def split(f: Nothing => Boolean) = (this, this) }) {

  def apply[T](_target: T, child: Link[T]): Link[T] = new TheLink[T](_target, child)

  def apply[T](_target: T): Link[T] = new TheLink[T](_target)

}

private[Z] class TheLink[A](val value: A, private var _child: Link[A]) extends Link[A] {
  def this(v: A) = this(v, \/)

  def child = _child

  def split(f: A => Boolean): (Link[A], Link[A]) = child.split(f) apply ((link1, link2) => if (f(value)) { _child = link1; (this, link2) } else { _child = link2; (link1, this) })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
