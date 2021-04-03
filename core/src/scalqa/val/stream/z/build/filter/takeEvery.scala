package scalqa; package `val`; package stream; package z; package build; package filter; import language.implicitConversions

class takeEvery[A](x: ~[A], n: Int) extends a.Pipe[A](x) with Able.Size.Opt.Long:
  private var i = 0
  @tn("read_Opt")     def read_?     = {var o = x.read_?; i += 1; while(o.nonEmpty && i % n != 0){ i+=1; o = x.read_?}; o}
  @tn("sizeLong_Opt") def sizeLong_? = x.sizeLong_?.map(_ / n )
  override            def info       = super.info += ("every",n)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
