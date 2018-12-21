package scalqa; package Stream; package Z; package extend; package zip

private[Stream] object unzip {

  def apply[A, B, C](s: Stream[A], fun: A => (B, C)): (Stream[B], Stream[C]) = {

    abstract class Stacked[T] extends Stream.A.Base[T] {
      val stack = new java.util.Stack[T]

      def prime = !stack.empty || s.prime

      def pump: T = if (!stack.empty) stack.pop else { val t = fun(s.pump); parse(t._1, t._2) }

      def parse(b: B, c: C): T

    }

    object Left extends Stacked[B] {

      def parse(b: B, c: C) = { Right.stack.push(c); b }

    }

    object Right extends Stacked[C] {

      def parse(b: B, c: C) = { Left.stack.push(b); c }

    }

    (Left, Right)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
