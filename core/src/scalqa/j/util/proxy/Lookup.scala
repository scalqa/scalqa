package scalqa; package j; package util; package proxy

abstract class Lookup[A,B] extends Lookup.Base[A,B]

object Lookup:

  trait Base[A,B] extends Val.Lookup[A,B] with J.Util.Proxy[Val.Lookup[A,B]]:
    override def size           = real.size
    override def getOpt(key: A) = real.getOpt(key)
    override def pairStream     = real.pairStream

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
