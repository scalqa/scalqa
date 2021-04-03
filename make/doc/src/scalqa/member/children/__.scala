package scalqa; package member; import language.implicitConversions

class Children private (val real: Member):
  private lazy val parser= new children.Parser(real)

  def constructors : Seq[Member]                         = real.members.~.take(_.kind.isConstructor).sort.toSeq
  def members      : Seq[Member]                         = parser.members.seq_^
  def aliases      : Seq[Member]                         = parser.aliases.seq_^
  def types        : Seq[Member]                         = parser.types.seq_^
  def defs         : Seq[Member]                         = parser.defs.seq_^
  def makers     : Seq[Member]                         = parser.makers.seq_^
  def extended     : Seq[Member]                         = parser.extended.seq_^
  def exports      : Seq[Member]                         = parser.exports.seq_^
  def localDefs    : Seq[Member]                         = parser.localDefs.seq_^
  def inheritedDefs: Seq[Member]                         = parser.inheritedDefs.seq_^
  def extensions   : Seq[(ExtensionTarget,List[Member])] = parser.extensions.seq_^

private object Children:
  private val lookup: Lookup.M[Member,Children] = Lookup.M.concurrent()

  def apply(v: Member) : Children = lookup.getOrPut(v,new Children(v))
