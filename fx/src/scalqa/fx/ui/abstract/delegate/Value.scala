package scalqa; package fx; package ui; package `abstract`; package delegate; import language.implicitConversions

trait Value[TYPE <: Value[TYPE, BASE], BASE] extends Any with Delegate:
  protected type REAL = BASE
  protected def setup: Value.Setup[TYPE, BASE]

  def real: BASE

object Value:

  abstract class Setup[TYPE <: Value[TYPE, BASE], BASE ]:
    self =>

    protected def apply(v: BASE) : TYPE

    given FxConverter: TwoWayFun[BASE,TYPE] = new TwoWayFun[BASE,TYPE] {
      def apply(v: BASE): TYPE = self(v)
      def undo(v: TYPE) : BASE = v.real
    }

    implicit def xx(v: BASE): TYPE = apply(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

