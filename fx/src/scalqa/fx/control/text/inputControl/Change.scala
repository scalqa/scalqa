package scalqa; package fx; package control; package text; package inputControl; import language.implicitConversions

import javafx.scene.control.TextFormatter.{ Change => JChange }

object Change extends Abstract.Delegate.Opaque[Change, JChange]("Fx.Text.InputControl.Change"):
  //implicit def implicitFromJava(v: JChange) : Change  = apply(v)

  extension (x: Change)
    inline def anchor                 : Int     = x.real.getAnchor
    inline def anchor_=(v: Int)       : Unit    = x.real.setAnchor(v)
    inline def text                   : String  = x.real.getText
    inline def text_=(v: String)      : Unit    = x.real.setText(v)
    inline def textBefore             : String  = x.real.getControlText
    inline def textAfter              : String  = x.real.getControlNewText
    inline def range                  : Int.<>  = x.real.getRangeStart <>> x.real.getRangeEnd
    inline def range_=(v: Int.<>)     : Unit    = x.real.setRange(v.start, v.endX)
    inline def selection              : Int.<>  = {val s = x.real.getSelection; s.getStart <>> s.getEnd}
    inline def selection_=(v: Int.<>) : Unit    = x.real.selectRange(v.start, v.endX)
    inline def caret                  : Int     = x.real.getCaretPosition
    inline def caret_=(v: Int)        : Unit    = x.real.setCaretPosition(v)
    inline def isAdd                  : Boolean = x.real.isAdded
    inline def isReplace              : Boolean = x.real.isReplaced
    inline def isDelete               : Boolean = x.real.isDeleted
    inline def isTextChange           : Boolean = x.real.isContentChange

  object opaque:
    opaque type `type` <: Any.Opaque.Ref = JChange & Any.Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
