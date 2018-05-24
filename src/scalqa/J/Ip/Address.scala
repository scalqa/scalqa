package scalqa; package J; package Ip

import java.net.{ InetAddress => JAVA }

class Address(protected val real: JAVA) extends AnyVal with Any.Value.Ref[JAVA] {
  protected override type THIS = Address

  protected def companion = Address

  def name: String = value.getHostName

  def address: String = value.getHostAddress

}

object Address extends Any.Value.Ref.Companion[Address, JAVA] {

  def get(v: JAVA) = new Address(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
