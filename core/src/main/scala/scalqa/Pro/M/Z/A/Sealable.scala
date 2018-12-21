package scalqa; package Pro; package M; package Z; package A

private[Pro] class Sealable[A](v: A) extends M.A.Basic[A](v) with Any.Able.Seal {

  override def update(v: A) = { _failIfSealed; super.update(v) }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
