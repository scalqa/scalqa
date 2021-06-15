package scalqa; package gen; import language.implicitConversions

object Given:
  inline def NameTag    = `given`.NameTag;      type NameTag[A]                              = `given`.NameTag[A];
  inline def DocTag     = `given`.DocTag;       type DocTag[-A]                              = `given`.DocTag[A]
  inline def VoidTag    = `given`.VoidTag;      type VoidTag[A]                              = `given`.VoidTag[A]
  inline def EmptyTag   = `given`.EmptyTag;     type EmptyTag[-A]                            = `given`.EmptyTag[A]
  inline def InTag      = `given`.InTag;        type InTag[A,-C]                             = `given`.InTag[A,C]
  inline def ArrayTag   = `given`.ArrayTag;     type ArrayTag [A, ARRAY <: Array.AnyType[A]] = `given`.ArrayTag[A,ARRAY]
  /**/   val PackTag    = `given`.PackTag
  inline def RangeTag   = `given`.RangeTag;     type RangeTag [A, RANGE <: <>.AnyType[A]]    = `given`.RangeTag[A,RANGE]
  inline def OptTag     = `given`.OptTag;       type OptTag   [A, OPT   <: Opt.AnyType[A]]   = `given`.OptTag[A,OPT]
  inline def StreamTag  = `given`.StreamTag;    type StreamTag[A, STREAM<: ~~.AnyType[A]]    = `given`.StreamTag[A,STREAM]

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
