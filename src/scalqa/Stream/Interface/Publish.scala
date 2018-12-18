package scalqa; package Stream; package Interface

object Publish extends scalqa.Util.Z.Include.Streaming

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Publish ->
 *
 *   Implicits to make Scala and Java collections [[Stream]] compatible
 *
 *   Note:  When there is a full 'import scalqa._', this object is not required because its functionality is covered
 *
 *    {{{
 *
 *       import scalqa.Stream.Interface.Publish._  // import attaches 'all' method to all collections
 *
 *       // 'all' returns container elements as Stream
 *
 *       List(1,2,3).all.lp  // Prints ~(1, 2, 3)
 *
 *   }}}
 */
