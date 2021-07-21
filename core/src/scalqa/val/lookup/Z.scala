package scalqa; package `val`; package lookup; import language.implicitConversions

object Z:

  class Basic[A,B] protected (protected val createFunOpt : Opt[A => Opt[B]]= \/, protected val real: Mutable[A,B]) extends J.Util.Proxy.Lookup[A,B]:
    def this(createFunOpt : A => Opt[B]) = this(createFunOpt.?, Mutable[A,B]())
    def this(s: ~[(A, B)]) = { this(\/, Mutable()); real.putAll(s) }

    @tn("get_Opt") override def get_?(key: A)    : Opt[B]   = real.get_?(key) or_? createFunOpt.map_?(_(key).forval(v => real.put(key, v)))
    protected               def put(s: ~[(A, B)]): Unit     = real.putAll(s)

  // *************************************************************************************************************************
  class Convert_View[A, B, C](protected val real: Lookup[A,B], f: B => C) extends Lookup[A, C]:
    val m: B => C = f.apply

    @tn("pair_Stream") def pair_~ : ~[(A, C)]    = real.pair_~.map((k,v) => (k, f(v)))
    @tn("get_Opt")     def get_?(key: A): Opt[C] = real.get_?(key).map(m)
    /**/               def size                  = real.size

  // *************************************************************************************************************************
  class ScalaMap_View[A, +B](protected val real: Lookup[A,B]) extends scala.collection.immutable.AbstractMap[A,B]:
    def get(key: A)                        : scala.Option[B]  = real.get_?(key).toScala
    def iterator                                              = real.pair_~.iterator
    def removed(key: A)                    : Predef.Map[A,B]  = J.unsupportedOperation()
    def updated[V1 >: B](key: A, value: V1): Predef.Map[A,V1] = J.unsupportedOperation()

  // *************************************************************************************************************************
  class PartialFunction_View[A,B](x: Lookup[A,B]) extends PartialFunction[A,B]:
    def isDefinedAt(a: A) = x.get_?(a)
    def apply(a: A): B = x.get_?(a).get

  /*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
