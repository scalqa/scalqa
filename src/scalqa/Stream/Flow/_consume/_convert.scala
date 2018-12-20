package scalqa; package Stream; package Flow; package _consume

trait _convert[A] extends Any.Able.ToText { self: Flow[A] =>

  def to[TRGT[A]](implicit cnv: Interface.To.Converter[TRGT]): TRGT[A] = cnv.make(this)

  def toRaw[TRGT](implicit c: Interface.To.Primitive.Converter[A, TRGT]): TRGT = c.make(this)

  def toVals(implicit c: Any.Datum.Setup[A]): Vals[A] = Vals.fromFlow(this)

  def toArray(implicit ct: ClassTag[A]): Array[A] = to[Idx.Array.Buffer].toArray

  def copyTo(b: Idx.Array.Buffer.Loader[A]): Unit = foreachSynchronized(b.add)

  def toText: String = Z.consume.convert.toText(this, false)

  def format(separator: Opt[String] = \/, padBefore: Opt[String] = \/, padAfter: Opt[String] = \/, converter: Opt[A => String] = \/): String =
    Z.consume.convert.format(this, separator, padBefore, padAfter, converter)

  def toString(name: String): String = name + '(' + format(", ") + ')'

  override def toString: String = toString("~")

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def format -> Elements as String
 *
 *       All elements are converted toString
 *
 *       The results are concatenated with possible use of padding and separator
 *
 *       @param separator optional string between elements
 *       @param padBefore optional string before each element
 *       @param padAfter optional string after each element
 *       @param converter custom element to String function
 *
 *   @example
 *   {{{
 *       ('a' <> 'z').all.format().lp
 *       ('a' <> 'z').all.format("|").lp
 *       ('a' <> 'z').all.format(",", "[", "]").lp
 *
 *       // Output
 *       abcdefghijklmnopqrstuvwxyz
 *
 *       a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z
 *
 *       [a],[b],[c],[d],[e],[f],[g],[h],[i],[j],[k],[l],[m],[n],[o],[p],[q],[r],[s],[t],[u],[v],[w],[x],[y],[z]
 *   }}}
 *
 * @def copyTo -> Copy to buffer
 *
 *     This is potentially the most efficient way to get all [[Stream]] elements
 *
 *    [[Idx.Array.Buffer.Loader]] provides a trustless way to copy arrays in bulk, so many array based Streams can take advantage of this
 *
 * @def toString( -> Elements as String
 *
 *      Returns String starting with given `name` and containing all elements separated by ", "
 *      {{{
 *          (1 <> 5).all.toString("My Ints").lp
 *
 *          // Output
 *          My Ints(1, 2, 3, 4, 5)
 *      }}}
 *
 * @def toString: -> Elements as String
 *
 *      Returns String starting with "~(" and containing all elements separated by ", "
 *      {{{
 *          (1 <> 5).all.toString.lp
 *
 *          // Output
 *          Stream(1, 2, 3, 4, 5)
 *      }}}
 *
 * @def toVals -> Convert to [[Vals]]
 *
 *      Stores all elements as [[Vals]] immutable collection
 *
 *      Only works if Stream holds [[Any.Datum]] type
 *
 * @def toText -> Elements as multi-line String
 *
 *    Returns all elements as String formatted table
 *
 *    If elements implement [[Any.Able.ToInfo]], each 'info' tag value is placed in a different column
 *
 *    If elements implement `scala.Product` (like all Tuples), each Product element is placed in a different column
 *
 *    {{{
 *       ('a' <> 'e').all.map(c => (c + "1", c + "2", c + "3", c + "4", c + "5")) tp
 *
 *       // Output
 *       -- -- -- -- --
 *       ?  ?  ?  ?  ?
 *       -- -- -- -- --
 *       a1 a2 a3 a4 a5
 *       b1 b2 b3 b4 b5
 *       c1 c2 c3 c4 c5
 *       d1 d2 d3 d4 d5
 *       e1 e2 e3 e4 e5
 *       -- -- -- -- --
 *    }}}
 *
 * @def to[ -> Convert to type
 *
 *     Converts pipeline elements to the specified target type
 *
 *     Available targets are defined in [[Stream.Interface.To$]]
 *
 *        - [[Idx]]
 *        - [[Idx.M]]
 *        - [[Idx.OM]]
 *        - [[Idx.I]]
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
 *      {{{
 *         ("1" ~+ "2" + "3").to[Idx.I]  // Returns: Idx.I[String]
 *
 *         ('A' <> 'D').all.to[List]        // Returns: scala.List[Char]
 *
 *         (1 <> 5).all.to[java.util.List]  // Returns: java.util.List[Int]
 *      }}}
 *
 *     New target conversions can be implemented by creating implicit object extending [[Stream.Interface.To$.Converter]]
 *
 */
