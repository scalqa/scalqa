package scalqa; package lang; package int; package z; import language.implicitConversions

object Range:
  // --------------------------------------------------------------------------------------------------------------------------
  /**/  private inline def SZ = 1024
  @fast private   lazy val BUF                  : Array[Int] = mk(0,SZ)
  /**/  private        def mk(s:Int,sz:Int)     : Array[Int] = { val a = new Array[Int](sz); (0 <>> sz).~.foreach(i => a(i)=s+i); a}
  /**/                 def mkArray(s:Int,sz:Int): Array[Int] = if(s>=0 && s+sz<=SZ) java.util.Arrays.copyOfRange(BUF,s,s+sz) else mk(s,sz)

  // **************************************************************************************************************************
  object Void extends G.<>[Int](0,0) with Void

  // **************************************************************************************************************************
  class Stream[A<:RAW](s: Int, eX: Long, step: Long) extends g.Stream[A] with Able.Size with Able.Doc:
    private              var i         : Long         = s
    @tn("readRaw_Opt")   def readRaw_? : G.Opt[A]     = { var o:G.Opt[A]= \/; if(i<eX) { o = i.cast[G.Opt[A]]; i+=step };  o}
    /**/                 def size      : Int          = { val sz=eX-i;  (sz/step + (if(sz%step > 0) 1 else 0)).Int}
    override             def toArray   : Array[A]     = if(i<eX && step==1) new G.<>(i.cast[A],(eX-i).Int).toArray  else super.toArray
    @tn("pack") override def ><        : G.><[A]      = if(i<eX && step==1) new G.<>(i.cast[A],(eX-i).Int).><   else super.><
    override             def toBuffer  : G.Buffer[A]  = if(i<eX && step==1) new G.<>(i.cast[A],(eX-i).Int).toBuffer else super.toBuffer
    /**/                 def doc      : Doc         = this.defaultDoc += (i<eX) ? ("from",i.tag) += step.?.drop(_ == 1).map(i=>("step",i.tag))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/