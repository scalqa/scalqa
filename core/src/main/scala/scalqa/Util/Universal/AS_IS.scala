package scalqa; package Util; package Universal

object AS_IS {

  implicit def zzMapping[A](v: AS_IS.type): Stream.Mapping[A, A] = Mapping.asInstanceOf[Stream.Mapping[A, A]]

  implicit def zzMap[A](v: AS_IS.type): A => A = Mapping.asInstanceOf[A => A]

  // ***********************************************************************
  private object Mapping extends (Any => Any) with Stream.Mapping[Any, Any] {

    def apply(v: Any) = v

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object AS_IS ->
 *
 *     See [[Universal]] for usage
 *
 *     Note. [[AS_IS]] can be implicitly converted to Any => Any function, which always returns passed value
 */
