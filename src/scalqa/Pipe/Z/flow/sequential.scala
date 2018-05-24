package scalqa; package Pipe; package Z; package flow

import java.util.{ function => JF }

private[Pipe] class sequential[A](src: (A => Any) => Any) extends Pipe.The.Base[A] {
  var started, filled = false; val buf = new Buffer[A]

  def pumpOpt(lf: A => Boolean): Opt[A] = {
    if (!started) synchronized(if (!started) {
      started = true;
      Concurrent.get {
        src(v => synchronized(buf.add(v)))
        filled = true
      }
    })
    while (!filled || buf.size > 0) {
      while (buf.size > 0) {
        val v = synchronized(buf.pop)
        if (lf(v)) return v
      }
      Pause(1.Millis)
    }
    \/
  }
}

private[Pipe] object sequential {

  def apply[A](src: Flow[A]): Pipe[A] = src match {
    case p: Pipe[A] => p
    case a: ~[_]    => (a.cast[~[A]]: Pipe[A])
    case l          => new sequential(l.apply)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
