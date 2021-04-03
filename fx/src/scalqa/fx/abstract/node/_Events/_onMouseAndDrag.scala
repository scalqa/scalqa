package scalqa; package fx; package `abstract`; package node; package _Events; import language.implicitConversions

transparent trait _onMouseAndDrag:
  self: Node =>

  def onMouseClicked     [U](l: Event.Mouse => U)      : Event.Control   = onMouse(l, real.onMouseClickedProperty)
  def onMouseLeftClicked [U](l: Event.Mouse => U)      : Event.Control   = onMouseClicked(e => if (e.button.isLeft) l(e))
  def onMouseRightClicked[U](l: Event.Mouse => U)      : Event.Control   = onMouseClicked(e => if (e.button.isRight) l(e))
  def onMouseEntered     [U](l: Event.Mouse => U)      : Event.Control   = onMouse(l, real.onMouseEnteredProperty)
  def onMouseExited      [U](l: Event.Mouse => U)      : Event.Control   = onMouse(l, real.onMouseExitedProperty)
  def onMouseMoved       [U](l: Event.Mouse => U)      : Event.Control   = onMouse(l, real.onMouseMovedProperty)
  def onMousePressed     [U](l: Event.Mouse => U)      : Event.Control   = onMouse(l, real.onMousePressedProperty)
  def onMouseReleased    [U](l: Event.Mouse => U)      : Event.Control   = onMouse(l, real.onMouseReleasedProperty)
  def onMouseDragged     [U](l: Event.Mouse => U)      : Event.Control   = onMouse(l, real.onMouseDraggedProperty)

  def onMouseDragEntered [U](l: Event.MouseDrag => U)  : Event.Control   = onMouseDrag(l, real.onMouseDragEnteredProperty)
  def onMouseDragExited  [U](l: Event.MouseDrag => U)  : Event.Control   = onMouseDrag(l, real.onMouseDragExitedProperty)
  def onMouseDragOver    [U](l: Event.MouseDrag => U)  : Event.Control   = onMouseDrag(l, real.onMouseDragOverProperty)
  def onMouseDragReleased[U](l: Event.MouseDrag => U)  : Event.Control   = onMouseDrag(l, real.onMouseDragReleasedProperty)

  def onDragDetected     [U](l: Event.Mouse => U)      : Event.Control   = onMouse(l, real.onDragDetectedProperty)
  def onDragDone         [U](l: Event.Drag  => U)      : Event.Control   = onDrag(l, real.onDragDoneProperty)
  def onDragDropped      [U](l: Event.Drag  => U)      : Event.Control   = onDrag(l, real.onDragDroppedProperty)
  def onDragEntered      [U](l: Event.Drag  => U)      : Event.Control   = onDrag(l, real.onDragEnteredProperty)
  def onDragExited       [U](l: Event.Drag  => U)      : Event.Control   = onDrag(l, real.onDragExitedProperty)
  def onDragOver         [U](l: Event.Drag  => U)      : Event.Control   = onDrag(l, real.onDragOverProperty)

  // ------------------------------------------------------------------------------------------------
  import javafx.scene.input.{ MouseEvent => MOUSE, DragEvent => DRAG, MouseDragEvent => MOUSE_DRAG }

  private def onMouse[U](l: Event.Mouse => U, op: ObjectProperty[EventHandler[_ >: MOUSE]]) =
    _onFxEvent[MOUSE, Event.Mouse, U](op.cast[ObjectProperty[EventHandler[MOUSE]]], new Event.Mouse(_, this), l)

  private def onMouseDrag[U](l: Event.MouseDrag => U, op: ObjectProperty[EventHandler[_ >: MOUSE_DRAG]]) =
    _onFxEvent[MOUSE_DRAG, Event.MouseDrag, U](op.cast[ObjectProperty[EventHandler[MOUSE_DRAG]]], new Event.MouseDrag(_, this), l)

  private def onDrag[U](l: Event.Drag => U, op: ObjectProperty[EventHandler[_ >: DRAG]]) =
    _onFxEvent[DRAG, Event.Drag, U](op.cast[ObjectProperty[EventHandler[DRAG]]], new Event.Drag(_, this), l)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**


@def onMouseClicked -> On mouse clicked

       Defines a function to be called when a mouse button has been clicked (pressed and released) on this Node


@def onMouseLeftClicked ->  Mouse left clicked

       Defines a function to be called when a mouse left button has been clicked (pressed and released) on this Node


@def onMouseRightClicked -> On mouse right clicked

        Defines a function to be called when a mouse right button has been clicked (pressed and released) on this Node


@def onMouseEntered -> On mouse entered

       Defines a function to be called when the mouse enters this Node


@def onMouseExited -> On mouse exited

       Defines a function to be called when the mouse exits this Node


@def onMouseMoved -> On mouse moved

       Defines a function to be called when mouse cursor moves within this Node but no buttons have been pushed


@def onMousePressed -> On mouse pressed

      Defines a function to be called when a mouse button has been pressed on this Node


@def onMouseReleased -> On mouse released

      Defines a function to be called when a mouse button has been released on this Node


@def onMouseDragged ->  Mouse dragged

       Defines a function to be called when a mouse button is pressed on this Node and then dragged


@def onMouseDragEntered -> On mouse drag entered

       Defines a function to be called when a full press-drag-release gesture enters this Node


@def onMouseDragExited -> On mouse drag exited

       Defines a function to be called when a full press-drag-release gesture leaves this Node


@def onMouseDragOver -> On mouse drag over

      Defines a function to be called when a full press-drag-release gesture progresses within this Node


@def onMouseDragReleased -> On mouse drag released

      Defines a function to be called when a full press-drag-release gesture ends (by releasing mouse button) within this Node

   // ------------------------------------------------------------------------------------------------

@def onDragDetected -> On drag detected

       Defines a function to be called when drag gesture has been detected. This is the right place to start drag and drop operation


@def onDragDone -> On drag done

       Defines a function to be called when this Node is a drag and drop gesture source after its data has been dropped on a drop target

       The transferMode of the event shows what just happened at the drop target.

       If transferMode has the value MOVE, then the source can clear out its data

       Clearing the source's data gives the appropriate appearance to a user that the data has been moved by the drag and drop gesture

       A transferMode that has the value NONE indicates that no data was transferred during the drag and drop gesture


@def onDragDropped -> On drag dropped

      Defines a function to be called when the mouse button is released on this Node during drag and drop gesture.

      Transfer of data from the DragEvent's dragboard should happen in this function


@def onDragEntered -> On drag entered

      Defines a function to be called when drag gesture enters this Node


@def onDragExited -> On drag exited

       Defines a function to be called when drag gesture exits this Node


@def onDragOver -> On drag over

       Defines a function to be called when drag gesture progresses within this Node

*/
