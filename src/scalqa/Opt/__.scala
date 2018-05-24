package scalqa; package Opt

private[Opt] trait __[+A] extends Any {

  @inline protected[Opt] def _target: Any

  @inline private[Opt] def _val: A = _target.cast

  @inline private[Opt] def _isVal: Boolean = !_target.isInstanceOf[Z.Empty]

  @inline private[Opt] def This[T]: T = this.cast

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
