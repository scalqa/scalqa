package scalqa; package docs

object Path:

  def apply(x: String): String =
    var s = x.replace("/project/release/scalqa/src/scalqa/fx/","/fx/src/scalqa/fx/")
             .replace("/project/release/scalqa/src/scalqa/"   ,"/core/src/scalqa/")
             .takeBeforeLast("#")
//    if(!s.startsWith("..") && !s.endsWith("/index") && !s.endsWith("/scalqa")){
//      var i = x.lastIndexOf("/")
//      if(i>0)
//        val c = s.charAt(i+1)
//        if(Character.isAlphabetic(c) && Character.isLowerCase(c))  s = s + "_"
//    }
    //">>> " + s tp()
    s