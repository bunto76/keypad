import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Keypad Tests.
 * @author ciaranbunting@gmail.com
 */
public class KeypadTest {

  @Test
  public void shouldReturnTrueWhenKeysAdjacent() {
    Keypad keypad = new Keypad();
    assertTrue(keypad.isAdjacent("2","1"));
    assertTrue(keypad.isAdjacent("5","6"));
    assertTrue(keypad.isAdjacent("0","8"));
  }

  @Test
  public void shouldReturnFalseWhenKeysNotAdjacent() {
    Keypad keypad = new Keypad();
    assertFalse(keypad.isAdjacent("3","1"));
    assertFalse(keypad.isAdjacent("1","9"));
    assertFalse(keypad.isAdjacent("0","6"));
  }

  @Test
  public void shouldReturnTrueWhenEasyToDial() {
    Keypad keypad = new Keypad();
    assertTrue(keypad.isEasyToDial(new String[]{"5","5","6","9"}));
    assertTrue(keypad.isEasyToDial(new String[]{"7","5","9","6"}));
    assertTrue(keypad.isEasyToDial(new String[]{"1","4","5","2"}));
  }

  @Test
  public void shouldReturnFalseWhenNotEasyToDial() {
    Keypad keypad = new Keypad();
    assertFalse(keypad.isEasyToDial(new String[]{"5","5","6","7"}));
    assertFalse(keypad.isEasyToDial(new String[]{"1","8","0","9"}));
    assertFalse(keypad.isEasyToDial(new String[]{"6","9","0","2"}));
  }
}
