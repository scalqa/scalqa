package sample.Performance.for_comprehension;  import scalqa.{*, given};  import language.implicitConversions

object IntRangeFilterForeach:

  def main(sa:Array[String]): Unit =

    val CNT = 100000

    J.Benchmark(
      ("scala.Range ", () => { var s=0L;  for(i <- 0 to CNT if i%2 == 0) s += i; s }),
      ("      Range ", () => { var s=0L;  for(i <- 0 <> CNT if i%2 == 0) s += i; s }),
      ("coded loop  ", () => { var s=0L;  var i=0; while(i <= CNT){ if(i%2 == 0) s += i; i+=1}; s }),
    )
