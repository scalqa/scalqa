package scalqa; package fx

object Ui:

  @fast lazy val JavaFx      = ui.JavaFx
  @fast lazy val Abstract    = ui.Abstract
  @fast lazy val Action      = ui.Action;       type Action       = ui.Action
  @fast lazy val HPos        = ui.HPos;         type HPos         = ui.HPos
  @fast lazy val Insets      = ui.Insets;       type Insets       = ui.Insets.opaque.`type`
  @fast lazy val Orientation = ui.Orientation;  type Orientation  = ui.Orientation
  @fast lazy val Pos         = ui.Pos;          type Pos          = ui.Pos
  @fast lazy val Side        = ui.Side;         type Side         = ui.Side
  @fast lazy val VPos        = ui.VPos;         type VPos         = ui.VPos
  @fast lazy val Style       = ui.Style;        type Style        = ui.Style.opaque.`type`
  @fast lazy val Selection   = ui.Selection;    type Selection[A] = ui.Selection[A]
  @fast lazy val Event       = ui.Event;        type Event        = ui.Event

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Ui -> ### GUI API Base

   [[Ui]] contains GUI basic definitions, which are aliased in [[Fx]] root and can be called without `Ui.` prefix

   For example:
   ```
   val p: Fx.Ui.Pos = CENTER
   // is usually defined as
   val p: Fx.Pos = CENTER


   val s: Fx.Ui.Side = TOP
   // is usually defined as
   val s: Fx.Side = TOP
   ```

*/