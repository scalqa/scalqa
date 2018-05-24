package scalqa; package Pro

trait _Trait[+A] extends Able.Info {

  def apply(): A

  protected def info = \/.info ~~ this.I.letAs(classOf[Able.Name]).map(n => ("name", n.name)) ~ ("value", apply)

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzFunction0[A](v: Pro[A]): () => A = () => v()

  implicit def zzLibrary[A](v: Pro[A]) = new _library(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Scalqa Properties Framework'''
 *
 *     There are 4 types of standard properties:
 *
 *     - '''[[scalqa.Pro    Pro]]'''    - read only
 *     - '''[[scalqa.Pro.W  Pro.W]]'''  - read, write
 *     - '''[[scalqa.Pro.O  Pro.O]]'''  - read only, observable
 *     - '''[[scalqa.Pro.WO Pro.WO]]''' - read, write, observable
 *
 *     and they are hierarchical:
 *     {{{
 *             Pro.O
 *           /       \
 *       Pro           Pro.WO
 *           \       /
 *             Pro.W
 *     }}}
 *
 *     Here are the signature examples based on 'name' property
 *
 *     {{{
 *              // 'Read Only'
 *             trait MyPro{
 *                 def namePro: Pro[String]
 *                 def name: String = namePro()               // Required shortcut
 *             }
 *
 *             // 'Read Write'
 *             trait MyPro_W extends MyPro{
 *                 def namePro: Pro.W[String]
 *                 def name_=(v :String):Unit = namePro() = v // Required shortcut
 *             }
 *
 *             // 'Read Only Observable'
 *             trait MyPro_O extends MyPro{
 *                 def namePro: Pro.O[String]
 *             }
 *
 *             // 'Read Write Observable'
 *             trait MyPro_WO extends MyPro_W with MyPro_O{
 *                 def namePro: Pro.WO[String]
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
 *         val pro: Pro.W[String] = Pro.W.get[String]("abc")
 *
 *         val v1 = pro.apply() // Regular call
 *         val v2 = pro()       // Scala "syntactic sugar" call
 *     }}}
 */
