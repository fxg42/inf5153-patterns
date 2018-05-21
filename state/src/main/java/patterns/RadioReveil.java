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
    public RadioReveilState getState() {
      return this.state;
    }
  }

  private Mode currentMode = Mode.NORMAL;

  public void onLeftArrowButtonPress() {
    this.currentMode.getState().onLeftArrowButtonPress(this);
  }

  public void onRightArrowButtonPress() {
    this.currentMode.getState().onRightArrowButtonPress(this);
  }

  public void onSwitchMode(Mode mode) {
    this.currentMode = mode;
  }
}


//
// Classe abstraite seulement pour pouvoir la garder dans le même fichier.
//

abstract class RadioReveilState {
  abstract void onLeftArrowButtonPress(RadioReveil radio);
  abstract void onRightArrowButtonPress(RadioReveil radio);
}

class NormalState extends RadioReveilState {
  void onLeftArrowButtonPress(RadioReveil radio) {
    System.out.println("Sélectionne la chaîne de radio présélectionnée précédente...");
  }
  void onRightArrowButtonPress(RadioReveil radio) {
    System.out.println("Sélectionne la chaîne de radio présélectionnée suivante...");
  }
}

class SetTimeState extends RadioReveilState {
  void onLeftArrowButtonPress(RadioReveil radio) {
    System.out.println("Recule l'heure du cadran...");
  }
  void onRightArrowButtonPress(RadioReveil radio) {
    System.out.println("Avance l'heure du cadran");
  }
}

class SetAlarmState extends RadioReveilState {
  void onLeftArrowButtonPress(RadioReveil radio) {
    System.out.println("Recule l'heure de l'alarme...");
  }
  void onRightArrowButtonPress(RadioReveil radio) {
    System.out.println("Avance l'heure de l'alarme...");
  }
}
