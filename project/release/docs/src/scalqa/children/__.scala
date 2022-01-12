package scalqa; import children.*; import language.implicitConversions

class Children private (val m: Member):

  private lazy val data: z.Data =
    if     (m.name == "API")    new z.Data(m).self(_.members = m.members.~~.take(_.name=="scalqa").pack)
    else if(m.name == "scalqa") new z.RootData(m)
    else if(m.dri.isTypeDef)    new z.OpaqueData(m)
    else                        new z.GeneralData(m)

  def constructors : Seq[Member]                         = m.members.~~.take(_.kind.isConstructor).sort.toSeq
  def members      : Seq[Member]                         = data.members.toSeqView
  def aliases      : Seq[Member]                         = data.aliases.toSeqView
  def cases        : Seq[Member]                         = data.cases.toSeqView
  def containers   : Seq[Member]                         = data.containers.toSeqView
  def types        : Seq[Member]                         = data.types.toSeqView
  def defs         : Seq[Member]                         = data.defs.toSeqView
  def makers       : Seq[Member]                         = data.makers.toSeqView
  def extended     : Seq[Member]                         = data.extended.toSeqView
  def exports      : Seq[Member]                         = data.exports.toSeqView
  def implicits    : Seq[Member]                         = data.implicits.toSeqView
  def givens       : Seq[Member]                         = data.givens.toSeqView
  def extensions   : Seq[(ExtensionTarget,List[Member])] = data.extensions.toSeqView

private object Children:
  private val lookup: Lookup.M[Member,Children] = Lookup.M.concurrent()

  def apply(v: Member): Children = lookup.getOrPut(v,new Children(v))
