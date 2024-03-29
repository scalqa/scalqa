package scalqa; package `val`; package lookup; import mutable.*; import language.implicitConversions

trait Mutable[A,B] extends Lookup[A,B]:
  /**/   def getOrPut(key: A, v: => B)  : B             = getOpt(key) or { val b = v; put(key, b); b }
  /**/   def put(key: A, value: B)      : Unit
  /**/   def putAll(s:Stream[(A,B)])    : Unit         = s.foreach(put)
  /**/   def update(key: A, value: B)   : Opt[B]       = getOpt(key).self(_ => put(key,value))
  /**/   def updateAll(s:Stream[(A,B)]) : Stream[B]    = s.mapOpt(update).load
  /**/   def remove(v: A)               : Opt[B]
  /**/   def removeAll(keys: Stream[A]) : Stream[B]    = keys.mapOpt(remove).load
  /**/   def clear                      : Unit
  inline def +=(v: (A,B))               : this.type    = { put(v._1,v._2);  this }
  inline def ++=(inline s:Stream[(A,B)]): this.type    = { putAll(s);       this }
  inline def -= (inline key: A)         : this.type    = { remove(key);     this }
  inline def --=(inline keys: Stream[A]): this.type    = { removeAll(keys); this }

object Mutable:
  /**/              def apply[A,B]()               : Mutable[A,B] = X.Basic[A,B]
  /**/              def apply[A,B](v:Stream[(A,B)]): Mutable[A,B] = apply().self(_.putAll(v))
  /**/              def concurrent[A,B]()          : Mutable[A,B] = new X.Concurrent[A,B]()
  implicit   inline def implicitRequest[A,B](v:NEW): Mutable[A,B] = apply()

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def X = mutable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Mutable -> ### Mutable Lookup Collection

      Mutable lookup collection provides methods to modify its content

      Note. [[Lookup.Mutable]] does not extend [[Collection.Mutable]], because it is impossible to reconsile update operations.

@def +=  -> Alias for [[put]]
@def ++= -> Alias for [[putAll]]
@def -=  -> Alias for [[remove]]
@def --= -> Alias for [[removeAll]]

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