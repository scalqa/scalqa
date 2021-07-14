package scalqa; package j; package util; import language.implicitConversions

import java.lang.ref.WeakReference
import J.WeakRef

object WeakRef:
  /**/     inline def apply[A](inline v: A): WeakRef[A] = new WeakReference[A](v).asOpaque[WeakRef[A]]

  implicit inline def implicitToBoolean[A](v: WeakRef[A]): Boolean    = v.get_?

  given givenClassTag[A](using t: ClassTag[A]): ClassTag[WeakRef[A]] = t.cast[ClassTag[WeakRef[A]]]
  given givenTypeTag [A]: Given.TypeTag[WeakRef[A]]  = Given.TypeTag("WeakRef")
  given givenVoidTag [A]: Given.VoidTag[WeakRef[A]]  with { inline def isVoid(v: WeakRef[A]) = false }

  given givenDocTag[A](using t: Given.DocTag[A]) : Given.DocTag[WeakRef[A]] with
    def tag(v: WeakRef[A]) : String   = "WeakRef("+ v.get_?.map(v => t.tag(v)).or("\\/") + ")"
    def doc(v: WeakRef[A]) : Doc      = Doc("WeakRef@"+v.self_^.hash)

  extension[A](x: WeakRef[A])
     @tn("get_Opt") def get_? : Opt[A] = { val v = x.cast[WeakReference[A]].get; if (v == null) \/ else v }

  object opaque:
    opaque type `type`[A] <: Opaque.Ref = WeakReference[A] & Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@object opaque -> ### Weakly Referenced Instance

       [[J.WeakRef]] value will be garbage collected in case there is no other reference to it

       Note. The returned [[get_?]] should be used for basic checks only.
             It should not be subjected to chain transformations, as this creates more references to the weak value

       ```
         var hr = new Object       // hard reference

         val wr = J.WeakRef(hr)    // weak reference

         wr.get_?.isEmpty.TP       // Prints: false

         hr = null                 // Clearing hard refference
         System.gc                 // Run garbage collection

         wr.get_?.isEmpty.TP       // Prints: true
       ```


@def get_? -> Value Option

       Returns value option


*/
