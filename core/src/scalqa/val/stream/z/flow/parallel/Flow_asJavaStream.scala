package scalqa; package `val`; package stream; package z; package flow; package parallel; import language.implicitConversions

class Flow_asJavaStream[A] private (val name: String, jStream: java.util.stream.Stream[A], szOpt: Long.Opt, override val base: Ref) extends custom.pipeline.ParallelFlow[A] with Custom.Pipeline:
  def this(v: ~[A]) = this(\/, v.toJavaStream(true), v.sizeLong_?, v)
  @tn("sizeLong_Opt") def sizeLong_?                                         : Long.Opt             = szOpt
  /**/                def take(f: A => Boolean)                              : Flow_asJavaStream[A] = Flow_asJavaStream[A]("take",    jStream.filter( v =>  f(v) ), \/, this)
  /**/                def drop(f: A => Boolean)                              : Flow_asJavaStream[A] = Flow_asJavaStream[A]("drop",    jStream.filter( v => !f(v) ), \/, this)
  /**/                def map[B](f: A => B)                                  : Flow_asJavaStream[B] = Flow_asJavaStream[B]("map",     jStream.map[B](f(_)), sizeLong_?, this)
  /**/                def flatMap[B](f: A => ~[B])                           : Flow_asJavaStream[B] = Flow_asJavaStream[B]("flatMap", jStream.flatMap[B](f(_).toJavaStream(true)), \/, this)
  /**/                def peek(c: A => Unit)                                 : Flow_asJavaStream[A] = Flow_asJavaStream[A]("peek",    jStream.peek(c(_)), sizeLong_?, this)
  /**/                def foreach[U](c: A => U)                              : Unit                 = jStream.forEach(c(_))
  @tn("reduce_Opt")   def reduce_?(f: (A,A) => A)                            : Opt[A]               = jStream.reduce(f(_, _))
  /**/                def foldAs[B](start: B)(op: (B,A) => B, f: (B,B) => B) : B                    = jStream.reduce(start, op(_, _), f(_, _))
  @tn("findAny_Opt")  def findAny_?                                          : Opt[A]               = Opt.fromJava(jStream.findAny)
  override            def count                                              : Int                  = jStream.count.toInt

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
