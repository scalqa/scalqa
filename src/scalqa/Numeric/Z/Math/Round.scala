package scalqa; package Numeric; package Z; package Math

private[Numeric] object Round {

  def apply[A](a: A, math: Math[A], i: Int, trimOnly: Boolean): A = {
    val m: Double = scalqa.Double.orderMultiplier(i.abs)
    val l = math.toLong(a)
    if (i < 0) {
      val r = l % m.toLong
      math(l - r + (if (!trimOnly && r >= m / 2) m.toLong else 0L))
    } else {
      val f = (math.toDouble(a) - l) * m
      var left = f.toLong
      if (!trimOnly && f - left >= 0.5D) left += 1
      math(l.toDouble + left.toDouble / m)
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/