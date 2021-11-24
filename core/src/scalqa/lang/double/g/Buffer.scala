package scalqa; package lang; package double; package g; import language.implicitConversions

class Buffer[A<:Raw](arrayToUse: Array[Primitive], sizeToStartWith: Int) extends Val.Buffer[A] with Idx.Mutable[A]:
  protected type ARRAY_TYPE = Primitive
  def this(initSize: Int)   = this(new Array[Primitive](initSize),0)
  def this()                = this(J.initSize)
  def this(v: Val.Stream[A])= { this(v.sizeOpt or J.initSize); addAll(v) }

  private         var ar                                 : Array[Primitive] = arrayToUse
  private         var sz                                 : Int              = sizeToStartWith
  protected       def array                              : Array[Primitive] = ar
  protected       def array_=(v: Array[Primitive])       : Unit             = ar = v
  protected       def size_=(v:Int)                      : Unit             = sz = v
  protected final def mkSpace(sz:Int)                    : Unit             = ar=ar.copySize(ar.length * 2 max sz)
  private[scalqa] def addAllRef(v: Val.Stream[A])        : Unit             = {v.sizeOpt.forval(i=>{val s=i+sz; if(ar.length<s) mkSpace(s); for(i <- sz<>>s) ar(i)=v.readOpt.`val`; sz=s}); v.FOREACH(add)}
  private[scalqa] def addAllRaw(v: Stream[A])            : Unit             = {v.sizeOpt.forval(i=>{val s=i+sz; if(ar.length<s) mkSpace(s); for(i <- sz<>>s) ar(i)=v.readRawOpt.`val`; sz=s}); v.FOREACH(add)}
  // ----------------------------------------------------------------------------------------------------------------------------------------------
  /**/            def apply(i: Int)                      : A                = ar(i).cast[A]
  /**/            def size                               : Int              = sz
  /**/   override def stream                             : Stream[A]        = Z.Stream_ofArray(ar,sz)
  /**/   override def add(v: A)                          : Unit             = { if(ar.length<=sz) mkSpace(sz+1); ar(sz)=v; sz+=1}
  /**/   override def addAt(i: Int, v: A)                : Unit             = { if(ar.length<=sz) mkSpace(sz+1); ar.copyTo(ar,i+1,i,sz-i); ar(i)=v; sz+=1 }
  /**/   override def updateAt(i: Int, v: A)             : Unit             = ar(i) = v
  /**/   override def sort        (using o: Ordering[A]) : Unit             = ar.sortRange(0,sz)(using o.cast[Ordering[Primitive]])
  /**/   override def pack                               : Pack[A]          = Pack.fromArray(ar,sz)
  /**/            def z_foreach[U](f: A=>U)              : Unit             = {var i=0; while(i<sz){ f(ar(i).cast[A]); i+=1 }}
  /**/            def z_foreachRaw[U](f:Fun.Consume[A,U]): Unit             = {var i=0; while(i<sz){ f(ar(i).cast[A]); i+=1 }}
  /**/   override def contains(v: A)                     : Boolean          = lang.array.z.contains.double(ar,v,sz)

object Buffer:
  implicit inline def implicitRequest[A<:Raw](inline v: NEW)                  : Buffer[A]                              = new Buffer()

  def z_StreamToArray(v: G.Stream[Primitive])                                   : Array[Primitive] = new Buffer(v).self.map(b => b.ar.self.mapIf(_.length!=b.size, _.copySize(b.size)))
  def z_ArrayJoinAll (x:Array[Primitive],v: Val.Stream[Primitive])              : Array[Primitive] = new Buffer(x,x.length).self(_ ++= v).self.map(b => b.ar.self.mapIf(a => a.length!=b.size || (a eq x), _.copySize(b.size)))
  def z_ArrayJoinAllAt(x:Array[Primitive],i:Int,v: Val.Stream[Primitive],sz:Int): Array[Primitive] = new Buffer(new Array[Primitive](v.sizeOpt.map(_ + sz) or i+J.initSize),i).self(_ ++= v).self.map(b => {
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
@class Buffer -> ### Double Specialized Generic Buffer

     To be used with Double based opaque values.

*/

