package scalqa; package fx; package control; package table; package column; import language.implicitConversions

transparent trait _edit[ROW,V,A]:
  self: Column[ROW,V,A] =>
  private[table] var editEnabledFun : ROW => Boolean   = \/
  private[table] var editCommitFun  : (ROW, A) => Unit = \/

  def useEditor(e: => Editor, commit: (ROW, A) => Unit, enabled: ROW => Boolean = \/): Unit = {
    useCell(e)
    editEnabledFun = enabled
    editCommitFun = commit
  }

  trait Editor extends Table.Cell[ROW,V,A]

  class CheckBox extends Cell.X.CheckBox[ROW,V,A](self) with Editor

  class ComboBox extends Cell.X.ComboBox[ROW,V,A](self) with Editor:
    def this(initItems: Stream[A]) = { this(); items ++= initItems }

  class TextField(parser: String => Result[A]) extends Cell.X.TextField[ROW,V,A](self, parser) with Editor

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Editor -> Cell Editor


@class CheckBox -> CheckBox Editor


@class ComboBox -> ComboBox Editor


@class TextField -> TextField Editor




*/
