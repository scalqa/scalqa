/**
 *
 *  Scalqa employs its original `Package-Oriented Programming` (POP) for program structuring. Without understanding the concepts,
 *  looking into the source code could be very frustrating
 *
 *  Given [[https://en.wikipedia.org/wiki/Object-oriented_programming Object-Oriented Programming (OOP)]],
 *  if object is not trivial, it can become a [[Package_Type Package Type]],
 *  occupying specially designated package and defined in many different files
 *
 *  From usage prospective [[Package_Type Package Type]] is not different from a regular object.
 *  More over, objects can be promoted to [[Package_Type Package Types]] later, and the move should not break any existing code
 *
 *  There are two reasons why an object should become a package type:
 *
 *    - [[Complexity_Reduction Complexity reduction]]
 *    - [[H2O Hierarchical objects organization]]
 */
package object POP { val sort_40 = () }
