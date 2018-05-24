package scalqa

package object Numeric {
  type BigDecimal = BigDecimal._Class
  type BigInteger = BigInteger._Class

  def getOpt(a: Any): Opt[Numeric] = a match {
    case v: Numeric          => v
    case v: Int              => v.The
    case v: Long             => v.The
    case v: Double           => v.The
    case v: Float            => v.The
    case v: Short            => v.The
    case v: java.lang.Number => get(v)
    case _                   => \/
  }

  def get(v: java.lang.Number): Numeric = v match {
    case v: java.lang.Integer => v.intValue.The
    case v: java.lang.Long => v.longValue.The
    case v: java.lang.Double => v.doubleValue.The
    case v: java.lang.Float => v.floatValue.The
    case v: java.lang.Short => v.shortValue.The
    case v: java.lang.Byte => v.shortValue.The
    case v: java.math.BigInteger => BigInteger.get(v)
    case v: java.math.BigDecimal => BigDecimal.get(v)
    case v: java.util.concurrent.atomic.AtomicInteger => v.intValue.The
    case v: java.util.concurrent.atomic.AtomicLong => v.longValue.The
    case v => v.doubleValue.The
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
