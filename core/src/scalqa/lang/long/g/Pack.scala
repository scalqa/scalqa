package scalqa; package lang; package long; package g; import language.implicitConversions

class Pack[A<:Raw] private(_a: Array[Primitive], sz: Int) extends Val.Pack[A] with Idx[A]:
  private def this(a: Array[Primitive]) = this(a,a.length)
  type THIS_TYPE = Pack[A]
  private  var ar                                  : Array[Primitive] = _a
  /**/     def size                                : Int              = sz
  /**/     def apply(i: Int)                       : A                = ar(i).cast[A]
  override def stream                              : Stream[A]        = ar.stream(sz).cast[Stream[A]]
  /**/     def pack                                : Pack[A]          = {if(ar.length>sz) {ar=new Array[Primitive](sz).self(ar.copyTo(_,0,0,sz))}; this}
  /**/     def toBuffer                            : Buffer[A]        = Buffer(ar.copySize(sz),sz)
  /**/     def takeRange(from:Int, sz:Int)         : Pack[A]          = new Pack(ar.takeRange(from,sz),sz)
  /**/     def dropRange(from:Int, sz:Int)         : Pack[A]          = new Pack(ar.dropRange(from,sz),sz)
  /**/     def join(v: A)                          : Pack[A]          = new Pack(ar.copySize(sz+1).self(_(sz)=v), sz+1)
  /**/     def joinAt( i: Int, v: A)               : Pack[A]          = new Pack(ar.copySize(sz+1).self(a=>{a.copyTo(a,i+1,i,a.length-i-1);a(i)=v}),sz+1)
  /**/     def joinAllAt(i:Int,vs: Val.Stream[A])  : Pack[A]          = new Pack(Buffer.z_ArrayJoinAllAt(ar,i,vs.cast[Stream[Primitive]],sz))
  /**/     def joinAll(vs: Val.Stream[A])          : Pack[A]          = vs.readOpt.map(v => Pack.Buf(ar,sz+1,v,vs).mk) or this
  /**/     def z_foreachRaw[U](f: Fun.Consume[A,U]): Unit             = {var i=0; while(i<sz){ f(ar(i).cast[A]); i+=1 }}
  /**/     def z_foreach[U](f: A=>U)               : Unit             = {var i=0; while(i<sz){ f(ar(i).cast[A]); i+=1 }}
  override def contains(v: A)                      : Boolean          = lang.array.z.contains.long(ar,v,sz)

object Pack:
  /**/                   def fromVarArg[A<:Raw](v: A, vs: Seq[A])            : Pack[A] = new Pack(Array(v.real,vs.cast[Seq[Primitive]] *))
  /**/            inline def fromArray [A<:Raw](v: Array[Primitive])         : Pack[A] = fromArray(v,v.length)
  /**/                   def fromArray [A<:Raw](v: Array[Primitive],sz: Int) : Pack[A] = new Pack(v.copySize(sz),sz)
  /**/                   def fromStream[A<:Raw](v: Val.Stream[A])            : Pack[A] = void[A].joinAll(v)
  @tn("getVoid")  inline def void      [A<:Raw]                              : Pack[A] = z_Void.cast[Pack[A]]; object z_Void extends Pack(Array.emptyLong) with Gen.Void

  implicit        inline def implicitRequest[A<:Raw](v: \/)                  : Pack[A] = void[A]
  implicit        inline def implicitFromStream[A<:Raw](inline v:G.Stream[A]): Pack[A] = v.pack

  private class Buf[A<:Raw] private(a: Array[Primitive],sz:Int) extends Buffer[A](a,sz):
    def this(a: Array[Primitive], sz: Int, v: A, vs: Val.Stream[A]) = { this(a.copySize(vs.sizeOpt.map(sz + _) or sz + J.initSize).self(_(sz-1)=v), sz); addAll(vs) }
    def mk: Pack[A] = { val s=size; if(s==0) \/ else new Pack(array,s) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Pack -> ### Long Specialized Generic Pack Collection

       To be used with Long based opaque values.

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/