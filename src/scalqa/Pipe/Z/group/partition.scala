package scalqa; package Pipe; package Z; package group

private[Pipe] object partition {

  def apply[A](src: Pipe[A], groups: Array.Raw[A => Boolean]): Pipe[~[A]] = Array.get[Coll.Val[A]](groups.size + 1).I(a => {
    a.fill(\/)
    src(v => {
      var i = 0;
      while (i < groups.size) if (!groups(i).apply(v)) i += 1 else { a(i) += v; i = a.size }
      if (i < a.size) a(i) += v
    })
  }).all.map(_.all)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/