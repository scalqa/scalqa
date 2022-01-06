package scalqa; package lang; package anyref; package g; import language.implicitConversions

class Buffer[A](arrayToUse: Array[AnyRef], sizeToStartWith: Int) extends Val.Buffer[A]:
  protected type ARRAY_TYPE  = AnyRef
  def this(initSize: Int)    = this(new Array[AnyRef](initSize),0)
  def this()                 = this(J.initSize)
  def this(v: Val.Stream[A]) = {this(v.sizeOpt or J.initSize); addAll(v)}

  private         var ar                         : Array[AnyRef] = arrayToUse
  private         var sz                         : Int           = sizeToStartWith
  protected       def array                      : Array[AnyRef] = ar
  protected       def array_=(v: Array[AnyRef])  : Unit          = ar = v
  protected       def size_=(v:Int)              : Unit          = sz = v
  protected final def mkSpace(sz:Int)            : Unit          = { ar=ar.copySize(ar.length * 2 max sz); }
  private[scalqa] def addAllRef(v: Val.Stream[A]): Unit          = {v.sizeOpt.forval(s=>{val ns=sz+s; if(ar.length<ns) mkSpace(ns); var i=sz; while(i<ns){ar(i)=v.readOpt.cast[AnyRef]; i+=1}; sz=ns});v.FOREACH(add)}
  // -----------------------------------------------------------------------------------------------------------------------------------------------------------------
  /**/            def apply(i: Int)              : A             = ar(i).cast[A]
  /**/            def size                       : Int           = sz
  /**/            def contains(v:A)              : Boolean       = lang.array.z.contains.anyref(ar,v.cast[AnyRef],sz)
  /**/   override def add(v: A)                  : Unit          = { if(ar.length<=sz) mkSpace(sz+1); ar(sz)=v.cast[AnyRef]; sz+=1}
  /**/            def addAt(i: Int, v: A)        : Unit          = { if(ar.length<=sz) mkSpace(sz+1); ar.copyTo(ar,i+1,i,sz-i); ar(i)=v.cast[AnyRef]; sz+=1 }
  /**/            def updateAt(i: Int, v: A)     : Unit          = ar(i) = v.cast[AnyRef]
  /**/   override def stream                     : Val.Stream[A] = Z.Stream_ofArray[A](ar,sz)
  /**/   override def sort  (using c:Ordering[A]): Unit          = ar.sortRange(0,sz)(using c.cast[Ordering[AnyRef]])
  /**/            def pack                       : Pack[A]       = `val`.Pack.fromArray(ar,sz)
  /**/            def z_foreach[U](f: A=>U)      : Unit          = {var i=0; while(i<sz){ f(ar(i).cast[A]); i+=1 }}

object Buffer:
  implicit inline def implicitRequest[A](inline v: NEW): Buffer[A] = new Buffer()

  def z_StreamToArray[A](v: Stream[A])(using t: ClassTag[A]): Array[A] =
    val b = new Buffer[A](new Array[A](v.sizeOpt or J.initSize).cast[Array[AnyRef]],0)
    b.addAll(v)
    b.ar.self.mapIf(_.length!=b.size, _.copySize(b.size)).cast[Array[A]]

  def z_ArrayJoinAll [A](x:Array[A],v: Stream[A]): Array[A] = new Buffer(x.cast[Array[AnyRef]],x.length).self(_ ++= v).self.map(b => b.ar.self.mapIf(a => a.length!=b.size || (a eq x), _.copySize(b.size))).cast[Array[A]]
  def z_ArrayJoinAllAt(x:Array[AnyRef],i:Int,v: Stream[AnyRef],sz:Int): Array[AnyRef] = new Buffer(new Array[AnyRef](v.sizeOpt.map(_ + sz) or i+J.initSize),i).self(_ ++= v).self.map(b => {
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