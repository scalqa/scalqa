package scalqa; package Stream; package Z; package extend; package filter

private[scalqa] object letMap {

  def primPrim[@specialized(DATA) A, @specialized(DATA) B](s: Stream[A], f: Mapping.Z.PrimRef[A, Opt[B]], i: Ilk[B]): Stream[B] = {
    class primPrim extends Stream[B] with A.Extended[B] {
      protected var o: Opt[B] = Opt.Void
      def prime = o || { while (!o && s.prime) o = f(s.pump); o }
      def pump = { val v = o.value; o = Opt.Void; v }
      def foreach(c: Consumer[B]) = real.foreach(new Consumer[A] { def accept(v: A) = f(v).apply(c.accept) })
      override def ilkOpt = i.ilkOpt; @inline final def real = s
    }
    new primPrim
  }
  def primRef[@specialized(DATA) A, B](s: Stream[A], f: Mapping.Z.PrimRef[A, Opt[B]], i: Ilk[B]): Stream[B] = {
    class primRef extends Stream[B] with A.Extended[B] {
      protected var o: Opt[B] = Opt.Void
      def prime = o || { while (!o && s.prime) o = f(s.pump); o }
      def pump = { val v = o.value; o = Opt.Void; v }
      def foreach(c: Consumer[B]) = real.foreach(new Consumer[A] { def accept(v: A) = f(v).apply(c.accept) })
      override def ilkOpt = i.ilkOpt; @inline final def real = s
    }
    new primRef
  }
  def refPrim[A, @specialized(DATA) B](s: Stream[A], f: Mapping[A, Opt[B]], i: Ilk[B]): Stream[B] = {
    class refPrim extends Stream[B] with A.Extended[B] {
      protected var o: Opt[B] = Opt.Void
      def prime = o || { while (!o && s.prime) o = f(s.pump); o }
      def pump = { val v = o.value; o = Opt.Void; v }
      def foreach(c: Consumer[B]) = real.foreach(new Consumer[A] { def accept(v: A) = f(v).apply(c.accept) })
      override def ilkOpt = i.ilkOpt; @inline final def real = s
    }
    new refPrim
  }
  def refRef[A, B](s: Stream[A], f: Mapping[A, Opt[B]], i: Ilk[B]): Stream[B] = {
    class refRef extends Stream[B] with A.Extended[B] {
      protected var o: Opt[B] = Opt.Void
      def prime = o || { while (!o && s.prime) o = f(s.pump); o }
      def pump = { val v = o.value; o = Opt.Void; v }
      def foreach(c: Consumer[B]) = real.foreach(new Consumer[A] { def accept(v: A) = f(v).apply(c.accept) })
      override def ilkOpt = i.ilkOpt; @inline final def real = s
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
