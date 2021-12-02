package scalqa; package j; package util; import language.implicitConversions

import test.z

class Test(private[j] val name: String=VOID):
  private val group = new z.Group(this)
  private var trueCnt, falseCnt, equalCnt = 0
  private[j] def resetCounters = { trueCnt = 0; falseCnt = 0; equalCnt = 0 }

  // ----------------------------------------------------------------------------------------------------------------------------------------------------------
  // Defining
  def include(t: Test *)                                                        : Unit = t.stream.map(_.group).foreach(group.add)
  def test[U]  (name:String)(code: => U)                                        : Unit = group.add(z.Method(name,() => code))
  def test[U]               (code: => U)                                        : Unit = test[U](VOID)(code)
  def testTrue (name:String)(code: => Boolean)                                  : Unit = test(name){assertTrue(code)}
  def testTrue              (code: => Boolean)                                  : Unit = test      {assertTrue(code)}
  def testFalse(name:String)(code: => Boolean)                                  : Unit = test(name){assertFalse(code)}
  def testFalse             (code: => Boolean)                                  : Unit = test      {assertFalse(code)}
  def testEqualStream[A](name:String)(s1:Stream[A],s2: Stream[A],ms: Stream[A]*): Unit = test(name){assertEqualStream(s1,s2,ms *)}
  def testEqualStream[A]             (s1:Stream[A],s2: Stream[A],ms: Stream[A]*): Unit = test      {assertEqualStream(s1,s2,ms *)}

  // ----------------------------------------------------------------------------------------------------------------------------------------------------------
  // Asserting
  def assertTrue( v: Boolean, message: => String =VOID)                         : Unit = { trueCnt  += 1; if (!v) throw new z.Problem("assertTrue", trueCnt,  message)}
  def assertFalse(v: Boolean, message: => String =VOID)                         : Unit = { falseCnt += 1; if ( v) throw new z.Problem("assertFalse",falseCnt, message)}
  def assertEqualStream[A](s1: Stream[A],s2: Stream[A],ms: Stream[A]*)          : Unit = { equalCnt += 1; val r=z.streamsEqual.result(s1,s2,ms);
    /**/                                                                                   if(r.isProblem) throw new z.Problem("assertEqualStream", equalCnt, r.problem.message)}

  // ----------------------------------------------------------------------------------------------------------------------------------------------------------
  // Running
  def main(sa: Array[String]) = { J.sleep(100.Millis); run }

  def run: Unit =
    val t = Time.current
    val s = "Started at " +- t.roundTo(1.Second)
    println(s + "\n" + "-" * s.length)
    val o = group.runResult(0)
    println("-" * s.length)
    println(o.valueOpt.map(_ => "Succesfully Finished").or("Stopped on problem") + " in " + t.age.tag)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Test  ->  Code Testing Utility

  "Test" is extensively used in Scalqa own [test project](https://github.com/scalqa/scalqa/tree/master/test/src/scalqa/test), which is the best usage example.

*/