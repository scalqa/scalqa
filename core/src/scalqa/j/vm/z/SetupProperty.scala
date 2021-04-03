package scalqa; package j; package vm; package z

class SetupProperty[A](default: => A) extends Pro.M[A]:
  private var value: A = _
  private var notUsed, notInit = true

  def apply() =
    if(notUsed)
      notUsed = false
      if(notInit){ notInit = false; value = default }
    value

  def update(v: A) =
    if (Setup.isSealed) J.illegalState("Setup has been sealed")
    if (!notUsed)       J.illegalState("Setup property has been used and cannot be updated")
    notInit = false
    value   = v

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
class Property


*/