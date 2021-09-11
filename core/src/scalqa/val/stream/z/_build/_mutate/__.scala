package scalqa; package `val`; package stream; package z; package _build; import language.implicitConversions

import _mutate.*

object mutate:

  def load[A](x: ~[A]): ~[A] & Able.Size =
    x.toBuffer.~.enableSize

  def hideSizeData[A](x: ~[A]): ~[A] =
    if(x.sizeLong_?) new hideSizeData(x) else x

  def enablePreview[A](x: ~[A]): ~[A] & Preview[A] =
    x match
       case v: Preview[_] => v.cast[Preview[A]]
       case v             => new preview(v)

  def enableSize[A](x: ~[A]): ~[A] & Able.Size =
    x match
       case v: Able.Size => x.cast[~[A] & Able.Size]
       case v            => new enableSize(v)

  def nonEmpty_Opt[A](x: ~[A]): Opt[~[A]] =
    x.sizeLong_? match
        case o if o => o.take(_ > 0).map(_ => x)
        case _      => { val b=x.enablePreview; if(b.preview_?) b.? else \/ }


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
