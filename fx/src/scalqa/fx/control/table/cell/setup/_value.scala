package scalqa; package fx; package control; package table; package cell; package setup; import language.implicitConversions

transparent trait _value[ROW, VIEW, A]:
  //self :cell.Setup[ROW, VIEW, A] =>
  private inline def self = this.cast[cell.Setup[ROW, VIEW, A]]

  private                      var proSetup         : ROW => Pro.O[Opt[A]]                           = Z.voidFun
  private                      var enhance          : ><[(ROW, Pro.O[Opt[A]]) => Pro.O[Opt[A]]]      = \/
  private[table]               def mkProOpt(e: ROW) : Pro.O[Opt[A]]                                  = enhance.~.foldAs(proSetup(e):Pro.O[Opt[A]])((p,pe) => pe(e,p))
  private[table]               var funFormat        : A => String.Opt                                = v => v.tag(using self.docTag)
  private[table]               var funFormatVoid    : ROW => String.Opt                              = v => \/
  private[table]               var funTooltipOpt    : Opt[Opt[A] => Tooltip]                         = \/

  @tn("value_Setup")           def value_:    (f: ROW => A)                                 : Unit   = value_:?(f(_))
  @tn("value_SetupOpt")        def value_:?   (f: ROW => Opt[A])                            : Unit   = value_:*?(r => Pro.O.constant(f(r)))
  @tn("value_SetupPro")        def value_:*   (f: ROW => Pro.O[A])                          : Unit   = value_:*?(f(_).map_^(Opt(_)))
  @tn("value_SetupOptPro")     def value_:?*  (f: ROW => Opt[Pro.O[A]])                     : Unit   = value_:*?(f(_).map(_.map_^(Opt(_))) or Z.voidPro)
  @tn("value_SetupProOpt")     def value_:*?  (f: ROW => Pro.O[Opt[A]])                     : Unit   = proSetup = f
  @tn("enhance_SetupProOpt")   def enhance_:*?(f: (ROW, Pro.O[Opt[A]]) => Pro.O[Opt[A]])    : Unit   = enhance += f

  @tn("valueView_Setup")       def valueView_:  (f: VIEW => A)                              : Unit   = valueView_:?(f(_))
  @tn("valueView_SetupOpt")    def valueView_:? (f: VIEW => Opt[A])                         : Unit   = valueView_:*?(v => Pro.O.constant(f(v)))
  @tn("valueView_SetupPro")    def valueView_:* (f: VIEW => Pro.O[A])                       : Unit   = valueView_:*?(f(_).map_^(Opt(_)))
  @tn("valueView_SetupOptPro") def valueView_:?*(f: VIEW => Opt[Pro.O[A]])                  : Unit   = self.valueView_:*?(f(_).map(_.map_^(Opt(_))) or Z.voidPro)
  @tn("valueView_SetupProOpt") def valueView_:*?(f: VIEW => Pro.O[Opt[A]])                  : Unit   = value_:*?(ZValueView(f))

  /**/                         def voidTag                                                  : Given.VoidDef[A]
  /**/                         def docTag                                                   : Given.DocDef[A]
  @tn("format_Setup")          def format_:(f: A => String.Opt)                             : Unit   = funFormat = f
  @tn("format_Setup")          def format_:(f: A => String.Opt, voidVal: ROW => String.Opt) : Unit   = { funFormat = f; funFormatVoid = voidVal }
  @tn("tooltip_Setup")         def tooltip_:(f: Opt[A] => Any)                              : Unit   = funTooltipOpt = f.?.map(f => (v:Opt[A]) => f(v) match { case v: Tooltip => v; case _ => Tooltip(v.toString) })


  // ************************************************************************************************************************************
  private class ZValueView(f: VIEW => Pro.O[Opt[A]]) extends (ROW => Pro.O[Opt[A]]):
    def apply(v: ROW) : Pro.O[Opt[A]] = try self.column.table.mkViewOpt[VIEW](v).map(f(_)) or Z.voidPro
                                        catch case v: ClassCastException => J.illegalState("Table 'view_:' is (most likely) not specified for table: " + self.column.table.^.typeName)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
