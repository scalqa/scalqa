package scalqa; package gen

object Able:

  @tn("Stream") type ~[+A] = able.Stream[A]; @tn("Stream") val ~ = able.Stream

  type Access[A]   = able.Access[A];    @fast lazy val Access     = able.Access
  type Add[A]      = able.Add[A]
  type Close       = able.Close
  type Contain[A]  = able.Contain[A]
  type Empty       = able.Empty;        @fast lazy val Empty      = able.Empty
  type Name        = able.Name
  type Refresh     = able.Refresh
  type Seal        = able.Seal;         @fast lazy val Seal       = able.Seal
  type Sequence[A] = able.Sequence[A];  @fast lazy val Sequence   = able.Sequence
  type Size        = able.Size;         @fast lazy val Size       = able.Size
  type Info        = able.Info;         @fast lazy val Info        = able.Info
  type Tag         = able.Tag
  type Void        = able.Void


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Able -> ###

[[Able]] contains a set of fundamentally generic interfaces

*/