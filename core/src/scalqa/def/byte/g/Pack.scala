package scalqa; package `def`; package byte; package g; import language.implicitConversions

class Pack[A<:RAW] private(_a: Array[SELF], sz: Int) extends ><[A] with Idx[A]:
  private def this(a: Array[SELF]) = this(a,a.length)
  type THIS_TYPE = Pack[A]
  private                var ar                       : Array[SELF] = _a
  /**/                   def size                     : Int         = sz
  /**/                   def apply(i: Int)            : A           = ar(i).cast[A]
  @tn("stream") override def ~                        : Stream[A]   = ar.~(sz).cast[Stream[A]]
  /**/          override def contains(v: A)           : Boolean     = `def`.array.z.contains.byte(ar,v,sz)
  /**/                   def compact                  : this.type   = {if(ar.length>sz) {ar=new Array[SELF](sz).^(ar.copyTo(_,0,0,sz))}; this}
  /**/                   def toBuffer                 : Buffer[A]   = Buffer(ar.copySize(sz),sz)
  @tn("take_Range")      def take_<>(from:Int, sz:Int): Pack[A]     = new Pack(ar.take_<>(from,sz),sz)
  @tn("drop_Range")      def drop_<>(from:Int, sz:Int): Pack[A]     = new Pack(ar.drop_<>(from,sz),sz)
  /**/                   def join(v: A)               : Pack[A]     = new Pack(ar.copySize(sz+1).^(_(sz)=v), sz+1)
  /**/                   def joinAt( i: Int, v: A)    : Pack[A]     = new Pack(ar.copySize(sz+1).^(a=>{a.copyTo(a,i+1,i,a.length-i-1);a(i)=v}),sz+1)
  /**/                   def joinAllAt(i:Int,vs: ~[A]): Pack[A]     = new Pack(`def`.array.z.joinAllAt.byte(ar,i,vs.cast[~[SELF]],sz))
  /**/                   def joinAll(vs: ~[A])        : Pack[A]     = vs.read_?.map(v => Pack.Buf(ar,sz+1,v,vs).mk) or this

object Pack:
  /**/            def fromVarArg[A<:RAW](v: A, vs: Seq[A])      : Pack[A] = new Pack(Array(v.real,vs.cast[Seq[SELF]] *))
  /**/            def fromArray [A<:RAW](v: Array[SELF],sz: Int): Pack[A] = new Pack(v.copySize(sz),sz)
  /**/            def fromStream[A<:RAW](v: ~[A])               : Pack[A] = void[A].joinAll(v)
  @tn("getVoid")  def void      [A<:RAW]                        : Pack[A] = zVoid.cast[Pack[A]]; private object zVoid extends Pack(SELF.emptyArray) with Void
  implicit inline def xxRequest [A<:RAW](inline v: \/)          : Pack[A] = void[A]
  implicit inline def xxStream  [A<:RAW](inline v: Stream[A])   : Pack[A] = v.><

  private class Buf[A<:RAW] private(a: Array[SELF],sz:Int) extends Buffer[A](a,sz):
    def this(a: Array[SELF], sz: Int, v: A, vs: ~[A]) = { this(a.copySize(vs.size_?.map(sz + _) or sz + J.initSize).^(_(sz-1)=v), sz); addAll(vs) }
    def mk: Pack[A] =
      val s=size; val a=array
      if(s==0) \/ else if(a.length==s || J.Setup.allowUncompactedPack) new Pack(a,s) else new Pack(a.copySize(s),s)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

@def xxRequest -> General void instance request \n\n It is possible to use general request \/ to get void instance of this type, thanks to this implicit conversion.

*/