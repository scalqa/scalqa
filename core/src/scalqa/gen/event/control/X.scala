package scalqa; package gen; package event; package control; import language.implicitConversions

import java.lang.ref.{ WeakReference => WEAK }

object X:
  private val Cancelled = ><[() => Boolean](() => true)

  abstract class Basic[A<:Ref](_target: A) extends Control:
    private   val ref                                      = J.Concurrent.Ref[><[() => Boolean]](><.void)
    private   var target                     : Ref         = _target
    private   var onCancelList               : ><[()=>Any] = \/
    /**/      def isCancelled                : Boolean     = ref.get == Cancelled
    /**/      def onCancel[U](f: () => U)    : this.type   = { onCancelList += f; this }
    /**/      def cancelIf(f: () => Boolean) : this.type   = { ref.set(_ + f); this }
    /**/      def cancel                     : Boolean     = if(isCancelled) false else { ref.set(_ => Cancelled); true }
    protected def fireOnCancel               : Unit        = { onCancelList.~.foreach(_.apply()); onCancelList = \/ }

    def removeHardReference: AnyRef = target match
      case v: WEAK[_]   => v.cast[WEAK[A]].get
      case v            => target.?.takeType[WEAK[A]].map(_.get) or { target = new WEAK(v); v }

    @tn("target_Opt") protected def target_? : Opt[A] =
      ref.get match
        case Cancelled                 => return \/
        case v if v.~.exists(_().not) => { cancel; return \/ }
      target match
        case r: WEAK[_] => { val v = r.get; if (v != null) v.cast[A] else { if (!isCancelled) cancel; \/ }}
        case v          => v.cast[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
*/