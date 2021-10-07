package scalqa; package `val`; package pro; package z

private[pro] class Mix_View[A, B, C](p1: Observable[A], p2: Observable[B], f: (A, B) => C) extends pro.X.Abstract[C] with Observable[C]:
  def apply()                 = f(p1(), p2())
  def onChange[U](l: () => U) = Event.Control.join(p1.onObservableChange(l), p2.onObservableChange(l))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
