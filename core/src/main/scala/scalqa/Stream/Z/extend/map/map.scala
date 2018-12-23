package scalqa; package Stream; package Z; package extend; package map

private[scalqa] object map {

  def primPrim[@specialized(DATA) A, @specialized(DATA) B](s: Stream[A], f: Mapping[A, B], t: Ilk[B]): Stream[B] = {
    class primPrim extends Stream[B] with A.Extended.Size[B] {
      @inline final def prime = s.prime
      @inline final def pump = f(s.pump)
      @inline final def foreach(c: Consumer[B]) = s.foreach(new Consumer[A] { def accept(v: A) = c.accept(f(v)) })
      override def ilkOpt = t.ilkOpt; def real = s
    }
    new primPrim
  }

  def primRef[@specialized(DATA) A, B](s: Stream[A], f: Mapping.Z.PrimRef[A, B], t: Ilk[B]): Stream[B] = {
    class primRef extends Stream[B] with A.Extended.Size[B] {
      @inline final def prime = s.prime
      @inline final def pump = f(s.pump)
      @inline final def foreach(c: Consumer[B]) = s.foreach(new Consumer[A] { def accept(v: A) = c.accept(f(v)) })
      override def ilkOpt = t.ilkOpt; def real = s
    }
    new primRef
  }

  def refPrim[A, @specialized(DATA) B](s: Stream[A], f: Mapping.Z.RefPrim[A, B], t: Ilk[B]): Stream[B] = {
    class refPrim extends Stream[B] with A.Extended.Size[B] {
      @inline final def prime = s.prime
      @inline final def pump = f(s.pump)
      @inline final def foreach(c: Consumer[B]) = s.foreach(new Consumer[A] { def accept(v: A) = c.accept(f(v)) })
      override def ilkOpt = t.ilkOpt; def real = s
    }
    new refPrim
  }

  def refRef[A, B](s: Stream[A], f: Mapping[A, B], t: Ilk[B]): Stream[B] = {
    class refRef extends Stream[B] with A.Extended.Size[B] {
      @inline final def prime = s.prime
      @inline final def pump = f(s.pump)
      @inline final def foreach(c: Consumer[B]) = s.foreach(new Consumer[A] { def accept(v: A) = c.accept(f(v)) })
      override def ilkOpt = t.ilkOpt; def real = s
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
