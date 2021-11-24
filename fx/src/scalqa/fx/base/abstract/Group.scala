package scalqa; package fx; package base; package `abstract`; import language.implicitConversions

class Group extends Parent:
  protected type REAL <: javafx.scene.Group;
  override def _createReal                     : REAL                = new javafx.scene.Group().cast[REAL]
  /**/lazy val children                        : Idx.M[Fx.Node.Like] = Idx.M.wrap(real.getChildren).mutableMapView[Fx.Node.Like]
  /**/     def +=(e: Fx.Node.Like)             : this.type           = { children.add(e); this }

  /**/     def autoSizeChildrenPro             : Boolean.Pro.OM      = Fx.JavaFx.To.pro_OM(real.autoSizeChildrenProperty)
  /**/     def autoSizeChildren                : Boolean             = real.isAutoSizeChildren
  /**/     def autoSizeChildren_=(v: Boolean)  : Unit                = real.setAutoSizeChildren(v)

object Group:
  def apply() = new Group

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
