package scalqa; package `val`; import lookup.*; import language.implicitConversions

trait Lookup[A, +B] extends Collection[B]:
  @tn("get_Opt")        def get_?(key: A)     : Opt[B]
  @tn("get_Stream")     def get_~(keys: ~[A]) : ~[B]       = keys.map_?(k => get_?(k))
  /**/                  def get(v: A)         : B          = get_?(v) or (throw ZZ.ME(v.tag))
  @tn("pair_Stream")    def pair_~            : ~[(A, B)]
  @tn("key_Stream")     def key_~             : ~[A]       = pair_~.map(_._1)
  @tn("stream")         def ~                 : ~[B]       = pair_~.map(_._2)

object Lookup:
  /**/                  def lazySource[A,B](createFunOpt:A=>Opt[B]): Lookup[A,B] = Z.Basic(createFunOpt)
  /**/                  def apply[A,B](v: ~[(A, B)])               : Lookup[A,B] = Stable(v)
  /**/                  def apply[A,B](vs: (A, B)*)                : Lookup[A,B] = Stable(vs)
  @tn("getVoid") inline def void[A,B]                              : Lookup[A,B] = Stable.void
  implicit       inline def implicitRequest[A,B](v: \/)            : Lookup[A,B] = void[A,B]

  extension[A,B] (x: Lookup[A,B])
    @tn("map_View")               def map_^[C](f: B => C) : Lookup[A,C]               = Z.Convert_View(x, f)
    @tn("toMap_View")             def toMap_^             : scala.collection.Map[A,B] = Z.ScalaMap_View(x)
    @tn("toPartialFunction_View") def toPartialFunction_^ : PartialFunction[A,B]      = Z.PartialFunction_View(x)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Stable  = lookup.Stable;   type Stable[A,B]  = lookup.Stable[A,B]
  transparent inline def Mutable = lookup.Mutable;  type Mutable[A,B] = lookup.Mutable[A,B]
  transparent inline def M       = Mutable;         type M[A,B]       = Mutable[A,B]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Lookup -> ### Lookup Collection

      In [[Lookup]] collection every element is stored with a 'key' and can be accessed (looked up) with this 'key'

      It is a greatly simplified equivalent of scala.Map


@def get ->  Element by key

      Returns element associated with the given `key`

      Note. This operation will fail, if value is not found. Thus, use safer [[get_?]] in most cases

@def get_? -> Optional element by key

      Optionally returns element associated with the given `key`

@def get_~ -> Multi key lookup

      Returns a stream of values for given stream of keys.

      Note: There may be less values, than keys. Keys with no assosiated values are ignored.

@def pair_~  -> Key/value pair stream

      Returns a [[Stream]] of all key/value pairs for this [[Lookup]]


@def key_~ -> Key stream

      Returns a [[Stream]] of all keys for this [[Lookup]]


@def ~ -> Value stream

      Returns a [[Stream]] of all values for this [[Lookup]]

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/
