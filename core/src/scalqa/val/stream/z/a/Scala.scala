package scalqa; package `val`; package stream; package z; package a; import language.implicitConversions

import scala.{ collection as SC }

object Scala:

  def apply[A](x: SC.IterableOnce[A]): ~[A] =
    x match
       case v: SC.IndexedSeq[A] => new Stream_fromIndexedSeq(v)
       case v: SC.LinearSeq[A]  => new Stream_fromLinearSeq(v)
       case v                   => new Stream_fromIterator(v.iterator)

  class Stream_fromIterator[A](v: Iterator[A]) extends Pipe[A](v) :
    @tn("read_Opt") def read_? = v.hasNext ? v.next

  class Stream_fromLinearSeq[A](ls: SC.LinearSeq[A]) extends ~[A] with custom.Discharge[A]:
    private         var i                         = 0;
    private         var s: SC.LinearSeq[A]        = ls
    @tn("read_Opt") def read_?                    = { var o: Opt[A] = \/; if(s.nonEmpty){ o = s.head; s = s.tail}; o}
    override        def dischargeTo(b: Buffer[A]) = while (s.nonEmpty) { b.add(s.head); s = s.tail }

  class Stream_fromIndexedSeq[A](seq: SC.IndexedSeq[A]) extends ~[A] with Able.Size with custom.Discharge[A] :
    private         var i                         = 0
    private         val sz                        = seq.size
    @tn("read_Opt") def read_?                    = { var o:Opt[A] = \/; if(i<sz){ o=seq(i); i+=1}; o}
    /**/            def size                      = sz - i
    /**/            def dischargeTo(b: Buffer[A]) = while(i < sz){ b.add(seq(i)); i+=1}

  class Stream_fromProduct(v: Product) extends ~[(String, Any)] with Able.Size:
    private         var i                             = 0
    private         val sz                            = v.productArity
    @tn("read_Opt") def read_? : Opt[(String,String)] = {var o:Opt[(String, String)]= \/; if(i<sz){ o=(v.productElementName(i), v.productElement(i).tag); i+=1}; o }
    /**/            def size   : Int                  = sz - i

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
