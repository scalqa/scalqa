package scalqa; package Lookup; package M; package A

class Basic[A, B](protected val real: java.util.Map[A, B]) extends M[A, B] {
  def this(initCapacity: Int = App.initSize) = this(new java.util.HashMap[A, B](initCapacity))

  def getOpt(key: A) = real.get(key)

  def size = real.size

  def allPairs: ~[(A, B)] = real.entrySet.iterator.all.map(e => (e.getKey, e.getValue))

  def clear = (real.size > 0).I(if (_) real.clear)

  def put(key: A, value: B) = { real.put(key, value) }

  def remove(key: A) = real.remove(key) != null

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
