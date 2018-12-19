package scalqa; package Any; package Itself

class Class[A] private[scalqa] (val real: java.lang.Class[A]) extends AnyVal {

  def name: String = real.getName

  def label: String = {
    val s = { val s = name.copyBefore("$$anon$").remove("._Trait").remove("._Class"); if (s endsWith "$") s copyShort 1 else s }
    val sa = s.split('.')
    if (sa.size >= 2 && sa.last == sa(sa.size - 2)) sa.array.dropRight(1).all.format(".") else s
  }

  def lastName: String = label.copyAfterLast(".")

  def ilk: Ilk = ??? // Ilk.make(this)

  def isSingleton: Boolean = real.getSimpleName.endsWith("$")

  override def toString = name

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Class ->
 *
 *   [[Class]] is a thing wrapper around `java.lang.Class`, providing same and improved functionality in Scalqa style
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
 * @def ilk -> Ilk of this class
 *
 *     See [[Ilk]] for details
 *
 * @def isSingleton -> Checks if object
 *
 *     Tests if this is Scala object, which is essentially singleton type.
 *
 *
 *
 */
