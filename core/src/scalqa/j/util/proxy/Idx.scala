package scalqa; package j; package util; package proxy

abstract class Idx[A] extends Collection[A] with Idx.Basis[A]:
  @tn("stream") override def ~ = real.~

object Idx:

  trait Basis[A] extends Val.Idx[A] with Collection.Basis[A] with J.Util.Proxy[Val.Idx[A]]:
    override def apply(i: Int) = real.apply(i)
    @tn("stream") override def ~ = real.~ // Needed to resolve conflict

  // ******************************************************************************************************
  abstract class M[A] extends Idx[A] with M.Basis[A]
  object M:
    trait Basis[A] extends Idx.Basis[A] with Val.Idx.M[A] with Collection.M.Basis[A] with J.Util.Proxy[Val.Idx.M[A]]:
      /**/                override def contains(v: A)                   = real.contains(v)
      /**/                override def add(v: A): Unit                  = real.add(v)
      /**/                override def addAll(v: ~[A]): Unit            = real.addAll(v)
      /**/                override def updateAt(n: Int, a: A)           = real.update(n, a)
      /**/                override def updateAllAt(i: Int, s: ~[A])     = real.updateAllAt(i, s)
      /**/                override def addAt(n: Int, e: A)              = real.addAt(n, e)
      /**/                override def addAllAt(n: Int, e: ~[A])        = real.addAllAt(n, e)
      @tn("remove_Range") override def remove_<>(r: Int.<>)             = real.remove_<>(r)
      /**/                override def removeAt(i: Int)                 = real.removeAt(i)
      override                     def clear: Unit                      = real.clear
      override                     def reposition(v:Val.Idx.Permutation)= real.reposition(v)
      override                     def sort         (using Ordering[A]) = real.sort

  // ******************************************************************************************************
  abstract class O[A] extends Idx[A] with O.Basis[A]
  object O:
    trait Basis[A] extends Idx.Basis[A] with Val.Idx.O[A] with J.Util.Proxy[Val.Idx.O[A]]:
      override def onChange[U](l: ><[Val.Idx.O.Event[A]] => U) = real.onChange(l)

  // ******************************************************************************************************
  abstract class OM[A] extends M[A] with OM.Basis[A]
  object OM:
    trait Basis[A] extends Val.Idx.OM[A] with M.Basis[A] with O.Basis[A] with J.Util.Proxy[Val.Idx.OM[A]]:
      @tn("refresh_Range") def refresh_<>(i: Int.<>)             = real.refresh_<>(i)
      /**/                 def modify(ch:  Val.Idx.M[A] => Unit) = real.modify(ch)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
