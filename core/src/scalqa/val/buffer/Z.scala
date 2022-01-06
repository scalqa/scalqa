package scalqa; package `val`; package buffer; import language.implicitConversions

object Z:

  def swap[A](a:Array[A], from: Int, to: Int, end:Int): Unit =
    val s1 = to - from      // old elements size
    val s2 = end - to       // new elements size
    val s3 = a.length - end // unused space size
    if(s1 < s2)
       if(s3 >= s1){ a.copyTo(a, end, from, s1);   a.copyTo(a, from, to, s2);     a.copyTo(a, from+s2, end, s1)}
       else        { val na = a.takeRange(from,s1);  a.copyTo(a, from, to, s2);    na.copyTo(a, from+s2, 0,   s1)}
    else
       if(s3 >= s2){ a.copyTo(a, end,to, s2);      a.copyTo(a, from+s2,from,s1);  a.copyTo(a, from, end, s2)}
       else        { val na = a.takeRange(to,s2);    a.copyTo(a, from+s2,from,s1); na.copyTo(a, from, 0,   s2)}

  def create[A](a:Array[A], s:Int): Buffer[A] = a match
    case a: Array[AnyRef]   => new AnyRef .G.Buffer[A](a,s)
    case a: Array[Int]      => new Int    .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Long]     => new Long   .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Double]   => new Double .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Boolean]  => new Boolean.G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Byte]     => new Byte   .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Char]     => new Char   .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Float]    => new Float  .G.Buffer(a,s).cast[Buffer[A]]
    case a: Array[Short]    => new Short  .G.Buffer(a,s).cast[Buffer[A]]
    case _                  => J.illegalState()

  inline def foreach[A,U](inline x: Buffer[A], inline f: A => U): Unit =
    inline x match
              case x : Boolean.G.Buffer[A] => x.z_foreachRaw(f(_))
              case x : Byte   .G.Buffer[A] => x.z_foreachRaw(f(_))
              case x : Char   .G.Buffer[A] => x.z_foreachRaw(f(_))
              case x : Short  .G.Buffer[A] => x.z_foreachRaw(f(_))
              case x : Int    .G.Buffer[A] => x.z_foreachRaw(f(_))
              case x : Long   .G.Buffer[A] => x.z_foreachRaw(f(_))
              case x : Float  .G.Buffer[A] => x.z_foreachRaw(f(_))
              case x : Double .G.Buffer[A] => x.z_foreachRaw(f(_))
              case x                       => x.z_foreach(f(_))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
