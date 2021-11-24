package scalqa; package `val`; package pack; package z; import language.implicitConversions

private[`val`] class ArrayPack[A](_a: Array[AnyRef], sz: Int) extends Pack[A] with Able.Doc:
  def this(a: Array[AnyRef])           = this(a,a.length)
  def this(v1:A,v2:A,v3:A,v4:A)     ={this(new Array[AnyRef](4),4); ar(0)=v1.cast[AnyRef]; ar(1)=v2.cast[AnyRef]; ar(2)=v3.cast[AnyRef]; ar(3)=v4.cast[AnyRef]}
  def this(v1:A,v2:A,v3:A,vs:Seq[A])={this(new Array[AnyRef](3 + vs.length),3 + vs.length); ar(0)=v1.cast[AnyRef]; ar(1)=v2.cast[AnyRef]; ar(2)=v3.cast[AnyRef]; for(i <- 0 <>> vs.size) ar(i + 3) = vs(i).cast[AnyRef]}

  type THIS_TYPE = Pack[A]

  private  var ar                          : Array[AnyRef]    = _a
  override def stream                      : Stream[A] & Able.Size = lang.anyref.Z.Stream_ofArray(ar,sz)
  /**/     def apply(i: Int)               : A                = ar(i).cast[A]
  /**/     def size                        : Int              = sz
  /**/     def join(v: A)                  : Pack[A]          = new ArrayPack(ar.copySize(sz+1).self(_(sz)=v.cast[AnyRef]),sz+1)
  /**/     def joinAt(i: Int, v: A)        : Pack[A]          = new ArrayPack(ar.copySize(sz+1).self(a=>{a.copyTo(a,i+1,i,a.length-i-1);a(i)=v.cast[AnyRef]}),sz+1)
  /**/     def joinAllAt(i:Int,v:Stream[A]): Pack[A]          = new ArrayPack(lang.anyref.Buffer.z_ArrayJoinAllAt(ar,i,v.cast[Stream[AnyRef]],sz))
  /**/     def takeRange(s: Int, sz: Int)  : Pack[A]          = new ArrayPack(ar.takeRange(s,sz))
  /**/     def dropRange(s: Int, sz: Int)  : Pack[A]          = new ArrayPack(ar.dropRange(s,sz))
  /**/     def doc                         : Doc              = Doc(this) += ("size", size) ++= (ar.length != sz) ? ("","Uncompacted") += ar.tag
  /**/     def pack                        : this.type        = {if(ar.length > sz) ar=ar.copySize(sz); this}
  /**/     def toBuffer                    : Buffer[A]        = new AnyRef.Buffer(ar.copySize(sz),sz)
  /**/     def joinAll(vs: Stream[A])      : Pack[A]          = vs.readOpt.map(v => ArrayPack.z_Buf(ar,sz+1,v,vs).mk) or this
  /**/     def z_foreach[U](f: A=>U)       : Unit             = {var i=0; while(i<sz){ f(ar(i).cast[A]); i+=1 }}

object ArrayPack:

  def fromStream[A](vs: Stream[A]): Pack[A] = vs.readOpt.map(v => z_Buf(Array.emptyAnyRef,1,v,vs).mk) or \/

  // *****************************************************************************************************
  private class z_Buf[A] private (a: Array[AnyRef],s:Int) extends AnyRef.Buffer[A](a,s):
    def this(a: Array[AnyRef], sz: Int, v: A, vs: Stream[A]) =
      this(a.copySize(vs.sizeOpt.map(sz + _) or sz + J.initSize).self(_(sz-1)=v.cast[AnyRef]), sz)
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
