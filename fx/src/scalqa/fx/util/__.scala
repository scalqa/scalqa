package scalqa; package fx

object Util:

  @fast lazy val JavaFx = util.JavaFx

  type HPos        = util.HPos;                   @fast lazy val HPos        = util.HPos;
  type Insets      = util.Insets.opaque.`type`;   @fast lazy val Insets      = util.Insets
  type Orientation = util.Orientation;            @fast lazy val Orientation = util.Orientation
  type Pos         = util.Pos;                    @fast lazy val Pos         = util.Pos
  type Side        = util.Side;                   @fast lazy val Side        = util.Side
  type VPos        = util.VPos;                   @fast lazy val VPos        = util.VPos
  type Style       = util.Style.opaque.`type`;    @fast lazy val Style       = util.Style;

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Util -> ###

   [[Util]] object contains GUI utilities, which are aliased in [[Fx]] root and can be called without `Util.` prefix

   For example:
   ```
   val p: Fx.Util.Pos = CENTER
   // is usually defined as
   val p: Fx.Pos = CENTER


   val s: Fx.Util.Side = TOP
   // is usually defined as
   val s: Fx.Side = TOP
   ```

*/