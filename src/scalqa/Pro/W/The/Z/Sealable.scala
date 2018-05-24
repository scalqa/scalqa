package scalqa; package Pro; package W; package The; package Z

class Sealable[A](v: A) extends The[A](v) with Able.Seal {

  override def update(v: A) = { _failIfSealed; super.update(v) }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
