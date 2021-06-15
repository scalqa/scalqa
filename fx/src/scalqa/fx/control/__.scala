package scalqa; package fx; import language.implicitConversions

trait Control extends Abstract.Region:
  protected type REAL <: javafx.scene.control.Control

  @tn("tooltip_Pro") def tooltip_*                     : Pro.OM[Control.Tooltip]  = Fx.JavaFx.To.pro_OM(real.tooltipProperty).mutableMap_^[Control.Tooltip]
  /**/               def tooltip                       : Control.Tooltip          = Control.Tooltip(real.getTooltip)
  /**/               def tooltip_=(t: Control.Tooltip) : Unit                     = real.setTooltip(t.?.map(_.real) or null)
  /**/               def tooltip_=(s: String)          : Unit                     = tooltip = Control.Tooltip(s)

object Control:
  @fast lazy val Button      = control.Button;               type Button       = control.Button
  @fast lazy val Cell        = control.Cell;                 type Cell         = control.Cell
  @fast lazy val CheckBox    = control.CheckBox;             type CheckBox     = control.CheckBox
  @fast lazy val ComboBox    = control.ComboBox;             type ComboBox[A]  = control.ComboBox[A]
  @fast lazy val Label       = control.Label;                type Label        = control.Label
  @fast lazy val List        = control.List;                 type List[A]      = control.List[A]
  @fast lazy val Menu        = control.Menu;                 type Menu         = control.Menu
  @fast lazy val Popup       = control.Popup;                type Popup        = control.Popup
  @fast lazy val Table       = control.Table;                type Table[A]     = control.Table[A]
  @fast lazy val Text        = control.Text;                 type Text         = control.Text
  @fast lazy val Tooltip     = control.Tooltip;              type Tooltip      = control.Tooltip
  @fast lazy val Toggle      = control.Toggle;               type Toggle       = control.Toggle


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Control -> ### GUI Widgets

   [[Control]] object also contains most of the available controls, which are aliased in [[Fx]] root and can be called without `Control.` prefix

   For example:
   ```
   val b: Fx.Control.Button = ?_?_?
   // is usually defined as
   val b: Fx.Button = ?_?_?


   val c: Fx.Control.CheckBox = ?_?_?
   // is usually defined as
   val c: Fx.CheckBox = ?_?_?
   ```
*/
