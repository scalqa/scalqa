package scalqa; package Custom

package object Number {

  def getOpt(a: Any): Opt[Number] = a match {
    case v: Number          => v
    case v: Int             => v.Number
    case v: Long            => v.Number
    case v: Double          => v.Number
    case v: Float           => v.Number
    case v: Short           => v.Number
    case v: Byte            => v.Number
    case v: Util.BigInteger => v.real
    case v: Util.BigDecimal => v.real
    case _                  => \/
  }

  def parseInt(ba: Array[Byte], r: Idx.Range): Int = parseLong(ba, r).toInt

  def parseLong(ba: Array[Byte], r: Idx.Range): Long = {
    var l = 0L; var i = r.start; var c = ba(i).toChar
    val end = r.end
    while (i < end && c >= '0' && c <= '9') { l = l * 10 + (c - '0'); i += 1; c = ba(i).toChar }
    return l
  }

  @inline final def get10Power(i: Int): Long = tenPowers(i); private lazy val tenPowers = new Array[Long](19).I(a => 19.all.foldAs(1L)((v, i) => { a(i) = v; v * 10L }))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
