package scalqa; package `val`; package range; package z; import language.implicitConversions

private class StepStream[A](r: Range[A], start: A, step: A => A) extends ~[A]:
  private         var cur    : A      = start
  @tn("read_Opt") def read_? : Opt[A] = if(r.contains(cur)){ val v=cur; cur=step(v); v } else \/

object StepStream:

  def apply[A](r: Range[A], step: A => A): ~[A] =
    r.ordering.compare(r.start,step(r.start)) match
      case i if i < 0 => new StepStream[A](r, r.start, step)
      case i if i > 0 => new StepStream[A](r, if (r.endIsIn) r.end else step(r.end), step)
      case _          => J.illegalArgument("Invalid step")

  def apply[A](r: Range[A], step: Int)(using q: Able.Sequence[A]) : ~[A] =
    step.sign match
      case 1  => new StepStream[A](r, r.start, q.step(_, step))
      case -1 => new StepStream[A](r, if (r.endIsIn) r.end else q.step(r.end, -1), q.step(_, step))
      case _  => J.illegalArgument("Invalid step: " + step)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
