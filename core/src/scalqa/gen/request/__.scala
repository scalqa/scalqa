package scalqa; package gen; import language.implicitConversions

class Request:

  override def toString = super.toString.takeBefore("$").takeAfterLast(".")

object Request:
  type DEFAULT    = request.DEFAULT;              inline def DEFAULT     = request.DEFAULT
  type ALL        = request.ALL;                  inline def ALL         = request.ALL
  type NEW        = request.NEW;                  inline def NEW         = request.NEW
  type EMPTY      = request.EMPTY;                inline def EMPTY       = request.EMPTY
  type CURRENT    = request.CURRENT;              inline def CURRENT     = request.CURRENT
  type LEFT       = request.LEFT;                 inline def LEFT        = request.LEFT
  type RIGHT      = request.RIGHT;                inline def RIGHT       = request.RIGHT
  type CENTER     = request.CENTER;               inline def CENTER      = request.CENTER
  type TOP        = request.TOP;                  inline def TOP         = request.TOP
  type BOTTOM     = request.BOTTOM;               inline def BOTTOM      = request.BOTTOM
  type HORIZONTAL = request.HORIZONTAL;           inline def HORIZONTAL  = request.HORIZONTAL
  type VERTICAL   = request.VERTICAL;             inline def VERTICAL    = request.VERTICAL
  type UP         = request.UP;                   inline def UP          = request.UP
  type DOWN       = request.DOWN;                 inline def DOWN        = request.DOWN
  type SEPARATOR  = request.SEPARATOR;            inline def SEPARATOR   = request.SEPARATOR
  type MAX        = request.MAX;                  inline def MAX         = request.MAX
  type MIN        = request.MIN;                  inline def MIN         = request.MIN
  type VOID       = request.VOID;                 inline def VOID        = request.VOID

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type VOID        ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.VOID$       Gen.Request.VOID]]
@def  VOID        ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.VOID$       Gen.Request.VOID]]
@type NEW         ->  Type alias      \n\n Shortcut to [[scalqa.gen.request.NEW$        Gen.Request.NEW]]
@def  NEW         ->  Singleton alias \n\n Shortcut to [[scalqa.gen.request.NEW$        Gen.Request.NEW]]
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

@class Request -> ### General Request

     General Request types establish some concept. They are always available without need to import.

     Application classes and traits can have implicit conversions from General Request type to a local definition
     ([for example](https://github.com/scalqa/scalqa/blob/master/fx/src/scalqa/fx/base/Side.scala)).

     Using general request singleton objects can make code more readable. There is no overhead because conversions are inlined.

     ```
         Time.current.roundTo(1.Second)(using UP)
         // vs.
         Time.current.roundTo(1.Second)(using Gen.Rounding.Up)

         Time.current.roundTo(1.Minute)(using DOWN)
         // vs.
         Time.current.roundTo(1.Minute)(using Gen.Rounding.Down)

         val b: Int.Buffer = NEW
         // vs.
         val b: Int.Buffer = Int.Buffer()

         val j: java.util.List[String] = NEW
         // vs.
         val j: java.util.List[String] = new java.util.ArrayList()

         val l: Long = MAX
         // vs.
         val l: Long = Long.max

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
            items += Fx.Menu.Item.separator
         }
     ```

     By far the most common request is VOID, which is a request for a void instance

     ```
     var s: Stream[Int]  = VOID     // Assigning empty stream of Ints
     var o: Opt[String]  = VOID     // Assigning empty optional value of String
     var i: Long.Idx     = VOID     // Assigning empty indexed collection of Long
     ```
*/
