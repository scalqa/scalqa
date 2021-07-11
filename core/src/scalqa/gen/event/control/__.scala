package scalqa; package gen; package event; import control.*; import language.implicitConversions

trait Control:
  def cancel                        : Boolean
  def isCancelled                   : Boolean
  def onCancel[U](b: () => U)       : Control
  def onCancelRun[U](f: => U)       : Control     = onCancel(() => f)
  def cancelIf(b: () => Boolean)    : Control
  def cancelIfTrue(b: => Boolean)   : Control     = cancelIf(() => b)
  def cancelIfFalse(b: => Boolean)  : Control     = cancelIf(() => !b)
  def removeHardReference           : Any.Ref
  def expireIn(tl: Time.Length)     : Control     = { val t = System.nanoTime + tl.nanosTotal; cancelIf(() => System.nanoTime > t) }
  def limitRunsTo(maxRunCount: Int) : Control     = { if (maxRunCount <= 0) { cancel; this } else { var c = 0; cancelIf(() => maxRunCount < { c += 1; c }) }}

object Control extends Gen.Void.Setup[Control](z.Void):
  def join(c1: Control, c2: Control, c3: Opt[Control] = \/): Control = c3.map(v => new z.Join.Three(c1, c2, v)) or new z.Join.Two(c1, c2)

  // Members ~~~~~~~~~~~~~~~~~~~~~
  transparent inline def X = control.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Control -> ###

@def cancel -> Cancel the event

   Returns true if cancelation is a success, false if the event was already cancelled before.

@def isCancelled -> Cancel check

   Returns false if the event is active

@def onCancel -> On cancel event

   Adds function to execute when the event is cancelled

@def onCancelRun -> On cancel event

   Adds code to execute when the event is cancelled

@def cancelIf -> Conditionally cancel

   Adds check to conditionally cancell the event.  It will be evaluated at least before each event execution.

@def cancelIfTrue -> Conditionally cancel

   Adds check to conditionally cancell the event.  It will be evaluated at least before each event execution.

@def cancelIfFalse -> Conditionally cancel

   Adds check to conditionally cancell the event.  It will be evaluated at least before each event execution.

@def expireIn -> Cancel in given time

   Adds check to conditionally cancell the event when given time length passes.

@def limitRunsTo -> Cancel after given execution count.

@def removeHardReference -> Make event weak referenced

   Event processing logic (usually wrapped in a function) may reference other objects, which cannot be garbage collected while the event exists.

   This method wraps the controlled event into a WeakReference, so the event itself and all the contained objects may be garbage collected.
   When the event is garbage collected it is effectively cancelled.

   The returned object is the only hard refference to the event and the program can decide when to discard it.

    ```
    val idx = Idx.OM[Int]()

    var hardRef = idx.onChange(_.~.print).removeHardReference

    System.gc

    idx += 1      // The onChange event will be printed out, because hard refference is kept

    hardRef = null

    System.gc

    idx += 2     // The onChange event should be gone (cancelled), because refference is lost.
    ```

*/