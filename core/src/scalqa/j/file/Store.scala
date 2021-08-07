package scalqa; package j; package file; import language.implicitConversions

import java.nio.file.{ FileStore => REAL }
import File.Store

object Store extends AnyRef.Opaque.Base[Store,REAL]("File.Store"):
  /**/     def apply(v: REAL)     : Store = v.opaque
  override def value_doc(v: Store): Doc   = Doc(this) += ("name", v.name) += ("label", v.label) += ("totalSpace", v.totalSpace.toBrief)
    /**/                                              += ("unallocatedSpace", v.unallocatedSpace.toBrief) += ("usableSpace", v.usableSpace.toBrief)

  extension (inline x: Store)
    inline def name            : String    = x.real.name
    inline def label           : String    = x.real.`type`()
    inline def totalSpace      : ByteCount = x.real.getTotalSpace.ByteCount
    inline def unallocatedSpace: ByteCount = x.real.getUnallocatedSpace.ByteCount
    inline def usableSpace     : ByteCount = x.real.getUsableSpace.ByteCount

  object OPAQUE:
    opaque type TYPE <: AnyRef.Opaque = REAL & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object OPAQUE  -> ###

   [[J.File.Store]] is an opaque value, backed by java.nio.file.FileStore

*/
