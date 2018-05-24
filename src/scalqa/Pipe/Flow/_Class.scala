package scalqa; package Pipe; package Flow

abstract class _Class[A] protected extends _extend._Trait[A] with _pump._Trait[A] {

  def metadata: Metadata[A]

}

object _Class {

  import scala.language.implicitConversions

  implicit def zzGet[A](v: \/.type): Flow[A] = The.Void.cast

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> '''Potentially Parallel Flow'''.
 *
 *   [[Pipe.Flow]] is [[Pipe]]'s parent, with only methods able of parallel processing
 *
 *   For example, running ''<pipe>.parallelIfOver(100)''  will always return [[Flow]],
 *   but it will only execute in parallel, if there are more than a 100 elements.
 *   Otherwise it will still be a [[Pipe]], reduced to [[Flow]] interface.
 *
 * @def metadata -> Metadata
 *
 *     Metadata optionally specifies some data characteristics, which are known for granted
 *
 *     Metadata must be trusted
 *
 *     For example if it specifies sizeOpt = 0, processing logic should not even attempt to confirm this
 *
 *     Metadata, unlike other methods, can be called many times
 */
