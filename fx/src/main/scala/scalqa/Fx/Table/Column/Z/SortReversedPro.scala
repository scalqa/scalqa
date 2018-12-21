package scalqa; package Fx; package Table; package Column; package Z

import javafx.scene.control.TableColumn.SortType
import SortType._

private[Table] class SortReversedPro(fxp: javafx.beans.property.ObjectProperty[SortType]) extends Pro.OM.A.Basic[Util.Trilean](false) {
  private var ok = true

  override def apply = { val v = super.apply; if (v.isVoid || v.toBoolean == (fxp.get == DESCENDING)) v else { ok = false; this.update(v.!); ok = true; apply } }

  this.onValueChange(v => if (ok && !v.isVoid && v.toBoolean == (fxp.get != DESCENDING)) fxp.set(if (v.toBoolean) ASCENDING else DESCENDING))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
