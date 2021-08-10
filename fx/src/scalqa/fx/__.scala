package scalqa; import language.implicitConversions

object Fx:
  transparent inline def Control     = fx.Control;             type Control      = fx.Control
  transparent inline def Button      = fx.control.Button;      type Button       = fx.control.Button
  transparent inline def Cell        = fx.control.Cell;        type Cell         = fx.control.Cell
  transparent inline def CheckBox    = fx.control.CheckBox;    type CheckBox     = fx.control.CheckBox
  transparent inline def ComboBox    = fx.control.ComboBox;    type ComboBox[A]  = fx.control.ComboBox[A]
  transparent inline def Label       = fx.control.Label;       type Label        = fx.control.Label
  transparent inline def List        = fx.control.List;        type List[A]      = fx.control.List[A]
  transparent inline def Menu        = fx.control.Menu;        type Menu         = fx.control.Menu
  transparent inline def Popup       = fx.control.Popup;       type Popup        = fx.control.Popup
  transparent inline def Table       = fx.control.Table;       type Table[A]     = fx.control.Table[A]
  transparent inline def Text        = fx.control.Text;        type Text         = fx.control.Text
  transparent inline def Tooltip     = fx.control.Tooltip;     type Tooltip      = fx.control.Tooltip
  transparent inline def Toggle      = fx.control.Toggle;      type Toggle       = fx.control.Toggle

  transparent inline def Scene       = fx.Scene;               type Scene        = fx.Scene
  transparent inline def Application = fx.scene.Application;   type Application  = fx.scene.Application
  transparent inline def Chart       = fx.scene.Chart;         type Chart        = fx.scene.Chart
  transparent inline def Image       = fx.scene.Image;         type Image        = fx.scene.Image.OPAQUE.TYPE
  transparent inline def Paint       = fx.scene.Paint;         type Paint        = fx.scene.Paint.OPAQUE.TYPE
  transparent inline def Pane        = fx.scene.Pane;          type Pane         = fx.scene.Pane
  transparent inline def Shape       = fx.scene.Shape;         type Shape        = fx.scene.Shape
  transparent inline def Stage       = fx.scene.Stage;         type Stage        = fx.scene.Stage
  transparent inline def Window      = fx.scene.Window;        type Window       = fx.scene.Window

  transparent inline def Base        = fx.Base
  transparent inline def Abstract    = fx.base.Abstract
  transparent inline def Action      = fx.base.Action;         type Action       = fx.base.Action
  transparent inline def Orientation = fx.base.Orientation;    type Orientation  = fx.base.Orientation
  transparent inline def Insets      = fx.base.Insets;         type Insets       = fx.base.Insets.OPAQUE.TYPE
  transparent inline def Side        = fx.base.Side;           type Side         = fx.base.Side
  transparent inline def Pos         = fx.base.Pos;            type Pos          = fx.base.Pos
  transparent inline def VPos        = fx.base.VPos;           type VPos         = fx.base.VPos
  transparent inline def HPos        = fx.base.HPos;           type HPos         = fx.base.HPos
  transparent inline def Style       = fx.base.Style;          type Style        = fx.base.Style.OPAQUE.TYPE
  transparent inline def JavaFx      = fx.base.JavaFx
  transparent inline def Selection   = fx.base.Selection;      type Selection[A] = fx.base.Selection[A]
  transparent inline def Event       = fx.base.Event;          type Event        = fx.base.Event

  //Shortcuts
  transparent inline def Node        = Abstract.Node;          type Node         = Abstract.Node
  transparent inline def Color       = Paint.Color;            type Color        = Paint.Color
  transparent inline def Font        = Text.Font;              type Font         = Text.Font
  transparent inline def Thread      = Application.Thread

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
   All the GUI controls are wrapped into Scala style classes.

   Some use examples can be found in [samplesFx](https://github.com/scalqa/samplesFx/tree/master/src/example/fx).

   There is also a ["Trading Station"](https://github.com/scalqa/TradingStationExample) example as a stand alone project.

*/


