package scalqa; package J; package Json; package Object

trait _Trait extends Data with Lookup[String, Any] with Able.Info {

  // -------------------------------------------------------------------------
  def obj(name: String): Object = objectOpt(name).value
  def objectOpt(name: String): Opt[Object] = opt(name).letAs(classOf[Object])

  def array(name: String): Array = arrayOpt(name).value
  def arrayOpt(name: String): Opt[Array] = opt(name).letAs(classOf[Array])

  def string(name: String): String = stringOpt(name).value
  def stringOpt(name: String): Opt[String] = opt(name).drop(_.isInstanceOf[Data]).map(_.toString)

  // -------------------------------------------------------------------------
  def int(name: String) = longOpt(name).value
  def intOpt(name: String): Opt[Int] = opt(name).letMap { case i: Int => i; case s: String => s.toIntOpt; case a => Numeric.getOpt(a).map(_.toInt) }

  def long(name: String) = longOpt(name).value
  def longOpt(name: String): Opt[Long] = opt(name).letMap { case l: Long => l; case s: String => s.toLongOpt; case a => Numeric.getOpt(a).map(_.toLong) }

  def double(name: String) = doubleOpt(name).value
  def doubleOpt(name: String): Opt[Double] = opt(name).letMap { case d: Double => d; case s: String => s.toDoubleOpt; case a => Numeric.getOpt(a).map(_.toDouble) }

  def boolean(name: String) = string(name).toBoolean

  protected override def info = allPairs

  override def toString = format(this)

}

object _Trait extends Able.Void.Companion[AnyRef](new Object with Void { def allPairs = \/; def opt(key: String): Opt[Any] = \/; def size = 0 })

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
