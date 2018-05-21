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
    abstract void onLeftArrowButtonPress(RadioReveil radio);
    abstract void onRightArrowButtonPress(RadioReveil radio);
  }

  static private class NormalState extends RadioReveilState {
    void onLeftArrowButtonPress(RadioReveil radio) {
      System.out.println("Sélectionne la chaîne de radio présélectionnée précédente...");
    }
    void onRightArrowButtonPress(RadioReveil radio) {
      System.out.println("Sélectionne la chaîne de radio présélectionnée suivante...");
    }
  }

  static private class SetTimeState extends RadioReveilState {
    void onLeftArrowButtonPress(RadioReveil radio) {
      System.out.println("Recule l'heure du cadran...");
    }
    void onRightArrowButtonPress(RadioReveil radio) {
      System.out.println("Avance l'heure du cadran");
    }
  }

  static private class SetAlarmState extends RadioReveilState {
    void onLeftArrowButtonPress(RadioReveil radio) {
      System.out.println("Recule l'heure de l'alarme...");
    }
    void onRightArrowButtonPress(RadioReveil radio) {
      System.out.println("Avance l'heure de l'alarme...");
    }
  }

  private Mode currentMode = Mode.NORMAL; // Le mode représente l'état du radio réveil.

  public void onLeftArrowButtonPress() {
    this.currentMode.state.onLeftArrowButtonPress(this); // Délégation à l'état
  }

  public void onRightArrowButtonPress() {
    this.currentMode.state.onRightArrowButtonPress(this); // Délégation à l'état
  }

  public void onSwitchMode(Mode mode) { // Permet au client de changer l'état en ne connaissant que l'enum.
    this.currentMode = mode;
  }
}
