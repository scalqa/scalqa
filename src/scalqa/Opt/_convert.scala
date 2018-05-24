package scalqa; package Opt

trait _convert[+A] extends Any with __[A] with Z.Like._convert[A] {

  def map[B](f: A => B): Opt[B] = if (_isVal) new Opt[B](f(_val)) else Void

  def mapCast[B]: Opt[B] = this.cast

  def swap[B](newValue: => B): Opt[B] = if (_isVal) new Opt[B](newValue) else Void

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _convert -> '''Value Conversion Interface'''
 *
 *
 */
