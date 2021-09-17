package scalqa; import language.implicitConversions

import scala.reflect.Enum

object Gen:
  transparent inline def Able               = gen.Able

  transparent inline def Calendar           = gen.Calendar
  transparent inline def Day                = gen.calendar.Day;               type Day                     = gen.calendar.Day.TYPE.DEF
  transparent inline def Week               = gen.calendar.Week;              type Week                    = gen.calendar.Week.TYPE.DEF
  transparent inline def Month              = gen.calendar.Month;             type Month                   = gen.calendar.Month.TYPE.DEF
  transparent inline def Year               = gen.calendar.Year;              type Year                    = gen.calendar.Year.TYPE.DEF

  transparent inline def Doc                = gen.Doc;                        type Doc                     = gen.Doc

  transparent inline def Event              = gen.Event
  transparent inline def Observable         = gen.event.Observable;           type Observable              = gen.event.Observable

  transparent inline def Math               = gen.Math;                       type Math[A]                 = scala.math.Numeric[A]
  transparent inline def Ordering           = gen.math.Ordering;              type Ordering[A]             = scala.Ordering[A]
  transparent inline def Rounding           = gen.math.Rounding;              type Rounding                = gen.math.Rounding
  transparent inline def BigDecimal         = gen.math.BigDecimal;            type BigDecimal              = gen.math.BigDecimal.TYPE.DEF
  transparent inline def BigInteger         = gen.math.BigInteger;            type BigInteger              = gen.math.BigInteger.TYPE.DEF

  transparent inline def Request            = gen.Request;                    type Request                 = gen.Request

  transparent inline def Time               = gen.Time;                       type Time                    = gen.Time.TYPE.DEF
  transparent inline def DayTime            = gen.time.DayTime;               type DayTime                 = gen.time.DayTime.TYPE.DEF
  transparent inline def Period             = gen.time.Period;                type Period                  = gen.time.Period

  transparent inline def Util               = gen.Util
  transparent inline def ByteCount          = gen.util.ByteCount;             type ByteCount               = gen.util.ByteCount.TYPE.DEF
  transparent inline def Percent            = gen.util.Percent;               type Percent                 = gen.util.Percent.TYPE.DEF
  transparent inline def ReversibleFunction = gen.util.ReversibleFunction;    type ReversibleFunction[A,B] = gen.util.ReversibleFunction[A,B]
  /**/                                                                        type EnumCompanion[A<:Enum]  = gen.util.EnumCompanion[A]
  transparent inline def Void               = gen.Void;                       type Void                    = gen.Void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Gen -> ### General Utilities

   [[Gen]] is fully exported to scalqa root, thus all members and aliases of [[Gen]] can be called with or without "Gen." prefix.

    For example:
    ```
    val v: Gen.Number.Percent = ?_?_?
    // is same as
    val v: Gen.Percent     = ?_?_?
    // is same as
    val v: Percent     = ?_?_?
    ```

@def  Able               ->  Object alias         \n\n Shortcut to [[scalqa.gen.Able$                    Gen.Able]]

@def  Event              ->  Object alias         \n\n Shortcut to [[scalqa.gen.Event$                   Gen.Event]]
@type Doc                ->  Type alias           \n\n Shortcut to [[scalqa.gen.Doc                      Gen.Doc]]
@def  Doc                ->  Type companion alias \n\n Shortcut to [[scalqa.gen.Doc$                     Gen.Doc]]
@type Request            ->  Type alias           \n\n Shortcut to [[scalqa.gen.Request                  Gen.Request]]
@def  Request            ->  Type companion alias \n\n Shortcut to [[scalqa.gen.Request$                 Gen.Request]]
@type EnumCompanion      ->  Type alias           \n\n Shortcut to [[scalqa.gen.util.EnumCompanion       Gen.Util.EnumCompanion]]
@type Observable         ->  Type alias           \n\n Shortcut to [[scalqa.gen.event.Observable         Gen.Event.Observable]]
@def  Observable         ->  Type companion alias \n\n Shortcut to [[scalqa.gen.event.Observable$        Gen.Event.Observable]]
@type Time               ->  Type alias           \n\n Shortcut to [[scalqa.gen.Time                     Gen.Time]]
@def  Time               ->  Type companion alias \n\n Shortcut to [[scalqa.gen.Time$                    Gen.Time]]
@type DayTime            ->  Type alias           \n\n Shortcut to [[scalqa.gen.time.DayTime             Gen.Time.DayTime]]
@def  DayTime            ->  Type companion alias \n\n Shortcut to [[scalqa.gen.time.DayTime$            Gen.Time.DayTime]]
@type Period             ->  Type alias           \n\n Shortcut to [[scalqa.gen.time.Period              Gen.Time.Period]]
@def  Period             ->  Type companion alias \n\n Shortcut to [[scalqa.gen.time.DayTime$            Gen.Time.Period]]
@def  Calendar           ->  Object alias         \n\n Shortcut to [[scalqa.gen.Calendar$                Gen.Calendar]]
@type Day                ->  Type alias           \n\n Shortcut to [[scalqa.gen.calendar.Day             Gen.Calendar.Day]]
@def  Day                ->  Type companion alias \n\n Shortcut to [[scalqa.gen.calendar.Day$            Gen.Calendar.Day]]
@type Week               ->  Type alias           \n\n Shortcut to [[scalqa.gen.calendar.Week            Gen.Calendar.Week]]
@def  Week               ->  Type companion alias \n\n Shortcut to [[scalqa.gen.calendar.Week$           Gen.Calendar.Week]]
@type Month              ->  Type alias           \n\n Shortcut to [[scalqa.gen.calendar.Month           Gen.Calendar.Month]]
@def  Month              ->  Type companion alias \n\n Shortcut to [[scalqa.gen.calendar.Month$          Gen.Calendar.Month]]
@type Year               ->  Type alias           \n\n Shortcut to [[scalqa.gen.calendar.Year            Gen.Calendar.Year]]
@def  Year               ->  Type companion alias \n\n Shortcut to [[scalqa.gen.calendar.Year$           Gen.Calendar.Year]]
@type Math               ->  Type alias           \n\n Shortcut to [[scalqa.gen.Math                     Gen.Math]]
@def  Math               ->  Type companion alias \n\n Shortcut to [[scalqa.gen.Math$                    Gen.Math]]
@type Ordering           ->  Type alias           \n\n Shortcut to [[scalqa.gen.math.Ordering            Gen.Math.Ordering]]
@def  Ordering           ->  Type companion alias \n\n Shortcut to [[scalqa.gen.math.Ordering$           Gen.Math.Ordering]]
@type Rounding           ->  Type alias           \n\n Shortcut to [[scalqa.gen.math.Rounding            Gen.Math.Rounding]]
@def  Rounding           ->  Type companion alias \n\n Shortcut to [[scalqa.gen.math.Rounding$           Gen.Math.Rounding]]
@type BigDecimal         ->  Type alias           \n\n Shortcut to [[scalqa.gen.math.BigDecimal          Gen.Math.BigDecimal]]
@def  BigDecimal         ->  Type companion alias \n\n Shortcut to [[scalqa.gen.math.BigDecimal$         Gen.Math.BigDecimal]]
@type BigInteger         ->  Type alias           \n\n Shortcut to [[scalqa.gen.math.BigInteger          Gen.Math.BigInteger]]
@def  BigInteger         ->  Type companion alias \n\n Shortcut to [[scalqa.gen.math.BigInteger$         Gen.Math.BigInteger]]
@def  Util               ->  Type companion alias \n\n Shortcut to [[scalqa.gen.Util$                    Gen.Util]]
@type ByteCount          ->  Type alias           \n\n Shortcut to [[scalqa.gen.util.ByteCount           Gen.Util.ByteCount]]
@def  ByteCount          ->  Type companion alias \n\n Shortcut to [[scalqa.gen.util.ByteCount$          Gen.Util.ByteCount]]
@type Percent            ->  Type alias           \n\n Shortcut to [[scalqa.gen.util.Percent             Gen.Util.Percent]]
@def  Percent            ->  Type companion alias \n\n Shortcut to [[scalqa.gen.util.Percent$            Gen.Util.Percent]]
@type ReversibleFunction ->  Type alias           \n\n Shortcut to [[scalqa.gen.util.ReversibleFunction  Gen.Util.ReversibleFunction]]
@def  ReversibleFunction ->  Type companion alias \n\n Shortcut to [[scalqa.gen.util.ReversibleFunction$ Gen.Util.ReversibleFunction]]
@type Void               ->  Type alias           \n\n Shortcut to [[scalqa.gen.Void                     Gen.Void]]
@def  Void               ->  Type companion alias \n\n Shortcut to [[scalqa.gen.Void$                    Gen.Void]]
*/