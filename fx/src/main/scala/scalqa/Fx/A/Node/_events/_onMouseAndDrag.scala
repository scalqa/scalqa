package scalqa; package Fx; package A; package Node; package _events

trait _onMouseAndDrag { self: Node =>

  def onMouseClicked(on: Event.Mouse => Any) = onMouse(on, real.onMouseClickedProperty)
  def onMouseLeftClicked(on: Event.Mouse => Any) = onMouseClicked(e => if (e.button.isLeft) on(e))
  def onMouseRightClicked(on: Event.Mouse => Any) = onMouseClicked(e => if (e.button.isRight) on(e))
  def onMouseEntered(on: Event.Mouse => Any) = onMouse(on, real.onMouseEnteredProperty)
  def onMouseExited(on: Event.Mouse => Any) = onMouse(on, real.onMouseExitedProperty)
  def onMouseMoved(on: Event.Mouse => Any) = onMouse(on, real.onMouseMovedProperty)
  def onMousePressed(on: Event.Mouse => Any) = onMouse(on, real.onMousePressedProperty)
  def onMouseReleased(on: Event.Mouse => Any) = onMouse(on, real.onMouseReleasedProperty)
  def onMouseDragged(on: Event.Mouse => Any) = onMouse(on, real.onMouseDraggedProperty)

  // ------------------------------------------------------------------------------------------------
  def onMouseDragEntered(on: Event.MouseDrag => Any) = onMouseDrag(on, real.onMouseDragEnteredProperty)
  def onMouseDragExited(on: Event.MouseDrag => Any) = onMouseDrag(on, real.onMouseDragExitedProperty)
  def onMouseDragOver(on: Event.MouseDrag => Any) = onMouseDrag(on, real.onMouseDragOverProperty)
  def onMouseDragReleased(on: Event.MouseDrag => Any) = onMouseDrag(on, real.onMouseDragReleasedProperty)

  // ------------------------------------------------------------------------------------------------
  def onDragDetected(on: Event.Mouse => Any) = onMouse(on, real.onDragDetectedProperty)
  def onDragDone(on: Event.Drag => Any) = onDrag(on, real.onDragDoneProperty)
  def onDragDropped(on: Event.Drag => Any) = onDrag(on, real.onDragDroppedProperty)
  def onDragEntered(on: Event.Drag => Any) = onDrag(on, real.onDragEnteredProperty)
  def onDragExited(on: Event.Drag => Any) = onDrag(on, real.onDragExitedProperty)
  def onDragOver(on: Event.Drag => Any) = onDrag(on, real.onDragOverProperty)

  // ------------------------------------------------------------------------------------------------
  private def onMouse(on: Event.Mouse => Any, op: ObjectProperty[EventHandler[_ >: javafx.scene.input.MouseEvent]]) =
    _onFxEvent[javafx.scene.input.MouseEvent, Event.Mouse](op.I.asInstanceOfTarget, e => new Event.Mouse(e, this), on)

  private def onMouseDrag(on: Event.MouseDrag => Any, op: ObjectProperty[EventHandler[_ >: javafx.scene.input.MouseDragEvent]]) =
    _onFxEvent[javafx.scene.input.MouseDragEvent, Event.MouseDrag](op.I.asInstanceOfTarget, e => new Event.MouseDrag(e, this), on)

  private def onDrag(on: Event.Drag => Any, op: ObjectProperty[EventHandler[_ >: javafx.scene.input.DragEvent]]) =
    _onFxEvent[javafx.scene.input.DragEvent, Event.Drag](op.I.asInstanceOfTarget, e => new Event.Drag(e, this), on)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def onMouseClicked -> On mouse clicked
 *
 *     Defines a function to be called when a mouse button has been clicked (pressed and released) on this Node
 *
 * @def onMouseLeftClicked ->  Mouse left clicked
 *
 *     Defines a function to be called when a mouse left button has been clicked (pressed and released) on this Node
 *
 * @def onMouseRightClicked -> On mouse right clicked
 *
 *      Defines a function to be called when a mouse right button has been clicked (pressed and released) on this Node
 *
 * @def onMouseEntered -> On mouse entered
 *
 *     Defines a function to be called when the mouse enters this Node
 *
 * @def onMouseExited -> On mouse exited
 *
 *     Defines a function to be called when the mouse exits this Node
 *
 * @def onMouseMoved -> On mouse moved
 *
 *     Defines a function to be called when mouse cursor moves within this Node but no buttons have been pushed
 *
 * @def onMousePressed -> On mouse pressed
 *
 *    Defines a function to be called when a mouse button has been pressed on this Node
 *
 * @def onMouseReleased -> On mouse released
 *
 *    Defines a function to be called when a mouse button has been released on this Node
 *
 * @def onMouseDragged ->  Mouse dragged
 *
 *     Defines a function to be called when a mouse button is pressed on this Node and then dragged
 *
 * @def onMouseDragEntered -> On mouse drag entered
 *
 *     Defines a function to be called when a full press-drag-release gesture enters this Node
 *
 * @def onMouseDragExited -> On mouse drag exited
 *
 *     Defines a function to be called when a full press-drag-release gesture leaves this Node
 *
 * @def onMouseDragOver -> On mouse drag over
 *
 *    Defines a function to be called when a full press-drag-release gesture progresses within this Node
 *
 * @def onMouseDragReleased -> On mouse drag released
 *
 *    Defines a function to be called when a full press-drag-release gesture ends (by releasing mouse button) within this Node
 *
 * // ------------------------------------------------------------------------------------------------
 * @def onDragDetected -> On drag detected
 *
 *     Defines a function to be called when drag gesture has been detected. This is the right place to start drag and drop operation
 *
 * @def onDragDone -> On drag done
 *
 *     Defines a function to be called when this Node is a drag and drop gesture source after its data has been dropped on a drop target
 *
 *     The transferMode of the event shows what just happened at the drop target.
 *
 *     If transferMode has the value MOVE, then the source can clear out its data
 *
 *     Clearing the source's data gives the appropriate appearance to a user that the data has been moved by the drag and drop gesture
 *
 *     A transferMode that has the value NONE indicates that no data was transferred during the drag and drop gesture
 *
 * @def onDragDropped -> On drag dropped
 *
 *    Defines a function to be called when the mouse button is released on this Node during drag and drop gesture.
 *
 *    Transfer of data from the DragEvent's dragboard should happen in this function
 *
 * @def onDragEntered -> On drag entered
 *
 *    Defines a function to be called when drag gesture enters this Node
 *
 * @def onDragExited -> On drag exited
 *
 *     Defines a function to be called when drag gesture exits this Node
 *
 * @def onDragOver -> On drag over
 *
 *     Defines a function to be called when drag gesture progresses within this Node
 */
