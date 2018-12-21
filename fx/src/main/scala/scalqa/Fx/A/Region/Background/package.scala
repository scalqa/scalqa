package scalqa; package Fx; package A; package Region

import javafx.scene.layout.{ Background => JAVA }

package object Background extends A.Delegate.Data.Setup[_Class, javafx.scene.layout.Background] {

  def make(v: JAVA) = new Background(v)

  implicit def zzFx(v: JAVA): Background = make(v)

  implicit def zzMake(v: Background): JAVA = make(v)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
