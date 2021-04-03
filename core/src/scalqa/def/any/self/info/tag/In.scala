package scalqa; package `def`; package any; package self; package info; package tag; import language.implicitConversions

import java.{ lang as J, util as U }
import scala.{ collection as S }

trait In[A,-CONTAINER]:
  def in(v: A, c: CONTAINER): Boolean

object In extends zInDefault:

  given xxAbleContain[A] : In[A,Able.Contain[A]] with { inline def in(v:A, x: Able.Contain[A]) = x.contains(v) }

  given xxIterableOnce[A]: In[A,S.IterableOnce[A]] = z.In.IterableOnce.cast[In[A,S.IterableOnce[A]]]
  given xxJIterable   [A]: In[A,J.Iterable[A]]     = z.In.Iterable    .cast[In[A,J.Iterable[A]]]
  given xxJIterator   [A]: In[A,U.Iterator[A]]     = z.In.Iterator    .cast[In[A,U.Iterator[A]]]
  given xxProduct     [A]: In[A,Product]           = z.In.Product     .cast[In[A,Product]]

private class zInDefault:
  given xxString[A<:String | Opaque.String]: In[A,A]               with { inline def in(v:A,    x:A) = x.asInstanceOf[String].contains(v.asInstanceOf[String])}
  given xxChar  [A<:String | Opaque.String]: In[Char,A]            with { inline def in(v:Char, x:A) = x.asInstanceOf[String].indexOf(v)>=0 }
  given xxCollection  [A]: In[A,Collection[A]]     = z.In.Collection  .cast[In[A,Collection[A]]]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
