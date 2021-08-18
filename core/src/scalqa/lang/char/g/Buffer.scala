package scalqa; package lang; package char; package g; import language.implicitConversions

class Buffer[A<:Raw](arrayToUse: Array[Char], sizeToStartWith: Int) extends Val.Buffer[A] with Idx.Mutable[A]:
  protected type ARRAY_TYPE = Char
  def this(initSize: Int) = this(new Array[Char](initSize),0)
  def this()              = this(J.initSize)
  def this(v: Val.~[A])   = {this(v.size_? or J.initSize); addAll(v)}

  private               var ar                              : Array[Char]    = arrayToUse
  private               var sz                              : Int            = sizeToStartWith
  protected             def array                           : Array[Char]    = ar
  protected             def array_=(v: Array[Char])         : Unit           = ar = v
  protected             def size_=(v:Int)                   : Unit           = sz = v
  protected      final  def mkSpace(sz:Int)                 : Unit           = ar=ar.copySize(ar.length * 2 max sz)
  private[scalqa]       def addAllRef(v: Val.~[A])          : Unit           = {v.size_?.forval(i=>{val s=i+sz; if(ar.length<s) mkSpace(s); for(i <- sz<>>s) ar(i)=v.read_?.cast[Char]; sz=s}); v.FOREACH(add)}
  private[scalqa]       def addAllRaw(v: Stream[A])         : Unit           = {v.size_?.forval(i=>{val s=i+sz; if(ar.length<s) mkSpace(s); for(i <- sz<>>s) ar(i)=v.readRaw_?.cast[Char]; sz=s}); v.FOREACH(add)}
  // ----------------------------------------------------------------------------------------------------------------------------------------------
  /**/                  def apply(i: Int)                   : A              = ar(i).cast[A]
  /**/                  def size                            : Int            = sz
  @tn("stream")override def ~                               : Stream[A]      = lang.array.z.As.CharStream(ar,sz)
  /**/         override def add(v: A)                       : Unit           = { if(ar.length<=sz) mkSpace(sz+1); ar(sz)=v; sz+=1}
  /**/         override def addAt(i: Int, v: A)             : Unit           = { if(ar.length<=sz) mkSpace(sz+1); ar.copyTo(ar,i+1,i,sz-i); ar(i)=v; sz+=1 }
  /**/         override def updateAt(i: Int, v: A)          : Unit           = ar(i) = v
  /**/         override def contains(v: A)                  : Boolean        = lang.array.z.contains.char(ar,v,sz)
  /**/         override def sort      (using o: Ordering[A]): Unit           = ar.sort_<>(0,sz)(using o.cast[Ordering[Char]])
  @tn("pack")  override def ><                              : Pack[A]        = Pack.fromArray(ar,sz)

object Buffer:
  /**/            def accessible[A<:Raw](use: Array[Char], usedSize: Int)  : Buffer[A] & Able.Access[Array[Char]] = zAccessible[A](use,usedSize)
  /**/     inline def accessible[A<:Raw](inline initSize: Int = J.initSize): Buffer[A] & Able.Access[Array[Char]] = accessible(new Array[Char](initSize),0)
  implicit inline def implicitRequest[A<:Raw](inline v: NEW)               : Buffer[A]                            = new Buffer()

  // ************************************************************************************************************************
  private class zAccessible[A<:Raw](a: Array[Char], s: Int) extends Buffer[A](a,s) with Able.Access[Array[Char]]:
    def access: Array[Char] = super.array

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
