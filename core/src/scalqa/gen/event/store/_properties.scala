package scalqa; package gen; package event; package store; import language.implicitConversions

transparent trait _properties:
  self : Store =>

  def setProperty_?[B]   (id: AnyRef, value: B)          : Opt[B] = { val o=removeProperty_?(id); add(id,value); o }
  def getProperty_?[B]   (id: AnyRef, dfltOpt: =>Opt[B]) : Opt[B] = get(id).?.dropVoid.map(_.value.cast[B]) or_? dfltOpt.forval(v => add(id,v))
  def removeProperty_?[B](id: AnyRef)                    : Opt[B] = get(id).?.dropVoid.map(e => { val v=e.value.cast[B]; e.cancel; v})


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
