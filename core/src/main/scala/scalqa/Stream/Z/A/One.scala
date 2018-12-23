package scalqa; package Stream; package Z; package A

private[scalqa] object One {

  def apply[A](v: A): Stream[A] = new Stream.A.Base[A] {
    protected var hot = true

    @inline final def prime = hot

    def pump = { hot = false; v }

    override def sizeOpt = if (hot) 1 else 0

    override def ilkOpt = v.I.ilk
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
