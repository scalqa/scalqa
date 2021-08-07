package scalqa; package fx; package base; package `abstract`; package node; package _Events; import language.implicitConversions

transparent trait _onKey:
  self: Fx.Node =>

  def onKeyPressed [U](l: Fx.Event.Key => U) : Gen.Event.Control = Fx.Event.Key.subscribe(self, l, real.onKeyPressedProperty)
  def onKeyReleased[U](l: Fx.Event.Key => U) : Gen.Event.Control = Fx.Event.Key.subscribe(self, l, real.onKeyReleasedProperty)
  def onKeyTyped   [U](l: Fx.Event.Key => U) : Gen.Event.Control = Fx.Event.Key.subscribe(self, l, real.onKeyTypedProperty)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def onKeyPressed -> On key pressed

       Defines a function to be called when this Node or its child Node has input focus and a key has been pressed


@def onKeyReleased -> On key released

       Defines a function to be called when this Node or its child Node has input focus and a key has been released


@def onKeyTyped -> On key customized

       Defines a function to be called when this Node or its child Node has input focus and a key has been customized

*/
