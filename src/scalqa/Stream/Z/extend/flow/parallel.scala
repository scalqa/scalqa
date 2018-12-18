package scalqa; package Stream; package Z; package extend; package flow

private[Stream] object parallel {

  def apply[A](s: Stream[A]): Flow[A] = App.Setup.ParallelFlowPro().apply(s).asInstanceOf[Flow[A]]

  def If[A](s: Stream[A], v: Boolean): Flow[A] = if (v) apply(s) else s

  def ifOver[A](s: Stream[A], threshold: Int): Flow[A] = { val b = s.preview; If(b, b.previewSizeAtLeast(threshold + 1)) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
