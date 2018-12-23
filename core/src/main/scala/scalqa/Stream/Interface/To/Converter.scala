package scalqa; package Stream; package Interface; package To

abstract class Converter[CONTAINER[_]] protected {

  def make[A]: Flow[A] => CONTAINER[A] // 'apply' would not be a better name, because method returns function which is to apply itself

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Converter ->
 *
 *    [[Converter]] is a standard interface from [[Stream]] to any other type
 *
 *    Once there is an implicit converter instance available in scope, the [[Stream._consume._convert.to  Stream.to]] method will work
 *
 *    There are default converters [[To$ available]] for major Java and Scala containers
 *
 *    {{{
 *       (1 <> 5).all.to[Refs]                     // Returns: Idx.I[Int]
 *
 *       ('A' <> 'D').all.to[List]                 // Returns: scala.List[Char]
 *
 *       ("1" ~+ "2" + "3").all.to[java.util.List]  // Returns: java.util.List[String]
 *    }}}
 */
