package scalqa; package Any; package Itself

private[Itself] trait __[A] extends Any {

  private[Itself] def _target: A

  private[Itself] def This: A = _target match { case v: _Class[A] => v.This; case v => v }

  private[Itself] def _isMeta = _target.isInstanceOf[_Class[A]]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
