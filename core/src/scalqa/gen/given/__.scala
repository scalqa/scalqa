package scalqa; package gen; import language.implicitConversions

object Given:
  transparent inline def TypeDef    = `given`.TypeDef;      type TypeDef[A]                                     = `given`.TypeDef[A];
  transparent inline def DocDef     = `given`.DocDef;       type DocDef[-A]                                     = `given`.DocDef[A]
  transparent inline def VoidDef    = `given`.VoidDef;      type VoidDef[A]                                     = `given`.VoidDef[A]
  transparent inline def EmptyDef   = `given`.EmptyDef;     type EmptyDef[-A]                                   = `given`.EmptyDef[A]
  transparent inline def WithinDef  = `given`.WithinDef;    type WithinDef  [A,-C]                              = `given`.WithinDef[A,C]
  transparent inline def ArrayShape = `given`.ArrayShape;   type ArrayShape [A, ARRAY <: lang.Array.AnyType[A]] = `given`.ArrayShape[A,ARRAY]
  transparent inline def PackShape  = `given`.PackShape;    type PackShape  [A, PACK  <: ><.AnyType[A]]         = `given`.PackShape[A,PACK]
  transparent inline def RangeShape = `given`.RangeShape;   type RangeShape [A, RANGE <: <>.AnyType[A]]         = `given`.RangeShape[A,RANGE]
  transparent inline def OptShape   = `given`.OptShape;     type OptShape   [A, OPT   <: Opt.AnyType[A]]        = `given`.OptShape[A,OPT]
  transparent inline def StreamShape= `given`.StreamShape;  type StreamShape[A, STREAM<: ~~.AnyType[A]]         = `given`.StreamShape[A,STREAM]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Given -> ### Implicit Definitions

    Contans a set of "Def" interfaces, which can be given (implicitly) for any type.

    Also contains "Shape" interfaces for some containers.

*/
