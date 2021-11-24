package scalqa; package `val`; package idx; package z; import language.implicitConversions

private[scalqa] class DefaultStream[A](v: Idx[A]) extends Stream[A] with Able.Size:
  private         var i      = 0
  private         val sz     = v.size
  def readOpt = { var o:Opt[A] = \/; if(i<sz){ o=v(i); i+=1}; o}
  /**/            def size   = sz - i

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
