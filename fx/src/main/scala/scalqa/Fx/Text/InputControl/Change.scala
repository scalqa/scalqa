package scalqa; package Fx; package Text.InputControl

import javafx.scene.control.TextFormatter.{ Change => JAVA }

class Change private (val real: JAVA) extends AnyVal with A.Delegate.Data[Change, JAVA] {
  protected def setup = Change

  def text = real.getText; def text_=(s: String) = real.setText(s)

  def isAdd = real.isAdded

  def isReplace = real.isReplaced

  def isDelete = real.isDeleted

  def isAddOrDelete = real.isContentChange

  def textBefore = real.getControlText

  def textAfter = real.getControlNewText

}

object Change extends A.Delegate.Data.Setup[Change, JAVA] {

  def make(f: JAVA) = new Change(f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
