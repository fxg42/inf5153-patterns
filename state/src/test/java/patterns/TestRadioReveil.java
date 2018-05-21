package patterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestRadioReveil {

  @Test void it_should_switch_modes() {
    var radio = new RadioReveil();
    radio.onLeftArrowButtonPress();
    radio.onSwitchMode(RadioReveil.Mode.SET_TIME);
    radio.onLeftArrowButtonPress();
    radio.onSwitchMode(RadioReveil.Mode.SET_ALARM);
    radio.onLeftArrowButtonPress();
    radio.onSwitchMode(RadioReveil.Mode.NORMAL);
    radio.onLeftArrowButtonPress();
  }
}
