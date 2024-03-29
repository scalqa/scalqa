package scalqa; package gen; package event; package control; import language.implicitConversions

import java.lang.ref.{ WeakReference => WEAK }

object X:
  private val Cancelled = Pack[() => Boolean](() => true)

  abstract class Basic[A<:AnyRef](_target: A) extends Control:
    private   val ref                                        = J.Concurrent.Ref[Pack[() => Boolean]](Pack.void)
    private   var target                     : AnyRef        = _target
    private   var onCancelPack               : Pack[()=>Any]=VOID
    /**/      def isCancelled                : Boolean       = ref.get == Cancelled
    /**/      def onCancel[U](f: () => U)    : this.type     = { onCancelPack += f; this }
    /**/      def cancelIf(f: () => Boolean) : this.type     = { ref.change(_ + f); this }
    /**/      def cancel                     : Boolean       = if(isCancelled) false else { ref.change(_ => Cancelled); fireOnCancel; true }
    protected def fireOnCancel               : Unit          = { onCancelPack.stream.foreach(_.apply()); onCancelPack=VOID }

    def removeHardReference: AnyRef = target match
      case v: WEAK[_]   => v.cast[WEAK[A]].get
      case v            => target.?.takeType[WEAK[A]].map(_.get) or { target = new WEAK(v); v }

    protected def targetOpt : Opt[A] =
      val p : Pack[() => Boolean] = ref.get
      if(p eq Cancelled) return VOID
      else if(p.stream.exists(_())){cancel; return VOID }

      target match
        case r: WEAK[_] => { val v = r.get; if (v != null) v.cast[A] else { if (!isCancelled) cancel; VOID }}
        case v          => v.cast[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/