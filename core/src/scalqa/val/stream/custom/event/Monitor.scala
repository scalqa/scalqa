package scalqa; package `val`; package stream; package custom; package event; import language.implicitConversions

trait Monitor:
  protected def runOnBeforeFirst                          : Unit
  protected def runOnEvery(cnt: Int, tm: Time.Length)     : Unit
  protected def runOnAfterLast(cnt: Int, tm: Time.Length) : Unit
  protected def runOnEmpty                                : Unit

object Monitor:
  inline private[stream] def runOnBeforeFirst(l: Monitor)                          : Unit    = l.runOnBeforeFirst
  inline private[stream] def runOnEvery(l: Monitor, cnt: Int, tm: Time.Length)     : Unit    = l.runOnEvery(cnt, tm)
  inline private[stream] def runOnAfterLast(l: Monitor, cnt: Int, tm: Time.Length) : Unit    = l.runOnAfterLast(cnt, tm)
  inline private[stream] def runOnEmpty(l: Monitor)                                : Unit    = l.runOnEmpty

  implicit def xxRequest(v: \/)     : Monitor = zVoid
  implicit def xxRequest(v: DEFAULT): Monitor = new zDefault

// *******************************************************************************
private object zVoid extends Monitor with Void:
  def runOnBeforeFirst                          = ()
  def runOnEvery(    cnt: Int, tm: Time.Length) = ()
  def runOnAfterLast(cnt: Int, tm: Time.Length) = ()
  def runOnEmpty                                = ()

// *******************************************************************************
private class zDefault extends Event:
  onBeforeFirst(         t => println("Stream Started at: " +- t))
  onAfterLast(      (c, l) => println("Stream Ended, processed: " +- c + " in " +- l))
  onEvery(1.Second, (x, y) => println(x +- " " +- y))


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
