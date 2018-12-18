package scalqa; package Pro

trait _Trait[@specialized(DATA) +A] {

  def apply(): A

}

object _Trait {

  implicit def zzFunction0[A](v: Pro[A]): () => A = () => v()

  implicit def zzLibrary[A](v: Pro[A]) = new _library._Class(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Properties Framework`
 *
 *     Properties are needed for GUI programming and can be skipped in most cases
 *
 *    There are 4 types of standard properties:
 *
 *     - `[[scalqa.Pro    Pro]]`    - view only
 *     - `[[scalqa.Pro.M  Pro.M]]`  - mutable
 *     - `[[scalqa.Pro.O  Pro.O]]`  - observable
 *     - `[[scalqa.Pro.OM Pro.OM]]` - observable, mutable
 *
 *     and they are hierarchical:
 *     {{{
 *             Pro.O
 *           /       \
 *       Pro           Pro.OM
 *           \       /
 *             Pro.M
 *     }}}
 *
 *     Here are the signature examples based on 'name' property
 *
 *     {{{
 *              // 'Read Only'
 *             trait MyObject{
 *                 def namePro: Pro[String]
 *                 def name: String = namePro()               // Required shortcut
 *             }
 *
 *             // 'Read Write'
 *             trait MyObject_Writable extends MyObject{
 *                 def namePro: Pro.M[String]
 *                 def name_=(v :String):Unit = namePro() = v // Required shortcut
 *             }
 *
 *             // 'Read Only, Observable'
 *             trait MyObject_Observable extends MyObject{
 *                 def namePro: Pro.O[String]
 *             }
 *
 *             // 'Read Write Observable'
 *             trait MyObject_OW extends MyObject_Observable with MyObject_Writable {
 *                 def namePro: Pro.OM[String]
 *             }
 *     }}}
 *
 *     Note. The 'Required shortcuts' must be implemented. They do not even show up in documentation, because they are assumed to be there
 *
 * @def apply -> Property value
 *
 *     Returns property value
 *
 *     {{{
 *         val pro: Pro.M[String] = Pro.M.make[String]("abc")
 *
 *         val v1 = pro.apply() // Regular call
 *         val v2 = pro()       // Scala "syntactic sugar" call
 *     }}}
 */
