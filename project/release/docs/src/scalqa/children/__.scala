package scalqa; import children.*; import language.implicitConversions

class Children private (val m: Member):

  private lazy val data: z.Data =
    if     (m.name == "API")    new z.Data(m).^(_.members = m.members.~.take(_.name=="scalqa").><)
    else if(m.name == "scalqa") new z.RootData(m)
    else if(m.dri.isTypeDef)    new z.OpaqueData(m)
    else                        new z.GeneralData(m)

  def constructors : Seq[Member]                         = m.members.~.take(_.kind.isConstructor).sort.toSeq
  def members      : Seq[Member]                         = data.members.toSeq_^
  def aliases      : Seq[Member]                         = data.aliases.toSeq_^
  def containers   : Seq[Member]                         = data.containers.toSeq_^
  def types        : Seq[Member]                         = data.types.toSeq_^
  def defs         : Seq[Member]                         = data.defs.toSeq_^
  def makers       : Seq[Member]                         = data.makers.toSeq_^
  def extended     : Seq[Member]                         = data.extended.toSeq_^
  def exports      : Seq[Member]                         = data.exports.toSeq_^
  def extensions   : Seq[(ExtensionTarget,List[Member])] = data.extensions.toSeq_^

private object Children:
  private val lookup: Lookup.M[Member,Children] = Lookup.M.concurrent()

  def apply(v: Member): Children = lookup.getOrPut(v,new Children(v))
