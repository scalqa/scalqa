package example.performance.buffer;  import scalqa.{*, given};  import language.implicitConversions

import collection.mutable.ArrayBuffer

object AddElement:

  def main(sa:  Array[String]): Unit =

    val CNT = 100000

    val array: Array[String] = (0 <>> CNT).~.map(_.toString).toArray

    J.Benchmark.custom()(
      ("scala.Buffer[String] ", () => { val b = ArrayBuffer[String](); for(i <- 0 <>> CNT) b += array(i); b.size }),
      ("String.Buffer        ", () => { val b = new String.Buffer();   for(i <- 0 <>> CNT) b += array(i); b.size }),
    )
