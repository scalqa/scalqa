package scalqa; package `val`; package pack; package z; import language.implicitConversions

private[`val`] class Tail[A](l: ><[A], off: Int) extends ><[A] :
  type THIS_TYPE = ><[A]
  private                def resolve                     : ><[A]          = l.drop_<>(0,off)
  override               def tail                        : ><[A]          = if(size<=1) \/ else new Tail[A](l,off+1)
  /**/                   def apply(i: Int)               : A              = l(i + off)
  /**/                   def size                        : Int            = l.size - off
  /**/                   def join(v: A)                  : ><[A]          = resolve.join(v)
  /**/                   def joinAll(v: ~[A])            : ><[A]          = resolve.joinAll(v)
  /**/                   def joinAt(i: Int, v: A)        : ><[A]          = resolve.joinAt(i,v)
  /**/                   def joinAllAt(i: Int, v: ~[A])  : ><[A]          = resolve.joinAllAt(i,v)
  @tn("take_Range")      def take_<>(s: Int, sz: Int)    : ><[A]          = resolve.take_<>(s,sz)
  @tn("drop_Range")      def drop_<>(s: Int, sz: Int)    : ><[A]          = resolve.drop_<>(s,sz)
  @tn("compact")         def ><                          : this.type      = {l.><; this }
  /**/                   def toBuffer                    : Buffer[A]      = resolve.toBuffer

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
