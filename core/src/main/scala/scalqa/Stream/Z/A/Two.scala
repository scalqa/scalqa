package scalqa; package Stream; package Z; package A

private[scalqa] object Two {

  def apply[A](one: A, two: A): Stream[A] = new Stream.A.Base[A] {
    protected var state = 0

    def prime = state < 2

    def pump = {
      state += 1
      state match {
        case 1 => one
        case 2 => two
        case _ => Stream.failEmpty
      }
    }

    override def sizeOpt = 2 - state max 0

    override def ilkOpt = one.I.ilk
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
