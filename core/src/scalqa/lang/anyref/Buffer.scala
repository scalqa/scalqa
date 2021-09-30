package scalqa; package lang; package anyref; import language.implicitConversions

class Buffer[A](arrayToUse: Array[AnyRef], sizeToStartWith: Int) extends Val.Buffer[A]:
  protected type ARRAY_TYPE = AnyRef
  def this(initSize: Int) = this(new Array[AnyRef](initSize),0)
  def this()              = this(J.initSize)
  def this(v: Val.~[A])   = {this(v.size_? or J.initSize); addAll(v)}

  private                var ar                         : Array[AnyRef] = arrayToUse
  private                var sz                         : Int           = sizeToStartWith
  protected              def array                      : Array[AnyRef] = ar
  protected              def array_=(v: Array[AnyRef])  : Unit          = ar = v
  protected              def size_=(v:Int)              : Unit          = sz = v
  protected       final  def mkSpace(sz:Int)            : Unit          = { ar=ar.copySize(ar.length * 2 max sz); }
  private[scalqa]        def addAllRef(v: Val.~[A])     : Unit          = {v.size_?.forval(s=>{val ns=sz+s; if(ar.length<ns) mkSpace(ns); var i=sz; while(i<ns){ar(i)=v.read_?.cast[AnyRef]; i+=1}; sz=ns});v.FOREACH(add)}
  // -----------------------------------------------------------------------------------------------------------------------------------------------------------------
  /**/                   def apply(i: Int)              : A             = ar(i).cast[A]
  /**/                   def size                       : Int           = sz
  /**/                   def contains(v:A)              : Boolean       = lang.array.z.contains.anyref(ar,v.cast[AnyRef],sz)
  /**/          override def add(v: A)                  : Unit          = { if(ar.length<=sz) mkSpace(sz+1); ar(sz)=v.cast[AnyRef]; sz+=1}
  /**/                   def addAt(i: Int, v: A)        : Unit          = { if(ar.length<=sz) mkSpace(sz+1); ar.copyTo(ar,i+1,i,sz-i); ar(i)=v.cast[AnyRef]; sz+=1 }
  /**/                   def updateAt(i: Int, v: A)     : Unit          = ar(i) = v.cast[AnyRef]
  @tn("stream") override def ~                          : ~[A]          = Z.Stream_ofArray[A](ar,sz)
  /**/          override def sort  (using c:Ordering[A]): Unit          = ar.sort_<>(0,sz)(using c.cast[Ordering[AnyRef]])
  @tn("pack")            def ><                         : ><[A]         = `val`.Pack.fromArray(ar,sz)

object Buffer:
  implicit inline def implicitRequest[A](inline v: NEW): Buffer[A] = new Buffer()

  def zzStreamToArray[A](v: ~[A])(using t: ClassTag[A]): Array[A] =
    val b = new Buffer[A](new Array[A](v.size_? or J.initSize).cast[Array[AnyRef]],0)
    b.addAll(v)
    b.ar.^.mapIf(_.length!=b.size, _.copySize(b.size)).cast[Array[A]]

  def zzArrayJoinAll [A](x:Array[A],v: ~[A]): Array[A] = new Buffer(x.cast[Array[AnyRef]],x.length).^(_ ++= v).^.map(b => b.ar.^.mapIf(a => a.length!=b.size || (a eq x), _.copySize(b.size))).cast[Array[A]]
  def zzArrayJoinAllAt(x:Array[AnyRef],i:Int,v: ~[AnyRef],sz:Int): Array[AnyRef] = new Buffer(new Array[AnyRef](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v).^.map(b => {
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
@class Buffer -> ###

  This is the main Buffer implementation for reference types.

*/