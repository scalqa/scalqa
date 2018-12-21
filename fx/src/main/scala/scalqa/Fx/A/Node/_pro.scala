package scalqa; package Fx; package A; package Node

trait _pro { self: Node =>

  def cachePro: Pro.OM[Boolean] = Custom.ProWO(real.cacheProperty); def cache = real.isCache; def cache_=(b: Boolean) = real.setCache(b)

  def focusedPro: Pro.O[Boolean] = Custom.ProO(real.focusedProperty); def focused = real.isFocused

  def focusTraversablePro: Pro.OM[Boolean] = Custom.ProWO(real.focusTraversableProperty); def focusTraversable = real.isFocusTraversable; def focusTraversable_=(b: Boolean) = real.setFocusTraversable(b)

  def hoverPro: Pro.O[Boolean] = Custom.ProO(real.hoverProperty); def hover = real.isHover

  def disabledPro: Pro.O[Boolean] = Custom.ProO(real.disabledProperty); def disabled = real.isDisabled

  def disablePro: Pro.OM[Boolean] = Custom.ProWO(real.disableProperty); def disable = real.isDisable; def disable_=(b: Boolean) = real.setDisable(b)

  def idPro: Pro.OM[String] = Custom.ProWO(real.idProperty); def id = real.getId; def id_=(b: String) = real.setId(b)

  def layoutXPro: Pro.OM[Double] = Custom.ProWO(real.layoutXProperty); def layoutX = real.getLayoutX; def layoutX_=(b: Double) = real.setLayoutX(b)

  def layoutYPro: Pro.OM[Double] = Custom.ProWO(real.layoutYProperty); def layoutY = real.getLayoutY; def layoutY_=(b: Double) = real.setLayoutY(b)

  def managedPro: Pro.OM[Boolean] = Custom.ProWO(real.managedProperty); def managed = real.isManaged; def managed_=(b: Boolean) = real.setManaged(b)

  def mouseTransparentPro: Pro.OM[Boolean] = Custom.ProWO(real.mouseTransparentProperty); def mouseTransparent = real.isMouseTransparent; def mouseTransparent_=(b: Boolean) = real.setMouseTransparent(b)

  def opacityPro: Pro.OM[Double] = Custom.ProWO(real.opacityProperty); def opacity = real.getOpacity; def opacity_=(b: Double) = real.setOpacity(b)

  def pressedPro: Pro.O[Boolean] = Custom.ProO(real.pressedProperty); def pressed = real.isPressed

  def rotatePro: Pro.OM[Double] = Custom.ProWO(real.rotateProperty); def rotate = real.getRotate; def rotate_=(b: Double) = real.setRotate(b)

  def scaleXPro: Pro.OM[Double] = Custom.ProWO(real.scaleXProperty); def scaleX = real.getScaleX; def scaleX_=(b: Double) = real.setScaleX(b)

  def scaleYPro: Pro.OM[Double] = Custom.ProWO(real.scaleYProperty); def scaleY = real.getScaleY; def scaleY_=(b: Double) = real.setScaleY(b)

  def scaleZPro: Pro.OM[Double] = Custom.ProWO(real.scaleZProperty); def scaleZ = real.getScaleZ; def scaleZ_=(b: Double) = real.setScaleZ(b)

  def translateXPro: Pro.OM[Double] = Custom.ProWO(real.translateXProperty); def translateX = real.getTranslateX; def translateX_=(b: Double) = real.setTranslateX(b)

  def translateYPro: Pro.OM[Double] = Custom.ProWO(real.translateYProperty); def translateY = real.getTranslateY; def translateY_=(b: Double) = real.setTranslateY(b)

  def translateZPro: Pro.OM[Double] = Custom.ProWO(real.translateZProperty); def translateZ = real.getTranslateZ; def translateZ_=(b: Double) = real.setTranslateZ(b)

  def visiblePro: Pro.OM[Boolean] = Custom.ProWO(real.visibleProperty); def visible = real.isVisible; def visible_=(b: Boolean) = real.setVisible(b)

  def stylePro: Pro.OM[Style] = Custom.ProWO(real.styleProperty).asBiMappedView(Style.Map); def style = real.getStyle; def style_=(s: Style) = real.setStyle(s.toString \/ "")

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def cachePro -> Performance hint
 *
 *     A performance hint to the system to indicate that this Node should be cached as a bitmap
 *
 *     Rendering a bitmap representation of a node will be faster than rendering primitives in many cases, especially in the case of primitives with effects applied (such as a blur)
 *
 *     However, it also increases memory usage. This hint indicates whether that trade-off (increased memory usage for increased performance) is worthwhile
 *
 *     Also note that on some platforms such as GPU accelerated platforms there is little benefit to caching Nodes as bitmaps when blurs and other effects are used since they are very fast to render on the GPU
 *
 *     The cacheHintProperty() variable provides additional options for enabling more aggressive bitmap caching
 *
 *     Caching may be disabled for any node that has a 3D transform on itself, any of its ancestors, or any of its descendants
 *
 * @def focusedPro -> Check focused
 *
 *     Indicates whether this Node currently has the input focus
 *
 *     To have the input focus, a node must be the Scene's focus owner, and the scene must be in a Stage that is visible and active
 *
 *     See requestFocus() for more information
 *
 * @def focusTraversablePro -> Check focus traversable
 *
 *     Specifies whether this Node should be a part of focus traversal cycle
 *
 *     When this property is true focus can be moved to this Node and from this Node using regular focus traversal keys
 *
 *     On a desktop such keys are usually TAB for moving focus forward and SHIFT+TAB for moving focus backward
 *
 *     When a Scene is created, the system gives focus to a Node whose focusTraversable variable is true and that is eligible
 *     to receive the focus, unless the focus had been set explicitly via a call to requestFocus()
 *
 * @def hoverPro -> Check hover
 *
 *     Whether or not this Node is being hovered over
 *
 *     Typically this is due to the mouse being over the node, though it could be due to a pen hovering on a graphics tablet or other form of input
 *
 *     Note that current implementation of hover relies on mouse enter and exit events to determine whether this Node is in the hover state;
 *     this means that this feature is currently supported only on systems that have a mouse
 *
 *     Future implementations may provide alternative means of supporting hover.
 *
 * @def disabledPro -> Check disabled
 *
 *     Indicates whether or not this Node is disabled. A Node will become disabled if disable is set to true on either itself or one of its ancestors in the scene graph
 *
 *     A disabled Node should render itself differently to indicate its disabled state to the user. Such disabled rendering is dependent on the implementation of the Node
 *
 *     The shape classes contained in javafx.scene.shape do not implement such rendering by default,
 *     therefore applications using shapes for handling input must implement appropriate disabled rendering themselves
 *
 *     The user-interface controls defined in javafx.scene.control will implement disabled-sensitive rendering, however.
 *
 *     A disabled Node does not receive mouse or key events.
 *
 * @def disablePro -> Disable
 *
 *     Sets the individual disabled state of this Node
 *
 *     Setting disable to true will cause this Node and any subnodes to become disabled
 *
 *     This variable should be used only to set the disabled state of a Node
 *
 *     For querying the disabled state of a Node, the disabled variable should instead be used,
 *     since it is possible that a Node was disabled as a result of an ancestor being disabled even if the individual disable state on this Node is false
 *
 * @def idPro -> Node id
 *
 *     The id of this Node.
 *
 *     This simple string identifier is useful for finding a specific Node within the scene graph. While the id of a Node should be unique within the scene graph, this uniqueness is not enforced
 *
 *     This is analogous to the "id" attribute on an HTML element (CSS ID Specification)
 *
 *     For example, if a Node is given the id of "myId", then the lookup method can be used to find this node as follows: scene.lookup("#myId");
 *
 * @def layoutXPro -> Layout x
 *
 *     Defines the x coordinate of the translation that is added to this Node's transform for the purpose of layout
 *
 *
 * @def layoutYPro -> Layout y
 *
 *     Defines the y coordinate of the translation that is added to this Node's transform for the purpose of layout
 *
 * @def managedPro -> Managed switch
 *
 *     Defines whether or not this node's layout will be managed by it's parent
 *
 *     If the node is managed, it's parent will factor the node's Geometry into its own preferred size and layoutBounds calculations and will lay it out during the scene's layout pass
 *
 *     If a managed node's layoutBounds changes, it will automatically trigger relayout up the scene-graph to the nearest layout root (which is typically the scene's root node)
 *
 *     If the node is unmanaged, its parent will ignore the child in both preferred size computations and layout. Changes in layoutBounds will not trigger relayout above it
 *
 *     If an unmanaged node is of type Parent, it will act as a "layout root",
 *     meaning that calls to Parent.requestLayout() beneath it will cause only the branch rooted by the node to be relayed out,
 *     thereby isolating layout changes to that root and below. It's the application's responsibility to set the size and position of an unmanaged node.
 *
 *     By default all nodes are managed.
 *
 * @def mouseTransparentPro -> Mouse transparent
 *
 *     If true, this node (together with all its children) is completely transparent to mouse events
 *
 *     When choosing target for mouse event, nodes with mouseTransparent set to true and their subtrees won't be taken into account.
 *
 * @def opacityPro -> Opacity
 *
 *     Specifies how opaque (that is, solid) the Node appears
 *
 *     A Node with 0% opacity is fully translucent
 *
 *     That is, while it is still visible and rendered, you generally won't be able to see it
 *
 *     The exception to this rule is when the Node is combined with a blending mode and blend effect in which case a translucent Node may still have an impact in rendering
 *
 *     An opacity of 50% will render the node as being 50% transparent.
 *
 *     A visible node with any opacity setting still receives mouse events and can receive keyboard focus.
 *
 *     For example, if you want to have a large invisible rectangle overlay all Nodes in the scene graph in order
 *     to intercept mouse events but not be visible to the user, you could create a large Rectangle that had an opacity of 0%.
 *
 *     Opacity is specified as a value between 0 and 1. Values less than 0 are treated as 0, values greater than 1 are treated as 1.
 *
 *     On some platforms ImageView might not support opacity variable.
 *
 *     There is a known limitation of mixing opacity < 1.0 with a 3D Transform. Opacity/Blending is essentially a 2D image operation
 *
 *     The result of an opacity < 1.0 set on a Group node with 3D transformed children will cause its children to be rendered in order without Z-buffering applied between those children
 *
 * @def pressedPro -> Pressed
 *
 *     Whether or not the Node is pressed
 *
 *     Typically this is true when the primary mouse button is down, though subclasses may define other mouse button state or key state to cause the node to be "pressed"
 *
 * @def rotatePro -> Rotate
 *
 *     Defines the angle of rotation about the Node's center, measured in degrees. This is used to rotate the Node
 *
 *     This rotation factor is not included in layoutBounds by default, which makes it ideal for rotating the entire node after all effects and transforms have been taken into account
 *
 *     The pivot point about which the rotation occurs is the center of the untransformed layoutBounds
 *
 *     Note that because the pivot point is computed as the center of this Node's layout bounds, any change to the layout bounds will cause the pivot point to change, which can move the object
 *
 *     For a leaf node, any change to the Geometry will cause the layout bounds to change
 *
 *     For a group node, any change to any of its children, including a change in a child's Geometry, clip, effect, position, orientation, or scale, will cause the group's layout bounds to change
 *
 *     If this movement of the pivot point is not desired, applications should instead use the Node's transforms ObservableList, and add a Rotate transform, which has a user-specifiable pivot point
 *
 * @def scaleXPro -> Scale x
 *
 *     Defines the factor by which coordinates are scaled about the center of the object along the X axis of this Node
 *
 *     This is used to stretch or animate the node either manually or by using an animation
 *
 *     This scale factor is not included in layoutBounds by default, which makes it ideal for scaling the entire node after all effects and transforms have been taken into account
 *
 *     The pivot point about which the scale occurs is the center of the untransformed layoutBounds
 *
 * @def scaleYPro -> Scale y
 *
 *     Defines the factor by which coordinates are scaled about the center of the object along the Y axis of this Node
 *
 *     This is used to stretch or animate the node either manually or by using an animation
 *
 *     This scale factor is not included in layoutBounds by default, which makes it ideal for scaling the entire node after all effects and transforms have been taken into account
 *
 *     The pivot point about which the scale occurs is the center of the untransformed layoutBounds
 *
 * @def scaleZPro -> Scale z
 *
 *     Defines the factor by which coordinates are scaled about the center of the object along the Z axis of this Node
 *
 *     This is used to stretch or animate the node either manually or by using an animation
 *
 *     This scale factor is not included in layoutBounds by default, which makes it ideal for scaling the entire node after all effects and transforms have been taken into account
 *
 *     The pivot point about which the scale occurs is the center of the rectangular bounds formed by taking boundsInLocal and applying all the transforms in the transforms ObservableList.
 *
 *     Note that this is a conditional feature. See ConditionalFeature.SCENE3D for more information.
 *
 * @def translateXPro -> Translate x
 *
 *     Defines the x coordinate of the translation that is added to this Node's transform
 *
 *     The node's final translation will be computed as layoutX + translateX, where layoutX establishes the node's stable position and translateX optionally makes dynamic adjustments to that position
 *
 *     This variable can be used to alter the location of a node without disturbing its layoutBounds, which makes it useful for animating a node's location
 *
 * @def translateYPro -> Translate y
 *
 *     Defines the y coordinate of the translation that is added to this Node's transform
 *
 *     The node's final translation will be computed as layoutY + translateY, where layoutY establishes the node's stable position and translateY optionally makes dynamic adjustments to that position
 *
 *     This variable can be used to alter the location of a node without disturbing its layoutBounds, which makes it useful for animating a node's location
 *
 * @def translateZPro -> Translate z
 *
 *     Defines the Z coordinate of the translation that is added to the transformed coordinates of this Node. This value will be added to any translation defined by the transforms ObservableList and layoutZ
 *
 *     This variable can be used to alter the location of a Node without disturbing its layout bounds, which makes it useful for animating a node's location
 *
 *     Note that this is a conditional feature. See ConditionalFeature.SCENE3D for more information
 *
 * @def visiblePro -> Visible
 *
 *     Specifies whether this Node and any subnodes should be rendered as part of the scene graph
 *
 *     A node may be visible and yet not be shown in the rendered scene if, for instance, it is off the screen or obscured by another Node
 *
 *     Invisible nodes never receive mouse events or keyboard focus and never maintain keyboard focus when they become invisible
 *
 * @def stylePro -> Style
 *
 *     A string representation of the CSS style associated with this specific Node
 *
 *     This is analogous to the "style" attribute of an HTML element
 *
 *     Note that, like the HTML style attribute, this variable contains style properties and values and not the selector portion of a style rule
 */
