package scalqa; package Any; package Itself

trait _describe[A] extends Any with __[A] {

  def id: String = This.Class.label + '@' + hashIndex

  def hashIndex: Int = HashIndexes(This.##)

  def trace(xs: Any*): Unit = println(id + ' ' + xs.all.format(" "))

  def info: Able.Info.Properties = infoOpt or \/
  def infoOpt: Opt[Able.Info.Properties] = This.I.letAs(classOf[Able.Info]).map(Able.Info._Trait.properties)
  def infoLine: String = info(This, Able.Info._Trait.line)
  def infoText: String.Text = info(This, Able.Info._Trait.text)

  // -------------------------------------------------------------------------
  private def info(v: Any, f: Able.Info => String): String = v match {
    case null                  => "null"
    case ()                    => " "
    case o: Opt[_] if o.isVoid => "Opt.Void"
    case t if t.isVoid         => "void"
    case t: Able.Info          => f(t)
    case v: ~[_]               => info((v: Pipe[_]), f)
    case v                     => v.toString
  }

  override def toString: String = This match {
    case ()            => " "
    case null          => "null"
    case t if t.isVoid => "void"
    case v             => v.toString
  }
}

// ***********************************************************************
private object HashIndexes extends Lookup.W.The[Int, Int] { var cnt = 0; override def apply(a: Int): Int = this.getOrElsePut(a, { cnt += 1; cnt }) }
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def info: -> Info properties
 *
 *    Returns [[Able.Info.Properties]] collection
 *
 *    If this is not instance of [[Able.Info]], void collection is returned
 *
 * @def infoLine -> String Description
 *
 *    If this isInstanceOf [[Able.Info]], then ''info'' is returned
 *
 *    Otherwise toString is returned
 *
 * @def infoText -> Text Description
 *
 *    If this isInstanceOf [[Able.Info]], then ''infoText'' is returned
 *
 *    Otherwise toString is returned
 *
 * @def toString -> String description
 *
 *     Only differences with basic ''toString'':
 *
 *       - will not fail for ''null'' and print "null"
 *       - for void objects will print "void"
 *       - for scala singleton objects will omit hashCode (which does not make sense)
 *
 *     {{{
 *         "abc".I.toString.lp           // Prints: abc
 *         (null: String).I.toString.lp  // Prints: null
 *         "".I.toString.lp              // Prints: void
 *     }}}
 *
 * @def trace -> Tracing with id
 *
 *   This is a debugging console printer.
 *
 *   It works like regular ''Print.ls'' statement, but prints ''this'' 'id' first
 *    {{{
 *         object ABC
 *         ABC.I.trace("Value:", 25)*
 *         // Output
 *         scalqa.Test_ABC@1 Value: 25
 *     }}}
 *
 * @def id -> Instance identifier
 *
 *   Returns: Class.label + "@" + hashIndex
 *    {{{ "abc".I.id.lp  // Prints: java.lang.String@1 }}}
 *
 * @def hashIndex -> Easy to read hash
 *
 *    Object hash is a long, hard to read number.
 *
 *   This method creates a static Lookup, where the long hash is stored with its sequential index. The index is used instead of real hash.
 *
 *   This mechanism is great for light debugging, and should not be use in production, because the Lookup table can grow to a point when it is a hurdle.
 *
 *   {{{
 *     object MyObject
 *
 *     "other1".I.hashIndex.lp  // Prints: 1
 *     MyObject.I.hashIndex.lp  // Prints: 2
 *     "other2".I.hashIndex.lp  // Prints: 3
 *     MyObject.I.hashIndex.lp  // Prints: 2
 *     "other3".I.hashIndex.lp  // Prints: 4
 *     MyObject.I.hashIndex.lp  // Prints: 2
 * }}}
 *
 *
 */
