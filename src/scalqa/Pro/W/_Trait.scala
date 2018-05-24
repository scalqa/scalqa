package scalqa; package Pro; package W

trait _Trait[A] extends Pro[A] {

  def update(v: A)

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](v: W[A]) = new _library(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Read Write Property'''
 *
 *     The usual in-type implementation looks like:
 *     {{{
 *        // Note. Highly predictable shortcut methods are in one line,
 *        //       to save front row space for semantically heaviar methods
 *
 *        class MyClass{
 *
 *           lazy val namePro: Pro.W[String] = Pro.W.get[String](""); def name = namePro(); def name_=(v :String):Unit = namePro() = v
 *
 *           lazy val valuePro = Pro.W.get[Int](0); def value = valuePro(); def value_=(v :Int):Unit = valuePro() = v
 *        }
 *     }}}
 *
 * @def update -> Updates value
 *
 *     Updates property value
 *
 *     {{{
 *         val pro: Pro.W[String] = Pro.W.get[String]("")
 *
 *         pro.update("abc") // Regular call
 *
 *         pro() = "abc"     // Scala "syntactic sugar" call
 *     }}}
 */
