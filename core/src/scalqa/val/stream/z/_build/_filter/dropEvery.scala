package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class dropEvery[A](x: Stream[A], n: Int) extends z.x.Pipe[A](x) with Able.Size.Opt.Long:
  private var i = 0
  /**/     def readOpt     = { var o=x.readOpt; i+=1; while(o && i % n == 0){ i+=1; o=x.readOpt}; o}
  /**/     def sizeLongOpt = x.sizeLongOpt.map(v => v - v / n )
  override def doc         = super.doc += ("every",n)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
