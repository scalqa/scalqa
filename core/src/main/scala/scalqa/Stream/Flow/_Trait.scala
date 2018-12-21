package scalqa; package Stream; package Flow

trait _Trait[A] extends _extend._Trait[A] with _consume._Trait[A] with _info._Trait[A]

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Potentially Parallel Flow`.
 *
 *   [[Stream.Flow]] is [[Stream]]'s parent, with only methods able of parallel processing
 *
 *   For example, running `<stream>.parallelIfOver(100)`  will always return [[Flow]],
 *   but it will only execute in parallel, if there are more than a 100 elements.
 *   Otherwise it will still be a [[Stream]], reduced to [[Flow]] interface.
 *
 */
