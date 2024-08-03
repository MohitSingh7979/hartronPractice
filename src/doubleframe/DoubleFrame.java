package doubleframe;

public class DoubleFrame {

  public static void main(String[] args) {
    m();
  }

  static void m() {
    Something s = new Something();
    render(s);
  }

  private static void render(Something s) {
    System.out.println(s);
  }

  private static class Something {

    public Something() {
    }
  }

}
