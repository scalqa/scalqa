package scalqa; package fx; package control; package cell; import language.implicitConversions

private object Z:

  object Void extends Setup[control.Cell] with Gen.Void:
    override def useMouseClicked (f: (Fx.Event.Mouse, control.Cell) => Unit)       = ()
    override def useContextMenu  (f: (Fx.Event.ContextMenu, control.Cell) => Unit) = ()
    override def useAlignmentOpt (f: control.Cell => Opt[Pos])                     = ()
    override def useStyleOpt     (f: control.Cell => Opt[Style])                   = ()
    override def useStyleClassOpt(f: control.Cell => Opt[Style.Class])             = ()
    override def apply(c: control.Cell)                                            = ()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
