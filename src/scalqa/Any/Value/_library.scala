package scalqa; package Any; package Value

class _library[THIS, VAL] private[Value] (private val v: Value) extends AnyVal {

  @inline def real: VAL = v._real.cast

  @inline def companion: Companion[THIS, VAL] = v.kin.cast
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @class _library ->
 *
 *  Library provides access to protected fields, which are not required by applications, but are important for smart collection implementations.
 *
 *
 */
