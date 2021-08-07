package scalqa; package lang; package anyref; package g; import language.implicitConversions

class Buffer[A](_a: Array[AnyRef], _s: Int) extends Val.Buffer[A]:
  protected type ARRAY_TYPE = AnyRef
  def this(initSize: Int) = this(new Array[AnyRef](initSize),0)
  def this()              = this(J.initSize)
  def this(v: Val.~[A])   = {this(v.size_? or J.initSize); addAll(v)}

  private                var ar                         : Array[AnyRef] = _a
  private                var sz                         : Int           = _s
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
  @tn("stream") override def ~                          : ~[A]          = lang.array.z.stream.As.Refs[A](ar,sz)
  /**/          override def sort  (using c:Ordering[A]): Unit          = ar.sort_<>(0,sz)(using c.cast[Ordering[AnyRef]])
  @tn("pack")            def ><                         : ><[A]         = `val`.Pack.fromArray(ar,sz)

object Buffer:
  /**/            def accessible[A](use: Array[AnyRef], usedSize: Int): Buffer[A] & Able.Access[Array[AnyRef]] = zAccessible[A](use,usedSize)
  /**/     inline def accessible[A](inline initSize: Int = J.initSize): Buffer[A] & Able.Access[Array[AnyRef]] = accessible(new Array[AnyRef](initSize),0)
  implicit inline def implicitRequest[A](inline v: NEW)               : Buffer[A]                              = new Buffer()

  // ************************************************************************************************************************
  private class zAccessible[A](a: Array[AnyRef], s: Int) extends Buffer[A](a,s) with Able.Access[Array[AnyRef]]:
    def access: Array[AnyRef] = super.array

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Buffer -> ###

  This is the main Buffer implementation for reference values.

*/