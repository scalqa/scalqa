package scalqa; package fx; package ui; package `abstract`; package node; import language.implicitConversions

transparent trait _properties:
  self: Node =>
  @tn("cache_Pro")            def cache_*                        : Boolean.Pro.OM  = Fx.JavaFx.As.pro_OM(real.cacheProperty)
  /**/                        def cache                          : Boolean         = real.isCache;
  /**/                        def cache_=(b: Boolean)            : Unit            = real.setCache(b)
  @tn("focused_Pro")          def focused_*                      : Boolean.Pro.O   = Fx.JavaFx.As.pro_O(real.focusedProperty)
  /**/                        def focused                        : Boolean         = real.isFocused
  @tn("focusTraversable_Pro") def focusTraversable_*             : Boolean.Pro.OM  = Fx.JavaFx.As.pro_OM(real.focusTraversableProperty)
  /**/                        def focusTraversable               : Boolean         = real.isFocusTraversable;
  /**/                        def focusTraversable_=(b: Boolean) : Unit            = real.setFocusTraversable(b)
  @tn("hover_Pro")            def hover_*                        : Boolean.Pro.O   = Fx.JavaFx.As.pro_O(real.hoverProperty)
  /**/                        def hover                          : Boolean         = real.isHover
  @tn("disabled_Pro")         def disabled_*                     : Boolean.Pro.O   = Fx.JavaFx.As.pro_O(real.disabledProperty)
  /**/                        def disabled                       : Boolean         = real.isDisabled
  @tn("disable_Pro")          def disable_*                      : Boolean.Pro.OM  = Fx.JavaFx.As.pro_OM(real.disableProperty)
  /**/                        def disable                        : Boolean         = real.isDisable;
  /**/                        def disable_=(b: Boolean)          : Unit            = real.setDisable(b)
  @tn("id_Pro")               def id_*                           : String.Pro.OM   = Fx.JavaFx.As.pro_OM(real.idProperty)
  /**/                        def id                             : String          = real.getId;
  /**/                        def id_=(b: String)                : Unit            = real.setId(b)
  @tn("layoutX_Pro")          def layoutX_*                      : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.layoutXProperty)
  /**/                        def layoutX                        : Double          = real.getLayoutX;
  /**/                        def layoutX_=(b: Double)           : Unit            = real.setLayoutX(b)
  @tn("layoutY_Pro")          def layoutY_*                      : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.layoutYProperty)
  /**/                        def layoutY                        : Double          = real.getLayoutY;
  /**/                        def layoutY_=(b: Double)           : Unit            = real.setLayoutY(b)
  @tn("managed_Pro")          def managed_*                      : Boolean.Pro.OM  = Fx.JavaFx.As.pro_OM(real.managedProperty)
  /**/                        def managed                        : Boolean         = real.isManaged;
  /**/                        def managed_=(b: Boolean)          : Unit            = real.setManaged(b)
  @tn("mouseTransparent_Pro") def mouseTransparent_*             : Boolean.Pro.OM  = Fx.JavaFx.As.pro_OM(real.mouseTransparentProperty)
  /**/                        def mouseTransparent               : Boolean         = real.isMouseTransparent;
  /**/                        def mouseTransparent_=(b: Boolean) : Unit            = real.setMouseTransparent(b)
  @tn("opacity_Pro")          def opacity_*                      : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.opacityProperty)
  /**/                        def opacity                        : Double          = real.getOpacity;
  /**/                        def opacity_=(b: Double)           : Unit            = real.setOpacity(b)
  @tn("pressed_Pro")          def pressed_*                      : Boolean.Pro.O   = Fx.JavaFx.As.pro_O(real.pressedProperty)
  /**/                        def pressed                        : Boolean         = real.isPressed
  @tn("rotate_Pro")           def rotate_*                       : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.rotateProperty)
  /**/                        def rotate                         : Double          = real.getRotate;
  /**/                        def rotate_=(b: Double)            : Unit            = real.setRotate(b)
  @tn("scaleX_Pro")           def scaleX_*                       : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.scaleXProperty)
  /**/                        def scaleX                         : Double          = real.getScaleX;
  /**/                        def scaleX_=(b: Double)            : Unit            = real.setScaleX(b)
  @tn("scaleY_Pro")           def scaleY_*                       : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.scaleYProperty)
  /**/                        def scaleY                         : Double          = real.getScaleY;
  /**/                        def scaleY_=(b: Double)            : Unit            = real.setScaleY(b)
  @tn("scaleZ_Pro")           def scaleZ_*                       : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.scaleZProperty)
  /**/                        def scaleZ                         : Double          = real.getScaleZ;
  /**/                        def scaleZ_=(b: Double)            : Unit            = real.setScaleZ(b)
  @tn("translateX_Pro")       def translateX_*                   : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.translateXProperty)
  /**/                        def translateX                     : Double          = real.getTranslateX;
  /**/                        def translateX_=(b: Double)        : Unit            = real.setTranslateX(b)
  @tn("translateY_Pro")       def translateY_*                   : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.translateYProperty)
  /**/                        def translateY                     : Double          = real.getTranslateY;
  /**/                        def translateY_=(b: Double)        : Unit            = real.setTranslateY(b)
  @tn("translateZ_Pro")       def translateZ_*                   : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.translateZProperty)
  /**/                        def translateZ                     : Double          = real.getTranslateZ;
  /**/                        def translateZ_=(b: Double)        : Unit            = real.setTranslateZ(b)
  @tn("visible_Pro")          def visible_*                      : Boolean.Pro.OM  = Fx.JavaFx.As.pro_OM(real.visibleProperty)
  /**/                        def visible                        : Boolean         = real.isVisible;
  /**/                        def visible_=(b: Boolean)          : Unit            = real.setVisible(b)
  @tn("style_Pro")            def style_*                        : Style.Pro.OM    = Fx.JavaFx.As.pro_OM(real.styleProperty).mutableMap_^[Style]
  /**/                        def style                          : Style           = real.getStyle;
  /**/                        def style_=(s: Style)              : Unit            = real.setStyle(s.^.?.map(_.toString) or "")
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def cache_* -> Performance hint

       A performance hint to the system to indicate that this Node should be cached as a bitmap

       Rendering a bitmap representation of a node will be faster than rendering primitives in many cases, especially in the case of primitives with effects applied (such as a blur)

       However, it also increases memory usage. This hint indicates whether that trade-off (increased memory usage for increased performance) is worthwhile

       Also note that on some platforms such as GPU accelerated platforms there is little benefit to caching Nodes as bitmaps when blurs and other effects are used since they are very fast to render on the GPU

       The cacheHintProperty() variable provides additional options for enabling more aggressive bitmap caching

       Caching may be disabled for any node that has a 3D transform on itself, any of its ancestors, or any of its descendants


@def focused_* -> Check focused

       Indicates whether this Node currently has the input focus

       To have the input focus, a node must be the Scene's focus owner, and the scene must be in a Stage that is visible and active

       See requestFocus() for more information


@def focusTraversable_* -> Check focus traversable

       Specifies whether this Node should be a part of focus traversal cycle

       When this property is true focus can be moved to this Node and from this Node using regular focus traversal keys

       On a desktop such keys are usually TAB for moving focus forward and SHIFT+TAB for moving focus backward

       When a Scene is created, the system gives focus to a Node whose focusTraversable variable is true and that is eligible
       to receive the focus, unless the focus had been set explicitly via a call to requestFocus()


@def hover_* -> Check hover

       Whether or not this Node is being hovered over

       Typically this is due to the mouse being over the node, though it could be due to a pen hovering on a graphics tablet or other form of input

       Note that current implementation of hover relies on mouse enter and exit events to determine whether this Node is in the hover state;
       this means that this feature is currently supported only on systems that have a mouse

       Future implementations may provide alternative means of supporting hover.


@def disabled_* -> Check disabled

       Indicates whether or not this Node is disabled. A Node will become disabled if disable is set to true on either itself or one of its ancestors in the scene graph

       A disabled Node should render itself differently to indicate its disabled state to the user. Such disabled rendering is dependent on the implementation of the Node

       The shape classes contained in javafx.scene.shape do not implement such rendering by default,
       therefore applications using shapes for handling input must implement appropriate disabled rendering themselves

       The user-interface controls defined in javafx.scene.control will implement disabled-sensitive rendering, however.

       A disabled Node does not receive mouse or key events.


@def disable_* -> Disable

       Sets the individual disabled state of this Node

       Setting disable to true will cause this Node and any subnodes to become disabled

       This variable should be used only to set the disabled state of a Node

       For querying the disabled state of a Node, the disabled variable should instead be used,
       since it is possible that a Node was disabled as a result of an ancestor being disabled even if the individual disable state on this Node is false


@def id_* -> Node id

       The id of this Node.

       This simple string identifier is useful for finding a specific Node within the scene graph. While the id of a Node should be unique within the scene graph, this uniqueness is not enforced

       This is analogous to the "id" attribute on an HTML element (CSS ID Specification)

       For example, if a Node is given the id of "myId", then the map method can be used to find this node as follows: scene.map("#myId");


@def layoutX_* -> Layout x

       Defines the x coordinate of the translation that is added to this Node's transform for the purpose of layout



@def layoutY_* -> Layout y

       Defines the y coordinate of the translation that is added to this Node's transform for the purpose of layout


@def managed_* -> Managed switch

       Defines whether or not this node's layout will be managed by it's parent

       If the node is managed, it's parent will factor the node's Geometry into its own preferred size and layoutBounds calculations and will lay it out during the scene's layout pass

       If a managed node's layoutBounds changes, it will automatically trigger relayout up the scene-graph to the nearest layout root (which is typically the scene's root node)

       If the node is unmanaged, its parent will ignore the child in both preferred size computations and layout. Changes in layoutBounds will not trigger relayout above it

       If an unmanaged node is of type Parent, it will act as a "layout root",
       meaning that calls to Parent.requestLayout() beneath it will cause only the branch rooted by the node to be relayed out,
       thereby isolating layout changes to that root and below. It's the application's responsibility to set the size and position of an unmanaged node.

       By default all nodes are managed.


@def mouseTransparent_* -> Mouse transparent

       If true, this node (together with all its children) is completely transparent to mouse events

       When choosing target for mouse event, nodes with mouseTransparent set to true and their subtrees won't be taken into account.


@def opacity_* -> Opacity

       Specifies how opaque (that is, solid) the Node appears

       A Node with 0% opacity is fully translucent

       That is, while it is still visible and rendered, you generally won't be able to see it

       The exception to this rule is when the Node is combined with a blending mode and blend effect in which case a translucent Node may still have an impact in rendering

       An opacity of 50% will render the node as being 50% transparent.

       A visible node with any opacity setting still receives mouse events and can receive keyboard focus.

       For example, if you want to have a large invisible rectangle overlay all Nodes in the scene graph in order
       to intercept mouse events but not be visible to the user, you could create a large Rectangle that had an opacity of 0%.

       Opacity is specified as a value between 0 and 1. Values less than 0 are treated as 0, values greater than 1 are treated as 1.

       On some platforms ImageView might not support opacity variable.

       There is a known limitation of mixing opacity < 1.0 with a 3D Transform. Opacity/Blending is essentially a 2D image operation

       The result of an opacity < 1.0 set on a Idx node with 3D transformed children will cause its children to be rendered in order without Z-buffering applied between those children


@def pressed_* -> Pressed

       Whether or not the Node is pressed

       Typically this is true when the primary mouse button is down, though subclasses may define other mouse button state or key state to cause the node to be "pressed"


@def rotate_* -> Rotate

       Defines the angle of rotation about the Node's center, measured in degrees. This is used to rotate the Node

       This rotation factor is not included in layoutBounds by default, which makes it ideal for rotating the entire node after all effects and transforms have been taken into account

       The pivot point about which the rotation occurs is the center of the untransformed layoutBounds

       Note that because the pivot point is computed as the center of this Node's layout bounds, any change to the layout bounds will cause the pivot point to change, which can move the object

       For a leaf node, any change to the Geometry will cause the layout bounds to change

       For a group node, any change to any of its children, including a change in a child's Geometry, clip, effect, position, orientation, or scale, will cause the group's layout bounds to change

       If this movement of the pivot point is not desired, applications should instead use the Node's transforms ObservableList, and add a Rotate transform, which has a user-specifiable pivot point


@def scaleX_* -> Scale x

       Defines the factor by which coordinates are scaled about the center of the object along the X axis of this Node

       This is used to stretch or animate the node either manually or by using an animation

       This scale factor is not included in layoutBounds by default, which makes it ideal for scaling the entire node after all effects and transforms have been taken into account

       The pivot point about which the scale occurs is the center of the untransformed layoutBounds


@def scaleY_* -> Scale y

       Defines the factor by which coordinates are scaled about the center of the object along the Y axis of this Node

       This is used to stretch or animate the node either manually or by using an animation

       This scale factor is not included in layoutBounds by default, which makes it ideal for scaling the entire node after all effects and transforms have been taken into account

       The pivot point about which the scale occurs is the center of the untransformed layoutBounds


@def scaleZ_* -> Scale z

       Defines the factor by which coordinates are scaled about the center of the object along the Z axis of this Node

       This is used to stretch or animate the node either manually or by using an animation

       This scale factor is not included in layoutBounds by default, which makes it ideal for scaling the entire node after all effects and transforms have been taken into account

       The pivot point about which the scale occurs is the center of the rectangular bounds formed by taking boundsInLocal and applying all the transforms in the transforms ObservableList.

       Note that this is a conditional feature. See ConditionalFeature.SCENE3D for more information.


@def translateX_* -> Translate x

       Defines the x coordinate of the translation that is added to this Node's transform

       The node's final translation will be computed as layoutX + translateX, where layoutX establishes the node's stable position and translateX optionally makes dynamic adjustments to that position

       This variable can be used to alter the location of a node without disturbing its layoutBounds, which makes it useful for animating a node's location


@def translateY_* -> Translate y

       Defines the y coordinate of the translation that is added to this Node's transform

       The node's final translation will be computed as layoutY + translateY, where layoutY establishes the node's stable position and translateY optionally makes dynamic adjustments to that position

       This variable can be used to alter the location of a node without disturbing its layoutBounds, which makes it useful for animating a node's location


@def translateZ_* -> Translate z

       Defines the Z coordinate of the translation that is added to the transformed coordinates of this Node. This value will be added to any translation defined by the transforms ObservableList and layoutZ

       This variable can be used to alter the location of a Node without disturbing its layout bounds, which makes it useful for animating a node's location

       Note that this is a conditional feature. See ConditionalFeature.SCENE3D for more information


@def visible_* -> Visible

       Specifies whether this Node and any subnodes should be rendered as part of the scene graph

       A node may be visible and yet not be shown in the rendered scene if, for instance, it is off the screen or obscured by another Node

       Invisible nodes never receive mouse events or keyboard focus and never maintain keyboard focus when they become invisible


@def style_* -> Style

       A string representation of the CSS style associated with this specific Node

       This is analogous to the "style" attribute of an HTML element

       Note that, like the HTML style attribute, this variable contains style properties and values and not the selector portion of a style rule

*/
