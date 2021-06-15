package scalqa; package fx; package scene; package chart; package xy

object X:
  type Basic[X, Y, XA <: Chart.Axis[X], YA <: Chart.Axis[Y]] = x.Basic[X, Y, XA, YA]
  type Lines[X, Y]                                           = x.Lines[X, Y]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
