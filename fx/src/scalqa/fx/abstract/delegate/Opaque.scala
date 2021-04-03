package scalqa; package fx; package `abstract`; package delegate; import language.implicitConversions

abstract class Opaque[TYPE<:Opaque.Ref, BASE<: AnyRef: ClassTag](name: String) extends Any.Ref.Custom.Type[TYPE,BASE](name):
  def apply(v: BASE) : TYPE = v.cast[TYPE]

  given FxConverter: TwoWayFun[BASE,TYPE] = \/

  implicit inline def xxBaseToType(v: BASE): TYPE = v.cast[TYPE]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

