package scalqa; package fx; package control; package cell; import language.implicitConversions

trait Setup[CELL <: control.Cell] extends Able.Doc:
  private var setupJobs                                       : Pack[CELL => Unit]                         = \/
  private var clickJobs                                       : Pack[(Fx.Event.Mouse, CELL) => Unit]       = \/
  private var menuJobs                                        : Pack[(Fx.Event.ContextMenu, CELL) => Unit] = \/

  def useCellSetup    (f: CELL => Unit)                       : Unit        = setupJobs += f
  def useMouseClicked (f: (Fx.Event.Mouse, CELL) => Unit)     : Unit        = clickJobs += f
  def useContextMenu  (f: (Fx.Event.ContextMenu,CELL) => Unit): Unit        = menuJobs  += f
  def useAlignment    (f: CELL => Pos)                        : Unit        = useCellSetup(c => c.alignment = f(c))
  def useAlignmentOpt (f: CELL => Opt[Pos])                   : Unit        = useCellSetup(c => f(c).forval(c.alignment= _))
  def useStyle        (f: CELL => Style)                      : Unit        = useCellSetup(c => c.style += f(c))
  def useStyleOpt     (f: CELL => Opt[Style])                 : Unit        = useCellSetup(c => f(c).forval(c.style += _))
  def useStyleClass   (f: CELL => Style.Class)                : Unit        = useCellSetup(c => c.styleClass = f(c))
  def useStyleClassOpt(f: CELL => Opt[Style.Class])           : Unit        = useCellSetup(c => f(c).forval(c.styleClass= _))

  def alignment                                               : Pos         = J.unsupportedOperation()
  def style                                                   : Style       = J.unsupportedOperation()
  def styleClass                                              : Style.Class = J.unsupportedOperation()
  def alignment_=(s: Pos)                                     : Unit        = useAlignment(_ => s)
  def style_=(s: Style)                                       : Unit        = useStyle(_ => s)
  def styleClass_=(s: Style.Class)                            : Unit        = useStyleClass(_ => s)

  def apply(c: CELL): Unit =
    setupJobs.foreach(_(c))
    val cs = c.currentSetup
    if (cs != this)
      if (cs != null)
        if (cs.clickJobs.size > 0) c.onMouseClicked(Event.Id.cancel1(cs.clickJobs))
        if (cs.menuJobs.size  > 0) c.useContextMenu(Event.Id.cancel1(cs.menuJobs))
      c.currentSetup = this
      if (clickJobs.size > 0) c.onMouseClicked(Event.Id.make1(clickJobs, e => clickJobs.stream.foreach(_(e, c))))
      if (menuJobs.size  > 0) c.useContextMenu(Event.Id.make1(menuJobs,  e => menuJobs.stream.foreach(_(e, c))))

  def doc = Doc(this) += ("setupJobs", setupJobs.size) ++= clickJobs.??.map(_.tag).map(("MouseClickedJobs", _)) ++= menuJobs.??.map(_.tag).map(("contextMenuJobs", _))

object Setup:
  implicit def implicitFrom[CELL <: control.Cell](v: \/) : Setup[CELL] = Z.Void.cast[Setup[CELL]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def alignment  -> Unsupported operation \n\n Value cannot be read. Method is needed for the 'set' operation work correctly
@def style      -> Unsupported operation \n\n Value cannot be read. Method is needed for the 'set' operation work correctly
@def styleClass -> Unsupported operation \n\n Value cannot be read. Method is needed for the 'set' operation work correctly

@def alignment_= -> Set alignment

      Specific alignment set to the cell before rendering

@def style_= -> Set style

      Specific style set to the cell before rendering

@def styleClass_= -> Set styleClass

      Specific styleClass set to the cell before rendering

@def useAlignmentOpt -> Alignment optional setup

      Function providing optional alignment based on current cell state

@def useStyleOpt -> Style optional setup

      Function providing optional style based on current cell state

@def useStyleClassOpt -> StyleClass optional setup

      Function providing optional style class based on current cell state


*/