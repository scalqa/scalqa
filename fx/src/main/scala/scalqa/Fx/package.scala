package scalqa

package object Fx {
  type Application = Application._Class
  type Action = Action._Class
  type Button = Button._Class
  type Cell = Cell._Class
  type Chart = Chart._Class
  type CheckBox = CheckBox._Class
  type ComboBox[A] = ComboBox._Class[A]
  type Event = Event._Class
  type Image = Image._Class
  type Label = Label._Class
  type List[A] = List._Class[A]
  type Menu = Menu._Class
  type Paint = Paint._Trait
  type Pane = Pane._Class
  type Popup = Popup._Class
  type Scene = Scene._Class
  type Selection[A] = Selection._Class[A]
  type Shape = Shape._Class
  type Stage = Stage._Class
  type Style = Style._Class
  type Table[T] = Table._Class[T]
  type Text = Text._Class
  type Tooltip = Tooltip._Class
  type Window = Window._Class

  // Shortcuts
  type Color = Paint.Color._Class; val Color = Paint.Color.This
  type Font = Text.Font; val Font = Text.Font
  val Thread = Application.Thread

  type Orientation = Geometry.Orientation; val Orientation = Geometry.Orientation
  type Insets = Geometry.Insets; val Insets = Geometry.Insets
  type Side = Geometry.Side; val Side = Geometry.Side
  type Pos = Geometry.Pos; val Pos = Geometry.Pos
  type VPos = Geometry.VPos; val VPos = Geometry.VPos
  type HPos = Geometry.HPos; val HPos = Geometry.HPos

  implicit def zzStringToLabel(text: String) = Label.make(text)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
