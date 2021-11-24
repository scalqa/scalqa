package scalqa; package j; package util; package proxy

abstract class Idx[A] extends Collection[A] with Idx.Base[A]:
  override def stream = real.stream

object Idx:

  trait Base[A] extends Val.Idx[A] with Collection.Base[A] with J.Util.Proxy[Val.Idx[A]]:
    override def apply(i: Int) = real.apply(i)
    override def stream        = real.stream // Needed to resolve conflict

  // ******************************************************************************************************
  abstract class M[A] extends Idx[A] with M.Base[A]
  object M:
    trait Base[A] extends Idx.Base[A] with Val.Idx.M[A] with Collection.M.Base[A] with J.Util.Proxy[Val.Idx.M[A]]:
      override def contains(v: A)                   = real.contains(v)
      override def add(v: A): Unit                  = real.add(v)
      override def addAll(v: Stream[A]): Unit       = real.addAll(v)
      override def updateAt(n: Int, a: A)           = real.update(n, a)
      override def updateAllAt(i: Int, s:Stream[A]) = real.updateAllAt(i, s)
      override def addAt(n: Int, e: A)              = real.addAt(n, e)
      override def addAllAt(n: Int, e: Stream[A])   = real.addAllAt(n, e)
      override def removeRange(r: Int.Range)        = real.removeRange(r)
      override def removeAt(i: Int)                 = real.removeAt(i)
      override def clear: Unit                      = real.clear
      override def reposition(v:Val.Idx.Permutation)= real.reposition(v)
      override def sort         (using Ordering[A]) = real.sort

  // ******************************************************************************************************
  abstract class O[A] extends Idx[A] with O.Base[A]
  object O:
    trait Base[A] extends Idx.Base[A] with Val.Idx.O[A] with J.Util.Proxy[Val.Idx.O[A]]:
      override def onChange[U](l: Pack[Val.Idx.O.Event[A]] => U) = real.onChange(l)

  // ******************************************************************************************************
  abstract class OM[A] extends M[A] with OM.Base[A]
  object OM:
    trait Base[A] extends Val.Idx.OM[A] with M.Base[A] with O.Base[A] with J.Util.Proxy[Val.Idx.OM[A]]:
      def refreshRange(i: Int.Range)          = real.refreshRange(i)
      def modify(ch:  Val.Idx.M[A] => Unit) = real.modify(ch)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
