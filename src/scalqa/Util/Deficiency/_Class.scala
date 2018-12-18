package scalqa; package Util; package Deficiency

class _Class(val message: String) extends Any.Able.ToString {

  final def errorOpt: Opt[Throwable] = this.I.letType[Error].map(_.error)

  override def toString = "Deficiency(" + message + ")"

}

object _Class {

  implicit def zzMake(v: String): Deficiency = apply(v)

  implicit def zzMake(v: Throwable): Deficiency = apply(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @class _Class -> Basic Deficiency with message
 *
 *     Applications can create custom deficiencies and match them on type
 *
 *     For example [[Deficiency.Time]]
 *
 */
