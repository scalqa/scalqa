package scalqa; package gen; package event; package store; package z; import language.implicitConversions

private[event] object Void extends Entry(null, null, null):
  override def child                      = this
  override def isCancelled                = false
  override def cancel                     = false
  override def find(typ: AnyRef)          = this
  override def next                       = this
  override def cancelIf(b: () => Boolean) = J.illegalState()
  override def onCancel[U](l: () => U)    = J.illegalState()
  override def removeHardReference:AnyRef = J.illegalState()
  override def doc                        = Doc("Entry") += "void"
  override def isVoid                     = true

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
