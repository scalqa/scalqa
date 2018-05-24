package scalqa; package Any; package Value; package Ref; package Companion

abstract class _Class[REF <: Ref[VAL], VAL <: AnyRef: Tag] protected (voidVal: VAL = null) extends Like[REF, VAL](voidVal) {

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
 *   Companion object type required to be implemented for each new [[Any.Value.Ref]] type
 *
 */
