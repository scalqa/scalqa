package scalqa; package gen; package event; package control; package z; import language.implicitConversions

private[scalqa] object Join:

  class Two(c1: Control, c2: Control) extends Control:
    c1.onCancel(() => cancel)
    c2.onCancel(() => cancel)

    def cancel                     = c1.cancel || c2.cancel
    def cancelIf(b: () => Boolean) = { c1.cancelIf(b); c2.cancelIf(b); this }
    def isCancelled                = c1.isCancelled && c2.isCancelled
    def onCancel[U](b: () => U)    = c1.onCancel(b)
    def removeHardReference      = (c1.removeHardReference, c2.removeHardReference)

  class Three(c1: Control, c2: Control, c3: Control) extends Control:
    c1.onCancel(() => cancel)
    c2.onCancel(() => cancel)
    c3.onCancel(() => cancel)

    def cancel                     = c1.cancel || c2.cancel || c3.cancel
    def cancelIf(b: () => Boolean) = { c1.cancelIf(b); c2.cancelIf(b); c3.cancelIf(b); this }
    def isCancelled                = c1.isCancelled && c2.isCancelled && c3.isCancelled
    def onCancel[U](b: () => U)    = c1.onCancel(b)
    def removeHardReference      = (c1.removeHardReference, c2.removeHardReference, c3.removeHardReference)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
