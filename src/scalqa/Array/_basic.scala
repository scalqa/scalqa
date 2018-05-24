package scalqa; package Array

trait _basic[A] extends Any with Like._basic[A, _Class] {

  def update(position: Int, value: A): Unit = raw.update(position, value)

  def applyUpdateIf(position: Int, updateIf: A => Boolean, newValue: A => A): A = { var b = apply(position); if (updateIf(b)) { b = newValue(b); update(position, b) }; b }

  def applyUpdateNull(position: Int, newValue: => A): A = applyUpdateIf(position, _ == null, _ => newValue)

  def Refs: View.Refs[A] = new View.Refs(raw)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def Refs -> Create view
 *
 *     Built-in constructor to create [[Array.View.Refs]] instances
 *
 *     Sending [[Refs]] to another method is like sending this [[Array]],
 *     but without ability to update data
 *
 *     Essentially this is like creating unmodifiable "view"
 *
 * @def applyUpdateIf -> Get with conditional update
 *
 *     Like regular ''apply'' this method returns element at given position
 *
 *     However, before the value is returned it is checked with the filter function 'updateIf'.
 *     If ''true'', the [[Array]] is updated with the ''newValue'' and the new value is returned
 *
 *     This function is great for implementing lazy [[Array]] defaults
 *
 *     {{{
 *         var next: Int = 'A'
 *
 *         def createDefault: Char = next.toChar.I.run(next += 1)
 *
 *         val a: Array[Char] = Array.get(10)
 *
 *         a.size.all.map(i => a.applyUpdateIf(i, _ == 0, _ => createDefault)).lp
 *         a.all.lp
 *
 *         // Output
 *         ~(A, B, C, D, E, F, G, H, I, J)
 *         ~(A, B, C, D, E, F, G, H, I, J)
 *     }}}
 *
 * @def applyUpdateNull -> Get with update for ''null''
 *
 *     Like regular ''apply'' this method returns element at given position
 *
 *     However, before the value is returned,  if it is ''null'',
 *     the [[Array]] is updated with the ''newValue'' and the new value is returned
 *
 *     This function is great for implementing lazy defaults for [[Array]][AnyRef]
 *
 *     {{{
 *         var next: Int = 'A'
 *
 *         def createDefault: String = (next.toChar.toString * 3).I.run(next += 1)
 *
 *         val a: Array[String] = Array.get(10)
 *
 *         a.size.all.map(i => a.applyUpdateNull(i, createDefault)).lp
 *         a.all.lp
 *
 *         // Output
 *         ~(AAA, BBB, CCC, DDD, EEE, FFF, GGG, HHH, III, JJJ)
 *         ~(AAA, BBB, CCC, DDD, EEE, FFF, GGG, HHH, III, JJJ)
 *     }}}
 *
 * @def update -> Replace at position
 *
 *     Replaces [[Array]] element at the specified position with specified value
 *
 *     {{{
 *       var a = Array.get[String](2)
 *
 *       a.update(0,"First")
 *
 *       // This is Scala "sintactic sugar" for the above
 *       a(1) = "Second"
 *
 *       a.all.lp  // Prints: ~(First, Second)
 *     }}}
 */
