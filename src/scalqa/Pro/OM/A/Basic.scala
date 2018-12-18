package scalqa; package Pro; package OM; package A

class Basic[@specialized(DATA) A](private var value: A) extends Base[A] {

  def apply = value;

  def update(v: A) = if (value != v) { value = v; fireChange }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
