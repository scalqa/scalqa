package scalqa; package j; package util; import language.implicitConversions

import java.lang.ref.WeakReference
import J.WeakRef

object WeakRef:
  /**/     inline def apply[A](inline v: A)                     : WeakRef[A] = new WeakReference[A](v).cast[WeakRef[A]]
  implicit inline def implicitToBoolean[A](inline v: WeakRef[A]): Boolean    = v.getOpt

  extension[A](x: WeakRef[A])
    def getOpt : Opt[A] = { val v = x.cast[WeakReference[A]].get; if (v == null) \/ else v }

  given z_ClassTag[A](using t: ClassTag[A]): ClassTag[WeakRef[A]] = t.cast[ClassTag[WeakRef[A]]]
  given z_NameDef [A]: Any.Def.TypeName[WeakRef[A]]  = Any.Def.TypeName("WeakRef")
  given z_VoidDef [A]: Any.Def.Void[WeakRef[A]]  with { inline def value_isVoid(v: WeakRef[A]) = false }
  given z_Doc     [A](using t: Any.Def.Tag[A]): Any.Def.Doc[WeakRef[A]]   with
    def value_doc(v: WeakRef[A]): Doc      = Doc("WeakRef@"+v.self.hash)
    def value_tag(v: WeakRef[A]): String   = "WeakRef("+ v.getOpt.map(v => t.value_tag(v)).or("\\/") + ")"

  object TYPE:
    opaque type DEF[A] <: AnyRef.Opaque = WeakReference[A] & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@type DEF  -> ### Weakly Referenced Instance

       [[J.WeakRef]] value will be garbage collected in case there is no other reference to it

       Note. The returned [[getOpt]] should be used for basic checks only.
             It should not be subjected to chain transformations, as this creates more references to the weak value

       ```
         var hr = new Object       // hard reference

         val wr = J.WeakRef(hr)    // weak reference

         wr.getOpt.isEmpty.TP       // Prints: false

         hr = null                 // Clearing hard refference
         System.gc                 // Run garbage collection

         wr.getOpt.isEmpty.TP       // Prints: true
       ```


@def getOpt -> Value Option

       Returns value option


*/
