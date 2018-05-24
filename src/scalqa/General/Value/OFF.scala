package scalqa; package General; package Value

object OFF extends Value {

  implicit def zzBoolean(n: OFF.type) = false

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object OFF -> '''General Request OFF'''
 *
 *   See [[General.Value]] for usage
 *
 *   Note: [[OFF]] is implicitly converted to ''false''
 *
 */
