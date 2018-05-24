package scalqa; package Int; package _library

trait _range extends Any with Any._library._range[Int] with __ {

  override def <>!(implicit s: Sorting[Int], t: Tag[Int] = \/): Range = Int.Range.getByStartSize(This, 1)

  override def <>>!(implicit s: Sorting[Int], t: Tag[Int] = \/): Range = Int.Range.getByStartSize(This, 0)

  override def <>(that: Int)(implicit s: Sorting[Int], t: Tag[Int] = \/): Range = Int.Range.getByStartSize(This, that - This + 1)

  override def <>>(that: Int)(implicit s: Sorting[Int], t: Tag[Int] = \/): Range = Int.Range.getByStartSize(This, that - This)

  override def <>+(size: Int)(implicit s: Step[Int], srt: Sorting[Int], t: Tag[Int] = \/): Range = Int.Range.getByStartSize(This, size + 1)

  override def <>>+(size: Int)(implicit s: Step[Int], srt: Sorting[Int], t: Tag[Int] = \/): Range = Int.Range.getByStartSize(This, size)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _range ->
 *
 *     Creating [[scalqa.Range Range[Int]]] based on [[Int]] value is different because special [[Int.Range]] is created
 *
 *     Note that [[Int.Range]] always has exclusive ''end'', which leads to the following discrepancies:
 *
 *     {{{
 *        3 <> 5   // Creates 3 <>> 6
 *
 *        3 <>+ 2  // Creates 3 <>> 6
 *
 *        3 <>!    // Creates 3 <>> 4
 *     }}}
 */
