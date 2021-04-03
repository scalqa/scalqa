package scalqa; package fx; package control; import language.implicitConversions

abstract class Cell extends Label.Like:
  protected type ITEM
  protected type REAL <: javafx.scene.control.Cell[ITEM]
  // --------------------------------------------------------------------------------------------------
  private[fx]         var currentSetup                  : cell.Setup[_]    = null
  protected  override def _createReal                   : REAL             = new javafx.scene.control.Cell[ITEM].cast[REAL]
  protected           def afterItemUpdated              : Unit             = { text = \/; style = \/; alignment = \/; style_*() = \/ }

  // --------------------------------------------------------------------------------------------------
  /**/                def item                          : ITEM             = item_?.get
  @tn("itemOpt")      def item_?                        : Opt[ITEM]        = if (real.isEmpty) \/ else real.getItem
  @tn("empty_Pro")    def empty_*                       : Boolean.Pro.O    = Fx.JavaFx.As.pro_O(real.emptyProperty)
  /**/                def empty                         : Boolean          = real.isEmpty
  @tn("editing_Pro")  def editing_*                     : Boolean.Pro.O    = Fx.JavaFx.As.pro_O(real.editingProperty)
  /**/                def editing                       : Boolean          = real.isEditing
  @tn("editable_Pro") def editable_*                    : Boolean.Pro.OM   = Fx.JavaFx.As.pro_OM(real.editableProperty)
  /**/                def editable                      : Boolean          = real.isEditable
  /**/                def editable_=(b: Boolean)        : Unit             = real.setEditable(b)

  // --------------------------------------------------------------------------------------------------
  protected           var _styleClass                   : Style.Class      = \/
  /**/                def styleClass                    : Style.Class      = _styleClass
  /**/                def styleClass_=(sc: Style.Class) : Unit             = if (_styleClass != sc) {
  /**/                                                                             val list = styleClasses
  /**/                                                                             val c = _styleClass
  /**/                                                                             if (list.last_?.contains(c)) list.removeAt(list.size - 1) else list.remove(c)
  /**/                                                                             _styleClass = sc
  /**/                                                                             list.add(sc)
  /**/                                                                        }

object Cell:
  type Indexed = cell.Indexed
  type Setup[A <: Cell] = cell.Setup[A]; inline def Setup = cell.Setup

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
