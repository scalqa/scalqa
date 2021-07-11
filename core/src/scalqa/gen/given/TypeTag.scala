package scalqa; package gen; package `given`; import language.implicitConversions

class  TypeTag[+A]

object TypeTag extends zTypeTagDefault:
  inline given givenBoolean   [A<:Raw.Boolean]: TypeTag[Raw.Boolean] = new TypeTag[Boolean]
  inline given givenByte      [A<:Raw.Byte   ]: TypeTag[Raw.Byte   ] = new TypeTag[Byte   ]
  inline given givenChar      [A<:Raw.Char   ]: TypeTag[Raw.Char   ] = new TypeTag[Char   ]
  inline given givenShort     [A<:Raw.Short  ]: TypeTag[Raw.Short  ] = new TypeTag[Short  ]
  inline given givenInt       [A<:Raw.Int    ]: TypeTag[Raw.Int    ] = new TypeTag[Int    ]
  inline given givenLong      [A<:Raw.Long   ]: TypeTag[Raw.Long   ] = new TypeTag[Long   ]
  inline given givenFloat     [A<:Raw.Float  ]: TypeTag[Raw.Float  ] = new TypeTag[Float  ]
  inline given givenDouble    [A<:Raw.Double ]: TypeTag[Raw.Double ] = new TypeTag[Double ]
  inline given givenRef       [A<:Any.Ref]    : TypeTag[Ref        ] = new TypeTag[Any.Ref]

// **********************************************************************************************************************************************
private[`given`] class zTypeTagDefault:
  inline given givenAny[A,Any]: TypeTag[Any] = new TypeTag[Any]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
