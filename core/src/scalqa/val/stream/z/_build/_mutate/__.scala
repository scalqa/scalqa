package scalqa; package `val`; package stream; package z; package _build; import language.implicitConversions

import _mutate.*

object mutate:

  def load[A](x: Stream[A]): Stream[A] & Able.Size =
    x.toBuffer.stream.enableSize

  def hideSizeData[A](x: Stream[A]): Stream[A] =
    if(x.sizeLongOpt) new hideSizeData(x) else x

  def enablePreview[A](x: Stream[A]): Stream[A] & Preview[A] =
    x match
       case v: Preview[_] => v.cast[Preview[A]]
       case v             => new preview(v)

  def enableSize[A](x: Stream[A]): Stream[A] & Able.Size =
    x match
       case v: Able.Size => x.cast[Stream[A] & Able.Size]
       case v            => new enableSize(v)

  def nonEmptyOpt[A](x: Stream[A]): Opt[Stream[A]] =
    x.sizeLongOpt match
        case o if o => o.take(_ > 0).map(_ => x)
        case _      => { val b=x.enablePreview; if(b.previewOpt) b.? else VOID }


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
