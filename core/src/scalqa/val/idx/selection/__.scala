package scalqa; package `val`; package idx; import language.implicitConversions

trait Selection[A] extends Idx[A] with Able.Doc:
  self =>
  /**/     def target            : Idx[A]
  /**/     def indexes           : Idx[Int]
  /**/     def size              : Int       = indexes.size
  /**/     def apply(i: Int)     : A         = target(indexes(i))
  /**/     def valueOpt          : Opt[A]    = indexes.headOpt.mapOpt(target.applyOpt(_))
  inline   def value             : A         = valueOpt.get
  override def stream            : Stream[A] = indexes.stream.mapOpt(target.applyOpt(_))
  /**/     def property(dflt: A) : Pro[A]    = new Pro[A] { def apply() = valueOpt or dflt }
  /**/     def doc               : Doc       = Doc(this) += ("indexes", indexes.stream.makeString(","))

object Selection:
  /**/            def apply[A](targetIndex:Idx[A],idx:Idx[Int]): Selection[A]  = selection.Z.Basic(targetIndex,idx)
  @tn("getVoid")  def void[A]                                  : Selection[A]  = selection.Z.Void.cast[Selection[A]]
  implicit inline def implicitRequest[A](v: \/)                : Selection[A]  = void

// Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Observable[A] = selection.Observable[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Selection -> ###

Lists selected values for some target indexed collection


@def target -> Selection target

       The [[Idx]] targeted by this selection

@def apply -> Get value

       Get selected value at given index

@def valueOpt -> Optional selected value

       Returns first selected value or void option, if selection is empty

@def size -> Count of selected values

       Returns total number of selected values

@def indexes -> Selected positions

       Selected positions from target index

       Note. `positions.size == size`

@def property -> Selected property

      Returns property instance wich will be updated real-time with the first selected value.
      Because the Selection can be empty, this property needs a default value to provide in this case.

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/
