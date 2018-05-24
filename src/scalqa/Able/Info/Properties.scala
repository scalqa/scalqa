package scalqa; package Able; package Info

class Properties private[Info] (p: Pipe[(Any, Any)]) extends Coll[(String, String)] {
  private val real = p.map(t => ((t._1 ? "").toString, (t._2 ? "").toString)).to[Coll]

  def all = real.all
  def size = real.size

  def allNames: ~[String] = all.map(_._1)
  def allValues: ~[String] = all.map(_._2)
  def allLabels(separator: String = "="): ~[String] = all.map(t => if (t._1.isVoid) t._2 else t._1 + separator + t._2)

  def names: String = allNames.format(",")
  def values: String = allValues.format(",")
  def labels: String = allLabels().format(",")

  def infoLine(label: String): String = label + '{' + labels + '}'

  def infoText(label: String): String.Text = (allLabels().format(",\n") + '}').Text.indent(label + '{')

}

object Properties extends Void.Companion[Properties](new Properties(\/) with Void)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Properties ->
 *
 *   Class [[Properties]] is rarely used in applications and can be skipped for later
 *
 *   [[Properties]] present a collection of info defined properties in [[Able.Info]] and accessed as: "<anyAbleInfo>.I.info"
 *
 */
