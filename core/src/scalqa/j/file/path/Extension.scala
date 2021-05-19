package scalqa; package j; package file; package path; import language.implicitConversions

import java.nio.file.{ Path => JPath }
import File.Path

class Extension:
  extension(inline x: Path)
    /**/                 inline def names                                : Idx[String] = new Z.Names(x)
    /**/                 inline def isEmpty                              : Boolean     = x.size == 0
    /**/                 inline def parent                               : Path        = x.real.getParent
    /**/                 inline def lastName                             : String      = x.real.getFileName.toString
    /**/                 inline def normalize                            : Path        = x.real.normalize
    /**/                 inline def delete                               : Boolean     = x.real.toFile.delete
    /**/                 inline def isFile                               : Boolean     = x.real.toFile.isFile
    /**/                 inline def isDirectory                          : Boolean     = x.real.toFile.isDirectory
    /**/                 inline def exists                               : Boolean     = x.real.toFile.exists
    /**/                 inline def endsWith  (p: Path)                  : Boolean     = x.real.endsWith(p.real)
    /**/                 inline def startsWith(p: Path)                  : Boolean     = x.real.startsWith(p.real)
  extension(x: Path)
    /**/                        def name(idx: Int)                       : String      = x.real.getName(idx).toString
    /**/                        def contains(v: Path)                    : Boolean     = index_?(v)
    /**/                        def contains(name:String, more:String*)  : Boolean     = contains(Path(name,more *))
    /**/                        def size                                 : Int         = {val v=x; val i=v.real.getNameCount; if (i == 1 && v.real.startsWith("")) 0 else i }
    @tn("root_Opt")             def root_?                               : Opt[Path]   = x.real.getRoot.^.?.map(Path(_))
    /**/                        def root                                 : Path        = x.root_?.get
    /**/                        def rootMake                             : Path        = x.root_? or Path().root + x
    /**/                        def rootDrop                             : Path        = x.root_?.map(_ => Path(x.real.subpath(0, x.real.getNameCount))) or x
    @tn("child_Stream")         def child_~                              : ~[Path]     = { val v = x.real.toFile; if (v.isDirectory) v.listFiles.~.map(f => Path(f.toPath)) else \/ }
    @tn("childRecursive_Stream")def childRecursive_~                     : ~[Path]     = x.child_~.flatMap(v => v.childRecursive_~ +@ (0, v))
    @tn("file_Opt")             def file_?                               : Opt[J.File] = x.real.toFile.?.drop(_.isDirectory).map(J.File(_))
    /**/                        def file                                 : J.File      = x.file_?.get
    /**/                        def make                                 : Unit        = if (!x.exists) x.real.toFile.mkdirs
    @tn("index_Opt")            def index_?(p: Path)                     : Int.Opt     = path.Z.indexOfOpt(x.real, p)
    /**/                        def join(v: Path | String)               : Path        = path.Z.join(x, v)
    /**/                        def joinAll(v: ~[Path | String])         : Path        = v.map(Path.any(_).real).fold(x.real)(_ resolve _)
    @tn("_join")         inline def + (inline v: Path | String)          : Path        = x.join(v)
    @tn("_joinAll")      inline def ++(inline v: ~[Path | String])       : Path        = x.joinAll(v)
    @tn("take_Range")           def take_<>(start: Int, size: Int)       : Path        = if(x.root_?.isEmpty || start > 0) x.real.subpath(start, start + size)
      /**/                                                                                  else (0 <>> x.size - start - size).~.foldAs(x.real)((v, _) => v.getParent) // keeping root
    @tn("take_Range")           def take_<>(r: Int.<>)                   : Path        = x.take_<>(r.start,r.size)
    /**/                        def takeFirst(cnt: Int)                  : Path        = x.take_<>(0,cnt)
    /**/                        def takeLast (cnt: Int)                  : Path        = x.take_<>(x.size - cnt, cnt)
    /**/                        def takeFrom  (p:Path, dflt:Path = \/)   : Path        = x.index_?(p).map(x.dropFirst(_)) or_? dflt.^.? or x
    /**/                        def takeAfter (p:Path, dflt:Path = \/)   : Path        = x.index_?(p).map(_ + p.size).map(x.dropFirst(_)) or_? dflt.^.? or x
    /**/                        def takeBefore(p:Path, dflt:Path = \/)   : Path        = x.index_?(p).map(x.takeFirst(_)) or_? dflt.^.? or x
    @tn("drop_Range")           def drop_<>(f: Int, sz: Int)             : Path        = x.takeFirst(f) + x.dropFirst(f + sz)
    @tn("drop_Range")           def drop_<>(r: Int.<>)                   : Path        = x.takeFirst(r.start) + x.dropFirst(r.endX)
    /**/                        def dropFirst(cnt: Int)                  : Path        = x.take_<>(cnt,x.size - cnt)
    /**/                        def dropLast( cnt: Int)                  : Path        = x.take_<>(0,x.size - cnt)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@class Extension -> ###

[[J.Path]] represents a directory or file in the [[File.System]], which may or may not exist

     [[Path]] implements [[Idx[String]]], representing directory names hierarchy. The last name may be a name of file, if [[Path]] is for file

     [[Path]] may or may not have root (like C:\). This may be checked with [[_package.root_? root_?]]

     A void [[Path]] has no root and zero directories

     NaturalOrderingly, a 'rootless' path can be added to another path in order to extend it

     Path with a root can only be extended itself

     ```
         val p1 = J.Path("aaa", "bbb").rootMake

         val p2 = J.Path("ccc", "ddd")

         p1 TP               // Prints: C:\aaa\bbb

         p2 TP               // Prints: ccc\ddd

         p1 + p2 + "xyz" TP  // Prints: C:\aaa\bbb\ccc\ddd\xyz

         p2 + p1             // App.Fail\$Message: Cannot extend with root: C:\aaa\bbb
     ```


@def root_? -> Optional root

       Optionally returns root [[Path]] if available
       ```
         val p = J.Path("aaa" , "bbb").rootMake

         p.root_? TP           // May print: Opt(C:\)

         p.rootDrop.root_? TP //     prints: Opt(\/)
       ```


@def root -> Root path

       Returns root [[Path]]

       Note: Fails if no root available
       ```
          J.Path.get.root TP // May print: C:\
       ```


@def rootMake -> Makes root if none

       If `this` [[Path]] has no root, new [[Path]] with current root is returned

       Otherwise `this` [[Path]] is returned as is
       ```
         val p: J.Path = "aaa" , "bbb"

         p TP           // May print: aaa\bbb

         p.rootMake TP  // May print: C:\aaa\bbb
       ```


@def rootDrop -> Looses root if any

       If `this` [[Path]] has a root, new [[Path]] without root is returned

       Otherwise `this` [[Path]] is returned as is
       ```
         val p = J.Path("aaa" , "bbb").rootMake

         p TP           // May print: C:\aaa\bbb

         p.rootDrop TP  // May print: aaa\bbb
      ```


@def lastName -> Last name

      Returns last name in the [[Path]] hierarchy

      If this [[Path]] points to a file, `lastName` is the name of file

      ```
          val path : J.Path =  "Temp" , "Test.txt"

          path.lastName TP  // Prints: Test.txt
      ```

@def index_? -> Sub-path index

      Optionally returns matching sub-path start index
      ```
         val path: J.Path = "aaa" , "bbb" + "ccc" + "ddd" + "eee"

         path index_? "ccc" , "ddd" TP  // Prints: Opt(2)

         path index_? "ddd" , "ccc" TP  // Prints: Opt(\/)
      ```


@def startsWith -> Checks start match

     Returns `true` if `this` [[Path]] starts with `p`
     ```
         val path: J.Path = "aaa" , "bbb" + "ccc" + "ddd"

         path startsWith "aaa" , "bbb" TP  // Prints: true

         path startsWith "bbb" , "aaa" TP  // Prints: false
     ```


@def endsWith -> Checks end match

     Returns `true` if `this` [[Path]] ends with `p`
     ```
         val path: J.Path = "aaa" , "bbb" + "ccc" + "ddd"

         path endsWith "ccc" , "ddd" TP // Prints: true

         path endsWith "aaa" , "bbb" TP // Prints: false
     ```


@def exists -> Check exists

     Returns `true` `this` [[Path]] exists in the file system as file or directory


@def takeAfter -> Sub-path after

       Returns sub-path after `p`

       @param p sub-path to copy after
       @param default path if `p` is not found. If not specified, default is the original path
       ```
         val p: J.Path = "aaa" , "bbb" + "ccc" + "ddd" + "eee" + "fff"

         p TP                                             // Prints: aaa\bbb\ccc\ddd\eee\fff

         p subpathAfter "ccc" , "ddd" TP                    // Prints: eee\fff

         p subpathAfter "ddd" , "ccc" TP                    // Prints: aaa\bbb\ccc\ddd\eee\fff

         p subpathAfter ("ddd" , "ccc", "xyz" , "bbc") TP  // Prints: xyz\bbc
      ```


@def takeBefore -> Sub-path before

       Returns sub-path from start to `p`

       @param p sub-path to copy up to
       @param default path if `p` is not found. If not specified, default is the original path

       ```
         val p: J.Path = "aaa" , "bbb" + "ccc" + "ddd" + "eee" + "fff"

         p TP                                            // Prints: aaa\bbb\ccc\ddd\eee\fff

         p subpathBefore "ccc" , "ddd" TP                   // Prints: aaa\bbb

         p subpathBefore "ddd" , "ccc" TP                   // Prints: aaa\bbb\ccc\ddd\eee\fff

         p subpathBefore ("ddd" , "ccc", "xyz" , "bbc") TP  // Prints: xyz\bbc
      ```


@def takeFrom -> Sub-path from

       Returns sub-path starting from specified [[Path]]

       @param p sub-path to copy from
       @param default path if `p` is not found. If not specified, default is the original path

       ```
         val p: J.Path = "aaa" , "bbb" + "ccc" + "ddd" + "eee" + "fff"

         p TP                                         // Prints: aaa\bbb\ccc\ddd\eee\fff

         p subpathFrom "ccc" , "ddd" TP                  // Prints: ccc\ddd\eee\fff

         p subpathFrom "ddd" , "ccc" TP                  // Prints: aaa\bbb\ccc\ddd\eee\fff

         p subpathFrom ("ddd" , "ccc", "xyz" , "bbc") TP // Prints: xyz\bbc
      ```


@def parent -> Parent [[Path]]

       Returns parent [[Path]] of `this` [[Path]]

       ```
          val p: J.Path = "aaa" , "bbb" + "ccc"

          p.parent TP  // Prints: aaa\bbb
       ```


*/
