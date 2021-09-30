package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

import scala.quoted.*
import x.VarArg.*

object values:

  inline def take  [A](  inline x: ~[A],                   inline v: ~[A]): ~[A] = ${ Macro('true, 'x,'null,'v) }
  inline def takeBy[A,B](inline x: ~[A], inline f: A => B, inline v: ~[B]): ~[A] = ${ Macro('true, 'x,'f   ,'v) }
  inline def drop  [A](  inline x: ~[A],                   inline v: ~[A]): ~[A] = ${ Macro('false,'x,'null,'v) }
  inline def dropBy[A,B](inline x: ~[A], inline f: A => B, inline v: ~[B]): ~[A] = ${ Macro('false,'x,'f   ,'v) }

  private def Macro[A:Type,B:Type](t: Expr[Boolean], x: Expr[~[A]], f: Expr[A=>B], v: Expr[~[B]])(using Quotes): Expr[~[A]] =
    v match
      case '{ Stream_ofOne($v1:A)                          } => '{ one  ($t,$x,$f,$v1) }
      case '{ Stream_ofTwo($v1:A,$v2:A)                    } => '{ two  ($t,$x,$f,$v1,$v2) }
      case '{ Stream_ofThree($v1:A,$v2:A,$v3:A)            } => '{ three($t,$x,$f,$v1,$v2,$v3) }
      case '{ Stream_ofFour($v1:A,$v2:A,$v3:A,$v4:A)       } => '{ four ($t,$x,$f,$v1,$v2,$v3,$v4) }
      case '{ Stream_ofFive($v1:A,$v2:A,$v3:A,$v4:A,$v5:A) } => '{ five ($t,$x,$f,$v1,$v2,$v3,$v4,$v5) }
      case _                                                 => '{ many ($t,$x,$f,$v) }

  inline def one  [A,B](inline t: Boolean, inline x: ~[A], inline f: A=>B, inline v1:B                                                ): ~[A] = inline f match{ case null => inline if(t) takeOne  (x,v1)             else dropOne(x,v1);              case _ => inline if(t) takeOneBy  (x,f,v1)             else dropOneBy  (x,f,v1)            }
  inline def two  [A,B](inline t: Boolean, inline x: ~[A], inline f: A=>B, inline v1:B,inline v2:B                                    ): ~[A] = inline f match{ case null => inline if(t) takeTwo  (x,v1,v2)          else dropTwo(x,v1,v2);           case _ => inline if(t) takeTwoBy  (x,f,v1,v2)          else dropTwoBy (x,f,v1,v2)          }
  inline def three[A,B](inline t: Boolean, inline x: ~[A], inline f: A=>B, inline v1:B,inline v2:B,inline v3:B                        ): ~[A] = inline f match{ case null => inline if(t) takeThree(x,v1,v2,v3)       else dropThree(x,v1,v2,v3);      case _ => inline if(t) takeThreeBy(x,f,v1,v2,v3)       else dropThreeBy (x,f,v1,v2,v3)     }
  inline def four [A,B](inline t: Boolean, inline x: ~[A], inline f: A=>B, inline v1:B,inline v2:B,inline v3:B,inline v4:B            ): ~[A] = inline f match{ case null => inline if(t) takeFour (x,v1,v2,v3,v4)    else dropFour(x,v1,v2,v3,v4);    case _ => inline if(t) takeFourBy (x,f,v1,v2,v3,v4)    else dropFourBy (x,f,v1,v2,v3,v4)   }
  inline def five [A,B](inline t: Boolean, inline x: ~[A], inline f: A=>B, inline v1:B,inline v2:B,inline v3:B,inline v4:B,inline v5:B): ~[A] = inline f match{ case null => inline if(t) takeFive (x,v1,v2,v3,v4,v5) else dropFive(x,v1,v2,v3,v4,v5); case _ => inline if(t) takeFiveBy (x,f,v1,v2,v3,v4,v5) else dropFiveBy (x,f,v1,v2,v3,v4,v5)}
  inline def many [A,B](inline t: Boolean, inline x: ~[A], inline f: A=>B, inline vs: ~[B]                                            ): ~[A] = inline f match{ case null => inline if(t) takeMany (x,vs)             else dropMany(x,vs);             case _ => inline if(t) takeManyBy (x,f,vs)             else dropManyBy(x,f,vs)             }

  def takeOne    [A,B](x: ~[A],          v1: B)                            : ~[A] = x.TAKE(_ == v1)
  def takeTwo    [A,B](x: ~[A],          v1: B, v2: B)                     : ~[A] = x.TAKE(_ in (v1,v2))
  def takeThree  [A,B](x: ~[A],          v1: B, v2: B, v3: B)              : ~[A] = x.TAKE(_ in (v1,v2,v3))
  def takeFour   [A,B](x: ~[A],          v1: B, v2: B, v3: B, v4: B)       : ~[A] = x.TAKE(_ in (v1,v2,v3,v4))
  def takeFive   [A,B](x: ~[A],          v1: B, v2: B, v3: B, v4: B, v5: B): ~[A] = x.TAKE(_ in (v1,v2,v3,v4,v5))
  def takeMany   [A,B](x: ~[A],          vs: ~[B])                         : ~[A] = {val s=vs.toSet; if(s.isEmpty) \/ else x.TAKE(s.contains) }

  def takeOneBy  [A,B](x: ~[A], f: A=>B, v1: B)                            : ~[A] = x.TAKE(f(_) == v1)
  def takeTwoBy  [A,B](x: ~[A], f: A=>B, v1: B, v2: B)                     : ~[A] = x.TAKE(f(_) in (v1,v2))
  def takeThreeBy[A,B](x: ~[A], f: A=>B, v1: B, v2: B, v3: B)              : ~[A] = x.TAKE(f(_) in (v1,v2,v3))
  def takeFourBy [A,B](x: ~[A], f: A=>B, v1: B, v2: B, v3: B, v4: B)       : ~[A] = x.TAKE(f(_) in (v1,v2,v3,v4))
  def takeFiveBy [A,B](x: ~[A], f: A=>B, v1: B, v2: B, v3: B, v4: B, v5: B): ~[A] = x.TAKE(f(_) in (v1,v2,v3,v4,v5))
  def takeManyBy [A,B](x: ~[A], f: A=>B, vs: ~[B])                         : ~[A] = {val s=vs.toSet; if(s.isEmpty) \/ else x.TAKE(v=>s.contains(f(v))) }

  def dropOne    [A,B](x: ~[A],          v1: B)                            : ~[A] = x.DROP(_ == v1)
  def dropTwo    [A,B](x: ~[A],          v1: B, v2: B)                     : ~[A] = x.DROP(_ in (v1,v2))
  def dropThree  [A,B](x: ~[A],          v1: B, v2: B, v3: B)              : ~[A] = x.DROP(_ in (v1,v2,v3))
  def dropFour   [A,B](x: ~[A],          v1: B, v2: B, v3: B, v4: B)       : ~[A] = x.DROP(_ in (v1,v2,v3,v4))
  def dropFive   [A,B](x: ~[A],          v1: B, v2: B, v3: B, v4: B, v5: B): ~[A] = x.DROP(_ in (v1,v2,v3,v4,v5))
  def dropMany   [A,B](x: ~[A],          vs: ~[B])                         : ~[A] = {val s=vs.toSet; if(s.isEmpty) x else x.DROP(s.contains) }

  def dropOneBy  [A,B](x: ~[A], f: A=>B, v1: B)                            : ~[A] = x.DROP(f(_) == v1)
  def dropTwoBy  [A,B](x: ~[A], f: A=>B, v1: B, v2: B)                     : ~[A] = x.DROP(f(_) in (v1,v2))
  def dropThreeBy[A,B](x: ~[A], f: A=>B, v1: B, v2: B, v3: B)              : ~[A] = x.DROP(f(_) in (v1,v2,v3))
  def dropFourBy [A,B](x: ~[A], f: A=>B, v1: B, v2: B, v3: B, v4: B)       : ~[A] = x.DROP(f(_) in (v1,v2,v3,v4))
  def dropFiveBy [A,B](x: ~[A], f: A=>B, v1: B, v2: B, v3: B, v4: B, v5: B): ~[A] = x.DROP(f(_) in (v1,v2,v3,v4,v5))
  def dropManyBy [A,B](x: ~[A], f: A=>B, vs: ~[B])                         : ~[A] = {val s=vs.toSet; if(s.isEmpty) x else x.DROP(v=>s.contains(f(v))) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
