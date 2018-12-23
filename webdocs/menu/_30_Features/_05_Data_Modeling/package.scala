package Features
/**
 * Data Modeling Framework allows creating scala.AnyVal value objects in a systematic fashion
 *
 * When creating number based data types a lot of numeric functionality is inherited, consider the [[Dollars_Example Dollars Example]]
 *
 * There are many data roots providing different features, for example:
 *
 *     - [[scalqa.Any.Datum.Int Any.Datum.Int]] just allows un-boxed collections
 *     - [[scalqa.Any.Datum.Int Any.Datum.Int.Ordered]] adds standard Ordering
 *     - [[scalqa.Any.Datum.Int Any.Datum.Int.Sequential]] adds type traversal with Int step
 *     - [[scalqa.Any.Datum.Int Any.Datum.Int.Computable]] adds Numeric functionality, it can be summed, multiplied by numbers, but not by itself
 *     - [[scalqa.Any.Datum.Int Any.Datum.Int.Number]] is a full number type
 *
 * A large example of modeled data is [[Time_and_Calendar Time and Calendar framework]]
 *
 * =All Data Roots=
 *
 * Byte
 *     - [[scalqa.Any.Datum.Byte               Any.Datum.Byte]]
 *     - [[scalqa.Any.Datum.Byte.Ordered       Any.Datum.Byte.Ordered]]
 *     - [[scalqa.Any.Datum.Byte.Sequential    Any.Datum.Byte.Sequential]]
 *     - [[scalqa.Any.Datum.Byte.Computable    Any.Datum.Byte.Computable]]
 *     - [[scalqa.Any.Datum.Byte.Number        Any.Datum.Byte.Number]]
 *
 * Short
 *     - [[scalqa.Any.Datum.Short              Any.Datum.Short]]
 *     - [[scalqa.Any.Datum.Short.Ordered      Any.Datum.Short.Ordered]]
 *     - [[scalqa.Any.Datum.Short.Sequential   Any.Datum.Short.Sequential]]
 *     - [[scalqa.Any.Datum.Short.Computable   Any.Datum.Short.Computable]]
 *     - [[scalqa.Any.Datum.Short.Number       Any.Datum.Short.Number]]
 *
 * Integer
 *     - [[scalqa.Any.Datum.Int                Any.Datum.Int]]
 *     - [[scalqa.Any.Datum.Int.Ordered        Any.Datum.Int.Ordered]]
 *     - [[scalqa.Any.Datum.Int.Sequential     Any.Datum.Int.Sequential]]
 *     - [[scalqa.Any.Datum.Int.Computable     Any.Datum.Int.Computable]]
 *     - [[scalqa.Any.Datum.Int.Number         Any.Datum.Int.Number]]
 *
 * Long
 *     - [[scalqa.Any.Datum.Long               Any.Datum.Long]]
 *     - [[scalqa.Any.Datum.Long.Ordered       Any.Datum.Long.Ordered]]
 *     - [[scalqa.Any.Datum.Long.Computable    Any.Datum.Long.Computable]]
 *     - [[scalqa.Any.Datum.Long.Number        Any.Datum.Long.Number]]
 *
 * Float
 *     - [[scalqa.Any.Datum.Float              Any.Datum.Float]]
 *     - [[scalqa.Any.Datum.Float.Ordered      Any.Datum.Float.Ordered]]
 *     - [[scalqa.Any.Datum.Float.Computable   Any.Datum.Float.Computable]]
 *     - [[scalqa.Any.Datum.Float.Number       Any.Datum.Float.Number]]
 *
 * Double
 *     - [[scalqa.Any.Datum.Double             Any.Datum.Double]]
 *     - [[scalqa.Any.Datum.Double.Ordered     Any.Datum.Double.Ordered]]
 *     - [[scalqa.Any.Datum.Double.Computable  Any.Datum.Double.Computable]]
 *     - [[scalqa.Any.Datum.Double.Number      Any.Datum.Double.Number]]
 *
 * Object
 *     - [[scalqa.Any.Datum.Ref                Any.Datum.Ref]]
 *     - [[scalqa.Any.Datum.Comparable         Any.Datum.Comparable]]
 *     - [[scalqa.Any.Datum.String             Any.Datum.String]]
 */
package object Data_Modeling { val sort_0 = () }
