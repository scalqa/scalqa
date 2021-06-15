package scalqa; package j; package file; import language.implicitConversions

import java.nio.file.{ FileStore => JStore }
import File.Store

object Store extends Any.Ref.Custom.Type[Store,JStore]("File.Store"):
  /**/     def apply(v: JStore): Store    = v.asOpaque[Store]
  override def doc(v: Store)   : Doc      = Doc(this) += ("name", v.name) += ("label", v.label) += ("totalSpace", v.totalSpace.toBrief)
  /**/                                                     += ("unallocatedSpace", v.unallocatedSpace.toBrief) += ("usableSpace", v.usableSpace.toBrief)

  extension (x: Store)
    def name             : String    = x.real.name
    def label            : String    = x.real.`type`()
    def totalSpace       : ByteCount = x.real.getTotalSpace.ByteCount
    def unallocatedSpace : ByteCount = x.real.getUnallocatedSpace.ByteCount
    def usableSpace      : ByteCount = x.real.getUsableSpace.ByteCount

  object opaque:
    opaque type `type` <: Opaque.Ref = JStore & Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.File.Store]] is an opaque value, backed by java.nio.file.FileStore

*/
