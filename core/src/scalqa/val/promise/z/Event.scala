package scalqa; package `val`; package promise; package z; import language.implicitConversions

import Promise.Context

private[z] class Event[A](f: Result[A]=>Any, c: Context) extends Runnable:
  private var value                           : Result[A] = _
  /**/    def fire(v: Result[A])              : Unit      = { value = v; c.execute(this) }
  /**/    def run()                           : Unit      = f(value)
  /**/    def add(f:Result[A]=>Any, c:Context): Event[A]  = new Event.Add(f,c,this)
  /**/    def join(e: Event[A])               : Event[A]  = new Event.Join(this,e)
  inline  def of[B]                           : Event[B]  = this.cast[Event[B]]

private[z] object Event:

  @tn("getVoid") def void[A] = Void.cast[Event[A]]

  private object Void extends Event[Any](null,null) with Gen.Void:
    override def fire(v: Result[Any])               = ()
    override def add(f:Result[Any]=>Any, c:Context) = new Event(f,c)
    override def join(e: Event[Any])                = e

  private class Add[A](f: Result[A]=>Any, c: Context, e: Event[A]) extends Event[A](f,c):
    override def fire(v: Result[A]) : Unit = { super.fire(v); e.fire(v) }

  private class Join[A](one: Event[A], two: Event[A]) extends Event[A](null,null):
    override def fire(v: Result[A]) : Unit = { one.fire(v); two.fire(v) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
