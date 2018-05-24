package scalqa; package Pipe

object Benchmarks {

  def run(size: Int): Unit = {
    import scala.collection.mutable.Buffer

    val array: Array[Int] = (0 <>> size).all.shuffle.to[Array]

    val list: List[Int] = array.all.to[List].reverse
    val vector: Vector[Int] = array.all.to[Vector]
    val buffer: Buffer[Int] = array.all.to[Buffer]
    def iterator: scala.Iterator[Int] = list.toIterator
    def pipe: ~[Int] = list.all

    "************* Collections Output *****************".lp.lp
    pipe.toString("             Pipe").lp
    list.lp("       scala.")
    vector.lp("     scala.")
    buffer.lp("scala.")
    iterator.all.toString("   scala.Iterator").lp.lp

    "************* Test Start *************************".lp.lp
    val map: Int => Int = _ + 1
    val filter: Int => Boolean = _ % 2 == 0
    val fold: (Int, Int) => Int = _ + _

    App.Benchmark(10, 2.Seconds,
      ("Pipe           ", () => /*    */ pipe.map(map).let(filter).fold(0, fold)),
      ("scala.List     ", () => /*    */ list.map(map).filter(filter).fold(0)(fold)),
      ("scala.Vector   ", () => /*  */ vector.map(map).filter(filter).fold(0)(fold)),
      ("scala.Iterator ", () => /**/ iterator.map(map).filter(filter).fold(0)(fold)),
      ("scala.Buffer   ", () => /*  */ buffer.map(map).filter(filter).fold(0)(fold)),
      ("Pipe (Again)   ", () => /*   */ pipe.map(map).let(filter).fold(0, fold)))
  }

  def test_10: Unit = run(10)

  def test_100: Unit = run(100)

  def test_1000: Unit = run(1000)

  def test_10000: Unit = run(10000)

  def test_100000: Unit = run(100000)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Benchmarks ->
 *
 *      [[Benchmarks]] provides basic performance tests of [[Pipe]] against major Scala collections
 *
 *      You can see the code in [[Benchmarks.run]]
 *
 *      You can see the results for different collection sizes under 'test_?'
 *
 * @def test_10: -> run(10)
 *
 *    Runs benchmark with collection size 10
 *
 *    Final result output
 *    {{{
 *       GRAND TOTAL
 *       --- --------------- --------- --- ------ --- -----------------
 *       Num Target          Run Count %   Memory %   Control Value Avg
 *       --- --------------- --------- --- ------ --- -----------------
 *       1   Pipe            6.2m      70  334b   38  30
 *       2   scala.List      7.9m      89  537b   62  30
 *       3   scala.Vector    3.6m      40  868b   100 30
 *       4   scala.Iterator  8.9m      100 244b   28  30
 *       5   scala.Buffer    3.3m      37  544b   63  30
 *       6   Pipe (Again)    6.2m      69  298b   34  30
 *       --- --------------- --------- --- ------ --- -----------------
 *    }}}
 *
 * @def test_100: -> run(100)
 *
 *    Runs benchmark with collection size 100
 *
 *    Final result output
 *    {{{
 *       GRAND TOTAL
 *       --- --------------- --------- --- ------ --- -----------------
 *       Num Target          Run Count %   Memory %   Control Value Avg
 *       --- --------------- --------- --- ------ --- -----------------
 *       1   Pipe            962.0k    74  1.0kb  24  2550
 *       2   scala.List      774.9k    60  4.4kb  100 2550
 *       3   scala.Vector    653.6k    50  2.7kb  62  2550
 *       4   scala.Iterator  1.2m      100 1.0kb  23  2550
 *       5   scala.Buffer    965.7k    74  1.6kb  37  2550
 *       6   Pipe (Again)    963.6k    74  1.1kb  25  2550
 *       --- --------------- --------- --- ------ --- -----------------
 *    }}}
 *
 * @def test_1000: -> run(1000)
 *
 *    Runs benchmark with collection size 1000
 *
 *    Final result output
 *    {{{
 *       GRAND TOTAL
 *       --- --------------- --------- --- ------ --- -----------------
 *       Num Target          Run Count %   Memory %   Control Value Avg
 *       --- --------------- --------- --- ------ --- -----------------
 *       1   Pipe            86.7k     82  22.9kb 41  250500
 *       2   scala.List      70.2k     67  56.5kb 100 250500
 *       3   scala.Vector    68.8k     65  29.2kb 52  250500
 *       4   scala.Iterator  105.6k    100 22.0kb 39  250500
 *       5   scala.Buffer    82.1k     78  31.3kb 55  250500
 *       6   Pipe (Again)    87.8k     83  21.6kb 38  250500
 *       --- --------------- --------- --- ------ --- -----------------
 *    }}}
 *
 * @def test_10000: -> run(10000)
 *
 *    Runs benchmark with collection size 10,000
 *
 *    Final result output
 *    {{{
 *       GRAND TOTAL
 *       --- --------------- --------- --- ------ --- -----------------
 *       Num Target          Run Count %   Memory %   Control Value Avg
 *       --- --------------- --------- --- ------ --- -----------------
 *       1   Pipe            12.3k     100 235.2kb 39  25005000
 *       2   scala.List      8.2k      67  600.2kb 100 25005000
 *       3   scala.Vector    6.6k      54  311.6kb 52  25005000
 *       4   scala.Iterator  11.3k     92  229.0kb 38  25005000
 *       5   scala.Buffer    8.9k      73  357.7kb 60  25005000
 *       6   Pipe (Again)    12.2k     99  230.8kb 38  25005000
 *       --- --------------- --------- --- ------ --- -----------------
 *    }}}
 *
 * @def test_100000: -> run(100000)
 *
 *    Runs benchmark with collection size 100,000
 *
 *    Final result output
 *    {{{
 *       GRAND TOTAL
 *       --- --------------- --------- --- ------ --- -----------------
 *       Num Target          Run Count %   Memory %   Control Value Avg
 *       --- --------------- --------- --- ------ --- -----------------
 *       1   Pipe            1.1k      100 2.2mb  36  -1794917296
 *       2   scala.List      689       58  6.1mb  100 -1794917296
 *       3   scala.Vector    550       46  3.5mb  58  -1794917296
 *       4   scala.Iterator  963       81  2.3mb  38  -1794917296
 *       5   scala.Buffer    557       47  2.7mb  45  -1794917296
 *       6   Pipe (Again)    1.1k      97  2.4mb  41  -1794917296
 *       --- --------------- --------- --- ------ --- -----------------
 *    }}}
 *
 * @def run -> Code
 *
 *    Here is the full code of this method
 *    {{{
 *      def run(size: Int): Unit = {
 *         import scala.collection.mutable.Buffer
 *
 *         val array: Array[Int] = (0 <>> size).all.shuffle.to[Array]
 *
 *         val list:     List[Int]     = array.all.to[List].reverse
 *         val vector:   Vector[Int]   = array.all.to[Vector]
 *         val buffer:   Buffer[Int]   = array.all.to[Buffer]
 *         def iterator: Iterator[Int] = list.toIterator
 *         def pipe:     ~[Int]        = list.all
 *
 *         "************* Collections Output *****************".lp.lp
 *         pipe.toString("             Pipe").lp
 *         list.lp("       scala.")
 *         vector.lp("     scala.")
 *         buffer.lp("scala.")
 *         iterator.all.toString("   scala.Iterator").lp.lp
 *
 *         "************* Test Start *************************".lp.lp
 *         val map: Int => Int = _ + 1
 *         val filter: Int => Boolean = _ % 2 == 0
 *         val fold: (Int, Int) => Int = _ + _
 *
 *         App.Benchmark(10, 2.Seconds,
 *           ("Pipe           ", () =>     pipe.map(map).let(filter)   .fold(0, fold)),
 *           ("scala.List     ", () =>     list.map(map).filter(filter).fold(0)(fold)),
 *           ("scala.Vector   ", () =>   vector.map(map).filter(filter).fold(0)(fold)),
 *           ("scala.Iterator ", () => iterator.map(map).filter(filter).fold(0)(fold)),
 *           ("scala.Buffer   ", () =>   buffer.map(map).filter(filter).fold(0)(fold)),
 *           ("Pipe (Again)   ", () =>     pipe.map(map).let(filter)   .fold(0, fold)))
 *      }
 *    }}}
 */
