package scalqa; package j; package vm; import language.implicitConversions

object Memory extends Able.Doc:

  /**/            def total : ByteCount = rt.totalMemory.ByteCount
  /**/            def max   : ByteCount = rt.maxMemory.ByteCount
  /**/            def free  : ByteCount = rt.freeMemory.ByteCount
  /**/            def used  : ByteCount = total - free
  inline          def gc    : Unit      = System.gc

  /**/            def doc  : Doc      = Doc(this) += ("max", max.toBrief) += ("total", total.toBrief) += ("free", free.toBrief) += ("used", used.toBrief)
  private inline  def rt    : Runtime   = Runtime.getRuntime


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
    @object Memory -> ###

[[App.Memory]] provides nicer access to 'java.lang.Runtime.getRuntime' memory values

      ```
         J.Vm.Memory.TP

         // Oputput

         J.Vm.Memory{max=15.2gB,total=1.0gB,free=970.0mB,used=59.1mB}
       ```


@def total -> Total

       Returns the total amount of memory in the Java virtual machine

       This is a shortcut to Java 'Runtime.getRuntime.totalMemory'


@def max -> Maximum

       Returns the maximum amount of memory that the Java virtual machine will attempt to use

       This is a shortcut to Java 'Runtime.getRuntime.maxMemory'


@def free -> Free

       Returns the amount of free memory in the Java Virtual Machine

       Calling the 'gc' method may result in increasing the value returned by free

       This is a shortcut to Java 'Runtime.getRuntime.freeMemory'


@def used -> Used

       Returns (total - free)

       This is a shortcut to Java 'Runtime.getRuntime.totalMemory - Runtime.getRuntime.freeMemory'


@def gc -> Garbage collect

       Runs the garbage collector

       Calling this method suggests that the Java virtual machine expend effort toward recycling unused objects in order to make the memory they currently occupy available for quick reuse

       When control returns from the method call, the virtual machine has made its best effort to recycle all discarded objects.

       The name gc stands for "garbage collector"

       The virtual machine performs this recycling process automatically as needed, in a separate thread, even if the 'gc' method is not invoked explicitly

*/
