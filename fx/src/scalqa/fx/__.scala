package scalqa; import language.implicitConversions

object Fx:
  /**/       val Abstract    = fx.Abstract
  /**/       val Control     = fx.Control;             type Control      = fx.Control
  /**/       val Scene       = fx.Scene;               type Scene        = fx.Scene
  /**/       val Util        = fx.Util

  @fast lazy val Action      = fx.control.Action;      type Action       = fx.control.Action
  @fast lazy val Button      = fx.control.Button;      type Button       = fx.control.Button
  @fast lazy val Cell        = fx.control.Cell;        type Cell         = fx.control.Cell
  @fast lazy val CheckBox    = fx.control.CheckBox;    type CheckBox     = fx.control.CheckBox
  @fast lazy val ComboBox    = fx.control.ComboBox;    type ComboBox[A]  = fx.control.ComboBox[A]
  @fast lazy val Label       = fx.control.Label;       type Label        = fx.control.Label
  @fast lazy val List        = fx.control.List;        type List[A]      = fx.control.List[A]
  @fast lazy val Menu        = fx.control.Menu;        type Menu         = fx.control.Menu
  @fast lazy val Selection   = fx.control.Selection;   type Selection[A] = fx.control.Selection[A]
  @fast lazy val Table       = fx.control.Table;       type Table[A]     = fx.control.Table[A]
  @fast lazy val Text        = fx.control.Text;        type Text         = fx.control.Text
  @fast lazy val Tooltip     = fx.control.Tooltip;     type Tooltip      = fx.control.Tooltip
  @fast lazy val Toggle      = fx.control.Toggle;      type Toggle       = fx.control.Toggle

  @fast lazy val Application = fx.scene.Application;   type Application  = fx.scene.Application
  @fast lazy val Chart       = fx.scene.Chart;         type Chart        = fx.scene.Chart
  @fast lazy val Event       = fx.scene.Event;         type Event        = fx.scene.Event
  @fast lazy val Image       = fx.scene.Image;         type Image        = fx.scene.Image.opaque.`type`
  @fast lazy val Paint       = fx.scene.Paint;         type Paint        = fx.scene.Paint.opaque.`type`
  @fast lazy val Pane        = fx.scene.Pane;          type Pane         = fx.scene.Pane
  @fast lazy val Popup       = fx.scene.Popup;         type Popup        = fx.scene.Popup
  @fast lazy val Shape       = fx.scene.Shape;         type Shape        = fx.scene.Shape
  @fast lazy val Stage       = fx.scene.Stage;         type Stage        = fx.scene.Stage
  @fast lazy val Window      = fx.scene.Window;        type Window       = fx.scene.Window

  @fast lazy val Orientation = fx.util.Orientation;    type Orientation  = fx.util.Orientation
  @fast lazy val Insets      = fx.util.Insets;         type Insets       = fx.util.Insets.opaque.`type`
  @fast lazy val Side        = fx.util.Side;           type Side         = fx.util.Side
  @fast lazy val Pos         = fx.util.Pos;            type Pos          = fx.util.Pos
  @fast lazy val VPos        = fx.util.VPos;           type VPos         = fx.util.VPos
  @fast lazy val HPos        = fx.util.HPos;           type HPos         = fx.util.HPos
  @fast lazy val Style       = fx.util.Style;          type Style        = fx.util.Style.opaque.`type`
  @fast lazy val JavaFx      = fx.util.JavaFx

  // Shortcuts
  @fast lazy val Node        = fx.`abstract`.Node;     type Node         = fx.`abstract`.Node
  @fast lazy val Color       = Paint.Color;            type Color        = Paint.Color
  @fast lazy val Font        = Text.Font;              type Font         = Text.Font
  @fast lazy val Thread      = Application.Thread


package fx:
  inline def Style       = fx.util.Style;          type Style        = util.Style.opaque.`type`;
  inline def Node        = fx.`abstract`.Node;     type Node         = fx.`abstract`.Node


  inline def Action      = fx.control.Action;      type Action       = fx.control.Action
  inline def Button      = fx.control.Button;      type Button       = fx.control.Button
  inline def Cell        = fx.control.Cell;        type Cell         = fx.control.Cell
  inline def CheckBox    = fx.control.CheckBox;    type CheckBox     = fx.control.CheckBox
  inline def ComboBox    = fx.control.ComboBox;    type ComboBox[A]  = fx.control.ComboBox[A]
  inline def Label       = fx.control.Label;       type Label        = fx.control.Label
  inline def List        = fx.control.List;        type List[A]      = fx.control.List[A]
  inline def Menu        = fx.control.Menu;        type Menu         = fx.control.Menu
  inline def Selection   = fx.control.Selection;   type Selection[A] = fx.control.Selection[A]
  inline def Table       = fx.control.Table;       type Table[A]     = fx.control.Table[A]
  inline def Text        = fx.control.Text;        type Text         = fx.control.Text
  inline def Tooltip     = fx.control.Tooltip;     type Tooltip      = fx.control.Tooltip
  inline def Toggle      = fx.control.Toggle;      type Toggle       = control.Toggle

  inline def Application = fx.scene.Application;   type Application  = fx.scene.Application
  inline def Chart       = fx.scene.Chart;         type Chart        = fx.scene.Chart
  inline def Event       = fx.scene.Event;         type Event        = fx.scene.Event
  inline def Image       = fx.scene.Image;         type Image        = fx.scene.Image.opaque.`type`
  inline def Paint       = fx.scene.Paint;         type Paint        = fx.scene.Paint.opaque.`type`
  inline def Pane        = fx.scene.Pane;          type Pane         = fx.scene.Pane
  inline def Popup       = fx.scene.Popup;         type Popup        = fx.scene.Popup
  inline def Shape       = fx.scene.Shape;         type Shape        = fx.scene.Shape
  inline def Stage       = fx.scene.Stage;         type Stage        = fx.scene.Stage
  inline def Window      = fx.scene.Window;        type Window       = fx.scene.Window

  // Shortcuts
  inline def Color       = Paint.Color;            type Color        = Paint.Color
  inline def Font        = control.Text.Font;      type Font         = control.Text.Font
  inline def Thread      = Application.Thread
  inline def Orientation = util.Orientation;       type Orientation  = util.Orientation
  inline def Insets      = util.Insets;            type Insets       = util.Insets.opaque.`type`
  inline def Side        = util.Side;              type Side         = util.Side
  inline def Pos         = util.Pos;               type Pos          = util.Pos
  inline def VPos        = util.VPos;              type VPos         = util.VPos
  inline def HPos        = util.HPos;              type HPos         = util.HPos

  implicit inline def xxStringToLabel(v: String): control.Label = control.Label(v)

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


