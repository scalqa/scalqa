package scalqa; package Pipe; package Z; package The; package Build

private[Pipe] abstract class Map[A, B] extends Pipe.The.Base[B] {

  protected def real: Pipe[A]

  override def sizeOpt = real.sizeOpt

  override def isMutable = real.isMutable

  override def metadataInfoText = super.metadataInfoText + '\n' + real.I.letAs(classOf[FlowWithMetadata[_]]).map(_.metadataInfoText).or(real.metadata.I.infoText).indent("  ")

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/