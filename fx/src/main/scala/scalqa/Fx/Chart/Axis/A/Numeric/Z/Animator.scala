package scalqa; package Fx; package Chart; package Axis; package A; package Numeric; package Z

import java.util.HashMap
import java.util.Map
import javafx.animation.Animation
import javafx.animation.AnimationTimer
import javafx.animation.KeyFrame
import javafx.animation.SequentialTransition
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Parent
import javafx.scene.chart.Axis

// Quick and dirty conversion from Java
final class Animator(private var nodeToLayout: Parent) extends AnimationTimer with EventHandler[ActionEvent] {
  private val activeTimeLines: Map[AnyRef, Animation] = new HashMap();
  private final val isAxis = nodeToLayout.isInstanceOf[Axis[_]]

  def handle(l: Long): Unit = if (isAxis) nodeToLayout.asInstanceOf[Axis[_]].requestAxisLayout(); else nodeToLayout.requestLayout()

  def handle(actionEvent: ActionEvent): Unit = {
    activeTimeLines.remove(actionEvent.getSource());
    if (activeTimeLines.isEmpty()) stop();
    // cause one last re-layout to make sure final values were used
    handle(0l);
  }

  def stop(animationID: AnyRef): Unit = {
    val t = activeTimeLines.remove(animationID);
    if (t != null) t.stop();
    if (activeTimeLines.isEmpty()) stop();
  }

  def animate(keyFrames: KeyFrame*): AnyRef = {
    val t = new Timeline();
    t.setAutoReverse(false);
    t.setCycleCount(1);
    t.getKeyFrames().addAll(keyFrames.all.to[java.util.List])
    t.setOnFinished(this);
    // start animation timer if needed
    if (activeTimeLines.isEmpty()) start();
    // get id and add to map
    activeTimeLines.put(t, t);
    // play animation
    t.play();
    return t;
  }

  def animate(animation: Animation): AnyRef = {
    val t = new SequentialTransition();
    t.getChildren().add(animation);
    t.setOnFinished(this);
    // start animation timer if needed
    if (activeTimeLines.isEmpty()) start();
    // get id and add to map
    activeTimeLines.put(t, t);
    // play animation
    t.play();
    return t;
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
