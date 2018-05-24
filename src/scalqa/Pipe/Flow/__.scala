package scalqa; package Pipe; package Flow

private[Pipe] trait __[A] {

  private[Pipe] def This: Flow[A] = this.cast

  private[Pipe] def synchronize: Flow[A]

  private[Pipe] def metadata: Metadata[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
