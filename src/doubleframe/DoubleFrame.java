package doubleframe;

public class DoubleFrame {

  public static void main(String[] args) {
    m();
  }

  static void m() {
    Something s = new Something();
    System.out.println(s);
  }


  private static class Something {

    public Something() {
    }
  }

}
