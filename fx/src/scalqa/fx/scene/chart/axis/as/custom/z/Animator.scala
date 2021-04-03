package scalqa; package fx; package scene; package chart; package axis; package as; package custom; package z; import language.implicitConversions

import java.util.{ HashMap, Map}
import javafx.animation.{Animation, AnimationTimer, KeyFrame, SequentialTransition, Timeline}
import javafx.event.{ActionEvent, EventHandler}
import javafx.scene.Parent
import javafx.scene.chart.Axis

// Quick and dirty conversion from Java
final class Animator(private var nodeToLayout: Parent) extends AnimationTimer with EventHandler[ActionEvent]:
  private val activeTimeIdxs: Map[AnyRef, Animation] = new HashMap();
  private final val isAxis = nodeToLayout.isInstanceOf[Axis[_]]

  def handle(l: Long): Unit =
    if (isAxis) nodeToLayout.cast[Axis[_]].requestAxisLayout()
    else nodeToLayout.requestLayout()

  def handle(actionEvent: ActionEvent): Unit =
    activeTimeIdxs.remove(actionEvent.getSource())
    if (activeTimeIdxs.isEmpty()) stop()
    // cause one last re-layout to make sure final values were used
    handle(0L)

  def stop(animationID: AnyRef): Unit =
    val t = activeTimeIdxs.remove(animationID)
    if (t != null) t.stop()
    if (activeTimeIdxs.isEmpty()) stop()

  def animate(keyFrames: KeyFrame*): AnyRef =
    val t = new Timeline()
    t.setAutoReverse(false)
    t.setCycleCount(1)
    t.getKeyFrames().addAll(keyFrames.~.toJavaList)
    t.setOnFinished(this)
    // start animation timer if needed
    if (activeTimeIdxs.isEmpty()) start()
    // get id and add to map
    activeTimeIdxs.put(t, t)
    // play animation
    t.play()
    return t

  def animate(animation: Animation): AnyRef =
    val t = new SequentialTransition()
    t.getChildren().add(animation)
    t.setOnFinished(this)
    // start animation timer if needed
    if (activeTimeIdxs.isEmpty()) start()
    // get id and add to map
    activeTimeIdxs.put(t, t)
    // play animation
    t.play()
    return t
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
