package scalqa; package Stream; package Z; package extend; package map

private[scalqa] object flatMap {

  def primPrim[@specialized(DATA) A, @specialized(DATA) B](s: Stream[A], f: Mapping.Z.PrimRef[A, ~[B]], i: Ilk[B]): Stream[B] = {
    class primPrim extends Stream[B] with A.Extended[B] {
      protected var cp: Stream[B] = \/
      override def prime = cp.prime || { while (!cp.prime && s.prime) cp = f(s.pump); cp.prime }
      @inline final def pump = cp.pump
      override def foreach(c: Consumer[B]) = { cp.foreach(c); s.foreach(new Consumer[A] { def accept(v: A) = f(v).foreach(c) }) }
      override def ilkOpt = i.ilkOpt; def real = s
    }
    new primPrim
  }

  def primRef[@specialized(DATA) A, B](s: Stream[A], f: Mapping.Z.PrimRef[A, ~[B]], i: Ilk[B]): Stream[B] = {
    class primRef extends Stream[B] with A.Extended[B] {
      protected var cp: Stream[B] = \/
      override def prime = cp.prime || { while (!cp.prime && s.prime) cp = f(s.pump); cp.prime }
      @inline final def pump = cp.pump
      override def foreach(c: Consumer[B]) = { cp.foreach(c); s.foreach(new Consumer[A] { def accept(v: A) = f(v).foreach(c) }) }
      override def ilkOpt = i.ilkOpt; def real = s
    }
    new primRef
  }

  def refPrim[A, @specialized(DATA) B](s: Stream[A], f: Mapping[A, ~[B]], i: Ilk[B]): Stream[B] = {
    class refPrim extends Stream[B] with A.Extended[B] {
      protected var cp: Stream[B] = \/
      override def prime = cp.prime || { while (!cp.prime && s.prime) cp = f(s.pump); cp.prime }
      @inline final def pump = cp.pump
      override def foreach(c: Consumer[B]) = { cp.foreach(c); s.foreach(new Consumer[A] { def accept(v: A) = f(v).foreach(c) }) }
      override def ilkOpt = i.ilkOpt; def real = s
    }
    new refPrim
  }

  def refRef[A, B](s: Stream[A], f: Mapping[A, ~[B]], i: Ilk[B]): Stream[B] = {
    class refRef extends Stream[B] with A.Extended[B] {
      protected var cp: Stream[B] = \/
      override def prime = cp.prime || { while (!cp.prime && s.prime) cp = f(s.pump); cp.prime }
      @inline final def pump = cp.pump
      override def foreach(c: Consumer[B]) = { cp.foreach(c); s.foreach(new Consumer[A] { def accept(v: A) = f(v).foreach(c) }) }
      override def ilkOpt = i.ilkOpt; def real = s
    }
    new refRef
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
