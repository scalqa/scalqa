package scalqa; package Stream; package Z; package consume; package foreach

private[Stream] object Idx {

  def apply[@specialized(DATA) A](s: Stream[A], c: Consumer.Idx[A], start: Int = 0) = {

    class Run extends Consumer[A] {
      var i = start;
      def accept(v: A) = { c.accept(i, v); i += 1 }
    }

    s.foreach(new Run)
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/