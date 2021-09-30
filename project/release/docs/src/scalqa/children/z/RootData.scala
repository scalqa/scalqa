package scalqa; package children; package z; import language.implicitConversions

class RootData(m: Member) extends Data(m):

  members = all.~.takeValuesBy(_.name,("Lang","Gen","J","Fx","Val")).><
  aliases = { all.~.find_?(_.name == "~~").~
              ++ members.~.dropValuesBy(_.name,("J","Fx")).flatMap(_.members).drop(v => v.name == "~" && v.kind.isDefLike)
              ++ Registry.member_?(Id("scalqa.gen.Request$")).get.members
            }.sort.><
