package scalqa; package fx; package scene; package chart; package axis

object X:
  type Custom[A]  = x.Custom[A];  transparent inline def Custom = x.Custom
  type Category   = x.Category
  type Doubles    = x.Doubles
  type Ints       = x.Ints
  type Numbers[A] = x.Numbers[A]
  type Value[A]   = x.Value[A]
  type Time       = x.Time;       transparent inline def Time = x.Time

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extention
*/
