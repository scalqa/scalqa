package scalqa; package Any;

package object Datum {
  type Vals[A] = Vals._Class[A]
  type Ref[TYPE <: Ref[TYPE, VAL], VAL] = Ref._Trait[TYPE, VAL]
  type Byte[A <: Byte[A]] = Byte._Trait[A]
  type Short[A <: Short[A]] = Short._Trait[A]
  type Int[A <: Int[A]] = Int._Trait[A]
  type Long[A <: Long[A]] = Long._Trait[A]
  type Float[A <: Float[A]] = Float._Trait[A]
  type Double[A <: Double[A]] = Double._Trait[A]
  type Comparable[TYPE <: Comparable[TYPE, VAL], VAL <: java.lang.Comparable[VAL]] = Comparable._Trait[TYPE, VAL]
  type String[A <: String[A]] = String._Trait[A]

  type BigInteger[A <: BigInteger[A]] = BigInteger._Trait[A]
  type BigDecimal[A <: BigDecimal[A]] = BigDecimal._Trait[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
