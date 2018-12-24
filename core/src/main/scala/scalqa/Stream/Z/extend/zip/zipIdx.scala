package scalqa; package Stream; package Z; package extend; package zip

private[Stream] class zipIdx[A](val real: Stream[A], var i: Int) extends Stream[(Int, A)] with A.Extended.Size[(Int, A)] {

  i -= 1

  def prime = real.prime

  def pump = { i += 1; (i, real.pump) }

  def foreach(c: Consumer[(Int, A)]) = {
    class Each extends Consumer[A] {
      var j = i
      def accept(v: A) = { j += 1; c.accept((j, v)) }
    }
    real.foreach(new Each)
  }

  override def ilkOpt = Ilk.Refs

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
