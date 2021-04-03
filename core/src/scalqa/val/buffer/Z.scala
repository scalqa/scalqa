package scalqa; package `val`; package buffer; import language.implicitConversions

object Z:

  def swap[A](a:Array[A], from: Int, to: Int, end:Int): Unit =
    val s1 = to - from      // old elements size
    val s2 = end - to       // new elements size
    val s3 = a.length - end // unused space size
    if(s1 < s2)
       if(s3 >= s1){ a.copyTo(a, end, from, s1);   a.copyTo(a, from, to, s2);     a.copyTo(a, from+s2, end, s1)}
       else        { val na = a.take_<>(from,s1);  a.copyTo(a, from, to, s2);    na.copyTo(a, from+s2, 0,   s1)}
    else
       if(s3 >= s2){ a.copyTo(a, end,to, s2);      a.copyTo(a, from+s2,from,s1);  a.copyTo(a, from, end, s2)}
       else        { val na = a.take_<>(to,s2);    a.copyTo(a, from+s2,from,s1); na.copyTo(a, from, 0,   s2)}

  def create[A](a:Array[A], s:Int): Buffer[A] = a match
    case a: Array[Ref]      => new Any.Ref.  Buffer[A](a,s)
    case a: Array[Int]      => new Int    .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Long]     => new Long   .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Double]   => new Double .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Boolean]  => new Boolean.G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Byte]     => new Byte   .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Char]     => new Char   .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Float]    => new Float  .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Short]    => new Short  .G.Buffer(a,s).cast[Buffer[A]]
    case _                  => J.illegalState()

  def accessible[A](a: Array[A], sz: Int): Buffer[A] & Able.Access[Array[A]] =
    { a match
      case a: Array[Ref]      => `def`.any.ref.  Buffer.accessible[A](a,sz)
      case a: Array[Int]      => `def`.int    .g.Buffer.accessible(a,sz)
      case a: Array[Long]     => `def`.long   .g.Buffer.accessible(a,sz)
      case a: Array[Double]   => `def`.double .g.Buffer.accessible(a,sz)
      case a: Array[Boolean]  => `def`.boolean.g.Buffer.accessible(a,sz)
      case a: Array[Byte]     => `def`.byte   .g.Buffer.accessible(a,sz)
      case a: Array[Char]     => `def`.char   .g.Buffer.accessible(a,sz)
      case a: Array[Float]    => `def`.float  .g.Buffer.accessible(a,sz)
      case a: Array[Short]    => `def`.short  .g.Buffer.accessible(a,sz)
      case _                  => J.illegalState()
    }.cast[Buffer[A] & Able.Access[Array[A]]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
