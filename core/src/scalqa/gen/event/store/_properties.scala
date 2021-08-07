package scalqa; package gen; package event; package store; import language.implicitConversions

transparent trait _properties:
  self : Store =>

  def setProperty_?[T]   (id: AnyRef, value: T)          : Opt[T] = { val o=removeProperty_?(id); add(id,value); o }
  def getProperty_?[T]   (id: AnyRef, dfltOpt: =>Opt[T]) : Opt[T] = get(id).?.dropVoid.map(_.value.cast[T]) or_? dfltOpt.forval(v => add(id,v))
  def removeProperty_?[T](id: AnyRef)                    : Opt[T] = get(id).?.dropVoid.map(e => { val v=e.value.cast[T]; e.cancel; v})


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
