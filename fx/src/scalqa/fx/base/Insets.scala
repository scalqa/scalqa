package scalqa; package fx; package base; import language.implicitConversions

import javafx.geometry.{ Insets => JInsets }

object Insets extends Abstract.Delegate.Opaque[Fx.Insets, JInsets]("Fx.Insets"):
  inline   def apply(inline top: Double, inline right: Double, inline bottom: Double, inline left: Double) : Insets = new JInsets(top, right, bottom, left).cast[Insets]
  inline   def apply(all: Double)                                                                          : Insets = apply(all, all, all, all)
  override def doc(v: Insets) = Doc(typeName) += ("top", v.top) += ("bottom", v.bottom) += ("left", v.left) += ("right", v.right)

  extension (x: Insets)
    inline def top                  : Double = x.real.getTop
    inline def bottom               : Double = x.real.getBottom
    inline def right                : Double = x.real.getRight
    inline def left                 : Double = x.real.getLeft
    /**/   def newTop(   v: Double) : Insets = Insets(v, x.right, x.bottom, x.left)
    /**/   def newBottom(v: Double) : Insets = Insets(x.top, x.right, v, x.left)
    /**/   def newRight( v: Double) : Insets = Insets(x.top, v, x.bottom, x.left)
    /**/   def newLeft(  v: Double) : Insets = Insets(x.top, x.right, x.bottom, v)

  object opaque:
    opaque type `type` <: Any.Opaque.Ref = JInsets & Any.Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
