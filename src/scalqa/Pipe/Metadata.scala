package scalqa; package Pipe

abstract class Metadata[A] protected extends Able.Info {

  protected def owner: Flow[A]

  def isMutable = true

  def tagOpt: Opt[Tag[A]] = \/

  def sizeOpt: Opt[Int] = \/

  def sortingOpt: Opt[Sorting[A]] = \/

  def sortingByOpt[B]: Opt[(Sorting[B], A => B)] = \/

  protected override def infoLine: String = this.I.info.infoLine(infoLabel)
  protected override def infoText = this.I.info.infoText(infoLabel)
  protected def info = \/.info ~~ isMutable.I.letOnly(false).swap((\/, "immutable")) ~~ sizeOpt.map(("size", _)) ~~
    tagOpt.map(t => ("tag", t.name)) ~~ sortingOpt.map(("sorting", _)) ~~ sortingByOpt.map((t: Any) => ("sortingBy", t))
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Metadata ->
 *
 *   [[Metadata]] optionally specifies some pipeline characteristics, which are known for granted
 *
 *   [[Metadata]] must be trusted
 *
 *   For example, if metadata.sizeOpt = Opt(0), the processing logic should assume the pipeline is empty and should not even attempt to confirm this
 *
 * @def isMutable -> Checks if mutable
 *
 *   Returns 'true' if pipeline elements can potentially mutate at source before pumping
 *   {{{
 *      (1 <> 10).all.metadata.isMutable lp  // Source is immutable, Prints: false
 *
 *      val x: Index.W[Int] = Index.W.get[Int].I(_ =+~ 1 <> 10)
 *
 *      x.all.metadata.isMutable lp          // Source is mutable, Prints: true
 *   }}}
 *
 * @def sizeOpt -> Size if known
 *
 *   Optionally returns pipeline element count if known
 *   {{{
 *     def all: ~[Int] = 1 <> 10
 *
 *     all.metadata.sizeOpt lp               // Prints: Opt(10)
 *
 *     all.dropFirst(6).metadata.sizeOpt lp  // Prints: Opt(4)
 *
 *     all.drop(_ > 5).metadata.sizeOpt lp   // Prints: Opt.Void
 *   }}}
 *
 * @def tagOpt -> Tag if known
 *
 *   Optionally returns pipeline's element [[Any.Class.Tag]]
 *   {{{
 *     def all: ~[Int] = 1 <> 10
 *
 *     all.metadata.tagOpt lp                // Prints: Opt(Tag.Int)
 *
 *     all.dropFirst(6).metadata.tagOpt lp   // Prints: Opt(Tag.Int)
 *
 *     all.map(_.toLong).metadata.tagOpt lp  // Prints: Opt.Void
 *   }}}
 *
 * @def sortingOpt -> Sorting if known
 *
 *   Returns Sorting if known
 *   {{{
 *      def all: ~[Int] = 1 <> 10
 *
 *      all.metadata.sortingOpt lp               // Prints: Opt(Sorting.The.Int)
 *
 *      all.sortReversed.metadata.sortingOpt lp  // Prints: Opt(Sorting.The.Int.Reversed)
 *
 *      all.shuffle.metadata.sortingOpt lp       // Prints: Opt.Void
 *   }}}
 *
 * @def sortingByOpt -> Sorting by if known
 *
 *   Optionally returns tuple of some type sorting and conversion function to this type
 */
