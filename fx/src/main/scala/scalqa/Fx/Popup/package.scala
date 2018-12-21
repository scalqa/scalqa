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
