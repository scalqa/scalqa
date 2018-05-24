package scalqa; package Pipe; package _pump

trait _reduce[A] extends Flow._pump._reduce[A] with __[A] {

  override def fold(start: A, op: (A, A) ⇒ A): A = Z.reduce.fold.as(This, start, op)

  override def foldOpt(op: (A, A) ⇒ A): Opt[A] = Z.reduce.fold.opt(synchronize, op)

  override def foldAsOpt[B](start: B, bf: (B, A) ⇒ B, cf: (B, B) => B = Fail): Opt[B] = Z.reduce.fold.asOpt(This, start, bf)

  def foldAs[B](start: B, bf: (B, A) ⇒ B): B = Z.reduce.fold.as(This, start, bf)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _reduce ->  '''Reduce Interface'''
 *
 *   All methods fully pump the pipeline
 *
 * @def foldAs[ -> Fold and convert
 *
 *   Folds and converts elements with a binary function
 *
 *   @param start seed value to start with
 *   @param bf binary function to fold elements with
 *
 *   @example
 *   {{{
 *       // Calculate sum of first 1000 Ints
 *
 *       (1 <> 1000).all.foldAs[Long](0L, _ + _).lp // Prints: 500500
 *   }}}
 */
