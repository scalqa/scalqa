package scalqa; package Any; package Value; package Ref; package Companion

abstract class Like[REF <: Ref[VAL], VAL <: AnyRef: Tag] protected (voidVal: VAL = null) extends Value.Companion[REF, VAL](voidVal, voidVal) {

  private[scalqa] override def undo(v: REF): VAL = v._real

  protected def tag[A <: AnyRef]: Tag[A] = Tag.AnyRef

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
