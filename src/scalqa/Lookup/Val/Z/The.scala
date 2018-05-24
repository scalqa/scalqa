package scalqa; package Lookup; package Val; package Z

import scala.collection.immutable.{ Map => ScalaMap }

private[Val] class The[A, B](base: ScalaMap[A, B]) extends Val[A, B] {

  def size = base.size

  def allPairs: ~[(A, B)] = base.iterator

  def opt(key: A): Opt[B] = base.get(key)

  override def isVoid = base == ScalaVoid

  protected def _plus(v: (A, B)) = new The(base + v)
  protected def _plusAll(p: ~[(A, B)], sz: Int): The[A, B] = p.nonEmptyOpt.map(a => new The(base ++ a.as[Iterator])) or this

  protected def _minus(v: A) = new The(base - v)
  protected def _minusAll(a: ~[A]) = a.foldAs[Val[A, B]](this, _ - _)

  def asScalaMap: ScalaMap[A, B] = base

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/