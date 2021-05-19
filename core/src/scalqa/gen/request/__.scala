package scalqa; package gen; import language.implicitConversions

class Request:

  override def toString = super.toString.takeBefore("$").takeAfterLast(".")

object Request:
  @tn("VOID")    type \/         = request.VOID      .type;    @tn("VOID")  inline def \/          = request.VOID
  /**/           type VOID       = request.VOID      .type;                 inline def VOID        = request.VOID
  /**/           type DEFAULT    = request.DEFAULT   .type;                 inline def DEFAULT     = request.DEFAULT
  /**/           type ALL        = request.ALL       .type;                 inline def ALL         = request.ALL
  /**/           type EMPTY      = request.EMPTY     .type;                 inline def EMPTY       = request.EMPTY
  /**/           type CURRENT    = request.CURRENT   .type;                 inline def CURRENT     = request.CURRENT
  /**/           type LEFT       = request.LEFT      .type;                 inline def LEFT        = request.LEFT
  /**/           type RIGHT      = request.RIGHT     .type;                 inline def RIGHT       = request.RIGHT
  /**/           type CENTER     = request.CENTER    .type;                 inline def CENTER      = request.CENTER
  /**/           type TOP        = request.TOP       .type;                 inline def TOP         = request.TOP
  /**/           type BOTTOM     = request.BOTTOM    .type;                 inline def BOTTOM      = request.BOTTOM
  /**/           type HORIZONTAL = request.HORIZONTAL.type;                 inline def HORIZONTAL  = request.HORIZONTAL
  /**/           type VERTICAL   = request.VERTICAL  .type;                 inline def VERTICAL    = request.VERTICAL
  /**/           type UP         = request.UP        .type;                 inline def UP          = request.UP
  /**/           type DOWN       = request.DOWN      .type;                 inline def DOWN        = request.DOWN
  /**/           type SEPARATOR  = request.SEPARATOR .type;                 inline def SEPARATOR   = request.SEPARATOR
  /**/           type MAX        = request.MAX       .type;                 inline def MAX         = request.MAX
  /**/           type MIN        = request.MIN       .type;                 inline def MIN         = request.MIN

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type \/          ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.VOID$       Gen.Request.VOID]]
@def  \/          ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.VOID$       Gen.Request.VOID]]

@type VOID        ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.VOID$       Gen.Request.VOID]]
@def  VOID        ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.VOID$       Gen.Request.VOID]]
@type DEFAULT     ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.DEFAULT$    Gen.Request.DEFAULT]]
@def  DEFAULT     ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.DEFAULT$    Gen.Request.DEFAULT]]
@type ALL         ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.ALL$        Gen.Request.ALL]]
@def  ALL         ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.ALL$        Gen.Request.ALL]]
@type EMPTY       ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.EMPTY$      Gen.Request.EMPTY]]
@def  EMPTY       ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.EMPTY$      Gen.Request.EMPTY]]
@type CURRENT     ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.CURRENT$    Gen.Request.CURRENT]]
@def  CURRENT     ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.CURRENT$    Gen.Request.CURRENT]]
@type LEFT        ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.LEFT$       Gen.Request.LEFT]]
@def  LEFT        ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.LEFT$       Gen.Request.LEFT]]
@type RIGHT       ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.RIGHT$      Gen.Request.RIGHT]]
@def  RIGHT       ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.RIGHT$      Gen.Request.RIGHT]]
@type CENTER      ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.CENTER$     Gen.Request.CENTER]]
@def  CENTER      ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.CENTER$     Gen.Request.CENTER]]
@type TOP         ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.TOP$        Gen.Request.TOP]]
@def  TOP         ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.TOP$        Gen.Request.TOP]]
@type BOTTOM      ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.BOTTOM$     Gen.Request.BOTTOM]]
@def  BOTTOM      ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.BOTTOM$     Gen.Request.BOTTOM]]
@type HORIZONTAL  ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.HORIZONTAL$ Gen.Request.HORIZONTAL]]
@def  HORIZONTAL  ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.HORIZONTAL$ Gen.Request.HORIZONTAL]]
@type VERTICAL    ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.VERTICAL$   Gen.Request.VERTICAL]]
@def  VERTICAL    ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.VERTICAL$   Gen.Request.VERTICAL]]
@type UP          ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.UP$         Gen.Request.UP]]
@def  UP          ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.UP$         Gen.Request.UP]]
@type DOWN        ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.DOWN$       Gen.Request.DOWN]]
@def  DOWN        ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.DOWN$       Gen.Request.DOWN]]
@type SEPARATOR   ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.SEPARATOR$  Gen.Request.SEPARATOR]]
@def  SEPARATOR   ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.SEPARATOR$  Gen.Request.SEPARATOR]]
@type MAX         ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.MAX$        Gen.Request.MAX]]
@def  MAX         ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.MAX$        Gen.Request.MAX]]
@type MIN         ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.MIN$        Gen.Request.MIN]]
@def  MIN         ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.MIN$        Gen.Request.MIN]]

@class Request -> ###

     Type Request objects establish some concept

     Application classes and traits can have implicit conversions from Request type to local definitions

     Using universal instead of local values can reduce and clarify code

     ```

         Time().roundTo(1.Second, UP)
         // vs.
         Time().roundTo(1.Second, Gen.Rounding.Up)

         Time().roundTo(1.Minute)(using DOWN)
         // vs.
         Time().roundTo(1.Minute, Gen.Rounding.Down)

         val l: Long = MAX
         // vs.
         val l: Long = Long.MaxValue

         new Fx.Label("XYZ") {
            alignment = RIGHT
            // vs.
            alignment = Fx.Pos.CenterRight
         }

         new Fx.Pane.Split{
            orientation = VERTICAL
            // vs.
            orientation = Fx.Orientation.Vertical
         }

         new Fx.Menu {
            items += SEPARATOR
            // vs.
            items += Fx.Menu.Item.separator_*
         }
     ```
*/
