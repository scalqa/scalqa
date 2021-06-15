package scalqa; package fx

object Base:

  @fast lazy val JavaFx      = base.JavaFx
  @fast lazy val Abstract    = base.Abstract
  @fast lazy val Action      = base.Action;       type Action       = base.Action
  @fast lazy val HPos        = base.HPos;         type HPos         = base.HPos
  @fast lazy val Insets      = base.Insets;       type Insets       = base.Insets.opaque.`type`
  @fast lazy val Orientation = base.Orientation;  type Orientation  = base.Orientation
  @fast lazy val Pos         = base.Pos;          type Pos          = base.Pos
  @fast lazy val Side        = base.Side;         type Side         = base.Side
  @fast lazy val VPos        = base.VPos;         type VPos         = base.VPos
  @fast lazy val Style       = base.Style;        type Style        = base.Style.opaque.`type`
  @fast lazy val Selection   = base.Selection;    type Selection[A] = base.Selection[A]
  @fast lazy val Event       = base.Event;        type Event        = base.Event

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Base -> ### GUI Base

   [[Base]] contains GUI basic definitions, which are aliased in [[Fx]] root and can be called without `Base.` prefix

   For example:
   ```
   val p: Fx.Base.Pos = CENTER
   // is usually defined as
   val p: Fx.Pos = CENTER


   val s: Fx.Base.Side = TOP
   // is usually defined as
   val s: Fx.Side = TOP
   ```

*/