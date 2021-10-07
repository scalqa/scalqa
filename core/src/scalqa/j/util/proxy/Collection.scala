package scalqa; package j; package util; package proxy

abstract class Collection[A] extends Collection.Base[A]

object Collection:

  trait Base[A] extends Val.Collection[A] with J.Util.Proxy[Val.Collection[A]]:
    override               def size = real.size
    @tn("stream") override def ~    = real.~

  // *********************************************************************************************************************
  abstract class O[A] extends Collection[A] with O.Base[A]

  object O:
    trait Base[A] extends Collection.Base[A] with Val.Collection.Observable[A] with J.Util.Proxy[Val.Collection.Observable[A]]:
      override def onAdd[U](   l: A => U) = real.onAdd(l)
      override def onRemove[U](l: A => U) = real.onRemove(l)

  // *********************************************************************************************************************
  abstract class M[A] extends Collection[A] with M.Base[A]

  object M:
    trait Base[A] extends Collection.Base[A] with Val.Collection.Mutable[A] with J.Util.Proxy[Val.Collection.Mutable[A]]:
      override def add(v: A)         : Unit    = real.add(v)
      override def addAll(s: ~[A])   : Unit    = real.addAll(s)
      override def remove(v: A)      : Int     = real.remove(v)
      override def removeAll(s: ~[A]): Int     = real.removeAll(s)
      override def clear             : Unit    = real.clear

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
