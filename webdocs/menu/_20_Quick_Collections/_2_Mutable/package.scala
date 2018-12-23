package Quick_Collections

/**
 * Mutable collections interfaces are:
 *
 *     - [[scalqa.Idx.M Idx.M]], which is Mutable Indexed Collection
 *     - [[scalqa.Lookup.M Lookup.M]], which is Mutable Lookup Collection
 *
 * [[scalqa.Idx.M Idx.M]] offers same performance as Scala Buffer [[Add_Benchmark for objects]] and is expectedly faster [[Add_Benchmark_Specialized for primitives]]
 *
 * [[scalqa.Idx.M Lookup.M]] is backed by a scala.Map, with no performance gain
 *
 */
package object Mutable { val sort_2 = () }
