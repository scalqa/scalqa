package scalqa; package fx; package control; package table; package cell; import language.implicitConversions

trait Setup[ROW,V,A] extends control.Cell.Setup[Cell[ROW, V, A]] with setup._value[ROW,V,A] with Event.Store.Provider:
  private[table] def rowFilter : ROW => Boolean    = J.unsupportedOperation()
  private[table] def column    : Column[ROW, V, _]

  /**/                       def voidDef                                                       : Any.Def.Void[A]
  /**/                       def docDef                                                        : Any.Def.Doc[A]
  /**/                       def onCellChange[U](l: Cell[ROW,V,A] => U)                        : Unit             = eventStore.onEvent1(Setup.Change, l)
  @tn("updateTrigger_Setup") def updateTrigger_:(d1: ROW => Observable)                        : Unit             = enhance_:*?((e, p) => p.observable_^(d1(e)))
  @tn("updateTrigger_Setup") def updateTrigger_:(d1: ROW => Observable, d2: ROW => Observable) : Unit             = enhance_:*?((e, p) => p.observable_^(d1(e), d2(e)))
  /**/                       def refreshEvery(tl: Gen.Time.Length)                             : Unit             = updateTrigger_:(_ => Gen.Time.current_*(tl))

private object Setup:
  object Change

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
