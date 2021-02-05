package poc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoublePredicate;

public class Generic1 {

  public static void main(String[] args) {

    simpleGeneric();
    printDefaultStringRepresentation("1234");
    printDefaultStringRepresentation(1234);

    List<Integer> lstInt = new ArrayList<>();
    lstInt.add(5);
    lstInt.add(8);

    upperBoundExample(lstInt);

    List<Object> obj = new ArrayList<>();
    obj.add("string");
    lowerBoundExample(obj);
  }

  public static void simpleGeneric() {
    List<String> listofString = new ArrayList<>();
    listofString.add("firstString");
    listofString.add("secondString");

    for (String element : listofString) {
      System.out.println(element);
    }
  }

  /**
   * example to show that a method can be generic, when the containing class is
   * note that this requires declaring the generic type to be declared prior to
   * return type
   */
  public static <E> void printDefaultStringRepresentation(E element) {
    System.out.println(element);
  }

  private static void demystifyingSubclassingAssumption() {

    // won't compile

    List<String> firstList = new ArrayList<>();
    List<Object> parentList = new ArrayList<>();

    // this works as Object is a parent of String
    firstList.add("someString");
    parentList.add("String");

    // however, following will not work, as List<Object> is NOT a parent of
    // List<String>
    // parentList = firstList;

    // now
    String secondString = "secondString";
    Object parent = secondString;

    // won't work
    // firstList.add(parent);
  }

  /**
   * wildcard PoC
   */
  public static void upperBoundExample(List<? extends Number> acceptAllList) {
    // acceptAllList.add(new Integer(4)); adding to upper bound powered list is
    // prohibited; the reason being, at this point, if compiler would have
    // allowed to add, and we retrieved, compiler would not have a clue how to
    // downcast it because the type has already been erased

    // however getting from an upper bound powered list is acceptable
    // Producer Extends - principle
    System.out.println(acceptAllList.stream().mapToDouble(Number::doubleValue)
        .allMatch(new DoublePredicate() {

          @Override
          public boolean test(double value) {
            // TODO Auto-generated method stub
            return false;
          }
        }));

    Number num = acceptAllList.get(0); // acceptable, as whatever comes out of
                                       // the list is bound to be casted into
                                       // number
  }
  
  public static void lowerBoundExample(List<? super Integer> consumer) {
    consumer.add(4);
    // Consumer Super - principle
  }
  


}
