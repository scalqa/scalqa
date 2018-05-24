package scalqa; package Pipe; package Z; package process

private[Pipe] class reverse[A](val real: Pipe[A]) extends The.Build[A] {
  private lazy val all = real.foldAs[Coll.Val[A]](\/, _ + _).allReversed

  def pumpOpt(lf: A => Boolean): Opt[A] = all.pumpOpt(lf)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/