package scalqa; package Coll; package O; package Change

abstract class _Class[A] private[scalqa] extends Able.Info {

  def name: String

  protected def info = \/.info ~ ("name", name) ~~ {
    this match {
      case v: Index.O.Add[A] => \/.info ~ ("range", v.range) ~ ("item", v.items.all.format(","))
      case v: Index.O.Remove[A] => \/.info ~ ("range", v.range) ~ ("item", v.items.all.format(","))
      case v: Coll.O.Add[A] => \/.info ~ ("item", v.items.all.format(","))
      case v: Coll.O.Remove[A] => \/.info ~ ("item", v.items.all.format(","))
      case v: Index.O.Refresh[A] => \/.info ~ ("range", v.range)
      case v: Index.O.Reposition[A] => \/.info ~ ("range", v.range) ~ ("index", v.indexes)
      case _ => \/.info
    }
  }

}

object _Class {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](v: Change[A]) = new _library(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @class _Class -> '''Collection Change'''
 *
 *  [[Change]] represents similar manipulation to one or many elements of the collection
 *
 *  There are 6 type of [[Change]] in existence:
 *
 *    - [[Coll.O.Add]]
 *    - [[Coll.O.Remove]]
 *    - [[Index.O.Add]] extends [[Coll.O.Add]]
 *    - [[Index.O.Remove]] extends [[Coll.O.Remove]]
 *    - [[Index.O.Refresh]]
 *    - [[Index.O.Reposition]]
 *
 *   When processing a [[Change]], it can be matched with the above types
 *
 * @def name -> Change name
 *
 *     Can be "Add", "Remove", "Refresh", or "Reposition"
 *
 *
 */
