package scalqa; package `val`; package stream; package z; package x; import language.implicitConversions

import scala.{ collection as C }

object Scala:

  def Stream_fromIterableOnce[A](x: C.IterableOnce[A]): Stream[A] =
    x match
       case _ : C.IndexedSeq[A] => new Stream_fromIndexedSeq(x.cast[C.IndexedSeq[A]])
       case _ : C.LinearSeq[A]  => new Stream_fromLinearSeq(x.cast[C.LinearSeq[A]])
       case _                   => new Stream_fromIterator(x.iterator)

  class Stream_fromIterator[A](v: Iterator[A]) extends Pipe[A](v) with Able.Size.Opt:
    private         val sz                        = v.knownSize;
    private         var i                         = 0;
    def readOpt                    = v.hasNext ? { i+=1; v.next }
    def sizeOpt                    = sz.?.drop(_ < 0).map(_ - i)

  class Stream_fromLinearSeq[A](ls: C.LinearSeq[A]) extends Stream[A] with custom.Discharge[A] with Able.Size.Opt:
    private         val sz                        = ls.knownSize;
    private         var i                         = 0;
    private         var s: C.LinearSeq[A]         = ls
    def readOpt                    = { var o: Opt[A]=VOID; if(s.nonEmpty){ o = s.head; s = s.tail; i+=1}; o}
    def sizeOpt                    = sz.?.drop(_ < 0).map(_ - i)
    override        def dischargeTo(b: Buffer[A]) = while (s.nonEmpty) { b.add(s.head); s = s.tail }

  class Stream_fromIndexedSeq[A](seq: C.IndexedSeq[A]) extends Stream[A] with Able.Size with custom.Discharge[A] :
    private         var i                         = 0
    private         val sz                        = seq.size
    def readOpt                    = { var o:Opt[A]=VOID; if(i<sz){ o=seq(i); i+=1}; o}
    /**/            def size                      = sz - i
    /**/            def dischargeTo(b: Buffer[A]) = while(i < sz){ b.add(seq(i)); i+=1}

  class Stream_fromProduct(v: Product) extends Stream[(String, Any)] with Able.Size:
    private         var i                             = 0
    private         val sz                            = v.productArity
    def readOpt : Opt[(String,String)] = {var o:Opt[(String, String)]=VOID;if(i<sz){ o=(v.productElementName(i), v.productElement(i).tag); i+=1}; o }
    /**/            def size   : Int                  = sz - i

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
