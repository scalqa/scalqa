package scalqa; package Pipe; package _pump

trait _foreach[A] extends Flow._pump._foreach[A] with __[A] {

  override def apply(f: A => Any): Unit = Z.foreach.apply(This, f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @trait _foreach -> '''Foreach Interface'''
 *
 *     All methods fully pump the pipeline
 */
