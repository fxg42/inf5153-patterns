package patterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestRadioReveil {

  @Test void it_should_switch_modes() {
    var radio = new RadioReveil();
    radio.onRightArrowButtonPress();

    radio.onSwitchMode(RadioReveil.Mode.SET_TIME);
    radio.onRightArrowButtonPress();

    radio.onSwitchMode(RadioReveil.Mode.SET_ALARM);
    radio.onRightArrowButtonPress();
    
    radio.onSwitchMode(RadioReveil.Mode.NORMAL);
    radio.onRightArrowButtonPress();
  }
}
