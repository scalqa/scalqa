package scalqa; package children; import language.implicitConversions

class RootData(m: Member) extends Data(m):

  members = all.~.takeOnlyBy(_.name,"Lang","Gen","J","Fx","Val")
  aliases = { all.~.find_?(_.name == "~~").~
      //      ++ members.~.drop(_.name=="J").flatMap(_.members).drop(v => v.name == "~" && v.kind.isDefLike)
              ++ Registry.member_?(Id("scalqa.gen.Request$")).get.members
            }.sort
