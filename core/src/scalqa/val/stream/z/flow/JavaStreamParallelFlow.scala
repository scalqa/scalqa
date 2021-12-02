package scalqa; package `val`; package stream; package z; package flow; import language.implicitConversions

class JavaStreamParallelFlow[A] private (val name: String, jStream: java.util.stream.Stream[A], szOpt: Long.Opt, override val base: AnyRef) extends custom.pipeline.ParallelFlow[A] with Custom.Pipeline:
  def this(v: Stream[A]) = this(VOID, v.toJavaStream(true), v.sizeLongOpt, v)

  def sizeLongOpt                               : Long.Opt                  = szOpt
  def take(f: A => Boolean)                     : JavaStreamParallelFlow[A] = JavaStreamParallelFlow[A]("take",    jStream.filter( v =>  f(v) ),VOID, this)
  def drop(f: A => Boolean)                     : JavaStreamParallelFlow[A] = JavaStreamParallelFlow[A]("drop",    jStream.filter( v => !f(v) ),VOID, this)
  def map[B](f: A => B)                         : JavaStreamParallelFlow[B] = JavaStreamParallelFlow[B]("map",     jStream.map[B](f(_)), sizeLongOpt, this)
  def flatMap[B](f: A => Stream[B])             : JavaStreamParallelFlow[B] = JavaStreamParallelFlow[B]("flatMap", jStream.flatMap[B](f(_).toJavaStream(true)),VOID, this)
  def peek(c: A => Unit)                        : JavaStreamParallelFlow[A] = JavaStreamParallelFlow[A]("peek",    jStream.peek(c(_)), sizeLongOpt, this)
  def foreach[U](c: A => U)                     : Unit                      = jStream.forEach(c(_))
  def reduceOpt(f: (A,A) => A)                  : Opt[A]                    = jStream.reduce(f(_, _))
  def foldAs[B](start:B)(op:(B,A)=>B,f:(B,B)=>B): B                         = jStream.reduce(start, op(_, _), f(_, _))
  def findAnyOpt                                : Opt[A]                    = Opt.fromJava(jStream.findAny)
  override def count                            : Int                       = jStream.count.toInt

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
