package scalqa; package `val`; package lookup; package stable; package z; import language.implicitConversions

import scala.collection.immutable.{ HashMap => REAL }

private[`val`] final class AnyRef[A,B] private[stable](private[stable] val real: REAL[A,B]) extends Stable[A,B]:
  def this(v : Iterator[(A,B)]) = this(REAL.from(v))
  type THIS_TYPE = Stable[A,B]

  @tn("get_Opt")     def get_?(key: A)         : Opt[B]      = Val.Opt.fromScala(real.get(key))
  /**/               def size                  : Int         = real.size
  @tn("pair_Stream") def pair_~                : ~[(A, B)]   = real.iterator
  /**/               def join(k: A, v: B)      : Stable[A,B] = new AnyRef(real.updated(k,v))
  /**/               def joinAll(v: ~[(A, B)]) : Stable[A,B] = new AnyRef(v.foldAs(real)(_ + _))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
