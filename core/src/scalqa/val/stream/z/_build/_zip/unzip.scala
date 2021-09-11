package scalqa; package `val`; package stream; package z; package _build; package _zip; import language.implicitConversions

object unzip:

  def apply[A, B, C](x: ~[A], f: A => (B, C)): (~[B],~[C]) =

    abstract class Stacked[T] extends ~[T]:
      /**/            val queue  = new java.util.ArrayDeque[T]
      @tn("read_Opt") def read_? = if(queue.size > 0) queue.pop else x.read_?.map(v => get(f(v)))
      /**/            def get(v: (B,C)): T

    object Left extends Stacked[B]:
      def get(v: (B,C)) = { Right.queue.add(v._2); v._1 }

    object Right extends Stacked[C]:
      def get(v: (B,C)) = { Left.queue.add(v._1); v._2 }

    (Left, Right)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
