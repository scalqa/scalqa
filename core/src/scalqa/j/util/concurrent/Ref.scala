package scalqa; package j; package util; package concurrent

import java.util.concurrent.atomic.{AtomicReference as REAL}
import Concurrent.Ref

object Ref:
  def apply[A](v: A) = new REAL(v).cast[Ref[A]]

  extension[A](inline x: Ref[A])
    inline def get                                   : A       = x.cast[REAL[A]].get
    inline def tryChange(inline old:A,inline value:A): Boolean = x.cast[REAL[A]].compareAndSet(old,value)

  extension[A](x: Ref[A])
    /**/   def change(f:A=>A)                        : A       = { while(true){ val o=x.get; val v=f(o); if(x.tryChange(o,v)) return v}; J.illegalState()}

  object OPAQUE:
    opaque type TYPE[A] <: AnyRef.Opaque = REAL[A] & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object OPAQUE  -> ###

  Thread safe, minimal overhead reference based on java.util.concurrent.atomic.AtomicReference

@def get -> Get target

      Returns referenced object

@def tryChange -> Try to replace the target value

      Provides the old and the new values

      Returns true if value is successfully changed, false if old value is not longer current (was changed by other thread) and the change failed.

@def change -> Change value

      Changes value based on function, which takes the old value and produces new one.

      Returns the new value

      Note. The provided function can be invoked and generate new value multiple times, and only last generated value will be returned (the others discarded).

*/