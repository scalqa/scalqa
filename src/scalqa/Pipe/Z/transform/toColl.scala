package scalqa; package Pipe; package Z; package transform

private[Pipe] object toColl extends To[Coll](false, classOf[Coll[_]]) {

  override def apply[A](src: Flow[A], t: Tag[A]): Coll[A] = Val(src, t)

  // ***************************************************************************************
  object Val extends To[Coll.Val](false, classOf[Coll.Val[_]]) {

    override def apply[A](src: Flow[A], t: Tag[A]): Coll.Val[A] = { var cv: Coll.Val[A] = \/; src.synchronize.apply(cv += _); cv }

  }

  // ****************************************************************************************************************
  object W extends To[Coll.W](false, classOf[Coll.W[Any]]) {

    override def apply[A](src: Flow[A], t: Tag[A]): Coll.W[A] = Coll.W.get[A].I(_.addFlow(src))

  }

  // ****************************************************************************************************************
  object WO extends To[Coll.WO](false, classOf[Coll.WO[Any]]) {

    override def apply[A](src: Flow[A], t: Tag[A]): Coll.WO[A] = Coll.WO.get[A].I(_.addFlow(src))

  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/