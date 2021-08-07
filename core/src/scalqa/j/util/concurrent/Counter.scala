package scalqa; package j; package util; package concurrent

import java.util.concurrent.atomic.AtomicLong
import Concurrent.Counter

object Counter extends AnyRef.Opaque.Base[Counter,AtomicLong]("Concurrent.Counter"):
  def apply(initValue : Long = 0): Counter = new AtomicLong(initValue).opaque

  extension(inline x: Counter)
    inline def get      : Int     = x.cast[AtomicLong].intValue
    inline def next     : Int     = x.cast[AtomicLong].incrementAndGet.toInt
    inline def getLong  : Long    = x.cast[AtomicLong].longValue
    inline def nextLong : Long    = x.cast[AtomicLong].incrementAndGet

  object OPAQUE:
    opaque type TYPE <: AnyRef.Opaque = AtomicLong & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
