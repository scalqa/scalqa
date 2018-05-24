package scalqa

package object J {
  type Input = Input._Trait
  type Output = Output._Trait
  type Format[A] = Format._Trait[A]
  type Path = Path._Class
  type Printer = Printer._Trait
  type File = File._Class
  type Url = Url._Class

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object J ->
 *
 *   '''J''' provides access to common Java functionality in Scalqa style
 *
 *   It is possible to use Java directly without the ''J'' package, but this would require lots of unnecessary boilerplate code, prone to errors
 *   
 *   ''J'' will probably cover over 95% of use cases, for the rest access Java directly 
 */
