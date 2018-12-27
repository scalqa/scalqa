package scalqa; package Pro; package A

class Setup[@specialized(DATA) A](private var value: A) extends Pro[A] with Any.Able.ToInfo {
  private var used = false

  def isUsed = used

  override def apply = { used = true; value }

  def update(v: A) = {
    if (used) App.Fail("Setup property has been used and cannot be updated")
    value = v
  }

  def toInfo = new Pro.Info(this) += (("value", apply))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Setup ->
 *
 *     Special setup property, which if used (applied) cannot be updated anymore
 *
 */
