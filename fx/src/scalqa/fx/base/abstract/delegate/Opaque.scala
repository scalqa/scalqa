package scalqa; package fx; package base; package `abstract`; package delegate; import language.implicitConversions

abstract class Opaque[TYPE<:AnyRef.Opaque, REAL<:AnyRef: ClassTag](name: String) extends AnyRef.Opaque.Base[TYPE,REAL](name):
  def apply(v: REAL) : TYPE = v.cast[TYPE]

  given FxConverter: ReversibleFunction[REAL,TYPE] = \/

  implicit inline def implicitBaseToType(v: REAL): TYPE = v.cast[TYPE]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

