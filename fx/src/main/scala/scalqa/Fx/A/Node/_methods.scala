package scalqa; package Fx; package A; package Node

trait _methods { self: Node =>

  def parent: Parent = Map(real.getParent).asInstanceOf[Parent]

  def scene: Scene = Scene.make(real.getScene)

  def resizeRelocate(x: Double, y: Double, width: Double, height: Double) = real.resizeRelocate(x, y, width, height)

  def styleClasses: Idx.M[Style.Class] = Idx.M.wrap(real.getStyleClass).asBiMappedView(s => s, _.toString)

  def psedoClasses: Any.Collection.M[Style.Pseudo.Class] =
    new Any.Collection.M[Style.Pseudo.Class] {
      val fxSet = real.getPseudoClassStates
      def all: ~[Style.Pseudo.Class] = real.getPseudoClassStates.all.map(Style.Pseudo.Class.make)
      def size = fxSet.size
      def add(c: Style.Pseudo.Class): Unit = real.pseudoClassStateChanged(c.real, true)
      def clear: Unit = fxSet.all.foreach(real.pseudoClassStateChanged(_, false))
      def remove(c: Style.Pseudo.Class) = real.pseudoClassStateChanged(c.real, false)
    }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def parent -> Parent
 *
 *     Returns node [[Parent]]
 *
 *     If this node has not been added to a scene graph, then parent will be null
 *
 * @def scene -> Scene
 *
 *     Returns node [[Scene]]
 *
 *     If the node is not part of a scene, then scene will be null
 *
 * @def styleClasses -> Mutable styles
 *
 *     An index collection of [[Style.Class]] which can be used to logically group Nodes, specifically for an external style engine
 *
 *     This variable is analogous to the "class" attribute on an HTML element and, as such, each element of the list is a style class to which this Node belongs
 *
 * @def psedoClasses -> Mutable pseudo-class states
 *
 *     Adding/Removing pseudo-class states from this collection, will trigger re-application of CSS
 *
 * @def resizeRelocate -> Resize and move
 *
 *     If the node is resizable, will set its layout bounds to the specified width and height. If the node is not resizable, the resize step is skipped
 *
 *     Once the node has been resized (if resizable) then sets the node's layoutX and layoutY translation properties in order to relocate it to x,y in the parent's coordinate space
 *
 *     This method should generally only be called by parent nodes from their layoutChildren() methods.
 *     All Parent classes will automatically resize resizable children, so resizing done directly by the application will be overridden by the node's parent, unless the child is unmanaged
 *
 *     Parents are responsible for ensuring the width and height values fall within the resizable node's preferred range.
 *     The autosize() and relocate() methods may be used if the parent just needs to resize the node to its preferred size and reposition it
 */
