package scalqa; package j; package util; package proxy

abstract class Lookup[A,B] extends Lookup.Basis[A,B]

object Lookup:

  trait Basis[A,B] extends Val.Lookup[A,B] with J.Util.Proxy[Val.Lookup[A,B]]:
    override                    def size          = real.size
    @tn("get_Opt")     override def get_?(key: A) = real.get_?(key)
    @tn("pair_Stream") override def pair_~        = real.pair_~

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
