package scalqa; package Stream; package Z; package extend; package zip

private[Stream] final class zipNext[A](s: Stream[A]) extends Stream[(A, Opt[A])] with A.Extended[(A, Opt[A])] {
  def real = s.preview

  def prime = real.prime

  def pump = (real.pump, real.previewNextOpt)

  def foreach(c: Consumer[(A, Opt[A])]) = while (prime) c.accept(pump)

  @inline override def sizeOpt = real.sizeOpt

  @inline override def ilkOpt = Ilk.Objects
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
