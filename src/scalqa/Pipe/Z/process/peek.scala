package scalqa; package Pipe; package Z; package process

private[Pipe] class peek[A](val real: Pipe[A], f: A => Any) extends The.Build[A] {

  def pumpOpt(lf: A => Boolean): Opt[A] = real.pumpOpt(v => { f(v); lf(v) })

}

private[Pipe] object peek {

  // ***********************************************************************************************
  private[Pipe] class idx[A](val real: Pipe[A], f: (Int, A) => Any, var i: Int) extends The.Build[A] {

    def pumpOpt(lf: A => Boolean): Opt[A] = real.pumpOpt(v => { f(i, v); i += 1; lf(v) })

  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/