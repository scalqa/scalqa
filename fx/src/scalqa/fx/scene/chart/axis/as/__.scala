package scalqa; package fx; package scene; package chart; package axis

object As:
  type Custom[A]  = as.Custom[A];  inline def Custom = as.Custom
  type Category   = as.Category
  type Doubles    = as.Doubles
  type Ints       = as.Ints
  type Numbers[A] = as.Numbers[A]
  type Value[A]   = as.Value[A]
  type Time       = as.Time;       inline def Time = as.Time

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
