package scalqa; package Pipe; package Z

private[Pipe] trait FlowWithMetadata[A] extends Flow[A] {

  def isMutable = true

  def tagOpt: Opt[Tag[A]] = \/

  def sizeOpt: Opt[Int] = \/

  def sortingOpt: Opt[Sorting[A]] = \/

  def sortingByOpt[B]: Opt[(Sorting[B], A => B)] = \/

  def metadataInfoText: String.Text = metadata.I.infoLine

  def metadata = new Metadata[A] {
    def owner = FlowWithMetadata.this
    override def info = super.info ~~ owner.info
    override def isMutable = owner.isMutable
    override def tagOpt: Opt[Tag[A]] = owner.tagOpt
    override def sizeOpt: Opt[Int] = owner.sizeOpt
    override def sortingOpt: Opt[Sorting[A]] = owner.sortingOpt
    override def sortingByOpt[B]: Opt[(Sorting[B], A => B)] = owner.sortingByOpt
    protected override def infoText = metadataInfoText
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
