package scalqa; package lang; package byte; package g; import language.implicitConversions

class Buffer[A<:Raw](arrayToUse: Array[Primitive], sizeToStartWith: Int) extends Val.Buffer[A] with Idx.Mutable[A]:
  protected type ARRAY_TYPE = Primitive
  def this(initSize: Int)   = this(new Array[Primitive](initSize),0)
  def this()                = this(J.initSize)
  def this(v: Val.~[A])     = { this(v.size_? or J.initSize); addAll(v) }

  private               var ar                              : Array[Primitive] = arrayToUse
  private               var sz                              : Int              = sizeToStartWith
  protected             def array                           : Array[Primitive] = ar
  protected             def array_=(v: Array[Primitive])    : Unit             = ar = v
  protected             def size_=(v:Int)                   : Unit             = sz = v
  protected      final  def mkSpace(sz:Int)                 : Unit             = ar=ar.copySize(ar.length * 2 max sz)
  private[scalqa]       def addAllRef(v: Val.~[A])          : Unit             = {v.size_?.forval(i=>{val s=i+sz; if(ar.length<s) mkSpace(s); for(i <- sz<>>s) ar(i)=v.read_?.`val`; sz=s}); v.FOREACH(add)}
  private[scalqa]       def addAllRaw(v: Stream[A])         : Unit             = {v.size_?.forval(i=>{val s=i+sz; if(ar.length<s) mkSpace(s); for(i <- sz<>>s) ar(i)=v.readRaw_?.`val`; sz=s}); v.FOREACH(add)}
  // ----------------------------------------------------------------------------------------------------------------------------------------------
  /**/                  def apply(i: Int)                   : A                = ar(i).cast[A]
  /**/                  def size                            : Int              = sz
  @tn("stream")override def ~                               : Stream[A]        = Z.Stream_ofArray(ar,sz)
  /**/         override def add(v: A)                       : Unit             = { if(ar.length<=sz) mkSpace(sz+1); ar(sz)=v; sz+=1}
  /**/         override def addAt(i: Int, v: A)             : Unit             = { if(ar.length<=sz) mkSpace(sz+1); ar.copyTo(ar,i+1,i,sz-i); ar(i)=v; sz+=1 }
  /**/         override def updateAt(i: Int, v: A)          : Unit             = ar(i) = v
  /**/         override def sort      (using o: Ordering[A]): Unit             = ar.sort_<>(0,sz)(using o.cast[Ordering[Primitive]])
  @tn("pack")  override def ><                              : Pack[A]          = Pack.fromArray(ar,sz)
  /**/         override def contains(v: A)                  : Boolean          = lang.array.z.contains.byte(ar,v,sz)

object Buffer:
  implicit inline def implicitRequest[A<:Raw](inline v: NEW)           : Buffer[A]        = new Buffer()

  def zzStreamToArray(v: G.~[Primitive])                               : Array[Primitive] = new Buffer(v).^.map(b => b.ar.^.mapIf(_.length!=b.size, _.copySize(b.size)))
  def zzArrayJoinAll (x:Array[Primitive],v: ~[Primitive])              : Array[Primitive] = new Buffer(x,x.length).^(_ ++= v).^.map(b => b.ar.^.mapIf(a => a.length!=b.size || (a eq x), _.copySize(b.size)))
  def zzArrayJoinAllAt(x:Array[Primitive],i:Int,v: ~[Primitive],sz:Int): Array[Primitive] = new Buffer(new Array[Primitive](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v).^.map(b => {
      var a=b.ar
      val s=b.size+sz-i
      if(a.length != s) a=a.copySize(s)
      x.copyTo(a,0,0,i)
      x.copyTo(a,b.size,i,sz-i)
      a
    })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Buffer -> ### Byte Specialized Generic Buffer

      To be used with Byte based opaque values.
*/
