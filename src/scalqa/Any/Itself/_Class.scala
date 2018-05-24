package scalqa; package Any; package Itself

class _Class[A] private[scalqa] (private[Itself] val _target: A) extends AnyVal with _use[A] with _opt[A] with _container[A] with _describe[A] with _printDebug[A]

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *     [[Any.Itself]] is a library available for ''every'' single object in Scalqa
 *
 *     [[Any.Itself]] has to be accessed of <any>.I notation
 *
 *     Because, of <any>.I access [[Any.Itself]] has luxury of providing diverse functionality on every object with no naming conflicts with application methods
 *
 *     {{{
 *       val txt = "abc".Text.I(_ lp) // Prints: "abc"
 *
 *       txt.I.id lp                  // Prints: scalqa.String.Text@1
 *
 *       txt.I.hashIndex lp           // Prints: 1
 *     }}}
 */
