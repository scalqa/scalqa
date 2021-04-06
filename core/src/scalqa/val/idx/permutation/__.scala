package scalqa; package `val`; package idx; import language.implicitConversions

import permutation.Z

trait Permutation:
  /**/                   def range                                             : Int.<>
  /**/                   def rangeMutated                                      : Int.><
  @tn("mutation_Stream") def mutation_~                                        : ~[(Int,Int)] = { var i=range.start-1; rangeMutated.~.map_?[Opt[(Int,Int)]](v =>{ i+=1; if(i!=v) (i,v) else \/})}
  /**/                   def mutate(pos: Int)                                  : Int          = { val i = range; if (i contains pos) rangeMutated(pos - i.start) else pos }
  /**/                   def reposition[T](l: Idx.M[T])                        : Unit         = reposition(l, l.updateAt)
  /**/                   def reposition[T](l: Idx[T], update: (Int,T) => Unit) : Unit         = { val il = l.~.take_<>(range).><; rangeMutated.~.foreachIndexed((i, j) => update(j, il(i))) }
  /**/                   def validate                                          : Unit         = Z.validate(this)

object Permutation extends Void.Setup[Permutation](Z.Void):
  def apply(r: Int.<>, rangeMutated: Int.><)                          : Permutation = Z.Basic(r, rangeMutated)
  def empty(i: Int.<>)                                                : Permutation = apply(i, i.><)
  def pairs(s: (Int, Int)*)                                           : Permutation = Z.pairs(s.~.><)
  def random(r: Int.<>)                                               : Permutation = Z.random(r)
  def sorting[A](idx:Idx[A], full:Boolean=false)(using c: Ordering[A]): Permutation = Z.sorting(idx, full, c)

  given xxDefDoc: Def.Doc[Permutation] with
    def tag(v: Permutation) = doc(v).tag
    def doc(v: Permutation) = Doc("Permutation") += ("range", v.range) += v.mutation_~.makeString()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Permutation -> ###

Permutation is a precise definition on how elements within Int.Range should be reorganized

     Consider ordering a buffer of integers. This could be accomplished it two steps:

        1. Based on some Ordering, we create a [[Permutation]] object, which captures all necessary repositions
        2. Apply permutation to the buffer
     ```
        val buf = ~~(0, 3, 1, 2, 4).toBuffer

        buf.~.TP // Prints:  ~(0, 3, 1, 2, 4)

        // Creating permutation based on comparator
        val p = Idx.Permutation.sorting(buffer)

        p.TP               // Prints: Permutation{range=1 <>> 4,(1,3)(2,1)(3,2)}

        p.reposition(buf)  // Applying permutation

        buf.~.TP           // Prints ~(0, 1, 2, 3, 4)
      ```

@def mutate -> New index

       Given current position, returns new position

@def mutation_~ -> All changes

       Returns a stream of all changed positions as a tuple: (<old position>, <new position>)

@def validate -> Check for consistency

      If is possible to create inconsistent [[Permutation]]. For example, the same position could be changed twice, etc.

      This operation will throw an exception if inconsistency found

@def range -> Range of change

       Range of indexes which changed


@def rangeMutated -> New positions

        Returns a list of new positions within the [[range]]

        ```
          // Repositioning range from 3 to 6 r reverse indexes = 6,5,4,3

          val r = Idx.Permutation(3 <> 6, Ints(6, 5, 4, 3))

          r TP  // Prints: Permutation{range=3 <>> 7,(3,6)(4,5)(5,4)(6,3)}
        ```

@def reposition -> Apply to mutable Idx

       Apply all changes to given mutable indexed collection

@def reposition -> Apply to Idx

       Apply all changes to given indexed collection, with the help of mutation function

@def sorting -> Ordering permutation

       Creates a [[Permutation]] for the given index, which if applied, will be equivalent to doing sort

       @param  fullRange By default permutation range is limited to the range of change.
               If this is true, permutation range will be 0 <>> index.size, even though some indexes will not be mapped.


@def empty -> No mappings

       Creates a [[Permutation]] for the given range, where all indexes are at their right places.

       Applying this [[Permutation]] will bring no actions


@def apply ->  By range and indexes

      Creates a [[Permutation]] for the given range and indexes.

      There are three rules which must be followed:

         - Sizes must be equal = range.size == indexes.size
         - Interval must not repeat
         - Interval must be within range = indexes.~.isEvery(range.contains)

       ```
         Idx.Permutation(3 <> 6, Ints(6, 5, 4, 3)).TP
         // Output
         Permutation{range=3 <>> 7,(3,6)(4,5)(5,4)(6,3)}
       ```


@def pairs -> By mappings

      Creates a [[Permutation]] by specifying a stream of mappings
      ```
         Idx.Permutation.^(Stream((5, 7),(7, 5))).TP
         // Output
         Permutation{range=5 <>> 8,(5,7)(7,5)}
      ```


*/
