package scalqa; package Fx; package Table; package Column

class Config[A] private (private val coll: Refs[Column[_, _, A] => Any]) {
  protected def this(on: Column[_, _, A] => Any) = this(on.I.to[Refs])

  def +(on: Column[_, _, A] => Any) = new Config[A](coll + on)

  def +(b: Config[A]): Config[A] = new Config[A](coll +~ b.coll)

  def apply[B <: A] = this.asInstanceOf[Config[B]]

  def apply[E, V](ui: Cell.Ui[E, V, _ <: A]): Unit = {
    val c = ui.I.as[Column[E, V, A]](ui => new Column[E, V, A] with Cell.Ui.Z.Proxy[E, V, A] {
      def realUi = ui.asInstanceOf[Cell.Ui[E, V, A]]
      def table = ui.column.table
      val real = new javafx.scene.control.TableColumn[E, Cell.Z.Item[E, V, A]]
    })
    coll.all(_(c.I.asInstanceOfTarget))
  }
}

object Config extends Util.Void.Setup.Typed[Config](new Config[Any](\/ : Refs[Column[_, _, Any] => Any]) with Void) {

  def make[A](on: Column[_, _, A] => Any) = new Config(on)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
