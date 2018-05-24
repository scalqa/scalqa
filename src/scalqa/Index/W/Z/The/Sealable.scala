package scalqa; package Index; package W; package Z; package The

import scala.collection.mutable.{ Buffer, ArrayBuffer }

private[Index] class Sealable[A](list: W[A]) extends Index.W.The.Proxy.Like[A] with Able.Seal {
  def this(initSize: Opt[Int] = \/)(implicit ct: Tag[A]) = this(W.getInit[A](initSize))

  override def size = list.size

  override def apply(i: Int) = list(i)

  override def all = list.all

  protected def real = { _failIfSealed; list }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/