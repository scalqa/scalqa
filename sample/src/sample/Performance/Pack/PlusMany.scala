package sample.Performance.Pack;  import scalqa.{*, given};  import language.implicitConversions

object PlusMany:

  def main(sa: Array[String]): Unit =
    "Started...".tp

    val CNT = 1000
    val array  : Array[Int]   = (1 <> CNT).~.toArray

    val intPack : Int.><      = array.~.><
    val refPack : ><[Int]     = array.~.><
    val list    : List[Int]   = array.toList
    val vector  : Vector[Int] = array.toVector

    J.Benchmark(
      ("List[Int]",   () => (list     ++ list     ++ (100 to 200) ++ array).size),
      ("Vector[Int]", () => (vector   ++ vector   ++ (100 to 200) ++ array).size),
      ("><[Int]",     () => (refPack  ++ refPack  ++ (100 <> 200) ++ array).size),
      ("Int.><",      () => (intPack  ++ intPack  ++ (100 <> 200) ++ array).size),
    )

