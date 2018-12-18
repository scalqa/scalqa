package scalqa; package Any; package Datum

trait _Trait[TYPE, VALUE] extends Any with Any.Wrap[VALUE] {

  protected def make(v: VALUE): TYPE

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> [[Any.Datum]] is a common root for all data objects
 *
 *     [[Any.Datum]] is not extended directly, but rather from following groups of data roots:
 *
 *     - [[Ref]]
 *     - [[Byte]]
 *     - [[Short]]
 *     - [[Int]]
 *     - Etc.
 */
