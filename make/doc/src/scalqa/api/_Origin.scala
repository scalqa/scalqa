package scalqa; package api

trait _Origin:

  extension (x: Origin)
    def isOverride    : Boolean     = x.isInstanceOf[Origin.Overrides]
    def isExtension   : Boolean     = x.isInstanceOf[Origin.ExtensionFrom]
    def isExport      : Boolean     = x.isInstanceOf[Origin.ExportedFrom]
    def isImplicit    : Boolean     = x.isInstanceOf[Origin.ImplicitlyAddedBy]
    def isDefined     : Boolean     = x == Origin.RegularlyDefined

