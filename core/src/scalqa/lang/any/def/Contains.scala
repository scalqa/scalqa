package scalqa; package lang; package any; package `def`; import language.implicitConversions

import java.{ lang as J, util as U }
import scala.{ collection as S }

trait Contains[-CONTAINER,A]:
  def contains(c: CONTAINER, v: A): Boolean

object Contains extends zContainer:
  given givenAbleContain [A]: Contains[Able.Contain[A]  ,A] with { inline def contains(x: Able.Contain[A],v:A) = x.contains(v) }
  given givenIterableOnce[A]: Contains[S.IterableOnce[A],A] = zContainer.IterableOnce.cast[Contains[S.IterableOnce[A],A]]
  given givenJavaIterable[A]: Contains[J.Iterable[A]    ,A] = zContainer.Iterable    .cast[Contains[J.Iterable[A],A]]
  given givenJavaIterator[A]: Contains[U.Iterator[A]    ,A] = zContainer.Iterator    .cast[Contains[U.Iterator[A],A]]
  given givenProduct     [A]: Contains[Product          ,A] = zContainer.Product     .cast[Contains[Product,A]]

private class zContainer:
  given givenStringInString[A<:String | String.Opaque]: Contains[A,A]             with { inline def contains(x:A,v:A)    = x.asInstanceOf[String].contains(v.asInstanceOf[String])}
  given givenCharInString  [A<:String | String.Opaque]: Contains[A,Char]          with { inline def contains(x:A,v:Char) = x.asInstanceOf[String].indexOf(v)>=0 }
  given givenCollection[A]                            : Contains[Collection[A],A] = zContainer.Collection.cast[Contains[Collection[A],A]]

// ******************************************************************************************************************************************************************************
object zContainer:
  object IterableOnce extends Contains[S.IterableOnce[AnyRef],AnyRef]:
    def contains(x:S.IterableOnce[AnyRef], v:AnyRef) = x match
                                                          case x: S.SeqOps[_,_,_] => x.contains(v)
                                                          case x: S.IterableOnceOps[_,_,_] => x.exists(_ == v)
                                                          case x => {val i=x.iterator; while(i.hasNext) if(v == i.next) return true; false }
  object Iterable extends Contains[J.Iterable[AnyRef],AnyRef]:
    def contains(x:J.Iterable[AnyRef], v:AnyRef)     = x match
                                                          case x: U.Collection[_] => x.contains(v)
                                                          case x => {val i=x.iterator; while(i.hasNext) if(v == i.next) return true; false }

  object Iterator   extends Contains[U.Iterator[AnyRef],AnyRef]{ def contains(x:U.Iterator[AnyRef], v:AnyRef) = { while(x.hasNext) if(v == x.next) return true; false } }
  object Collection extends Contains[Collection[AnyRef],AnyRef]{ def contains(x:Collection[AnyRef], v:AnyRef) = x match { case x: Idx[_] => x.contains(v); case x => x.contains(v) } }
  object Product    extends Contains[Product,AnyRef]           { def contains(x:Product, v:AnyRef)            = {val sz=x.productArity; var i=0; while(i<sz){ if(v == x.productElement(i)) return true; i+=1}; false }}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Contains -> A given Any.Def.Contains instance for a specific type determines if universal method [[scalqa.lang.any._Methods in]] can be applied.

    ```
      val range = 1 <> 10

      if(5 in range) "is in".tp

      if("CD" in "ABCDEF") ()
      // same as
      if("ABCDEF".contains("CD")) ()

    ```

    Any.Def.Contains is defined for most known types and can be defined for new ones.

*/