package scalqa; package fx; package scene; package chart; import axis.*; import language.implicitConversions

abstract class Axis[A] extends Abstract.Region with _properties:
  type VALUE
  protected type REAL <: javafx.scene.chart.Axis[VALUE]

  def valueMap    : ReversibleFunction[A, VALUE]
  val ordering    : Ordering[A]
  def apply(v: A) : Double            = real.getDisplayPosition(valueMap(v))
  def ticks       : Idx[Tick[A]]      = Idx.wrap(real.getTickMarks).map_^(axis.Tick(_, valueMap))

object Axis:
  inline def X = axis.X
  type Tick[A]  = axis.Tick[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
