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

object Control extends Self.Void.Setup[Control](z.Void):
  def join(c1: Control, c2: Control, c3: Opt[Control] = \/): Control = c3.map(v => new z.Join.Three(c1, c2, v)) or new z.Join.Two(c1, c2)

  // ~~~~~~~~~~~~~~~~~~~~~
  inline def X = control.X


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
