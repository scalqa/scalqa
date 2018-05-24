package scalqa; package Pipe; package From; package Z

private[scalqa] object JavaSpliterator extends Pipe.From[java.util.Spliterator] {

  def apply[A](v: java.util.Spliterator[A]): Pipe[A] = new all(v)

  // ********************************************************************************************************
  class all[A](src: java.util.Spliterator[A]) extends Pipe.The.Base[A] with java.util.function.Consumer[A] {
    var opt: Opt[A] = \/

    def accept(a: A): Unit = opt = a

    def pumpOpt(f: A => Boolean): Opt[A] = { while ({ src.tryAdvance(this); opt } && !opt.let(f)) opt = \/; opt.run(opt = \/) }

  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
