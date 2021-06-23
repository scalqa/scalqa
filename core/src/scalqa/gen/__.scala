package scalqa; import language.implicitConversions

import scala.reflect.Enum

object Gen:
  @fast lazy val Able               = gen.Able
  @fast lazy val Given              = gen.Given

  @fast lazy val Calendar           = gen.Calendar
  @fast lazy val Day                = gen.calendar.Day;               type Day                     = gen.calendar.Day.opaque.`type`
  @fast lazy val Week               = gen.calendar.Week;              type Week                    = gen.calendar.Week.opaque.`type`
  @fast lazy val Month              = gen.calendar.Month;             type Month                   = gen.calendar.Month.opaque.`type`
  @fast lazy val Year               = gen.calendar.Year;              type Year                    = gen.calendar.Year.opaque.`type`

  @fast lazy val Doc                = gen.Doc;                        type Doc                     = gen.Doc

  @fast lazy val Event              = gen.Event
  @fast lazy val Observable         = gen.event.Observable;           type Observable              = gen.event.Observable

  @fast lazy val Math               = gen.Math;                       type Math[A]                 = scala.math.Numeric[A]
  @fast lazy val Numeric            = gen.math.Numeric
  @fast lazy val Rounding           = gen.math.Rounding;              type Rounding                = gen.math.Rounding
  @fast lazy val BigDecimal         = gen.math.BigDecimal;            type BigDecimal              = gen.math.BigDecimal.opaque.`type`
  @fast lazy val BigInteger         = gen.math.BigInteger;            type BigInteger              = gen.math.BigInteger.opaque.`type`

  @fast lazy val Request            = gen.Request;                    type Request                 = gen.Request

  @fast lazy val Time               = gen.Time;                       type Time                    = gen.Time.opaque.`type`
  @fast lazy val DayTime            = gen.time.DayTime;               type DayTime                 = gen.time.DayTime.opaque.`type`
  @fast lazy val Period             = gen.time.Period;                type Period                  = gen.time.Period

  @fast lazy val Util               = gen.Util
  @fast lazy val ByteCount          = gen.util.ByteCount;             type ByteCount               = gen.util.ByteCount.opaque.`type`
  @fast lazy val Percent            = gen.util.Percent;               type Percent                 = gen.util.Percent.opaque.`type`
  @fast lazy val ReversibleFunction = gen.util.ReversibleFunction;    type ReversibleFunction[A,B] = gen.util.ReversibleFunction[A,B]
  /**/                                                                type EnumCompanion[A<:Enum]  = gen.util.EnumCompanion[A]
  @fast lazy val Void               = gen.Void;                       type Void                    = gen.Void

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
@val  Event              ->  Object alias    \n\n Shortcut to [[scalqa.gen.Event$                   Gen.Event]]
@type Observable         ->  Type alias      \n\n Shortcut to [[scalqa.gen.event.Observable         Gen.Event.Observable]]
@val  Observable         ->  Companion alias \n\n Shortcut to [[scalqa.gen.event.Observable$        Gen.Event.Observable]]
@type Time               ->  Type alias      \n\n Shortcut to [[scalqa.gen.Time                     Gen.Time]]
@val  Time               ->  Companion alias \n\n Shortcut to [[scalqa.gen.Time$                    Gen.Time]]
@type DayTime            ->  Type alias      \n\n Shortcut to [[scalqa.gen.time.DayTime             Gen.Time.DayTime]]
@val  DayTime            ->  Companion alias \n\n Shortcut to [[scalqa.gen.time.DayTime$            Gen.Time.DayTime]]
@type Period             ->  Type alias      \n\n Shortcut to [[scalqa.gen.time.Period              Gen.Time.Period]]
@val  Period             ->  Companion alias \n\n Shortcut to [[scalqa.gen.time.DayTime$            Gen.Time.Period]]
@val  Calendar           ->  Object alias    \n\n Shortcut to [[scalqa.gen.Calendar$                Gen.Calendar]]
@type Day                ->  Type alias      \n\n Shortcut to [[scalqa.gen.calendar.Day             Gen.Calendar.Day]]
@val  Day                ->  Companion alias \n\n Shortcut to [[scalqa.gen.calendar.Day$            Gen.Calendar.Day]]
@type Week               ->  Type alias      \n\n Shortcut to [[scalqa.gen.calendar.Week            Gen.Calendar.Week]]
@val  Week               ->  Companion alias \n\n Shortcut to [[scalqa.gen.calendar.Week$           Gen.Calendar.Week]]
@type Month              ->  Type alias      \n\n Shortcut to [[scalqa.gen.calendar.Month           Gen.Calendar.Month]]
@val  Month              ->  Companion alias \n\n Shortcut to [[scalqa.gen.calendar.Month$          Gen.Calendar.Month]]
@type Year               ->  Type alias      \n\n Shortcut to [[scalqa.gen.calendar.Year            Gen.Calendar.Year]]
@val  Year               ->  Companion alias \n\n Shortcut to [[scalqa.gen.calendar.Year$           Gen.Calendar.Year]]
@val  Math               ->  Object alias    \n\n Shortcut to [[scalqa.gen.Math$                    Gen.Math]]
@type Rounding           ->  Type alias      \n\n Shortcut to [[scalqa.gen.math.Rounding            Gen.Math.Rounding]]
@val  Rounding           ->  Companion alias \n\n Shortcut to [[scalqa.gen.math.Rounding$           Gen.Math.Rounding]]
@type BigDecimal         ->  Type alias      \n\n Shortcut to [[scalqa.gen.math.BigDecimal          Gen.Math.BigDecimal]]
@val  BigDecimal         ->  Companion alias \n\n Shortcut to [[scalqa.gen.math.BigDecimal$         Gen.Math.BigDecimal]]
@type BigInteger         ->  Type alias      \n\n Shortcut to [[scalqa.gen.math.BigInteger          Gen.Math.BigInteger]]
@val  BigInteger         ->  Companion alias \n\n Shortcut to [[scalqa.gen.math.BigInteger$         Gen.Math.BigInteger]]
@type ByteCount          ->  Type alias      \n\n Shortcut to [[scalqa.gen.util.ByteCount           Gen.Util.ByteCount]]
@val  ByteCount          ->  Companion alias \n\n Shortcut to [[scalqa.gen.util.ByteCount$          Gen.Util.ByteCount]]
@type Percent            ->  Type alias      \n\n Shortcut to [[scalqa.gen.util.Percent             Gen.Util.Percent]]
@val  Percent            ->  Companion alias \n\n Shortcut to [[scalqa.gen.util.Percent$            Gen.Util.Percent]]
@type ReversibleFunction ->  Type alias      \n\n Shortcut to [[scalqa.gen.util.ReversibleFunction  Gen.Util.ReversibleFunction]]
@val  ReversibleFunction ->  Companion alias \n\n Shortcut to [[scalqa.gen.util.ReversibleFunction$ Gen.Util.ReversibleFunction]]
*/