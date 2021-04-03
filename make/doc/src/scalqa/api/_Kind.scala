package scalqa; package api


trait _Kind:

  extension (x: Kind)
    def isTypeLike    : Boolean     = x.isClass || x.isTrait || x.isEnum   || x.isType
    def isDefLike     : Boolean     = !x.isTypeLike
    // ----------------------------------------------------------------------------------------
    def isClassLike   : Boolean     = x.isInstanceOf[Classlike]
    def isClass       : Boolean     = x.isInstanceOf[Kind.Class]
    def isTrait       : Boolean     = x.isInstanceOf[Kind.Trait]
    def isObject      : Boolean     = x == Kind.Object
    def isEnum        : Boolean     = x == Kind.Enum
    def isPackage     : Boolean     = x == Kind.Package || x == Kind.RootPackage
    def isDef         : Boolean     = x.isInstanceOf[Kind.Def]
    def isVal         : Boolean     = x == Kind.Var
    def isVar         : Boolean     = x == Kind.Var
    def isConstructor : Boolean     = x.isInstanceOf[Kind.Constructor]
    def isEnumCase    : Boolean     = x.isInstanceOf[Kind.EnumCase]
    def isExtension   : Boolean     = x.isInstanceOf[Kind.Extension]
    def isExported    : Boolean     = x.isInstanceOf[Kind.Exported]
    def isType        : Boolean     = x.isInstanceOf[Kind.Type]
    def isGiven       : Boolean     = x.isInstanceOf[Kind.Given]
    def isImplicit    : Boolean     = x.isInstanceOf[Kind.Implicit]
    def isUnknown     : Boolean     = x == Kind.Unknown

