package scalqa; package j; import file.*; import language.implicitConversions

import J.File

object File extends Any.Ref.Custom.Type[J.File,java.io.File]("File"):
  inline          def apply(inline v: java.io.File)            : File   = v.asOpaque[File]
  implicit inline def implicitFromJava(inline v: java.io.File) : File   = v.asOpaque[File]
  override        def tag(v: File)                             : String = v.path.toString

  extension (x: File)
    def name                                   : String    = x.real.getName
    def path                                   : Path      = x.real.toPath
    def exists                                 : Boolean   = x.real.exists
    def lastModified                           : Time      = Time.fromMillis(x.real.lastModified)
    def extension                              : String    = x.real.getCanonicalPath.takeAfterLast(".", "")
    def size                                   : ByteCount = x.real.length.ByteCount
    def openOutput                             : J.Output  = J.Output(x)
    def openInput                              : J.Input   = J.Input(x)
    def readString                             : String    = x.openInput.asText.readAllAndClose
    def writeString(s: String)                 : Unit      = Z.writeString(x, s)
    def delete                                 : Boolean   = x.real.delete
    def move(trgt:Path,overwrite:Boolean=false): File      = Z.move(x, trgt, overwrite)
    def temp                                   : File      = Z.tempFile(x)
    def copy(p:Path, overwrite:Boolean=false,
                      copyAttr:Boolean=false)  : File      = Z.copy(x, p, overwrite, copyAttr)

  object opaque:
    opaque type `type` <: Opaque.Ref = java.io.File & Opaque.Ref

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Path   = file.Path.opaque.`type`;   inline def Path   = file.Path
  type Store  = file.Store.opaque.`type`;  inline def Store  = file.Store
  type System = file.System.opaque.`type`; inline def System = file.System

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

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

         f2 TP            // Prints: C:\Temp\Test2.txt

         f2.readString TP // Prints: Foo
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

         f.path TP       // Prints: C:\Temp\Test.txt

         f.name TP       // Prints: Test.txt

         f.extension TP  // Prints: txt
      ```

@def size -> File size

      Returns file [[ByteCount]]

      ```
         val p = J.Path("C:", "Temp", "Test.txt")

         val f: J.File = p.fileMake

         f.writeString("ABC" * 1000)

         f.size TP // Prints: 3.0kB
      ```


@def move -> Move file

       Returns new [[File]]

       ```
         val p = J.Path("C:", "Temp", "Test.txt")

         val f1: J.File = p.fileMake.^(_.writeString("Foo"))

         val f2: J.File = f1.move(p.parent + "Test2.txt")

         f2 TP            // Prints: C:\Temp\Test2.txt

         f2.readString TP // Prints: Foo
       ```


@def temp -> Creates temporary file

       Creates new temporary file with `this` file as base

       if App._^.TempPath_? is available, this will be the directory, otherwise `this` file directory will be used

       Temporary file name will be `this.name' plus '.temp' or '.temp1' or '.temp2' or '.temp3' or etc. if exists
       ```
         val p = J.Path("C:", "Temp", "Test.txt")

         val f: J.File = p.fileMake

         f.temp TP // Prints: C:\Temp\Test.txt.temp

         f.temp TP // Prints: C:\Temp\Test.txt.temp1

         f.temp TP // Prints: C:\Temp\Test.txt.temp2
       ```

*/
