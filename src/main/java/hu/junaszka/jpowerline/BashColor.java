package hu.junaszka.jpowerline;

public class BashColor {

  public static String foreground(int color) {
    return "\\[\\e[38;5;"+color+"m\\]";
  }

  public static String background(int color) {
    return "\\[\\e[48;5;"+color+"m\\]";
  }
}
