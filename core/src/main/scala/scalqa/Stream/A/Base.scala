package scalqa; package Stream; package A

abstract class Base[A] protected extends Stream[A] with Specialized[A] {

  def foreach(c: Consumer[A]) = while (prime) c.accept(pump)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Base -> `Basic Abstract Stream`
 *
 *
 */
