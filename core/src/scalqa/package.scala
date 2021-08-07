import language.implicitConversions

package object scalqa:
  export scalqa.Lang.*
  //export scalqa.Gen.*
  export scalqa.gen.Request.*
  export scalqa.j.vm.Predef.{ given }

  @tn("Stream")                    val ~~         = `val`.Stream;      @tn("Stream") type ~[A]           = `val`.Stream[A]
  @tn("Range")  transparent inline def <>         = `val`.Range;       @tn("Range")  type <>[A]          = `val`.Range[A]
  @tn("Pack")   transparent inline def ><         = `val`.Pack;        @tn("Pack")   type ><[A]          = `val`.Pack[A]
  /**/          transparent inline def Buffer     = `val`.Buffer;                    type Buffer[A]      = `val`.Buffer[A]
  /**/          transparent inline def Collection = `val`.Collection;                type Collection[+A] = `val`.Collection[A]
  /**/          transparent inline def Idx        = `val`.Idx;                       type Idx[+A]        = `val`.Idx[A]
  /**/          transparent inline def Lookup     = `val`.Lookup;                    type Lookup[A,+B]   = `val`.Lookup[A,B]
  /**/          transparent inline def Opt        = `val`.Opt;                       type Opt[+A]        = `val`.Opt.OPAQUE.TYPE[A]
  /**/          transparent inline def Pro        = `val`.Pro;                       type Pro[+A]        = `val`.Pro[A]
  /**/          transparent inline def Promise    = `val`.Promise;                   type Promise[+A]    = `val`.Promise[A]
  /**/          transparent inline def Result     = `val`.Result;                    type Result[+A]     = `val`.Result.OPAQUE.TYPE[A]
  /**/          transparent inline def StableSet  = Collection.StableSet;            type StableSet[A]   = Collection.StableSet[A]


  transparent inline def Able               = gen.Able
  transparent inline def Given              = gen.Given

  transparent inline def Calendar           = gen.Calendar
  transparent inline def Day                = gen.calendar.Day;               type Day                     = gen.calendar.Day.OPAQUE.TYPE
  transparent inline def Week               = gen.calendar.Week;              type Week                    = gen.calendar.Week.OPAQUE.TYPE
  transparent inline def Month              = gen.calendar.Month;             type Month                   = gen.calendar.Month.OPAQUE.TYPE
  transparent inline def Year               = gen.calendar.Year;              type Year                    = gen.calendar.Year.OPAQUE.TYPE

  transparent inline def Doc                = gen.Doc;                        type Doc                     = gen.Doc

  transparent inline def Event              = gen.Event
  transparent inline def Observable         = gen.event.Observable;           type Observable              = gen.event.Observable

  transparent inline def Math               = gen.Math;                       type Math[A]                 = scala.math.Numeric[A]
  transparent inline def Rounding           = gen.math.Rounding;              type Rounding                = gen.math.Rounding
  transparent inline def BigDecimal         = gen.math.BigDecimal;            type BigDecimal              = gen.math.BigDecimal.OPAQUE.TYPE
  transparent inline def BigInteger         = gen.math.BigInteger;            type BigInteger              = gen.math.BigInteger.OPAQUE.TYPE

  transparent inline def Request            = gen.Request;                    type Request                 = gen.Request

  transparent inline def Time               = gen.Time;                       type Time                    = gen.Time.OPAQUE.TYPE
  transparent inline def DayTime            = gen.time.DayTime;               type DayTime                 = gen.time.DayTime.OPAQUE.TYPE
  transparent inline def Period             = gen.time.Period;                type Period                  = gen.time.Period

  transparent inline def Util               = gen.Util
  transparent inline def ByteCount          = gen.util.ByteCount;             type ByteCount               = gen.util.ByteCount.OPAQUE.TYPE
  transparent inline def Percent            = gen.util.Percent;               type Percent                 = gen.util.Percent.OPAQUE.TYPE
  transparent inline def ReversibleFunction = gen.util.ReversibleFunction;    type ReversibleFunction[A,B] = gen.util.ReversibleFunction[A,B]
  /**/                                                                        type EnumCompanion[A<:scala.reflect.Enum]  = gen.util.EnumCompanion[A]
  transparent inline def Void               = gen.Void;                       type Void                    = gen.Void


  private[scalqa] type ClassTag[A] = scala.reflect.ClassTag[A];     private[scalqa] inline def ClassTag = scala.reflect.ClassTag
  private[scalqa] type tn          = scala.annotation.targetName
  private[scalqa] type fast        = scala.annotation.threadUnsafe
  extension[A](inline x: A) private[scalqa] inline def cast[B]:  B = x.asInstanceOf[B]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object scalqa -> ### \n\n Root package [[scalqa]] defines 5 members:

  -- [[scalqa.Lang$ Lang]] holds language level extentions to Java and Scala functionality
  -- [[scalqa.Gen$ Gen]]   holds core language utilities
  -- [[scalqa.Fx$ Fx]]     holds GUI API
  -- [[scalqa.J$ J]]       holds second tier language utilities
  -- [[scalqa.Val$ Val]]   holds generic containers framework

  [[scalqa]] also contains many aliases,
  so the types and objects defined deeper in the hierarchy can be accessed without prefixes


@val ~~ ->  Companion operator alias \n\n Shortcut to [[scalqa.val.Stream$ Val.Stream]]

    `Note.`

    The stream companion alias is a double tilde (`~~`) instead of a single (`~`).
    This exception is made only for root object scalqa.~~ , `scalqa.Val.~` companion is stil single tilde.
    ```
    val s1 : ~[String] = ~~("a","b","c")
    val s2 : ~[String] = Val.~("a","b","c")
    ```
    The reason for the exception is twofold:

      1. `~` is universally used as a method name, which would conflict with unprefixed companion inside some classes
      2. Simple expression ~("a","b","c") compiles in Scala as a prefix method on Tuple3, but ~~("a","b","c") works fine as ~~.apply("a","b","c")
*/
