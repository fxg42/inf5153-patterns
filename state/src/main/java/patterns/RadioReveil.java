package patterns;

public class RadioReveil {

  public enum Mode {
    NORMAL(new NormalState()),
    SET_TIME(new SetTimeState()),
    SET_ALARM(new SetAlarmState());

    private final RadioReveilState state;

    Mode(RadioReveilState state) {
      this.state = state;
    }
  }

  static private abstract class RadioReveilState {
    abstract String onLeftArrowButtonPress(RadioReveil radio);
    abstract String onRightArrowButtonPress(RadioReveil radio);
  }

  static private class NormalState extends RadioReveilState {
    String onLeftArrowButtonPress(RadioReveil radio) {
      return "Sélectionne la chaîne de radio présélectionnée précédente...";
    }
    String onRightArrowButtonPress(RadioReveil radio) {
     return "Sélectionne la chaîne de radio présélectionnée suivante...";
    }
  }

  static private class SetTimeState extends RadioReveilState {
    String onLeftArrowButtonPress(RadioReveil radio) {
      return "Recule l'heure du cadran...";
    }
    String onRightArrowButtonPress(RadioReveil radio) {
      return "Avance l'heure du cadran...";
    }
  }

  static private class SetAlarmState extends RadioReveilState {
    String onLeftArrowButtonPress(RadioReveil radio) {
      return "Recule l'heure de l'alarme...";
    }
    String onRightArrowButtonPress(RadioReveil radio) {
      return "Avance l'heure de l'alarme...";
    }
  }

  private Mode currentMode = Mode.NORMAL; // Le mode représente l'état du radio réveil.

  public String onLeftArrowButtonPress() {
    return this.currentMode.state.onLeftArrowButtonPress(this); // Délégation à l'état
  }

  public String onRightArrowButtonPress() {
    return this.currentMode.state.onRightArrowButtonPress(this); // Délégation à l'état
  }

  public void onSwitchMode(Mode mode) { // Permet au client de changer l'état en ne connaissant que l'enum.
    this.currentMode = mode;
  }
}
