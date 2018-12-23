package scalqa; package Fx

package object Popup {

  def make(message: Any, delay: Duration, target: Fx.Window): Popup = {
    val p = message match {
      case p: Popup => p
      case v        => new Popup { children += v.toString }
    }
    p.delay = delay
    p.targetWindowOpt = target
    p
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
