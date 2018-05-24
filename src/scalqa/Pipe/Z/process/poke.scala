package scalqa; package Pipe; package Z; package process

private[Pipe] class trigger[A](val real: Pipe[A], f: => Any) extends The.Build[A] {

  def pumpOpt(lf: A => Boolean): Opt[A] = real.pumpOpt(v => { f; lf(v) })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/