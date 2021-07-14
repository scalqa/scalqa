package scalqa; package gen; import language.implicitConversions

object Given:
  transparent inline def TypeTag    = `given`.TypeTag;      type TypeTag[A]                              = `given`.TypeTag[A];
  transparent inline def DocTag     = `given`.DocTag;       type DocTag[-A]                              = `given`.DocTag[A]
  transparent inline def VoidTag    = `given`.VoidTag;      type VoidTag[A]                              = `given`.VoidTag[A]
  transparent inline def EmptyTag   = `given`.EmptyTag;     type EmptyTag[-A]                            = `given`.EmptyTag[A]
  transparent inline def WithinTag  = `given`.WithinTag;    type WithinTag[A,-C]                         = `given`.WithinTag[A,C]
  transparent inline def ArrayTag   = `given`.ArrayTag;     type ArrayTag [A, ARRAY <: lang.Array.AnyType[A]] = `given`.ArrayTag[A,ARRAY]
  transparent inline def PackTag    = `given`.PackTag;      type PackTag  [A, PACK  <: ><.AnyType[A]]    = `given`.PackTag[A,PACK]
  transparent inline def RangeTag   = `given`.RangeTag;     type RangeTag [A, RANGE <: <>.AnyType[A]]    = `given`.RangeTag[A,RANGE]
  transparent inline def OptTag     = `given`.OptTag;       type OptTag   [A, OPT   <: Opt.AnyType[A]]   = `given`.OptTag[A,OPT]
  transparent inline def StreamTag  = `given`.StreamTag;    type StreamTag[A, STREAM<: ~~.AnyType[A]]    = `given`.StreamTag[A,STREAM]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Def -> ### Type Implicit Definitions

    Contans a set of interfaces, which can be given (implicitly) for any type

*/
