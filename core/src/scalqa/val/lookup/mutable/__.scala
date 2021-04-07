package scalqa; package `val`; package lookup; import mutable.*; import language.implicitConversions

trait Mutable[A,B] extends Lookup[A,B]:
  def getOrPut(key: A, v: => B): B         = get_?(key) or { val b = v; put(key, b); b }
  def put(key: A, value: B)    : Unit
  def putAll(s: ~[(A, B)])     : Unit      = s.foreach(put)
  def update(key: A, value: B) : Opt[B]    = get_?(key).^(_ => put(key,value))
  def updateAll(s: ~[(A, B)])  : ~[B]      = s.map_?(update).load
  def remove(v: A)             : Opt[B]
  def removeAll(keys: ~[A])    : ~[B]      = keys.map_?(remove).load
  def clear                    : Unit

object Mutable:
  def apply[A,B]()             : Mutable[A,B] = X.Basic[A,B]
  def apply[A,B](v: ~[(A, B)]) : Mutable[A,B] = apply().self_^(_.putAll(v))
  def concurrent[A,B]()        : Mutable[A,B] = new X.Concurrent[A,B]()

  extension[SELF <: Mutable[A,B],A,B](x: SELF)
    @tn("put")        inline def +=(v: (A,B))             : SELF         = { x.put(v._1,v._2);  x }
    @tn("putAll")     inline def ++=(inline s: ~[(A, B)]) : SELF         = { x.putAll(s);       x }
    @tn("remove")     inline def -= (inline key: A)       : SELF         = { x.remove(key);     x }
    @tn("removeAll")  inline def --=(inline keys: ~[A])   : SELF         = { x.removeAll(keys); x }

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def X = mutable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Mutable -> ### Mutable Lookup Collection

      Mutable lookup collection provides methods to modify its content

      Note. [[Lookup.Mutable]] DOES NOT extend [[Collection.Mutable]], as it if impossible to reconsile these operations.

@def getOrPut -> Get or create key/value association

      Returns existent value assisiated with the given key.

      If the association does not exist, it will be created with the given default value, and then same value will be returned.

@def put -> Create key/value association

      If given key entry already exists, it will be overridden with given value

      If given key entry does not exist, it will be added, with collection increasing in size

@def putAll -> Create multitiple key/value associations

      This operation executes [[put]] for every stream entry

@def update -> Update key/value association

      Unlike [[put]], this operation will only update existing association, and will do nothing for non-existent.

@def updateAll -> Update multiple key/value associations

      This operation executes [[update]] for every stream entry

@def clear -> Make empty

     Discards all entries, collection size will become zero

@def remove -> Remove key association

    Removes given key and value associated with it

    Optionally returns the removed value, if it was indeed removed.

@def removeAll -> Remove milti key associations

    Removes given stream of keys and values associated with them

    Returns stream of removed values

*/