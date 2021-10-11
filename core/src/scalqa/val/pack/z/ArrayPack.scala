package scalqa; package `val`; package pack; package z; import language.implicitConversions

private[`val`] class ArrayPack[A](_a: Array[AnyRef], sz: Int) extends ><[A] with Able.Doc:
  def this(a: Array[AnyRef])           = this(a,a.length)
  def this(v1:A,v2:A,v3:A,v4:A)     ={this(new Array[AnyRef](4),4); ar(0)=v1.cast[AnyRef]; ar(1)=v2.cast[AnyRef]; ar(2)=v3.cast[AnyRef]; ar(3)=v4.cast[AnyRef]}
  def this(v1:A,v2:A,v3:A,vs:Seq[A])={this(new Array[AnyRef](3 + vs.length),3 + vs.length); ar(0)=v1.cast[AnyRef]; ar(1)=v2.cast[AnyRef]; ar(2)=v3.cast[AnyRef]; for(i <- 0 <>> vs.size) ar(i + 3) = vs(i).cast[AnyRef]}

  type THIS_TYPE = Pack[A]

  private                var ar                          : Array[AnyRef]    = _a
  @tn("stream") override def ~                           : ~[A] & Able.Size = lang.anyref.Z.Stream_ofArray(ar,sz)
  /**/                   def apply(i: Int)               : A                = ar(i).cast[A]
  /**/                   def size                        : Int              = sz
  /**/                   def join(v: A)                  : ><[A]            = new ArrayPack(ar.copySize(sz+1).^(_(sz)=v.cast[AnyRef]),sz+1)
  /**/                   def joinAt(i: Int, v: A)        : ><[A]            = new ArrayPack(ar.copySize(sz+1).^(a=>{a.copyTo(a,i+1,i,a.length-i-1);a(i)=v.cast[AnyRef]}),sz+1)
  /**/                   def joinAllAt(i: Int, v: ~[A])  : ><[A]            = new ArrayPack(lang.anyref.Buffer.z_ArrayJoinAllAt(ar,i,v.cast[~[AnyRef]],sz))
  @tn("take_Range")      def take_<>(s: Int, sz: Int)    : ><[A]            = new ArrayPack(ar.take_<>(s,sz))
  @tn("drop_Range")      def drop_<>(s: Int, sz: Int)    : ><[A]            = new ArrayPack(ar.drop_<>(s,sz))
  /**/                   def doc                         : Doc              = Doc(this) += ("size", size) ++= (ar.length != sz) ? ("","Uncompacted") += ar.tag
  @tn("compact")         def ><                          : this.type        = {if(ar.length > sz) ar=ar.copySize(sz); this}
  /**/                   def toBuffer                    : Buffer[A]        = new AnyRef.Buffer(ar.copySize(sz),sz)
  /**/                   def joinAll(vs: ~[A])           : ><[A]            = vs.read_?.map(v => ArrayPack.z_Buf(ar,sz+1,v,vs).mk) or this

object ArrayPack:

  def fromStream[A](vs: ~[A]): ><[A] = vs.read_?.map(v => z_Buf(Array.emptyAnyRef,1,v,vs).mk) or \/

  // *****************************************************************************************************
  private class z_Buf[A] private (a: Array[AnyRef],s:Int) extends AnyRef.Buffer[A](a,s):
    def this(a: Array[AnyRef], sz: Int, v: A, vs: ~[A]) =
      this(a.copySize(vs.size_?.map(sz + _) or sz + J.initSize).^(_(sz-1)=v.cast[AnyRef]), sz)
      addAll(vs)

    def mk: Pack[A] =
      val s=size
      if(s==0) Pack.void else new ArrayPack(array,s)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
