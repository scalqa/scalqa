package scalqa; package j; package util; import language.implicitConversions

import test.z

class Test(private[j] val name: String = \/):
  private val group = new z.Group(this)
  private var trueCnt, falseCnt, equalCnt = 0
  private[j] def resetCounters = { trueCnt = 0; falseCnt = 0; equalCnt = 0 }

  // ----------------------------------------------------------------------------------------------------------------------------------------------------------
  // Defining
  /**/                      def include(t: Test *)                                 : Unit = t.~.map(_.group).foreach(group.add)
  /**/                      def test[U]  (name:String)(code: => U)                 : Unit = group.add(z.Method(name,() => code))
  /**/                      def test[U]               (code: => U)                 : Unit = test[U](\/)(code)
  /**/                      def testTrue (name:String)(code: => Boolean)           : Unit = test(name){assertTrue(code)}
  /**/                      def testTrue              (code: => Boolean)           : Unit = test      {assertTrue(code)}
  /**/                      def testFalse(name:String)(code: => Boolean)           : Unit = test(name){assertFalse(code)}
  /**/                      def testFalse             (code: => Boolean)           : Unit = test      {assertFalse(code)}
  @tn("test_Streams")       def test_~[A](name:String)(s1: ~[A],s2: ~[A],ms: ~[A]*): Unit = test(name){assertEqual_~(s1,s2,ms *)}
  @tn("test_Streams")       def test_~[A]             (s1: ~[A],s2: ~[A],ms: ~[A]*): Unit = test      {assertEqual_~(s1,s2,ms *)}

  // ----------------------------------------------------------------------------------------------------------------------------------------------------------
  // Asserting
  /**/                      def assertTrue( v: Boolean, message: => String = \/)   : Unit = { trueCnt += 1; if (!v)    throw new z.Problem("assertTrue", trueCnt, message)}
  /**/                      def assertFalse(v: Boolean, message: => String = \/)   : Unit = { falseCnt += 1; if (v)     throw new z.Problem("assertFalse",falseCnt, message)}
  @tn("assertEqual_Streams")def assertEqual_~[A](s1: ~[A],s2: ~[A],ms: ~[A]*)      : Unit = { equalCnt += 1; val o=z.streamsEqual.result(s1,s2,ms);
    /**/                                                                                      if(o.isProblem) throw new z.Problem("assertEqual_~", equalCnt, o.problem.message)}

  // ----------------------------------------------------------------------------------------------------------------------------------------------------------
  // Running
  def main(sa: Array[String]) = { J.sleep(100.Millis); run }

  def run: Unit =
    val t = Time()
    val s = "Started at " +- t.roundTo(1.Second)
    println(s + "\n" + "-" * s.length)
    val o = group.run_??(0)
    println("-" * s.length)
    println(o.value_?.map(_ => "Succesfully Finished").or("Stopped on problem") + " in " + t.age.tag)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/