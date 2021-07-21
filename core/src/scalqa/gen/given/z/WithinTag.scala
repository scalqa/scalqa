package scalqa; package gen; package `given`; package z; import language.implicitConversions

import java.{ lang as J, util as U }
import scala.{ collection as S }

object WithinTag:

  object Product extends WithinTag[AnyRef,Product]:
    def within(v:AnyRef, x:Product) = {val sz=x.productArity; var i=0; while(i<sz){ if(v == x.productElement(i)) return true; i+=1}; false }

  object IterableOnce extends WithinTag[AnyRef,S.IterableOnce[AnyRef]]:
    def within(v:AnyRef, x:S.IterableOnce[AnyRef]) = x match
                                                        case x: S.SeqOps[_,_,_] => x.contains(v)
                                                        case x: S.IterableOnceOps[_,_,_] => x.exists(_ == v)
                                                        case x => {val i=x.iterator; while(i.hasNext) if(v == i.next) return true; false }

  object Iterable extends WithinTag[AnyRef,J.Iterable[AnyRef]]:
    def within(v:AnyRef, x:J.Iterable[AnyRef])     = x match
                                                        case x: U.Collection[_] => x.contains(v)
                                                        case x => {val i=x.iterator; while(i.hasNext) if(v == i.next) return true; false }

  object Iterator extends WithinTag[AnyRef,U.Iterator[AnyRef]]:
    def within(v:AnyRef, x:U.Iterator[AnyRef])     = { while(x.hasNext) if(v == x.next) return true; false }


  object Collection extends WithinTag[AnyRef,Collection[AnyRef]]:
    def within(v:AnyRef, x:Collection[AnyRef])     = x match
                                                        case x: Idx[_] => x.contains(v)
                                                        case x         => x.contains(v)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
