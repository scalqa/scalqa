package scalqa; package `val`; package pro; package mutable

object X:

  abstract class Base[A] extends pro.X.Base[A] with Mutable[A]

  // *************************************************************
  class Basic[A](_value: A) extends Mutable[A]:
    private var value: A     = _value
    /**/    def apply()      = value
    /**/    def update(v: A) = value = v

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
*/