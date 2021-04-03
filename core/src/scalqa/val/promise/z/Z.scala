package scalqa; package `val`; package promise; import language.implicitConversions

import Promise.Context

object Z:

  def flatMap[A,B](p: Promise[A], f: A => Promise[B])(using e: Context): Promise[B] =
    val c = z.Control[B]()
    val run: A=>Unit = v =>
      try{ val
        fp = f(v);
        fp.result_?.forval(c.complete) or {if(fp.isInstanceOf[z.Control.Promise[_]]) fp.cast[z.Control.Promise[B]].linkTo(c) else fp.onResult(c.complete)}}
      catch { case scala.util.control.NonFatal(t) => c.complete(Result.Problem(t)) }
    p.process(run,c.complete(_))
    c.promise

  // -------------------------------------------------------------------------------------------------------------------------
  def zip[A,B](fa: Promise[A], fb: Promise[B])(using ec: Context): Promise[(A, B)] =
    val c = Control[(A, B)]()
    fa.process( va => fb.result_?.forval(_.forval(vb => c.complete((va, vb)))), c.complete(_))
    fb.process( vb => fa.result_?.forval(_.forval(va => c.complete((va, vb)))), c.complete(_))
    c.promise

    // -------------------------------------------------------------------------------------------------------------------------
  def await[A](p: Promise[A], d: Time.Length)(using e: Context): Result[A] =
    val c = concurrent.Promise[Unit]
    p.onResult(_ => c.trySuccess(()))
    try
      concurrent.Await.result(c.future, concurrent.duration.Duration(d.nanosTotal, concurrent.duration.NANOSECONDS))
      p.result_?.get
    catch
      case _: concurrent.TimeoutException => Result[A](new Result.Problem.Timeout(d.tag))
      case t: Throwable                   => Result[A](Result.Problem(t))

  // **********************************************************************************************************
  class Completed[A](v: A) extends Promise[A]:
    @tn("result_Opt") def result_?                                          : Opt[Result[A]]  = v.??
    override          def mapAll[B](f: Result[A]=>Result[B])(using Context) : Promise[B]      = { val r=f(v.??); if (r.isValue) Completed(r.value) else Failed(r.problem)}
    /**/              def onResult[U]( f: Result[A] => U)   (using Context) : Unit            = f(v.??)

  // **********************************************************************************************************
  class Failed[A](v: Result.Problem) extends Promise[A]:
    @tn("result_Opt") def result_?                                          : Opt[Result[A]]  = v : Result[A]
    override          def mapAll[B](f: Result[A]=>Result[B])(using Context) : Promise[B]      = { val r=f(v.??); if (r.isValue) Completed(r.value) else Failed(r.problem)}
    /**/              def onResult[U]( f: Result[A] => U)   (using Context) : Unit            = f(v.??)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
