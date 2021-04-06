package scalqa; package fx; package ui; package `abstract`; import language.implicitConversions

trait Delegate extends Any:
  protected type REAL

  def real: REAL

object Delegate:
  type Opaque[A<:Opaque.Ref,B<:AnyRef]   = delegate.Opaque[A,B]
  type Gui                               = delegate.Gui;            inline def Gui   = delegate.Gui
  type Value[A <: delegate.Value[A,B],B] = delegate.Value[A,B];     inline def Value = delegate.Value

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def real -> JavaFX peer

       Returns the real JavaFX peer, which makes GUI happen

       It can be manipulated directly

*/
