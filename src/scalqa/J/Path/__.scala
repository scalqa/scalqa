package scalqa; package J; package Path

private[Path] trait __ extends Any {

  private[Path] def This: Path = this.cast

  private[Path] def rootOpt: Opt[Path]

  private[Path] def indexOpt(p: Path): Opt[Int]

  private[Path] def real: java.nio.file.Path

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
