package scalqa; package Opt

class Ok private (private val _target: Throwable) extends AnyVal {

  def isTrue = _target == Ok.TrueException

  def isFalse = _target == Ok.FalseException

  def isFailure = !(isTrue || isFalse)

  def failOpt: Opt[Throwable] = _target.I.letIf(isFailure)

  def errorOpt: Opt[String] = failOpt.map(e => e.getMessage ? (_ == null, _ => e.Class.label))

  def validate(v: String): Unit = failOpt.run(Fail.validate(v))

  override def toString: String = if (!isFailure) "Opt.Ok(" + isTrue + ")" else "Opt.Ok(error=" + errorOpt.value + ")"

}

object Ok {

  private val TrueException = new Exception("True")
  private val FalseException = new Exception("False")

  val True = new Ok(TrueException)
  val False = new Ok(TrueException)

  def get(v: Boolean): Ok = if (v) True else False

  def getFail(m: String): Ok = getFail(new Exception(m))

  def getFail(t: Throwable): Ok = if (t == null) Fail() else new Ok(t)

  def getTryCatch(v: => Boolean): Ok = try { v } catch { case t: Throwable => getFail(t) }

  import scala.language.implicitConversions

  implicit def zzGet(v: Ok.type): Ok = True
  implicit def zzGet(v: Boolean): Ok = get(v)
  implicit def zzGet(v: String): Ok = getFail(v)
  implicit def zzGet(t: Throwable): Ok = getFail(t)

  implicit def zzBoolean(v: Ok): Boolean = v.isTrue
  implicit def zzOpt(v: Ok): Opt[Boolean] = if (v.isFailure) \/ else v.isTrue
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @class Ok -> '''Success or Failure'''
 *
 *   [[Opt.Ok]] can be considered a special case of [[Opt.orError]], where value is Boolean or Unit
 *
 *   It allow to capture outcomes:
 *
 *     - Ok.isTrue or Ok.isFailure
 *     - Ok.isTrue, Ok.isFalse, or Ok.isFailure
 *
 *   {{{
 *     // The possible outcomes: true, false, or SecurityException
 *     def deleteFile(f: java.io.File): Opt.Ok = Opt.Ok.getTryCatch(f.delete)
 *
 *     val o = deleteFile(new java.io.File("Z:\\tempXYZ"))
 *
 *     o lp  // Prints: Opt.Ok(true)
 *
 *     o.errorOpt.map("Error Message: " + _) or { if (o) "Deleted" else "Did not delete" } lp // Prints: Deleted
 *   }}}
 *
 */
