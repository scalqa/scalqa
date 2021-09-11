package scalqa; package `val`; package lookup; package mutable; import language.implicitConversions

import scala.collection.mutable.HashMap
import scala.collection.immutable.{ Map as IMap, HashMap as IHash }

object X:

  abstract class Base[A,B] extends Mutable[A,B]

  // ************************************************************************
  class Concurrent[A,B](root: IMap[A,B] = IHash.empty[A,B]) extends Base[A,B] :
    private            val cRef                  = J.Concurrent.Ref[IMap[A,B]](root)
    /**/               def size                  = cRef.get.size
    @tn("get_Opt")     def get_?(key: A): Opt[B] = cRef.get.get(key)
    @tn("pair_Stream") def pair_~ : ~[(A, B)]    = cRef.get.iterator.~
    /**/               def clear                 = cRef.change(_.mapFactory.empty)
    /**/               def put(key: A, value: B) = cRef.change(_.updated(key,value))
    /**/               def remove(k: A) : Opt[B] = { while(true){ val m=cRef.get; val o:Opt[B]=m.get(k); if(!o || cRef.tryChange(m,m.removed(k))) return o }; \/ }

  // ************************************************************************
  class Basic[A,B](protected val real: HashMap[A,B]) extends Base[A,B]:
    def this() = this(HashMap.empty[A,B])

    /**/               def size                  = real.size
    @tn("get_Opt")     def get_?(key: A): Opt[B] = real.get(key)
    @tn("pair_Stream") def pair_~ : ~[(A, B)]    = real
    /**/               def clear                 = real.clear
    /**/               def put(key: A, value: B) = real.put(key, value)
    /**/               def remove(key: A)        = Opt.fromScala(real.remove(key))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extention
*/