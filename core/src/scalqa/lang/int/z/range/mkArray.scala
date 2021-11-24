package scalqa; package lang; package int; package z; package range; import language.implicitConversions

object mkArray:
  /**/  private inline def SZ = 1024
  @fast private   lazy val BUF                  : Array[Int] = mk(0,SZ)
  /**/  private        def mk(s:Int,sz:Int)     : Array[Int] = new Array[Int](sz).self(a => (0 <>> sz).stream.foreach(i => a(i)=s+i))

  def apply(s:Int,sz:Int): Array[Int] = if(s >= 0 && s+sz <= SZ) java.util.Arrays.copyOfRange(BUF,s,s+sz) else mk(s,sz)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/