package scalqa; package Fx; package Table; package Cell; package Ui

trait _value_setup[ENTRY, VIEW, VAL] { self: Ui[ENTRY, VIEW, VAL] =>
  private var proFun = __onGet.defaultFun.asInstanceOf[ENTRY => Pro.O[Opt[VAL]]]
  private var enhance: Refs[(ENTRY, Pro.O[Opt[VAL]]) => Pro.O[Opt[VAL]]] = \/

  def onGet(on: ENTRY => VAL): Unit = onGetOpt(on(_).Opt)

  def onGetOpt(on: ENTRY => Opt[VAL]): Unit = onGetOptPro(r => Pro.O.constant(on(r)))

  def onGetPro(on: ENTRY => Pro.O[VAL]): Unit = onGetOptPro(on(_).asMappedView(_.Opt))

  def onGetProOpt(f: ENTRY => Opt[Pro.O[VAL]]): Unit = onGetOptPro(f(_).map(_.asMappedView(_.Opt)) or \/)

  def onGetOptPro(f: ENTRY => Pro.O[Opt[VAL]]): Unit = proFun = f

  def onGetOptProEnhance(f: (ENTRY, Pro.O[Opt[VAL]]) => Pro.O[Opt[VAL]]): Unit = enhance += f

  // -------------------------------------------------------------------------------------
  def onViewGet(on: VIEW => VAL): Unit = onViewGetOpt(on(_).Opt)

  def onViewGetOpt(on: VIEW => Opt[VAL]): Unit = onViewGetOptPro(v => Pro.O.constant(on(v)))

  def onViewGetPro(on: VIEW => Pro.O[VAL]): Unit = onViewGetOptPro(on(_).asMappedView(_.Opt))

  def onViewGetProOpt(f: VIEW => Opt[Pro.O[VAL]]): Unit = onViewGetOptPro(f(_).map(_.asMappedView(_.Opt)) or \/)

  def onViewGetOptPro(f: VIEW => Pro.O[Opt[VAL]]): Unit = onGetOptPro(column.table._viewOpt(_).asInstanceOf[Opt[VIEW]].map(f(_)) or \/)

  // -------------------------------------------------------------------------------------

  private[Table] var _onFormat: VAL => String = c => c.toString
  private[Table] var _onFormatVoid: ENTRY => String = r => ""
  private[Table] var _onTooltipOpt: Opt[Opt[VAL] ⇒ Tooltip] = \/

  def onFormat(f: VAL => String) = _onFormat = f

  def onFormatVoid(f: ENTRY => String) = _onFormatVoid = f

  def onTooltip(f: Opt[VAL] ⇒ Any) = _onTooltipOpt = f.Opt.map(f => v => f(v).I.as[Tooltip](_ => new Tooltip(v.toString)))

  // -------------------------------------------------------------------------------------
  private[Table] def createOptPro(e: ENTRY): Pro.O[Opt[VAL]] = {
    val p = proFun(e)
    if (enhance.isEmpty) p else enhance.all.foldAs[Pro.O[Opt[VAL]]](p)((p, pe) => pe(e, p))
  }
}

private object __onGet {
  val defaultFun: Any => Pro.O[Opt[Any]] = r => \/
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
