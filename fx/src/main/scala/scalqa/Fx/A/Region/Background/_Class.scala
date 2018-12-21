package scalqa; package Fx; package A; package Region; package Background

import javafx.scene.layout.{ Background => JAVA }

class _Class private[Fx] (val real: JAVA) extends A.Delegate.Data[_Class, JAVA] {
  protected def setup = Background.This

  def images: Idx[Image] = Idx.wrap(real.getImages).asMappedView(Image.make)

  def fills: Idx[Fill] = Idx.wrap(real.getFills).asMappedView(Fill.make)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
