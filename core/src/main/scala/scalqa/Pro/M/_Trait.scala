package scalqa; package Pro; package M

trait _Trait[@specialized(DATA) A] extends Pro[A] {

  def update(v: A): Unit

}

object _Trait {

  implicit def zzLibrary[A](v: M[A]) = new _library._Class(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Read Write Property`
 *
 *     The usual in-type implementation looks like:
 *     {{{
 *        // Note. Highly predictable shortcut methods are in one line,
 *        //       to save front row space for semantically heaviar methods
 *
 *        class MyClass{
 *
 *           lazy val namePro: Pro.M[String] = Pro.M.make[String](""); def name = namePro(); def name_=(v :String):Unit = namePro() = v
 *
 *           lazy val valuePro = Pro.M.make[Int](0); def value = valuePro(); def value_=(v :Int):Unit = valuePro() = v
 *        }
 *     }}}
 *
 * @def update -> Updates value
 *
 *     Updates property value
 *
 *     {{{
 *         val pro: Pro.M[String] = Pro.M.make[String]("")
 *
 *         pro.update("abc") // Regular call
 *
 *         pro() = "abc"     // Scala "syntactic sugar" call
 *     }}}
 */
