package scalqa; package Stream; package Z; package extend; package zip

private[Stream] class zipFoldAs[A, B](val real: Stream[A], var b: B, f: Folding.As[B, A]) extends Stream[(A, B)] with A.Extended.Size[(A, B)] {

  @inline def prime = real.prime

  @inline def pump = { val a = real.pump; b = f(b, a); (a, b) }

  @inline def foreach(c: Consumer[(A, B)]) = {
    class Each extends Consumer[A] {
      var vb = b
      def accept(v: A) = { vb = f(vb, v); c.accept((v, vb)) }
    }
    real.foreach(new Each)
  }

  @inline override def ilkOpt = Ilk.Refs

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
