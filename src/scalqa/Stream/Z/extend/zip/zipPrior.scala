package scalqa; package Stream; package Z; package extend; package zip

private[Stream] class zipPrior[A](val real: Stream[A]) extends Stream[(Opt[A], A)] with A.Extended.Size[(Opt[A], A)] {
  var o: Opt[A] = \/

  @inline def prime = real.prime

  def pump = { val t = (o, real.pump); o = t._2; t }

  def foreach(c: Consumer[(Opt[A], A)]) = real.foreach(v => { c.accept(o, v); o = v })

  @inline override def ilkOpt = Ilk.Objects
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
