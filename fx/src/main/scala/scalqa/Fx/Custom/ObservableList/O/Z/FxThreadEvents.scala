package scalqa; package Fx; package Custom; package ObservableList; package O; package Z

private[Fx] class FxThreadEvents[A](l: Idx.O[A]) extends scalqa.Custom.Proxy.Idx.O[A](l) {

  override def onChange(f: Idx[Idx.Change[A]] ⇒ Any): EventControl = real.onChange(EventControl.moveId1(f, e => Fx.Thread.run(f(e))))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
