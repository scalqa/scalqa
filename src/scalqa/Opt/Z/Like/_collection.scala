package scalqa; package Opt; package Z; package Like

private[Opt] trait _collection[+A] extends Any with __[A] with Coll[A] {

  def size: Int = if (_isVal) 1 else 0

  def all: ~[A] = if (_isVal) _val.I.~ else \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _collection -> '''Collection Interface'''
 *
 * @def all ->  As Pipe
 *
 *    If no value, void pipe is returned
 *
 *    Otherwise the pipe with a single value element is returned
 *
 *    {{{
 *       Opt.Void.all.lp     // Prints: void
 *
 *       12.Opt.all.lp       // Prints: ~(12)
 *
 *       "Abc".Opt.all.lp    // Prints: ~(Abc)
 *    }}}
 *
 * @def size -> 1 or 0
 *
 *    Returns 1 if there is value, 0 otherwise
 *
 *     {{{
 *       Opt.Void.size.lp    // Prints: 0
 *
 *       12.Opt.size.lp      // Prints: 1
 *
 *       "Abc".Opt.size.lp   // Prints: 1
 *     }}}
 */
