package scalqa; package `val`; package promise; package z; import language.implicitConversions

private[promise] class Control[A] extends java.util.concurrent.atomic.AtomicReference[Control[A] | Result[A] | Event[A]](Event.void[A]) with Promise.Control[A]:
  val promise: Val.Promise[A] = new Control.Promise(this)

  def complete(r: Result[A]): Boolean = get match
    case c: Control[_] => c.of[A].complete(r)
    case e: Event[_]   => if compareAndSet(e.of[A],r) then { e.of[A].fire(r); true } else complete(r)
    case _/*Result*/   => false

  private def onResult[U](fun: Result[A] => U, cxt: Promise.Context): Unit = get match
    case c: Control[_] => root(c.of[A]).onResult(fun,cxt)
    case e: Event[_]   => if compareAndSet(e.of[A],e.of[A].add(fun,cxt)) then () /*done*/ else onResult(fun,cxt) /*retry*/
    case r/*Result*/   => Event(fun,cxt).fire(r.cast[Result[A]])

  private def onResult(je: Event[A]): Unit = get match
    case c: Control[_] => root(c.of[A]).onResult(je)
    case e: Event[_]   => if compareAndSet(e.of[A], e.of[A].join(je)) then () /*done*/ else onResult(je) /*retry*/
    case r/*Result*/   => je.of[A].fire(r.cast[Result[A]])

  private def root(c: Control[A]): Control[A] =
    def find(c: Control[A]): Control[A] = if c.get.isInstanceOf[Control[_]] then find(c.of[A]) else c
    val rc = find(c)
    if (c eq rc) || compareAndSet(c, rc) then rc else if get.isInstanceOf[Control[_]] then root(c.of[A]) else c

  private def linkTo(l: Control[A]): Unit = if (this ne l) get() match
    case c: Control[_] => root(c.of[A]).linkTo(l)
    case e: Event[_]   => if compareAndSet(e.of[A],l)  then l.onResult(e.of[A]) else linkTo(l) /*retry*/
    case r/*Result*/   => if !l.complete(r.cast[Result[A]]) then J.illegalState("Cannot link completed promises together")

  inline def of[B]: Control[B] = this.cast[Control[B]]

private[promise] object Control:

  class Promise[A](pc:Control[A]) extends Val.Promise[A]:
    def onResult[U](f: Result[A] => U)(using x: Val.Promise.Context) = pc.onResult(f,x)
    def linkTo(c: Control[A]): Unit           = pc.linkTo(c.get match { case v: Control[_] => c.root(v.of[A]); case _ => c })
    def resultOpt            : Opt[Result[A]] = pc.get match
      /**/                                             case c: Control[_] => pc.root(c.of[A]).promise.resultOpt
      /**/                                             case e: Event[_]   => VOID
      /**/                                             case r/*Result*/   => r.cast[Result[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
