package scalqa; package Fx; package Custom

import javafx.beans.{ Observable, InvalidationListener }

package object AnyO {

  def apply(real: Observable): Any.O = new Any.O {

    def onObservableChange(run: () => Any) = new Util.EventControl.A.Base with InvalidationListener {

      def invalidated(o: Observable) = if (isActive) run()

      onCancel(() => real.removeListener(this))

      real.addListener(this)
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
