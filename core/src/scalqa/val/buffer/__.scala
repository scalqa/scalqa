package scalqa; package `val`; import language.implicitConversions

abstract class Buffer[A] private[scalqa]() extends Idx.Mutable[A] with Able.Contain[A]:
  protected type ARRAY_TYPE
  protected                 def array                            : Array[ARRAY_TYPE]
  protected                 def array_=(v: Array[ARRAY_TYPE])    : Unit
  protected                 def size_=(v: Int)                   : Unit
  protected                 def mkSpace(sz:Int)                  : Unit
  private[scalqa]           def addAllRef(v: ~[A])               : Unit
  @tn("pack")               def ><                               : ><[A]
  // ----------------------------------------------------------------------------------
  /**/             override def clear                            : Unit = size = 0
  @tn("remove_Range")       def remove_<>(v: Int.<>)             : Unit = if (v.size > 0){val s=size; v.checkIn(s); val a=array; a.copyTo(a,v.start,v.endX,s-v.endX); size = s-v.size}
  /**/             override def addAll(v: ~[A])                  : Unit = v match{ case v: Stream.Custom.Discharge[_] => v.cast[Stream.Custom.Discharge[A]].dischargeTo(this); case v => addAllRef(v)}
  /**/             override def addAllAt(i: Int, v: ~[A])        : Unit = {val sz=size; addAll(v); if(size>sz && i<sz) buffer.Z.swap(array,i,sz,size) }

  final def addArray_trusted(a: Array[A], start: Int, len: Int): Unit =
    var ar=array; val sz=size
    if(ar.length < sz+len) { mkSpace(sz+len); ar=array}
    a match
      case a if ar.getClass.isAssignableFrom(a.getClass) => System.arraycopy(a,start,ar,sz,len)
      case a: Array[Ref]     => for(i <- 0 <>> len) updateAt(sz+i, a(start+i).cast[A])
      case a: Array[Int]     => for(i <- 0 <>> len) updateAt(sz+i, a(start+i).cast[A])
      case a: Array[Double]  => for(i <- 0 <>> len) updateAt(sz+i, a(start+i).cast[A])
      case a: Array[Long]    => for(i <- 0 <>> len) updateAt(sz+i, a(start+i).cast[A])
      case a: Array[Float]   => for(i <- 0 <>> len) updateAt(sz+i, a(start+i).cast[A])
      case a: Array[Char]    => for(i <- 0 <>> len) updateAt(sz+i, a(start+i).cast[A])
      case a: Array[Byte]    => for(i <- 0 <>> len) updateAt(sz+i, a(start+i).cast[A])
      case a: Array[Short]   => for(i <- 0 <>> len) updateAt(sz+i, a(start+i).cast[A])
      case a: Array[Boolean] => for(i <- 0 <>> len) updateAt(sz+i, a(start+i).cast[A])
      case _ => J.illegalState()
    size = sz+len

object Buffer:
  /**/     inline def apply[A]()                                             : Buffer[A]                         = new Ref.Buffer(J.initSize)
  /**/     inline def apply[A](inline initSize: Int)                         : Buffer[A]                         = new Ref.Buffer(initSize)
  /**/     inline def apply[A](inline a:Array[A], inline s:Int)              : Buffer[A]                         = buffer.Z.create(a,s)
  /**/            def accessible[A](use: Array[A], usedSize: Int)            : Buffer[A] & Able.Access[Array[A]] = buffer.Z.accessible(use,usedSize)
  /**/     inline def accessible[A:ClassTag](inline initSize: Int=J.initSize): Buffer[A] & Able.Access[Array[A]] = accessible(new Array[A](initSize),0)
  implicit inline def implicitRequest[A](inline v: NEW)                      : Buffer[A]                         = apply[A]()

  given givenDocTag[A](using t: Given.DocTag[A]) : Given.DocTag[Buffer[A]] with
    def tag(v: Buffer[A]) = doc(v).tag
    def doc(v: Buffer[A]) = Doc(v) += ("size", v.size) += v.array.tag

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@class Buffer -> ### Value Buffer

      [[Buffer]] is the default implementation of [[scalqa.val.idx.Mutable Mutable Indexed Collection]]

@def addAll -> Append [[Stream]]

     Adds all elements to Buffer end


@def addAllAt ->  Insert [[Stream]]

     Inserts all elements at specified buffer position

@def addArray_trusted -> Add array elements

     Programms are expected to pass even private sensitive arrays, because this method is final and can be exemined not to abuse the trust

     The given arguments specify range of elements to be added.

     Whenever possible the adding will be done with bulk copy from given array to buffer array

@def clear -> Empty buffer

    Note. Even buffer becomes zero sized, the storage array will not shrink and will still reference the old elements (untill overwritten with new).

@def remove_<> -> Remove range

      Removes elements at given range
      ```
        val x = (0 <> 10).~.toBuffer

        x.remove(7 <> 8)
        x.remove(2 <> 4)

        x.~.TP // Prints ~(0, 1, 5, 6, 9, 10)
      ```

@def >< -> Pack Buffer elements

     Both Buffer and Pack are mostly Array based, so the direct convertions between them are very efficient

*/
