package scalqa; package Util; package Enum

trait Package[ENUM <: Enum[ENUM]] {
  private lazy val lookup: Lookup[String, ENUM] = Lookup.M.make[String, ENUM].I(_.putAll(all.map(e => (e.name, e))))
  private[Enum] lazy val _names = all.map(_.name).to[Refs]

  def items: Idx[ENUM]

  def names: Idx[String] = _names

  def all = items.all

  def fromName(name: String): ENUM = lookup.getOpt(name.toLowerCase) or App.Fail("Name", name, "is not in ", names.all)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def all -> All `enums`
 *
 *     Returns a stream of all available `enums'
 *
 *     Same as `items.all`
 *
 * @def names -> Index of names
 *
 *     [[Idx]] of all defined `enum` names
 *
 *     Name position match corresponding item's
 *
 *     {{{
 *         names(0) == items(0).name // Evaluates true
 *     }}}
 *
 *
 * @def items -> Index `enums`
 *
 *     [[Idx]] of all available `enum` instances
 *
 *     Enum position matches its ordinal property
 *
 *     {{{
 *         item(0).ordinal == 0 // Evaluates true
 *     }}}
 *
 * @def fromName -> Name lookup
 *
 *     Returns `enum` with equal name
 *
 *     Fails if not found
 */
