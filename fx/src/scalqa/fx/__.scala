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

  /**/       val Base        = fx.Base
  /**/       val Abstract    = fx.base.Abstract
  @fast lazy val Action      = fx.base.Action;         type Action       = fx.base.Action
  @fast lazy val Orientation = fx.base.Orientation;    type Orientation  = fx.base.Orientation
  @fast lazy val Insets      = fx.base.Insets;         type Insets       = fx.base.Insets.opaque.`type`
  @fast lazy val Side        = fx.base.Side;           type Side         = fx.base.Side
  @fast lazy val Pos         = fx.base.Pos;            type Pos          = fx.base.Pos
  @fast lazy val VPos        = fx.base.VPos;           type VPos         = fx.base.VPos
  @fast lazy val HPos        = fx.base.HPos;           type HPos         = fx.base.HPos
  @fast lazy val Style       = fx.base.Style;          type Style        = fx.base.Style.opaque.`type`
  @fast lazy val JavaFx      = fx.base.JavaFx
  @fast lazy val Selection   = fx.base.Selection;      type Selection[A] = fx.base.Selection[A]
  @fast lazy val Event       = fx.base.Event;          type Event        = fx.base.Event

  // Shortcuts
  @fast lazy val Node        = Abstract.Node;          type Node         = Abstract.Node
  @fast lazy val Color       = Paint.Color;            type Color        = Paint.Color
  @fast lazy val Font        = Text.Font;              type Font         = Text.Font
  @fast lazy val Thread      = Application.Thread

package fx:
  inline def Abstract    = base.Abstract
  inline def Style       = base.Style;             type Style        = base.Style.opaque.`type`;
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

  inline def Action      = base.Action;            type Action       = base.Action
  inline def Orientation = base.Orientation;       type Orientation  = base.Orientation
  inline def Insets      = base.Insets;            type Insets       = base.Insets.opaque.`type`
  inline def Side        = base.Side;              type Side         = base.Side
  inline def Pos         = base.Pos;               type Pos          = base.Pos
  inline def VPos        = base.VPos;              type VPos         = base.VPos
  inline def HPos        = base.HPos;              type HPos         = base.HPos

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

   [[Fx]] is an easy to use wrapper of [JavaFx](https://openjfx.io) technology.
   Scalqa observable containers like [[scalqa.val.idx.ObservableMutable Idx.OM]] and [[scalqa.val.pro.ObservableMutable Pro.OM]] serve as a simple to use data model.
   All the GUI controlls are wrapped into Scala style classes.

   Some use examples can be found in [samplesFx](https://github.com/scalqa/samplesFx/tree/master/src/example/fx).

   There is also a ["Trading Station"](https://github.com/scalqa/TradingStationExample) example as a stand alone project.

*/


