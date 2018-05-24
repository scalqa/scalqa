package scalqa; package Coll; package Val; package Z

private[Val] abstract class Base[A] extends Val[A] {

  def head: A

  def tail: Base[A]

  def size: Int

  def all: ~[A] = new all(this)

  def allReversed: ~[A] = new allReversed(this)

  override def +(v: A)(implicit t: Tag[A] = \/): Val[A]

  @inline protected def _plus(v: A, t: Tag[A]) = this + v
  @inline protected def _plusAll(p: ~[A], sz: Int, t: Tag[A]): Val[A] = p.foldAs[Val[A]](this, _ + _)

  protected def _minus(a: A): Val[A] = if (allReversed.contains(a)) all.drop(_ == a).as[Coll.Val] else this
  protected def _minusAll(p: ~[A]): Val[A] = p.foldAs[Val[A]](this, _ - _)
  protected def _target: Val[A] = this

  def tag: Tag[_] = Tag.AnyRef
}

// **********************************************************************************************************************************************
private class allReversed[A](var cur: Base[A]) extends Pipe.The.Base[A] {

  def pumpOpt(f: A => Boolean): Opt[A] = { while (!cur.isVoid) { val v = cur.head; cur = cur.tail; if (f(v)) return v }; \/ }

  override def sizeOpt = cur.size

  override def isMutable = false
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
