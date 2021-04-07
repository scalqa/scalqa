package scalqa; package fx; package scene; import language.implicitConversions

abstract class Stage(stage: Opt[javafx.stage.Stage] = \/) extends Window:
  protected type REAL = javafx.stage.Stage;
  protected override def _createReal = stage.or(new javafx.stage.Stage).^(_.setScene(scene.real))

  /**/       lazy  val icons              : Idx.M[Image]   =  Idx.M.javaList_^(real.getIcons).twoWay_^[Image]
  /**/             def show               : Unit           = real.show
  @tn("title_Pro") def title_*            : String.Pro.OM  = Fx.JavaFx.As.pro_OM(real.titleProperty)
  /**/             def title              : String         = real.getTitle
  /**/             def title_=(v: String) : Unit           = real.setTitle(v)

object Stage:

  def apply(titleO: String.Opt, w: Int, h: Int, e: Node.Like): Stage = new Stage(new javafx.stage.Stage) {
    titleO.forval(title = _)
    val scene = Scene(w, h, e)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/