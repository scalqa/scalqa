package scalqa; package fx; package scene; package chart; import language.implicitConversions

import javafx.scene.{ chart => J }

abstract class XY[X, Y] protected (val axisX: Chart.Axis[X], val axisY: Chart.Axis[Y]) extends Chart with xy._properties[X,Y]:
  self =>
  protected      type REAL       <: J.XYChart[axisX.VALUE, axisY.VALUE]
  private[chart] type REAL_SERIES = J.XYChart.Series[axisX.VALUE, axisY.VALUE]
  private[chart] type REAL_ITEM   = J.XYChart.Data[axisX.VALUE, axisY.VALUE]
  /**/           type SERIES     <: SeriesBase
  /**/           type ITEM       <: ItemBase

  val data:  Idx.M[SERIES] =  Idx.M.javaList_^(real.getData).twoWay_^(SeriesBase.apply, _.real.cast[REAL_SERIES])

  // **************************************************************************************************************
  class SeriesBase protected (nameO: String.Opt = \/, private var _items:  Idx.O[ITEM] = \/):
    protected[chart] val real : self.REAL_SERIES = new self.REAL_SERIES(zObservableList()).^(s => nameO.forval(s.setName))
    /**/             def chart: Chart.XY[X, Y]    = self
    /**/             def name : String            = real.getName; def name_=(v: String) = real.setName(v)
    /**/             def items: Idx.O[ITEM]       = _items;       def items_=(l:  Idx.O[ITEM]): Unit = { _items = l; real.setData(zObservableList()) }
    // ***************************
    private class zObservableList extends ui.javaFx.z.list.Observable[self.REAL_ITEM](items.fun_^(_.real.cast[self.REAL_ITEM])){ def series = SeriesBase.this}

  object SeriesBase:
    def apply(s: J.XYChart.Series[_, _]): SERIES = s.getData.cast[SeriesBase#zObservableList].series.cast[SERIES]

  // **************************************************************************************************************
  class ItemBase extends Able.Doc:
    def this(xPar: X, yPar: Y) = { this(); x = xPar; y = yPar }
    def this(p: (X, Y))        = { this(p._1, p._2) }
    protected[chart] val real       : self.REAL_ITEM  = new self.REAL_ITEM().^(_.setExtraValue(this))
    /**/             def chart      : Chart.XY[X, Y]  = self
    /**/             def x          : X               = self.axisX.valueMap.undo(real.getXValue); def x_=(v: X) = real.setXValue(self.axisX.valueMap(v))
    /**/             def y          : Y               = self.axisY.valueMap.undo(real.getYValue); def y_=(v: Y) = real.setYValue(self.axisY.valueMap(v))
    /**/             def setY(v: Y) : Unit            = real.setYValue(self.axisY.valueMap(v))
    /**/             def xPos       : Double          = axisX(x)
    /**/             def yPos       : Double          = axisY(y)
    /**/             def doc       : Doc            = Doc(this) += ("x", x) += ("y", y)

  object ItemBase:
    def apply(d: J.XYChart.Data[_, _]): ITEM = d.getExtraValue.cast[ITEM]

object XY:
  val As = xy.As

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
