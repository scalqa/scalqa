package scalqa; package gen; package event; package control; package z; import language.implicitConversions

private[event] object Void extends Control with Gen.Void:
  def cancel                      = true
  def isCancelled                 = true
  def cancelIf(b: () => Boolean)  = this
  def onCancel[U](b: () => U)     = this
  def removeHardReference       = null

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
