package scalqa; package Stream; package Z; package extend; package zip

private[Stream] class zipMap[A, B](val real: Stream[A], f: Mapping[A, B]) extends Stream[(A, B)] with A.Extended.Size[(A, B)] {

  @inline def prime = real.prime

  @inline def pump = { val v = real.pump; (v, f(v)) }

  @inline def foreach(c: Consumer[(A, B)]) = real.foreach(v => c.accept((v, f(v))))

  @inline override def ilkOpt = Ilk.Objects

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
