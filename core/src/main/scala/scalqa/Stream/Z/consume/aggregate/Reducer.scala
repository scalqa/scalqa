package scalqa; package Stream; package Z; package consume; package aggregate

private[aggregate] abstract class Reducer[@specialized(DATA) A] extends Consumer[A] {
  var fresh = true
  var value: A = _

  def accept(v: A) = if (fresh) init(v) else value = reduce(value, v)

  def reduce(x: A, y: A): A

  def init(v: A) = { fresh = false; value = v }

  def toOpt: Opt[A] = if (fresh) Opt.Void else value

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
