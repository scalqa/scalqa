package scalqa; package Time; package Length; package Z; package Custom

private[Time] abstract class Companion[A <: _Trait](private[Time] val _name: String, private[Time] val _paddedLength: Int = 2) extends Long.Like.Companion[A] {

  import scala.language.implicitConversions

  implicit def zzLength(v: A) = v.length

  implicit def zzPreciseLength(v: A) = v.preciseLength

  implicit def zzLong(n: A): Long = n.toLong

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
