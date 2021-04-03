package scalqa; package j; package util; package concurrent

import java.util.concurrent.atomic.AtomicLong
import Concurrent.Counter

object Counter extends Any.Ref.Custom.Type[Counter,AtomicLong]("Concurrent.Counter"):
  def apply(initValue : Long = 0): Counter = new AtomicLong(initValue).asOpaque[Counter]

  extension(inline x: Counter)
    private inline def self : AtomicLong = x.cast[AtomicLong]
    inline def get          : Int        = self.intValue
    inline def next         : Int        = self.incrementAndGet.Int
    inline def getLong      : Long       = self.longValue
    inline def nextLong     : Long       = self.incrementAndGet

  object opaque:
    opaque type `type` <: Opaque.Ref = AtomicLong & Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
