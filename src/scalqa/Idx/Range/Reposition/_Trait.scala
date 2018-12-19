package scalqa; package Idx; package Range; package Reposition

trait _Trait extends Any.Able.ToInfo {

  def range: Idx.Range

  def indexes: Ints

  def toInfo = new Pro.Info(this, "Reposition") += ("range", range) += (\/, this.allPairs.format())
}

object _Trait extends Util.Void.Setup[Reposition](Z.Void) {

  implicit def zzLibrary(v: Reposition): _library = new _library(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *
 *   [[Reposition]] is a precise definition how elements within [[Idx.Range]] should be reorganized
 *
 *   Consider ordering a list of integers. This could be accomplished it two steps:
 *
 *      - First, based on some Ordering , we create a [[Reposition]] object, which captures all necessary position permutations
 *      - Second, apply reposition to the list
 *   {{{
 *       val buffer = (0 ~+~ (3 ~+ 1 + 2) + 4).to[Idx.M]
 *
 *       buffer.all lp      // Prints:  ~(0, 3, 1, 2, 4)
 *
 *       // Creating reposition based on ordering
 *       val rep = Idx.Reposition.fromOrdering(buffer)
 *
 *       rep lp             // Prints: Reposition{range=1 <>> 4,(1,3)(2,1)(3,2)}
 *
 *       rep.apply(buffer)  // Applying reposition
 *
 *       buffer.all.lp      // Prints: ~(0, 1, 2, 3, 4)
 *    }}}
 *
 *     [[Reposition]] has rich library, where all derivative methods are located
 *
 *     This is done not to pollute main name space, because reposition can be implemented by classes doing something else
 *
 * @def range -> Scope
 *
 *     [[Idx.Range]] the reposition is applicable to
 *
 * @def indexes -> New positions
 *
 *      Int indexes on new positions
 *
 *      {{{
 *        // Repositioning range from 3 to 6 in reverse indexes = 6,5,4,3
 *
 *        val r = Idx.Reposition.make(3 <> 6, Ints.make(6, 5, 4, 3))
 *
 *        r lp  // Prints: Reposition{range=3 <>> 7,(3,6)(4,5)(5,4)(6,3)}
 *      }}}
 */
