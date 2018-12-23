package scalqa

package object Util {
  type BiMap[A, B] = BiMap._Trait[A, B]
  type Enum[A <: Enum[A]] = Enum._Class[A]
  type Void = Void._Trait
  type Out[+A] = Out._Class[A]
  type Deficiency = Deficiency._Class
  type Future[+A] = Future._Trait[A]
  type Opt[+A] = Opt._Class[A]
  type Range[A] = Range._Trait[A]
  type EventControl = EventControl._Trait

  private[scalqa] val One: Long = 1L
  private[scalqa] val OneThousand = One * 1000L
  private[scalqa] val OneMillion = OneThousand * 1000L
  private[scalqa] val OneBillion = OneMillion * 1000L
  private[scalqa] val OneTrillion = OneBillion * 1000L

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
