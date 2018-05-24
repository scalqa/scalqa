package scalqa; package String; package _library

trait _constructor extends Any with __ {

  def Text: Text = This

  def Id: Id = String.Id.get(This)

  def Ops = new scala.collection.immutable.StringOps(This)

  def Wrap = new scala.collection.immutable.WrappedString(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def Ops ->  Scala StringOps library
 *
 *   Provides access to Scala StringOps library.
 *
 *   This library is available by default in Scala, but is disabled in Scalqa
 *   {{{ "abc".Ops.head.lp  // Prints: a }}}
 *
 * @def Wrap ->  Scala WrappedString library
 *
 *   Provides access to Scala WrappedString library.
 *
 *   This library is available by default in Scala, but is disabled in Scalqa
 *   {{{ "abc".Wrap.head.lp  // Prints: a }}}
 *
 *
 * @def Text -> As Text
 *
 *    Built-in constructor to create [[String.Text]] instances
 *
 *    {{{
 *        "a \n b \n c".Text.allLines lp
 *
 *        // Output
 *        ~(a ,  b ,  c)
 *    }}}
 *
 * @def Id -> As Id
 *
 *    Built-in constructor to create [[String.Id]] instances
 *
 */
