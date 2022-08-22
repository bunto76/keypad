import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Keypad challenge. Adjacent keys are easy to dial.
 * @author ciaran.bunting@oracle.com
 */
public class Keypad {

  /** Map of adjacency keypad data. */
  Map<String, List<String>> adjacencyMap = Map.ofEntries(
    new AbstractMap.SimpleEntry<>("0", List.of("7","8","9","*")),
    new AbstractMap.SimpleEntry<>("1", List.of("2","4","5")),
    new AbstractMap.SimpleEntry<>("2", List.of("1","3","4","5","6")),
    new AbstractMap.SimpleEntry<>("3", List.of("2","5","6")),
    new AbstractMap.SimpleEntry<>("4", List.of("1","2","5","7","8")),
    new AbstractMap.SimpleEntry<>("5", List.of("1","2","3","4","6","7","8","9")),
    new AbstractMap.SimpleEntry<>("6", List.of("2","3","5","8","9")),
    new AbstractMap.SimpleEntry<>("7", List.of("0","4","5","8","*")),
    new AbstractMap.SimpleEntry<>("8", List.of("0","4","5","6","7","9","*","#")),
    new AbstractMap.SimpleEntry<>("9", List.of("0","5","6","8","#")),
    new AbstractMap.SimpleEntry<>("*", List.of("0","7","8")),
    new AbstractMap.SimpleEntry<>("#", List.of("0","8","9"))
  );

  /**
   * Returns true when an array of keys is easy to dial in sequence.
   * @param keys the keys.
   * @return true when an array of keys is easy to dial in sequence.
   */
  public boolean isEasyToDial(String[] keys) {
    if (keys == null || keys.length == 0) return false;

    String previousKey = null;
    for (String currentKey: keys) {
      if (null != previousKey && !previousKey.equals(currentKey) && !isAdjacent(previousKey, currentKey)) {
        return false;
      }
      previousKey = currentKey;
    }
    return true;
  }

  /**
   * Returns true if the second key is adjacent to the first.
   * @param firstKey the first key.
   * @param secondKey the second key.
   * @return true if the second key is adjacent to the first.
   */
  public boolean isAdjacent(String firstKey, String secondKey) {
    if (adjacencyMap.containsKey(firstKey)) {
      return adjacencyMap.get(firstKey).contains(secondKey);
    }
    return false;
  }

  /**
   * Main.
   * @param args command line arguments. Not used.
   */
  public static void main(String[] args) {
    Keypad keypad = new Keypad();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Hi, enter some keys in the keypad:");
    while (scanner.hasNext()) {
      String keys = scanner.nextLine();
      if (keys.equals("exit")) break;

      if (keypad.isEasyToDial(keys.split(""))) {
        System.out.printf("Nice! %s is easy to dial.%n", keys);
      } else {
        System.out.printf("%s is not easy to dial :(%n", keys);
      }
    }
  }
}
