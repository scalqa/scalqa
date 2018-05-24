package scalqa; package Pipe

abstract class _Class[A] protected extends Flow[A] with _extend._Trait[A] with _pump._Trait[A] with Interface[A] {

  @inline protected def supplyOpt: Opt[A] = pumpOpt(EVERY)

  def pumpOpt(f: A => Boolean): Opt[A]
}

object _Class extends Able.Void.Companion.Typed[Pipe](The.Void) {

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *     [[Pipe]] or several [[Pipe]]s together represent a pipeline
 *
 *     Pipeline is a one time channel to some source of elements
 *
 *     A pipeline can be '''extended'''.
 *     By calling extension method we create a new piece of [[Pipe]], connected to and representing the entire pipeline.
 *     This new piece of [[Pipe]] depending on its nature can ''potentially'' add, remove or modify elements passing through it.
 *
 *     At the end of life cycle, a pipeline can be '''pumped'''.
 *     Pumping means that only at this point the pipeline source is requested to deliver the elements.
 *     They start moving the entire pipeline length, processed by each section.
 *
 *     {{{
 *       (0 <> 100).all               //  A pipeline of Ints from 0 to 100 is created
 *         .drop(_ > 25)              //  Extended with filtering logic to loose Ints above 25
 *         .let(_ % 2 == 0)           //  Extended with filtering logic to only allow even Ints
 *         .map('A' + _ toChar)       //  Extended with conversion logic from Int to Char
 *         .apply(c => Print(c, ",")) //  Pumping action, prints each element
 *
 *       // Output
 *       A,C,E,G,I,K,M,O,Q,S,U,W,Y,
 *     }}}
 *
 *      A [[Pipe]] is only good for a ''single method call'':
 *
 *         - If this is an extension call, we get a new [[Pipe]] to deal with. The original [[Pipe]] must be discarded
 *         - If this is a pumping call, the [[Pipe]] is considered 'pumped' and must be discarded
 *
 *      If there is a desire to call a [[Pipe]] more than once, most likely [[Pipe._pump._transform.iterator Pipe.Iterator]] is needed
 *
 *
 * @def pumpOpt -> Main method
 *
 *     This is the only abstract method, everything else is a derivative
 *
 *     ''pumpOpt'' allows efficient bulk processing for large pipelines and is speed competitive even with Scala custom collections.
 *     What happens is, instead of pumping elements through the pipeline, the ''pumpOpt'' function travels the opposite direction to the root,
 *     incorporating all the processing logic of each [[Pipe]] section, and it gets executed against the source.
 *
 *     Most applications should implement [[Pipe.Interface]], instead of [[Pipe]]. This would be much easier to do and is not critical for end-point pipes
 *
 *     Note, this method (and ''metadata'') can legally be called multiple times on the same [[Pipe]] (This should be a secret from application developers, who should use [[Pipe.Iterator]])
 */
