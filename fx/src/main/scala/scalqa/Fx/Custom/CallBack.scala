package scalqa; package Fx; package Custom

object CallBack {

  def apply[A, B](f: A => B): javafx.util.Callback[A, B] = new javafx.util.Callback[A, B] { def call(a: A): B = f(a) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
