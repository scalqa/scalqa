package scalqa; package Index; package O; package Z; package The

private[scalqa] trait Unsupported[A] extends Index.O[A] {

  def onChange(on: Coll[Change[A]] => Any): Concurrent.Control = \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/