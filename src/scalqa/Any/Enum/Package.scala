package scalqa; package Any; package Enum

trait Package[ENUM <: Enum[ENUM]] {
  private lazy val lookup: Lookup[String, ENUM] = Lookup.W.get[String, ENUM] =+~ all.map(e => (e.name, e))
  private[Enum] lazy val _names = all.map(_.name).to[Index.Val]

  def items: Index[ENUM]

  def names: Index[String] = _names

  def all = items.all

  def getByOrdinal(ordinal: Int): ENUM = items(ordinal)

  def getByName(name: String): ENUM = lookup.opt(name.toLowerCase) or Fail("Name", name, "is not in ", names.all)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def all -> All ''enums''.
 *
 *     Returns a pipe of all available ''enums'.
 *
 *     Same as ''items.all''
 *
 * @def names -> Index of all ''enum'' names.
 *
 *     [[Index]] of all defined ''enum'' names.
 *
 *     Name position match corresponding item's
 *
 *     {{{
 *         names(0) == items(0).name // Evaluates true
 *     }}}
 *
 *
 * @def items -> Index of all ''enums''.
 *
 *     [[Index]] of all available ''enum'' instances.
 *
 *     Enum position matches its ordinal property
 *
 *     {{{
 *         item(0).ordinal == 0 // Evaluates true
 *     }}}
 *
 * @def getByName -> Name lookup.
 *
 *     Returns ''enum'' with equal name.
 *
 *     Fails if not found.
 *
 * @def getByOrdinal -> Index lookup.
 *
 *     Fails if not found.
 *
 *     {{{
 *         getByOrdinal(0) == items(0) // Evaluates true
 *     }}}
 *
 */
