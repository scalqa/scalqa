package scalqa; package `val`; package idx; package z; import language.implicitConversions

private[scalqa] class Void[A] extends Idx[A] with Gen.Void:
  def size          = 0
  def apply(i: Int) = J.illegalState()

object Void extends Void[Nothing]:

  object OM extends Idx.OM.X.Abstract[Nothing] with Gen.Void:
    /**/     def size                                                 = 0
    /**/     def apply(i: Int)                                        = J.illegalState()
    /**/     def addAt(i: Int, e: Nothing)                            = J.unsupportedOperation()
    /**/     def updateAt(i: Int, e: Nothing)                         = J.unsupportedOperation()
    /**/     def removeRange(r: Int.Range)                            = J.unsupportedOperation()
    /**/     def refreshRange(r: Int.Range)                           = ()
    /**/     def onChange[U](l: Pack[Observable.Event[Nothing]] => U) = \/
    /**/     def modify(ch: Mutable[Nothing] => Unit)                 = J.unsupportedOperation()
    override def sort(using c: Ordering[Nothing] = null)              = ()



/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
