package scalqa; package Pipe; package Z; package process

private[Pipe] object on {

  // ***********************************************************************************************
  private[Pipe] class every[A](val real: Pipe[A], tl: Time.Length, f: (Int, Time.Length) => Any) extends The.Build[A] {
    private var i = 0
    var start, time: Time = \/

    def pumpOpt(lf: A => Boolean): Opt[A] = real.pumpOpt(v => {
      if (i == 0) { time = CURRENT; start = time }
      else if (time.age > tl) { time = CURRENT; f(i, start.age.roundDown(tl / 10)) }
      i += 1;
      lf(v)
    })
  }

  // ***********************************************************************************************
  class beforeFirst[A](val real: Pipe[A], fun: Time => Any) extends The.Build[A] {
    var hot = true

    def pumpOpt(lf: A => Boolean): Opt[A] = real.pumpOpt(v => { if (hot) { hot = false; fun(Time.get) }; lf(v) })

  }

  // ***********************************************************************************************
  class afterLast[A](val real: Pipe[A], tlf: (Int, Time.Length) => Any) extends The.Build[A] {
    var cnt = 0; var t: Time = \/

    def pumpOpt(lf: A => Boolean): Opt[A] = real.pumpOpt(v => { if (cnt == 0) t = CURRENT; cnt += 1; lf(v) }) voidRun { if (cnt > 0) tlf(cnt, t.age) }

  }

  // ***********************************************************************************************
  class empty[A](val real: Pipe[A], f: => Any) extends The.Build[A] {
    var empty = true

    def pumpOpt(lf: A => Boolean): Opt[A] = real.pumpOpt(v => { empty = false; lf(v) }).voidRun(if (empty) { empty = false; f })

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/