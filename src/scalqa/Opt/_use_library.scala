package scalqa; package Opt

class _use_library[A] private[Opt] (protected[Opt] val _target: Any) extends AnyVal with Z.Like._use_library[A]
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _use_library ->
 *
 *     '''Use Library''' extends '_use' interface with strictly typed methods
 *
 *     [[Opt]] is co-variant and methods accepting precise types are not allowed
 *
 *     Nevertheless, attaching invariantly typed library solves the problem
 *
 */
