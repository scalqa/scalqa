package scalqa; import language.implicitConversions

object Test0:

    def main(sa: Array[String]): Unit =
      "===========================================================================================================".tp

      (1 <> 3).~.drop(_ => true).nonEmpty_?.tp

      (1 <> 3).~.drop(_ => true).default(333).sum.tp


      "===========================================================================================================".tp


      //s.~.tp
//      val d  = new J.Concurrent.Deque[String]()
//      val d2 = new J.Concurrent.Deque[String]()
//
//      s.~.parallel.peek(d.push).peek(_ => d.pop_?.forval(d2.push)).~.sum.tp
//
//      d.~.sum.tp
//      d2.~.sum.tp

