package object scalqa extends Util.Z.Include.Root {
  type App = App._Class
  type Idx[+A] = Idx._Trait[A]
  type Lookup[A, +B] = Lookup._Trait[A, B]
  type Stream[A] = Stream._Class[A]
  type Pro[+A] = Pro._Trait[A]

  // Shortcuts ------------------------------------------------------------------------------
  type ~[+A] = Stream.Interface[A]; def ~ = Stream.Interface.This
  type Ilk[-A] = Any.Ilk.Tag[A]; val Ilk = Any.Ilk.This
  type Vals[A] = Any.Datum.Vals[A]; val Vals = Any.Datum.Vals.This
  type Percent = Util.Percent; val Percent = Util.Percent
  // type ByteSize = Util.ByteSize; val ByteSize = Util.ByteSize

  // Time and Calendar ----------------------------------------------------------------------
  type Time = Util.Time._Class; val Time = Util.Time.This
  type Duration = Util.Time.Duration; val Duration = Util.Time.Duration
  type DayTime = Util.Time.DayTime; val DayTime = Util.Time.DayTime
  type Period = Util.Time.Period; val Period = Util.Time.Period
  type Year = Util.Calendar.Year; val Year = Util.Calendar.Year
  type Month = Util.Calendar.Month; val Month = Util.Calendar.Month
  type Day = Util.Calendar.Day; val Day = Util.Calendar.Day

  // Util   ---------------------------------------------------------------------------------
  type EventControl = Util.EventControl._Trait; val EventControl = Util.EventControl.This
  type Range[A] = Util.Range._Trait[A]; val Range = Util.Range.This
  type Opt[+A] = Util.Opt._Class[A]; val Opt = Util.Opt.This
  type Out[+A] = Util.Out[A]; val Out = Util.Out.This
  type BiMap[A, B] = Util.BiMap[A, B]; lazy val BiMap = Util.BiMap.This
  type Future[+A] = Util.Future[A]; val Future = Util.Future.This
  type Deficiency = Util.Deficiency; val Deficiency = Util.Deficiency.This
  type OneOfTwo[+A, +B] = Util.OneOfTwo[A, B]; val OneOfTwo = Util.OneOfTwo
  type Void = Util.Void

  implicit def any2stringadd() = () // any2stringadd is globally disabled
  implicit def zzWarrant_ImplicitConversions = languageFeature.implicitConversions
  implicit def zzWarrant_HigherKinds = languageFeature.higherKinds
  implicit def zzWarrant_PostfixOps = scala.language.postfixOps

  private[scalqa] type ClassTag[A] = scala.reflect.ClassTag[A]
  private[scalqa] val DATA = new Specializable.Group((scala.Byte, scala.Char, scala.Short, scala.Int, scala.Long, scala.Double, scala.Float))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def any2stringadd -> Disable any2stringadd
 *
 *      Disable "Any to String Add" functionality in Scalqa
 *
 *     {{{
 *         new Object() + "str"  // will not compile
 *
 *         // Use instead special String building operator "plus spaced"
 *
 *         new Object() +- "str"  // will compile
 *     }}}
 *
 * @type Vals -> Alias
 *
 *   Globally available alias to type and object [[Any.Datum.Vals]]
 *
 * @type Deficiency -> Alias
 *
 *   Globally available alias to type and object [[Util.Deficiency]]
 *
 * @type OneOfTwo -> Alias
 *
 *   Globally available alias to type and object [[Util.OneOfTwo]]
 *
 * @type Opt -> Alias
 *
 *   Globally available alias to type and object [[Util.Opt]]
 *
 * @type Out -> Alias
 *
 *   Globally available alias to type and object [[Util.Out]]
 *
 * @type Range -> Alias
 *
 *   Globally available alias to type and object [[Util.Range]]
 *
 * @type Future -> Alias
 *
 *   Globally available alias to type and object [[Util.Future]]
 *
 * @type EventControl -> Alias
 *
 *   Globally available alias to type and object [[Util.EventControl]]
 *
 * @type BiMap -> Alias
 *
 *   Globally available alias to type and object [[Util.BiMap]]
 *
 * @type Percent -> Alias
 *
 *   Globally available alias to type and object [[Util.Percent]]
 *
 * @type ~ -> Alias
 *
 *   Globally available alias to type and object [[Stream.Interface]]
 *
 * @type Ilk -> Alias
 *
 *   Globally available alias to type [[Any.Ilk.Tag]] and object [[Any.Ilk]]
 *
 * @type Void -> Alias
 *
 *   Globally available alias to type and object [[Util.Void]]
 *
 * @type Year -> Alias
 *
 *   Globally available alias to type and object [[Util.Calendar.Year]]
 *
 * @type Month -> Alias
 *
 *   Globally available alias to type and object [[Util.Calendar.Month]]
 *
 * @type Day = -> Alias
 *
 *   Globally available alias to type and object [[Util.Calendar.Day]]
 *
 * @type DayTime -> Alias
 *
 *   Globally available alias to type and object [[Util.Time.DayTime]]
 *
 * @type Time = -> Alias
 *
 *   Globally available alias to type and object [[Util.Time]]
 *
 * @type Duration = -> Alias
 *
 *   Globally available alias to type and object [[Util.Time.Duration]]
 *
 * @type Period -> Alias
 *
 *   Globally available alias to type and object [[Util.Time.Period]]
 *
 * @type Year -> Alias
 *
 *   Globally available alias to type and object [[Util.Calendar.Year]]
 *
 * @type Month -> Alias
 *
 *   Globally available alias to type and object [[Util.Calendar.Month]]
 *
 * @type Day = -> Alias
 *
 *   Globally available alias to type and object [[Util.Calendar.Day]]
 *
 * @type DayTime -> Alias
 *
 *   Globally available alias to type and object [[Util.Time.DayTime]]
 *
 * @def zzWarrant_ImplicitConversions -> Enable Implicit Conversions
 *
 *     Implicit Conversions are to be used in Scalqa with no restrictions
 *
 * @def zzWarrant_HigherKinds -> Enable Higher Kinds
 *
 *     Higher Kinds are to be used in Scalqa with no restrictions
 *
 * @def zzWarrant_PostfixOps -> Enable Postfix Operations
 *
 *     Postfix Operations are to be used in Scalqa with no restrictions
 */
