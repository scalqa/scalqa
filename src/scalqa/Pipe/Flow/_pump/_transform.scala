package scalqa; package Pipe; package Flow; package _pump

import scala.language.higherKinds

trait _transform[A] extends __[A] with Able.Info {

  def to[TARGET[A]](implicit cnv: To[TARGET], tag: Tag[A] = \/): TARGET[A] = cnv(This, tag)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def to -> Convert to type
 *
 *     Converts pipeline elements to the specified target type
 *
 *     The converted object will not be a view, i.e. it will not be dependent on the pipeline source
 *
 *     Available targets are defined in [[Pipe.To]]
 *
 *        - [[Array]]
 *        - [[Array.View.Refs]]
 *        - [[Coll]]
 *        - [[Coll.W]]
 *        - [[Coll.WO]]
 *        - [[Coll.Val]]
 *        - [[Index]]
 *        - [[Index.W]]
 *        - [[Index.WO]]
 *        - [[Index.Val]]
 *        - scala.List
 *        - scala.Seq
 *        - scala.IndexedSeq
 *        - scala.Iterator
 *        - scala.Vector
 *        - scala.collection.mutable.Buffer
 *        - java.util.Collection
 *        - java.util.List
 *        - java.util.Iterator
 *        - java.util.Spliterator
 *        - java.util.stream.Stream
 *
 *     New target conversions can easily be implemented by creating implicit object extending [[Pipe.To]]
 *
 *      {{{
 *         ("1" ~ "2" ~ "3").to[Index.Val]  // Returns: Index.Val[String]
 *
 *         ('A' <> 'D').all.to[List]        // Returns: scala.List[Char]
 *
 *         (1 <> 5).all.to[java.util.List]  // Returns: java.util.List[Int]
 *      }}}
 */
