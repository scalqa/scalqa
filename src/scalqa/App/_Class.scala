package scalqa; package App

import _Class._

class _Class(verbose: Boolean = ON) extends scala.DelayedInit {

  def args: Refs[String] = _args

  def startTime = _startTime

  override def delayedInit(body: => Unit) { _delayed += (() => body) }

  def main(args: Array[String]): Unit = {
    _args = args.toRefs
    if (verbose) "App '" + this.I.Class.label + "' started: " + startTime + " with " + args.length + " params\n" + ("_" * 80) + '\n' lp
    val it = _delayed.all
    while (it.prime) it.pump.apply
    if (verbose) Runtime.getRuntime.addShutdownHook(new Thread(new Runnable {
      def run = "\n" + ("_" * 80) + "\nApp '" + _Class.this.I.Class.label + "' finished in " + startTime.age lp
    }));
  }
}

private object _Class {
  // located here because class body is with DelayedInit
  val _startTime = Time.now
  var _args: Refs[String] = _
  var _delayed: Refs[() => Any] = \/
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> A convenient way to create Java main executable class
 *   {{{
 *     object MyMain extends App {
 *
 *       "Hello World" lp
 *
 *     }
 *   }}}
 *
 *   @param verbose if true, prints application name, start, and end time
 *
 * @def args -> Arguments
 *
 *   Application arguments the JVM was started with
 *
 *   These are the arguments passed to {{{ def main(sa: Array[String]) }}}
 *
 * @def startTime -> Start time
 *
 *   Application start time
 *
 * @def delayedInit -> Delayed init
 *
 *   Implementation detail, it should not be used in code
 *
 * @def main(args: Array[String]) -> Main
 *
 *   Implementation detail, it should not be used in code
 */
