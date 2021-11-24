package scalqa; package fx; package control; package menu; import language.implicitConversions

import javafx.scene.control.{MenuItem => JItem}

class Item extends Action:
  private[menu] def this(a: Action)    = { this(); _createRealOverride(a.real.cast[REAL]) }
  private[menu] def this(text: String) = { this(); _createRealOverride(new JItem(text).cast[REAL]) }
  protected type REAL <: JItem
  protected override def _createReal: REAL = new JItem().cast[REAL]

  def graphicPro               : Pro.OM[Fx.Node.Like] = Fx.JavaFx.To.pro_OM(real.graphicProperty).mutableMapView[Fx.Node.Like]
  def graphic                  : Fx.Node.Like         = graphicPro()
  def graphic_=(g:Fx.Node.Like): Unit                 = real.setGraphic(g.real)
  def idPro                    : Pro.OM[String]       = Fx.JavaFx.To.pro_OM(real.idProperty)
  def id                       : String               = real.getId
  def id_=(v: String)          : Unit                 = real.setId(v)

object Item:
  type Custom = item.Custom

  def apply(a: Action)                                               : Item  = a match { case v: Item => v; case _ => new Item(a) }
  def apply(text: String)                                            : Item  = new Item(text)
  def apply(text: String, n: Fx.Node.Like)                           : Item  = apply(text).self(_.graphicPro() = n)
  def apply[U](text: String, l: Action.Event => U)                   : Item  = apply(text).self(_.onAction(l))
  def apply[U](text: String, enabled: Boolean, l: Action.Event => U) : Item  = apply(text, l).self(_.enable = enabled)
  def apply(real: JItem)                                             : Item  = real.getUserData.cast[Item]
  def separator                                                      : Item  = new z.Separator

  given FxConverter: TwoWayFunction[JItem,Item] = z_TwoWay;

  implicit inline def implicitFrom(v: SEPARATOR): Item = separator

  // *************************************************************
  private object z_TwoWay extends TwoWayFunction[JItem,Item] { def apply(real: JItem) = Item.apply(real); def undo(i: Item): JItem = i.real }
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
