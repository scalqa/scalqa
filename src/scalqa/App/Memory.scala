package scalqa; package App

object Memory extends Able.Info {
  private def rt = Runtime.getRuntime

  def total: Byte.Size = rt.totalMemory

  def max: Byte.Size = rt.maxMemory

  def free: Byte.Size = rt.freeMemory

  def used: Byte.Size = total - free

  def gc: Unit = java.lang.System.gc

  protected def info = \/.info ~ ("max", max) ~ ("total", total) ~ ("free", free) ~ ("used", used)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Memory ->
 *
 *    [[App.Memory]] provides nicer access to 'java.lang.Runtime.getRuntime' memory values
 *
 *    @example
 *    {{{
 *       App.Memory.tp
 *
 *       // Oputput
 *       Memory{max=15.2gB,
 *             total=1.0gB,
 *             free=990.1mB,
 *             used=39.0mB}
 *     }}}
 *
 * @def total -> Total
 *
 *     Returns the total amount of memory in the Java virtual machine
 *
 *     The value returned by this method may vary over time, depending on the host environment.
 *
 * @def max -> Maximum
 *
 *     Returns the maximum amount of memory that the Java virtual machine will attempt to use
 *
 * @def free -> Free
 *
 *     Returns the amount of free memory in the Java Virtual Machine
 *
 *     Calling the 'gc' method may result in increasing the value returned by free
 *
 * @def used -> Used
 *
 *     Returns (total - free)
 *
 * @def gc -> Garbage collect
 *
 *     Runs the garbage collector
 *
 *     Calling this method suggests that the Java virtual machine expend effort toward recycling unused objects in order to make the memory they currently occupy available for quick reuse
 *
 *     When control returns from the method call, the virtual machine has made its best effort to recycle all discarded objects.
 *
 *     The name gc stands for "garbage collector"
 *
 *     The virtual machine performs this recycling process automatically as needed, in a separate thread, even if the 'gc' method is not invoked explicitly
 */
