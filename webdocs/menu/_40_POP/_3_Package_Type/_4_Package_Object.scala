package POP.Package_Type

/**
 *  What if package type has a single instance?  This would be equivalent to Scala object definition, which by itself can contain other entities
 *
 *  Fast solution would be to use the 'package object' itself as a single entity
 *
 *  In Scala however 'package object' is not a 'val' by default, and it has other problems with inheritance
 *
 *  The best solution so far (but not perfect for sure) is to create an object with fixed name `The` and treat it as a value object of the package
 *
 *  In the following example we create an application, where all Gui is defined in a package "Ui', and the Ui has a single package object `Ui.The` (pronounced "The Ui")
 *
 *  {{{
 *    package Foo{
 *
 *      package Ui {
 *        class Menu{ /*Menu definition */  }
 *        class Panel{ /*Panel definition */  }
 *
 *        object The extends Fx.Panel{
 *          add(new Menu)
 *          add(new Panel)
 *       }
 *     }
 *
 *     object Main extends Fx.Aplication{
 *
 *       scene = Ui.The  // All Ui as a single object
 *
 *     }
 *  }}}
 */
class Package_Object { val sort_4 = () }
