package scalqa; package Array; package Like

trait _Trait[A, SELF] extends Any with _basic[A, _Class] with _copy[A, _Class] with _plusMinus[A, SELF] with Able.Info {

  protected def info = \/.info ~ ("size", size) ~ ("raw", Z.Raw.toString(raw))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
