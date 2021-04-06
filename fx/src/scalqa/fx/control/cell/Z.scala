package scalqa; package fx; package control; package cell; import language.implicitConversions

private object Z:

  object Void extends Setup[control.Cell] with Void:
    @tn("mouseClicked_Setup")  override def mouseClicked_:(f: (Ui.Event.Mouse, control.Cell) => Unit)      = ()
    @tn("contextMenu_Setup")   override def contextMenu_:(f: (Ui.Event.ContextMenu, control.Cell) => Unit) = ()
    @tn("alignment_SetupOpt")  override def alignment_:?(f: control.Cell => Opt[Pos])                   = ()
    @tn("style_SetupOpt")      override def style_:?(f: control.Cell => Opt[Style])                     = ()
    @tn("styleClass_SetupOpt") override def styleClass_:?(f: control.Cell => Opt[Style.Class])          = ()
    /**/                       override def apply(c: control.Cell)                                      = ()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
