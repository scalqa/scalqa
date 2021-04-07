package scalqaTry.Performance.Pack;  import scalqa.{*, given};  import language.implicitConversions

object FilterMapFlat:

  def main(sa: Array[String]): Unit =

    val CNT = 100

    val refPack : ><[Int]   = (1 <> CNT).~.ref.><
    val intPack : Int.><    = (1 <> CNT).~.><
    val list    : List[Int] = (1 to CNT).toList

    J.Benchmark(
      ("List[Int]", () => {val l: List[Int] =  for(i <- list    if i%2==0; j <- list    if i%5==0) yield i + j;     l.size}),
      ("><[Int]",   () => {val l: ><[Int]   = {for(i <- refPack if i%2==0; j <- refPack if i%5==0) yield i + j}.><; l.size}),
      ("Int.><",    () => {val l: Int.><    = {for(i <- intPack if i%2==0; j <- intPack if i%5==0) yield i + j}.><; l.size}),
    )

