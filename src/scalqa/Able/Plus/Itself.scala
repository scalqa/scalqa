package scalqa; package Able; package Plus

trait Itself[A] extends Any with Plus[A] {
  protected type TARGET = A

  @inline protected def _plus(v: A) = _plus(_target, v)
  @inline protected def _plusAll(a: ~[A], size: Int) = a.foldAs[A](_target, (b, a) => _plus(b, a))

  protected def _plus(t: A, a: A): A

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Itself -> '''Generic Plus to Itself'''
 */
