package scalqa; package Any; package Class

class _Class[A] private[scalqa] (val real: java.lang.Class[A]) extends AnyVal {

  def name: String = real.getName

  def label: String = name.copyBefore("$$anon$").remove("._Trait").remove("._Class").?(_ endsWith "$", _ copyShort 1)
    .I.to[String](s => s.split('.').I.to(sa => if (sa.size >= 2 && sa.last == sa(sa.size - 2)) sa.raw.dropRight(1).all.format(".") else s))

  def lastName: String = label.copyAfterLast(".")

  def configRootOpt: Opt[J.File.Directory] = App.Pro.ConfigRootOpt().map(_.path + label.replace(".", "_") directoryMake)

  def tag: Tag[A] = Tag.get(this).cast

  def isValue = Any.Value.Class.isAssignableFrom(real)

  def isSingleton: Boolean = real.getSimpleName.endsWith("$")

  def url(name: String): J.Url = real.getResource(name)

  override def toString = name

}

object _Class {

  import scala.language.implicitConversions

  implicit def zzClass[A](v: java.lang.Class[A]) = new Class(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *   [[Any.Class]] is a thing wrapper around ''java.lang.Class'', providing same and improved functionality in Scalqa style.
 *
 *   If some methods are not included, they can be called directly with the handle 'real'
 *
 * @def name -> Class name
 *
 *     Same as real.getName
 *
 * @def label -> Class label
 *
 *     Name with unessential components removed
 *
 *     Usually, shorted and cleaner looking identifier.
 *
 * @def lastName -> Class last name
 *
 *     Name left after last 'dot' separator in the full name
 *
 * @def tag -> Tag type of this class
 *
 *     See [[Tag]] for details
 *
 * @def isSingleton -> Checks if object
 *
 *     Tests if this is Scala object, which is essentially singleton type.
 *
 *
 *
 */
