package scalqa; package Util; package EventControl; package Z

private[scalqa] class Cancel[A, B, C, D](val id: Any) extends WithId with (() => Any) with ((Any) => Any) with ((A, B) => Any) with ((A, B, C) => Any) with ((A, B, C, D) => Any) {

  override def isCancel = true

  override def curried = error

  override def tupled = error

  def apply = error
  def apply(a: Any) = error
  def apply(a: A, b: B) = error
  def apply(a: A, b: B, c: C) = error
  def apply(a: A, b: B, c: C, d: D) = error

  private def error = App.Fail.state(
    "The remove request was done on real event. \n" +
      "Check the $anonfun few lines down.  \n" +
      "The wrapping was done without movid id to the new function.  \n" +
      "EventControl.Id.moveId must be used when wrapping events")
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
