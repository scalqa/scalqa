package scalqa; package Coll; package W; package The

class _Class[A] extends W[A] {
  private var chain: Z.The.Link[A] = \/
  private var _size = 0

  def all = chain.all

  def size = _size

  def add(a: A) { chain = Z.The.Link(a, chain); _size += 1 }

  final def remove(e: A) = removeFor(_ == e)

  def removeFor(f: A => Boolean): Coll[A] = chain.split(f) to ((lnk1, lnk2) => { chain = lnk2; _size -= lnk1.size; lnk1 })

  def clear = (size > 0).I.run { _size = 0; chain = \/ }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
