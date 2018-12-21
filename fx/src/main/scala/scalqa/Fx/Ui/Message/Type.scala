package scalqa; package Fx; package Ui; package Message

sealed class Type extends Util.Enum[Type](Type) {

  def isInfo = this == Type.Info

  def isWarning = this == Type.Warning

  def isError = this == Type.Error

  def color: Fx.Color = this match {
    case Type.Info    => Fx.Color.Green
    case Type.Warning => Fx.Color.Blue
    case Type.Error   => Fx.Color.Red
    case _            => Fx.Color.Black
  }

}

object Type extends Util.Enum.Setup[Type] {

  val Info, Warning, Error = new Type

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
