package scalqa; package fx; package scene; package chart; package axis; package x; import language.implicitConversions

class Category extends Chart.Axis[String]:
  def this(name: String) = { this(); name.??.forval(label = _) }
  type VALUE = String
  protected type REAL = javafx.scene.chart.CategoryAxis; override def _createReal = new REAL

  /**/  val list: Idx.M[String] =  Idx.M.wrap(real.getCategories)
  final def valueMap=VOID
  /**/  val ordering = String.ordering

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
