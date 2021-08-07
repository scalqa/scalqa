package scalqa; package j; package util; package concurrent

import java.util.concurrent.atomic.{AtomicReference as REAL}
import Concurrent.Ref

object Ref:
  def apply[A](v: A) = new REAL(v).cast[Ref[A]]

  extension[A](x: Ref[A])
    private inline def real= x.cast[REAL[A]]
    inline def get                              : A       = x.real.get
    inline def change(old:A,value:A)            : Boolean = x.real.compareAndSet(old,value)
    inline def set  (inline f:A=>A)             : Unit    = {var done=false;            while(!done){ val v=x.get; val w=f(v); done=change(v,w)}  }
    inline def reset(inline f:A=>A, old:A )     : A       = {var done=false; var w=old; while(!done){ val v=w; w=f(v); if(change(v,w)) done=true else w=x.get}; w}
    inline def reset(inline f:A=>A)             : A       = reset(f,x.get)

  object OPAQUE:
    opaque type TYPE[A] <: AnyRef.Opaque = REAL[A] & AnyRef.Opaque


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
