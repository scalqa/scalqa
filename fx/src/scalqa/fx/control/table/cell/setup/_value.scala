package scalqa; package fx; package control; package table; package cell; package setup; import language.implicitConversions

transparent trait _value[ROW, VIEW, A]:
  //self :cell.Setup[ROW, VIEW, A] =>
  private inline def self = this.cast[cell.Setup[ROW, VIEW, A]]

  private        var proSetup         : ROW => Pro.O[Opt[A]]                           = Z.voidFun
  private        var upgrade          : Pack[(ROW, Pro.O[Opt[A]]) => Pro.O[Opt[A]]]   =VOID
  private[table] def mkProOpt(e: ROW) : Pro.O[Opt[A]]                                  = upgrade.stream.foldAs(proSetup(e):Pro.O[Opt[A]])((p,pe) => pe(e,p))
  private[table] var funFormat        : A => Opt[String]                               = v => v.tag(using self.docDef)
  private[table] var funFormatVoid    : ROW => Opt[String]                             = v => VOID
  private[table] var funTooltipOpt    : Opt[Opt[A] => Tooltip]                        =VOID
  def voidDef                                                   : Any.Def.Void[A]
  def docDef                                                    : Any.Def.Doc[A]

  def useValue      (f: ROW => A)                               : Unit   = useValueOpt(f(_))
  def useValueOpt   (f: ROW => Opt[A])                          : Unit   = useValueProOpt(r => Pro.O.constant(f(r)))
  def useValuePro   (f: ROW => Pro.O[A])                        : Unit   = useValueProOpt(f(_).mapView(Opt(_)))
  def useValueOptPro (f: ROW => Opt[Pro.O[A]])                  : Unit   = useValueProOpt(f(_).map(_.mapView(Opt(_))) or Z.voidPro)
  def useValueProOpt (f: ROW => Pro.O[Opt[A]])                  : Unit   = proSetup = f

  def useValueFromView      (f: VIEW => A)                      : Unit   = useValueFromViewOpt(f(_))
  def useValueFromViewOpt   (f: VIEW => Opt[A])                 : Unit   = useValueFromViewProOpt(v => Pro.O.constant(f(v)))
  def useValueFromViewPro   (f: VIEW => Pro.O[A])               : Unit   = useValueFromViewProOpt(f(_).mapView(Opt(_)))
  def useValueFromViewOptPro(f: VIEW => Opt[Pro.O[A]])          : Unit   = self.useValueFromViewProOpt(f(_).map(_.mapView(Opt(_))) or Z.voidPro)
  def useValueFromViewProOpt(f: VIEW => Pro.O[Opt[A]])          : Unit   = useValueProOpt(ZValueView(f))

  def useProUpgrade(f: (ROW, Pro.O[Opt[A]]) => Pro.O[Opt[A]])   : Unit   = upgrade += f

  def useFormat(f: A => Opt[String])                            : Unit   = funFormat = f
  def useFormat(f: A => Opt[String],voidVal: ROW => Opt[String]): Unit   = { funFormat = f; funFormatVoid = voidVal }
  def useTooltip(f: Opt[A] => Any)                              : Unit   = funTooltipOpt = f.?.map(f => (v:Opt[A]) => f(v) match { case v: Tooltip => v; case _ => Tooltip(v.toString) })

  // ************************************************************************************************************************************
  private class ZValueView(f: VIEW => Pro.O[Opt[A]]) extends (ROW => Pro.O[Opt[A]]):
    def apply(v: ROW) : Pro.O[Opt[A]] = try self.column.table.mkViewOpt[VIEW](v).map(f(_)) or Z.voidPro
                                        catch case v: ClassCastException => J.illegalState("Table 'useView' is (most likely) not specified for table: " + self.column.table.self.typeName)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
