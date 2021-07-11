package scalqa; package fx

object Base:
  transparent inline def JavaFx      = base.JavaFx
  transparent inline def Abstract    = base.Abstract
  transparent inline def Action      = base.Action;       type Action       = base.Action
  transparent inline def HPos        = base.HPos;         type HPos         = base.HPos
  transparent inline def Insets      = base.Insets;       type Insets       = base.Insets.opaque.`type`
  transparent inline def Orientation = base.Orientation;  type Orientation  = base.Orientation
  transparent inline def Pos         = base.Pos;          type Pos          = base.Pos
  transparent inline def Side        = base.Side;         type Side         = base.Side
  transparent inline def VPos        = base.VPos;         type VPos         = base.VPos
  transparent inline def Style       = base.Style;        type Style        = base.Style.opaque.`type`
  transparent inline def Selection   = base.Selection;    type Selection[A] = base.Selection[A]
  transparent inline def Event       = base.Event;        type Event        = base.Event

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