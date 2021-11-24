package scalqa; package `val`; package lookup; import language.implicitConversions

object Z:

  class Basic[A,B] protected (protected val createFunOpt : Opt[A => Opt[B]]= \/, protected val real: Mutable[A,B]) extends J.Util.Proxy.Lookup[A,B]:
    def this(createFunOpt : A => Opt[B]) = this(createFunOpt.?, Mutable[A,B]())
    def this(s: Stream[(A, B)])          = { this(\/, Mutable()); real.putAll(s) }

    override  def getOpt(key: A)        : Opt[B]   = real.getOpt(key) orOpt createFunOpt.mapOpt(_(key).forval(v => real.put(key, v)))
    protected def put(s: Stream[(A, B)]): Unit     = real.putAll(s)

  // *************************************************************************************************************************
  class Convert_View[A, B, C](protected val real: Lookup[A,B], f: B => C) extends Lookup[A, C]:
    val m: B => C = f.apply

    def pairStream    : Stream[(A,C)] = real.pairStream.map((k,v) => (k, f(v)))
    def getOpt(key: A): Opt[C]        = real.getOpt(key).map(m)
    def size                          = real.size

  // *************************************************************************************************************************
  class ScalaMap_View[A, +B](protected val real: Lookup[A,B]) extends scala.collection.immutable.AbstractMap[A,B]:
    def get(key: A)                        : scala.Option[B]  = real.getOpt(key).toScala
    def iterator                                              = real.pairStream.iterator
    def removed(key: A)                    : Predef.Map[A,B]  = J.unsupportedOperation()
    def updated[V1 >: B](key: A, value: V1): Predef.Map[A,V1] = J.unsupportedOperation()

  // *************************************************************************************************************************
  class PartialFunction_View[A,B](x: Lookup[A,B]) extends PartialFunction[A,B]:
    def isDefinedAt(a: A) = x.getOpt(a)
    def apply(a: A): B = x.getOpt(a).get

  /*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
