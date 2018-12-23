package POP.Package_Type

/**
 *  A complex package type can have many different roles, uses, responsibilities, and each of them can be defined as a separate [[Type_Trait type trait]]
 *
 *  A [[Type_Trait type trait]] is a trait with a sole purpose to be assembled into a larger type, and will `never` be used independently
 *
 *  It must be located within the type's package, named with lower case character, and prefixed with underscore
 *
 *  Here are code fragments of how [[scalqa.Fx.A.Node Fx.A.Node]] is defined
 *
 *  {{{
 *    package scalqa.Fx.A {
 *
 *       package object A {
 *         type Node = Node._Trait                      // The name to be used
 *
 *       }
 *
 *       package Node {
 *
 *          trait _Trait extends Like                   // Type definition
 *              with _pro with _events with _methods {
 *
 *               // More methods
 *          }
 *
 *          trait _pro { self: Node =>                  // Type trait definition
 *               // More methods
 *          }
 *
 *          trait _events { self: Node =>               // Type trait definition
 *               // More methods
 *          }
 *
 *          trait _methods { self: Node =>              // Type trait definition
 *               // More methods
 *          }
 *
 *
 *          abstract class Like  {                      // Base independent type
 *               // More methods
 *          }
 *       }
 *     }
 *  }}}
 */
class Type_Trait { val sort_1 = () }
