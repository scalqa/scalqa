package scalqa; package Pro; package WO

trait _Trait[A] extends W[A] with O[A]

object _Trait {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](v: WO[A]) = new _library(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Read Write Observable Property'''
 *
 *     The usual in-type implementation looks like:
 *     {{{
 *        // Note. Highly predictable shortcut methods are in one line,
 *        //       to save front row space for semantically heaviar methods
 *
 *        class MyClass{
 *
 *           lazy val namePro: Pro.WO[String] = Pro.WO.get[String](""); def name = namePro(); def name_=(v :String):Unit = namePro() = v
 *
 *           lazy val valuePro = Pro.W.get[Int](0); def value = valuePro(); def value_=(v :Int):Unit = valuePro() = v
 *        }
 *     }}}
 *
 */
