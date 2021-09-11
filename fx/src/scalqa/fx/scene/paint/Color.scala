package scalqa; package fx; package scene; package paint

import javafx.scene.paint.{ Color => FX }
import Fx.Color

object Color extends Abstract.Delegate.Opaque[Color, FX]("Fx.Paint.Color"):
  def apply(red: Int, green: Int, blue: Int) : Color = FX.rgb(red, green, blue).cast[Color]

  object TYPE:
    opaque type DEF <: Paint.TYPE.DEF  = FX & Paint.TYPE.DEF

  export Named.*
  object Named:
    extension(x: javafx.scene.paint.Color) private inline def mk: Color = Color(x)
    inline def AliceBlue         = FX.ALICEBLUE.mk
    inline def AntiqueWhite      = FX.ANTIQUEWHITE.mk
    inline def Aqua              = FX.AQUA.mk
    inline def AquaMarine        = FX.AQUAMARINE.mk
    inline def Azure             = FX.AZURE.mk
    inline def Beige             = FX.BEIGE.mk
    inline def Bisque            = FX.BISQUE.mk
    inline def Black             = FX.BLACK.mk
    inline def BlanchedAlmond    = FX.BLANCHEDALMOND.mk
    inline def Blue              = FX.BLUE.mk
    inline def BlueViolet        = FX.BLUEVIOLET.mk
    inline def Brown             = FX.BROWN.mk
    inline def BurlyWood         = FX.BURLYWOOD.mk
    inline def CadetBlue         = FX.CADETBLUE.mk
    inline def ChartReuse        = FX.CHARTREUSE.mk
    inline def Chocolate         = FX.CHOCOLATE.mk
    inline def Coral             = FX.CORAL.mk
    inline def CornFlowerBlue    = FX.CORNFLOWERBLUE.mk
    inline def CornSilk          = FX.CORNSILK.mk
    inline def Crimson           = FX.CRIMSON.mk
    inline def Cyan              = FX.CYAN.mk
    inline def DarkBlue          = FX.DARKBLUE.mk
    inline def DarkCyan          = FX.DARKCYAN.mk
    inline def DarkGoldenRod     = FX.DARKGOLDENROD.mk
    inline def DarkGrey          = FX.DARKGRAY.mk
    inline def DarkGreen         = FX.DARKGREEN.mk
    inline def DarkKhaki         = FX.DARKKHAKI.mk
    inline def DarkMagenta       = FX.DARKMAGENTA.mk
    inline def DarkOliveGreen    = FX.DARKOLIVEGREEN.mk
    inline def DarkOrange        = FX.DARKORANGE.mk
    inline def DarkOrchid        = FX.DARKORCHID.mk
    inline def DarkRed           = FX.DARKRED.mk
    inline def DarkSalmon        = FX.DARKSALMON.mk
    inline def DarkSeaGreen      = FX.DARKSEAGREEN.mk
    inline def DarkSlateBlue     = FX.DARKSLATEBLUE.mk
    inline def DarkSlateGrey     = FX.DARKSLATEGRAY.mk
    inline def DarkTurquoise     = FX.DARKTURQUOISE.mk
    inline def DarkViolet        = FX.DARKVIOLET.mk
    inline def DeepPink          = FX.DEEPPINK.mk
    inline def DeepSkyBlue       = FX.DEEPSKYBLUE.mk
    inline def DimGrey           = FX.DIMGREY.mk
    inline def DodgeBlue         = FX.DODGERBLUE.mk
    inline def FireBrick         = FX.FIREBRICK.mk
    inline def FloralWhite       = FX.FLORALWHITE.mk
    inline def ForestGreen       = FX.FORESTGREEN.mk
    inline def Fuchsia           = FX.FUCHSIA.mk
    inline def Gainsboro         = FX.GAINSBORO.mk
    inline def GhostWhite        = FX.GHOSTWHITE.mk
    inline def Gold              = FX.GOLD.mk
    inline def GoldenRod         = FX.GOLDENROD.mk
    inline def Gray              = FX.GRAY.mk
    inline def Green             = FX.GREEN.mk
    inline def GreenYellow       = FX.GREENYELLOW.mk
    inline def HoneyDew          = FX.HONEYDEW.mk
    inline def HotPink           = FX.HOTPINK.mk
    inline def IndianRed         = FX.INDIANRED.mk
    inline def Indigo            = FX.INDIGO.mk
    inline def Ivory             = FX.IVORY.mk
    inline def Khaki             = FX.KHAKI.mk
    inline def Lavender          = FX.LAVENDER.mk
    inline def LavenderBlush     = FX.LAVENDERBLUSH.mk
    inline def LawnGreen         = FX.LAWNGREEN.mk
    inline def LemonChiffon      = FX.LEMONCHIFFON.mk
    inline def LightBlue         = FX.LIGHTBLUE.mk
    inline def LightCoral        = FX.LIGHTCORAL.mk
    inline def LightCyan         = FX.LIGHTCYAN.mk
    inline def LightGoldenYellow = FX.LIGHTGOLDENRODYELLOW.mk
    inline def LightGray         = FX.LIGHTGRAY.mk
    inline def LightGreen        = FX.LIGHTGREEN.mk
    inline def LightPink         = FX.LIGHTPINK.mk
    inline def LightSalmon       = FX.LIGHTSALMON.mk
    inline def LightSeaGreen     = FX.LIGHTSEAGREEN.mk
    inline def LightSkyBlue      = FX.LIGHTSKYBLUE.mk
    inline def LightSlateGray    = FX.LIGHTSLATEGRAY.mk
    inline def LightSteelBlue    = FX.LIGHTSTEELBLUE.mk
    inline def LightYellow       = FX.LIGHTYELLOW.mk
    inline def Lime              = FX.LIME.mk
    inline def LimeGreen         = FX.LIMEGREEN.mk
    inline def Idxn              = FX.LINEN.mk
    inline def Magenta           = FX.MAGENTA.mk
    inline def Maroon            = FX.MAROON.mk
    inline def MediumAquaMarine  = FX.MEDIUMAQUAMARINE.mk
    inline def MediumBlue        = FX.MEDIUMBLUE.mk
    inline def MediumOrchid      = FX.MEDIUMORCHID.mk
    inline def MediumPurple      = FX.MEDIUMPURPLE.mk
    inline def MediumSeaGreen    = FX.MEDIUMSEAGREEN.mk
    inline def MediumSlateBlue   = FX.MEDIUMSLATEBLUE.mk
    inline def MediumSpringGreen = FX.MEDIUMSPRINGGREEN.mk
    inline def MediumTurquoise   = FX.MEDIUMTURQUOISE.mk
    inline def MediumVioletRed   = FX.MEDIUMVIOLETRED.mk
    inline def MidnightBlue      = FX.MIDNIGHTBLUE.mk
    inline def MintCream         = FX.MINTCREAM.mk
    inline def MistyRose         = FX.MISTYROSE.mk
    inline def Moccasin          = FX.MOCCASIN.mk
    inline def NavajoWhite       = FX.NAVAJOWHITE.mk
    inline def Navy              = FX.NAVY.mk
    inline def OldLace           = FX.OLDLACE.mk
    inline def Olive             = FX.OLIVE.mk
    inline def OliveDrab         = FX.OLIVEDRAB.mk
    inline def Orange            = FX.ORANGE.mk
    inline def OrangeRed         = FX.ORANGERED.mk
    inline def Orchid            = FX.ORCHID.mk
    inline def PaleGoldenRod     = FX.PALEGOLDENROD.mk
    inline def PaleGreen         = FX.PALEGREEN.mk
    inline def PaleTurquoise     = FX.PALETURQUOISE.mk
    inline def PaleVioletRed     = FX.PALEVIOLETRED.mk
    inline def PapayaWhip        = FX.PAPAYAWHIP.mk
    inline def PeachPuff         = FX.PEACHPUFF.mk
    inline def Peru              = FX.PERU.mk
    inline def Pink              = FX.PINK.mk
    inline def Plum              = FX.PLUM.mk
    inline def PowderBlue        = FX.POWDERBLUE.mk
    inline def Purple            = FX.PURPLE.mk
    inline def Red               = FX.RED.mk
    inline def RosyBrown         = FX.ROSYBROWN.mk
    inline def RoyalBlue         = FX.ROYALBLUE.mk
    inline def SaddleBrown       = FX.SADDLEBROWN.mk
    inline def Salmon            = FX.SALMON.mk
    inline def SandyBrown        = FX.SANDYBROWN.mk
    inline def SeaGreen          = FX.SEAGREEN.mk
    inline def SeaShell          = FX.SEASHELL.mk
    inline def Sienna            = FX.SIENNA.mk
    inline def Silver            = FX.SILVER.mk
    inline def SkyBlue           = FX.SKYBLUE.mk
    inline def SlateBlue         = FX.SLATEBLUE.mk
    inline def SlateGray         = FX.SLATEGRAY.mk
    inline def Snow              = FX.SNOW.mk
    inline def SpringGreen       = FX.SPRINGGREEN.mk
    inline def SteelBlue         = FX.STEELBLUE.mk
    inline def Tan               = FX.TAN.mk
    inline def Teal              = FX.TEAL.mk
    inline def Thistle           = FX.THISTLE.mk
    inline def Tomato            = FX.TOMATO.mk
    inline def Transparent       = FX.TRANSPARENT.mk
    inline def Turquoise         = FX.TURQUOISE.mk
    inline def Violet            = FX.VIOLET.mk
    inline def Wheat             = FX.WHEAT.mk
    inline def White             = FX.WHITE.mk
    inline def WhiteSmoke        = FX.WHITESMOKE.mk
    inline def Yellow            = FX.YELLOW.mk
    inline def YellowGreen       = FX.YELLOWGREEN.mk

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c.mk 2020, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
