package patterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestRadioReveil {

  @Test void it_should_switch_modes() {
    var radio = new RadioReveil();
    assertEquals("Sélectionne la chaîne de radio présélectionnée suivante...", radio.onRightArrowButtonPress());

    radio.onSwitchMode(RadioReveil.Mode.SET_TIME);
    assertEquals("Avance l'heure du cadran...", radio.onRightArrowButtonPress());

    radio.onSwitchMode(RadioReveil.Mode.SET_ALARM);
    assertEquals("Avance l'heure de l'alarme...", radio.onRightArrowButtonPress());
  }
}
