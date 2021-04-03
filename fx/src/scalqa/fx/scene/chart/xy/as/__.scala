package scalqa; package fx; package scene; package chart; package xy

object As:
  type Basic[X, Y, XA <: Chart.Axis[X], YA <: Chart.Axis[Y]] = as.Basic[X, Y, XA, YA]
  type Lines[X, Y]                                           = as.Lines[X, Y]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
