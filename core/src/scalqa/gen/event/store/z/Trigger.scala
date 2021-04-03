package scalqa; package gen; package event; package store; package z; import language.implicitConversions

private[z] trait Trigger:
  /**/         def value           : Any   = cargo match { case v: Trigger => v.value; case v => v }
  protected[z] def cargo           : Any
  protected[z] def cargo_=(v: Any) : Unit

private[z] object Trigger:

  def get(e: Trigger): Any = e.cargo match { case v: Trigger => get(v); case v => v }

  class OnCancel(var cargo: Any, val code: () => Any) extends Trigger

  class CancelIf(e: Entry, var cargo: Any, val b: () => Boolean) extends Trigger:
    override def value           : Any  = if (b()) { e.cancel; null } else super.value

  class WeakRef private (e: Entry, val cargo: J.WeakRef[Any]) extends Trigger:
    def this(e: Entry, v: Any) = this(e,J.WeakRef(v))
    override def value           : Any  = cargo.get_?.fornil(e.cancel) or null
    /**/     def cargo_=(v: Any) : Unit = J.unsupportedOperation()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
