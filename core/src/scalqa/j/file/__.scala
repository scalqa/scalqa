package scalqa; package j; import file.*; import language.implicitConversions

import J.File
import java.io.{ File as REAL}

object File extends AnyRef.Opaque.Base[J.File,REAL]("File"):
  inline          def apply(inline v: REAL)           : File   = v.opaque
  override        def value_tag(v: File)              : String = v.path.toString
  implicit inline def implicitFromJava(inline v: REAL): File   = v.opaque

  extension (inline x: File)
    inline def name                                   : String    = x.real.getName
    inline def path                                   : Path      = x.real.toPath
    inline def exists                                 : Boolean   = x.real.exists
    inline def lastModified                           : Time      = Time.fromMillis(x.real.lastModified)
    inline def extension                              : String    = x.real.getCanonicalPath.takeAfterLast(".", "")
    inline def size                                   : ByteCount = x.real.length.ByteCount
    inline def openOutput                             : J.Output  = J.Output(x)
    inline def openInput                              : J.Input   = J.Input(x)
    inline def readString                             : String    = x.openInput.asText.readAllAndClose
    inline def writeString(inline s: String)          : Unit      = Z.writeString(x, s)
    inline def delete                                 : Boolean   = x.real.delete
    inline def temp                                   : File      = Z.tempFile(x)
    inline def move(inline trgt:Path,
                    inline overwrite:Boolean=false)   : File      = Z.move(x, trgt, overwrite)
    inline def copy(inline p:Path,
                    inline overwrite:Boolean=false,
                    inline copyAttr:Boolean=false)    : File      = Z.copy(x, p, overwrite, copyAttr)

  object OPAQUE:
    opaque type TYPE <: AnyRef.Opaque = REAL & AnyRef.Opaque

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Path   = file.Path.OPAQUE.TYPE;   transparent inline def Path   = file.Path
  type Store  = file.Store.OPAQUE.TYPE;  transparent inline def Store  = file.Store
  type System = file.System.OPAQUE.TYPE; transparent inline def System = file.System

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object OPAQUE  -> ###

   [[J.File]] is an opaque value, backed by java.io.File

   [[J.File]] does not have direct constructors. To create [[File]] one needs to start with [[J.Path]]

@def name -> Name

      Last name without prior path $example


@def exists -> Check if exists

      Usually returns `true`, unless was [[delete]]d just before


@def lastModified -> Last updated time

      Returns [[Time]] when `this` was last modified


@def path -> Path

      Returns [[J.Path]] to this $example


@def copy -> Copy to new location

       Copies `this` file to new location

       Returns new [[File]]
       ```
         val p: J.Path = ~~("C:", "Temp", "Test.txt")

         val f1: J.File = p.fileMake.^(_.writeString("Foo"))

         val f2: J.File = f1.copy(p.parent + "Test2.txt")

         f2.TP            // Prints: C:\Temp\Test2.txt

         f2.readString.TP // Prints: Foo
       ```

@def readString -> Read as String

       Reads `this` file as String

       Full code = ``` openInput.asText.readAllAndClose ```


@def writeString -> Write String

       Writes String to `this` file, overwriting prior data

       Full code =
       ```
         if (exists) delete;
         openOutput.asText.writeAllAndClose(s)
       ```


@def openOutput -> Create output

       Opens [[J.Output]] to `this` file


@def openInput -> Create input

       Opens [[J.Input]] to `this` file


@def delete -> Delete file

      Deletes file


@def extension -> File extension

      Returns the part of file name after last period

      If no period in file name, empty String is returned

      ```
         val p = J.Path("C:", "Temp", "Test.txt")

         val f: J.File = p.fileMake

         f.path.TP       // Prints: C:\Temp\Test.txt

         f.name.TP       // Prints: Test.txt

         f.extension.TP  // Prints: txt
      ```

@def size -> File size

      Returns file [[ByteCount]]

      ```
         val p = J.Path("C:", "Temp", "Test.txt")

         val f: J.File = p.fileMake

         f.writeString("ABC" * 1000)

         f.size.TP // Prints: 3.0kB
      ```


@def move -> Move file

       Returns new [[File]]

       ```
         val p = J.Path("C:", "Temp", "Test.txt")

         val f1: J.File = p.fileMake.^(_.writeString("Foo"))

         val f2: J.File = f1.move(p.parent + "Test2.txt")

         f2.TP            // Prints: C:\Temp\Test2.txt

         f2.readString.TP // Prints: Foo
       ```


@def temp -> Creates temporary file

       Creates new temporary file with `this` file as base

       if App._^.TempPath_? is available, this will be the directory, otherwise `this` file directory will be used

       Temporary file name will be `this.name' plus '.temp' or '.temp1' or '.temp2' or '.temp3' or etc. if exists
       ```
         val p = J.Path("C:", "Temp", "Test.txt")

         val f: J.File = p.fileMake

         f.temp.TP // Prints: C:\Temp\Test.txt.temp

         f.temp.TP // Prints: C:\Temp\Test.txt.temp1

         f.temp.TP // Prints: C:\Temp\Test.txt.temp2
       ```

*/
