package scalqa; package lang; package byte; package g; import language.implicitConversions

trait Idx[A<:Raw] extends Val.Idx[A] with Collection[A]:
  /**/                   def apply(i: Int) : A
  @tn("stream") override def ~             : Stream[A] = Z.Stream_ofIdx(this)
  /**/          override def contains(v: A): Boolean   = {var i=0; val sz=size; while(i<sz){if(apply(i).real==v.real) return true; i+=1}; false}

object Idx:
  implicit inline def implicitRequest[A<:Raw](v: \/): Idx[A] = Pack.void

  trait Mutable[A<:Raw] extends Idx[A] with Collection.Mutable[A] with Val.Idx.M[A]:
    def addAt   (i: Int, v: A): Unit
    def updateAt(i: Int, v: A): Unit

  object Mutable:
    implicit inline def implicitRequest[A<:Raw](inline v: NEW): Mutable[A] = new Buffer()


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
