package scalqa; package Opt; package orError

trait _convert[+A] extends Any with __[A] with Z.Like._convert[A] {

  def map[B](f: A => B): orError[B] = if (_isVal) new orError[B](f(_val)) else This

  def mapCast[B]: orError[B] = this.cast

  def swap[B](f: => B): orError[B] = if (_isVal) new orError[B](f) else This

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
 */
