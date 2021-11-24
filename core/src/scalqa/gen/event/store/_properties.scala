package scalqa; package gen; package event; package store; import language.implicitConversions

transparent trait _properties:
  self : Store =>

  def setPropertyOpt[B]   (id: AnyRef, value: B)          : Opt[B] = { val o=removePropertyOpt(id); add(id,value); o }
  def getPropertyOpt[B]   (id: AnyRef, dfltOpt: =>Opt[B]) : Opt[B] = get(id).?.dropVoid.map(_.value.cast[B]) orOpt dfltOpt.forval(v => add(id,v))
  def removePropertyOpt[B](id: AnyRef)                    : Opt[B] = get(id).?.dropVoid.map(e => { val v=e.value.cast[B]; e.cancel; v})


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
