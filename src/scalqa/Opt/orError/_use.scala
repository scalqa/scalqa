package scalqa; package Opt; package orError

trait _use[+A] extends Any with __[A] with Z.Like._use[A] {

  def valueOpt: Opt[A] = if (_isVal) new Opt(_val) else \/

  def failOpt: Opt[Throwable] = _target match { case v: Z.Empty => v.value; case _ => \/ }

  def errorOpt: Opt[String] = failOpt.map(e => e.getMessage ? (_ == null, _ => e.Class.label))

  override def apply(f: A => Any): orError[A] = { if (_isVal) f(_val); This }

  def applyFailure(f: Throwable => Any): orError[A] = { failOpt(f); This }

  def applyError(f: String => Any): orError[A] = { errorOpt(f); This }

  override def run(f: => Any): orError[A] = { if (_isVal) f; This }

  override def voidRun(f: => Any): orError[A] = { if (isVoid) f; This }

  // ---------------------------------------------------------------------------
  def default[B >: A](v: => B): orError[B] = if (_isVal) This else new orError(v)

  def orOpt[B >: A](o: => orError[B]): orError[B] = if (_isVal) This else o

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _use -> '''Opt Use Interface'''
 *
 * @def valueOpt -> Optionally returns value.
 *
 *                  This method is opposite to the errorOpt, one of the two must return ().
 *
 * @def errorOpt -> Optionally returns error
 *
 *                  This method is opposite to the valueOpt, one of the two must return ().
 *
 *
 */
