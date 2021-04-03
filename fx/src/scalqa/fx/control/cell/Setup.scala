package scalqa; package fx; package control; package cell; import language.implicitConversions

trait Setup[CELL <: control.Cell] extends Able.Info:
  private                    var updateJobs                                           : ><[CELL => Unit]                      = \/
  private                    var clickJobs                                            : ><[(Event.Mouse, CELL) => Unit]       = \/
  private                    var menuJobs                                             : ><[(Event.ContextMenu, CELL) => Unit] = \/

  @tn("cell_Setup")          def cell_:        (f: CELL => Unit)                      : Unit        = updateJobs += f
  @tn("mouseClicked_Setup")  def mouseClicked_:(f: (Event.Mouse, CELL) => Unit)       : Unit        = clickJobs += f
  @tn("contextMenu_Setup")   def contextMenu_: (f: (Event.ContextMenu, CELL) => Unit) : Unit        = menuJobs  += f
  @tn("alignment_SetupOpt")  def alignment_:?  (f: CELL => Opt[Pos])                  : Unit        = cell_:(c => f(c).forval(c.alignment= _))
  @tn("style_SetupOpt")      def style_:?      (f: CELL => Opt[Style])                : Unit        = cell_:(c => f(c).forval(c.style += _))
  @tn("styleClass_SetupOpt") def styleClass_:? (f: CELL => Opt[Style.Class])          : Unit        = cell_:(c => f(c).forval(c.styleClass= _))

  /**/                       def alignment                                            : Pos         = J.unsupportedOperation()
  /**/                       def style                                                : Style       = J.unsupportedOperation()
  /**/                       def styleClass                                           : Style.Class = J.unsupportedOperation()
  /**/                       def alignment_=(s: Pos)                                  : Unit        = alignment_:?(_ => s)
  /**/                       def style_=(s: Style)                                    : Unit        = style_:?(_ => s)
  /**/                       def styleClass_=(s: Style.Class)                         : Unit        = styleClass_:?(_ => s)

  def apply(c: CELL): Unit =
    if (updateJobs.size > 0) updateJobs.~.foreach(_(c))
    val cs = c.currentSetup
    if (cs != this)
      if (cs != null)
        if (cs.clickJobs.size > 0) c.onMouseClicked(Event.Id.cancel1(cs.clickJobs))
        if (cs.menuJobs.size  > 0) c.onContextMenu(Event.Id.cancel1(cs.menuJobs))
      c.currentSetup = this
      if (clickJobs.size > 0) c.onMouseClicked(Event.Id.make1(clickJobs, e => clickJobs.~.foreach(_(e, c))))
      if (menuJobs.size  > 0) c.onContextMenu( Event.Id.make1(menuJobs,  e => menuJobs.~.foreach(_(e, c))))

  def info = Info(this) += ("updateJobs", updateJobs.size) ++= clickJobs.size.?.take(_ > 0).map(_.tag).map(("MouseClickedJobs", _)).~ ++= menuJobs.size.?.take(_ > 0).map(_.tag).map(("contextMenuJobs", _)).~

object Setup:
  implicit def xxRequest[CELL <: control.Cell](v: \/) : Setup[CELL] = Z.Void.cast[Setup[CELL]]

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

@def alignment_:? -> Alignment optional setup

      Function providing optional alignment based on current cell state

@def style_:? -> Style optional setup

      Function providing optional style based on current cell state

@def styleClass_:? -> StyleClass optional setup

      Function providing optional style class based on current cell state


*/