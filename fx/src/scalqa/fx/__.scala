package scalqa; import language.implicitConversions

object Fx:
  /**/       val Control     = fx.Control;             type Control      = fx.Control
  @fast lazy val Button      = fx.control.Button;      type Button       = fx.control.Button
  @fast lazy val Cell        = fx.control.Cell;        type Cell         = fx.control.Cell
  @fast lazy val CheckBox    = fx.control.CheckBox;    type CheckBox     = fx.control.CheckBox
  @fast lazy val ComboBox    = fx.control.ComboBox;    type ComboBox[A]  = fx.control.ComboBox[A]
  @fast lazy val Label       = fx.control.Label;       type Label        = fx.control.Label
  @fast lazy val List        = fx.control.List;        type List[A]      = fx.control.List[A]
  @fast lazy val Menu        = fx.control.Menu;        type Menu         = fx.control.Menu
  @fast lazy val Popup       = fx.control.Popup;       type Popup        = fx.control.Popup
  @fast lazy val Table       = fx.control.Table;       type Table[A]     = fx.control.Table[A]
  @fast lazy val Text        = fx.control.Text;        type Text         = fx.control.Text
  @fast lazy val Tooltip     = fx.control.Tooltip;     type Tooltip      = fx.control.Tooltip
  @fast lazy val Toggle      = fx.control.Toggle;      type Toggle       = fx.control.Toggle

  /**/       val Scene       = fx.Scene;               type Scene        = fx.Scene
  @fast lazy val Application = fx.scene.Application;   type Application  = fx.scene.Application
  @fast lazy val Chart       = fx.scene.Chart;         type Chart        = fx.scene.Chart
  @fast lazy val Image       = fx.scene.Image;         type Image        = fx.scene.Image.opaque.`type`
  @fast lazy val Paint       = fx.scene.Paint;         type Paint        = fx.scene.Paint.opaque.`type`
  @fast lazy val Pane        = fx.scene.Pane;          type Pane         = fx.scene.Pane
  @fast lazy val Shape       = fx.scene.Shape;         type Shape        = fx.scene.Shape
  @fast lazy val Stage       = fx.scene.Stage;         type Stage        = fx.scene.Stage
  @fast lazy val Window      = fx.scene.Window;        type Window       = fx.scene.Window

  /**/       val Ui          = fx.Ui
  /**/       val Abstract    = fx.ui.Abstract
  @fast lazy val Action      = fx.ui.Action;           type Action       = fx.ui.Action
  @fast lazy val Orientation = fx.ui.Orientation;      type Orientation  = fx.ui.Orientation
  @fast lazy val Insets      = fx.ui.Insets;           type Insets       = fx.ui.Insets.opaque.`type`
  @fast lazy val Side        = fx.ui.Side;             type Side         = fx.ui.Side
  @fast lazy val Pos         = fx.ui.Pos;              type Pos          = fx.ui.Pos
  @fast lazy val VPos        = fx.ui.VPos;             type VPos         = fx.ui.VPos
  @fast lazy val HPos        = fx.ui.HPos;             type HPos         = fx.ui.HPos
  @fast lazy val Style       = fx.ui.Style;            type Style        = fx.ui.Style.opaque.`type`
  @fast lazy val JavaFx      = fx.ui.JavaFx
  @fast lazy val Selection   = fx.ui.Selection;        type Selection[A] = fx.ui.Selection[A]
  @fast lazy val Event       = fx.ui.Event;            type Event        = fx.ui.Event

  // Shortcuts
  @fast lazy val Node        = Abstract.Node;          type Node         = Abstract.Node
  @fast lazy val Color       = Paint.Color;            type Color        = Paint.Color
  @fast lazy val Font        = Text.Font;              type Font         = Text.Font
  @fast lazy val Thread      = Application.Thread

package fx:
  inline def Abstract    = ui.Abstract
  inline def Style       = ui.Style;               type Style        = ui.Style.opaque.`type`;
  inline def Node        = Abstract.Node;          type Node         = Abstract.Node

  inline def Button      = control.Button;         type Button       = control.Button
  inline def Cell        = control.Cell;           type Cell         = control.Cell
  inline def CheckBox    = control.CheckBox;       type CheckBox     = control.CheckBox
  inline def ComboBox    = control.ComboBox;       type ComboBox[A]  = control.ComboBox[A]
  inline def Label       = control.Label;          type Label        = control.Label
  inline def List        = control.List;           type List[A]      = control.List[A]
  inline def Menu        = control.Menu;           type Menu         = control.Menu
  inline def Popup       = control.Popup;          type Popup        = control.Popup
  inline def Table       = control.Table;          type Table[A]     = control.Table[A]
  inline def Text        = control.Text;           type Text         = control.Text
  inline def Tooltip     = control.Tooltip;        type Tooltip      = control.Tooltip
  inline def Toggle      = control.Toggle;         type Toggle       = control.Toggle

  inline def Application = scene.Application;      type Application  = scene.Application
  inline def Chart       = scene.Chart;            type Chart        = scene.Chart
  inline def Image       = scene.Image;            type Image        = scene.Image.opaque.`type`
  inline def Paint       = scene.Paint;            type Paint        = scene.Paint.opaque.`type`
  inline def Pane        = scene.Pane;             type Pane         = scene.Pane
  inline def Shape       = scene.Shape;            type Shape        = scene.Shape
  inline def Stage       = scene.Stage;            type Stage        = scene.Stage
  inline def Window      = scene.Window;           type Window       = scene.Window

  inline def Action      = ui.Action;              type Action       = ui.Action
  inline def Orientation = ui.Orientation;         type Orientation  = ui.Orientation
  inline def Insets      = ui.Insets;              type Insets       = ui.Insets.opaque.`type`
  inline def Side        = ui.Side;                type Side         = ui.Side
  inline def Pos         = ui.Pos;                 type Pos          = ui.Pos
  inline def VPos        = ui.VPos;                type VPos         = ui.VPos
  inline def HPos        = ui.HPos;                type HPos         = ui.HPos

  // Shortcuts
  inline def Color       = Paint.Color;            type Color        = Paint.Color
  inline def Font        = control.Text.Font;      type Font         = control.Text.Font
  inline def Thread      = Application.Thread

  implicit inline def implicitStringToLabel(v: String): control.Label = control.Label(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Fx -> ### GUI API

   [[Fx]] is an easy to use wrapper of JavaFx technology


*/


