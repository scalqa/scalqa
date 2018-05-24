package scalqa; package Pipe; package Z; package transform

private[Pipe] class toIndex[A](src: Flow[A]) extends Buffer[A] { src.synchronize.apply(add) }

private[Pipe] object toIndex extends To[Index](false, classOf[Index[Any]]) {

  override def apply[A](src: Flow[A], t: Tag[A]): Index[A] = src match {
    case a: Pipe[_] => toArray(a.cast[~[A]], t)
    case l          => new toIndex(l)
  }

  // ****************************************************************************************************************
  object Val extends To[Index.Val](false, classOf[Index.Val[Any]]) {

    override def apply[A](src: Flow[A], t: Tag[A]): Index.Val[A] = src match {
      case a: Pipe[_] => (\/ : Index.Val[A]).+~(a.cast[~[A]])(t)
      case l          => apply(l.to(To.Index, t).all, t)
    }
  }

  // ****************************************************************************************************************
  object W extends To[Index.W](false, classOf[Index.W[Any]]) {

    override def apply[A](src: Flow[A], t: Tag[A]): Index.W[A] = new Index.W.The[A](src.sizeOpt or App.Pro.DefaultBufferSize())(t).I(_.addFlow(src))

  }

  // ****************************************************************************************************************
  object WO extends To[Index.WO](false, classOf[Index.WO[Any]]) {

    override def apply[A](src: Flow[A], t: Tag[A]): Index.WO[A] = new Index.WO.The[A](src.sizeOpt or App.Pro.DefaultBufferSize())(t).I(_.addFlow(src))

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
