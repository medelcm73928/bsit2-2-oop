// Exportable.java
// An INTERFACE = a list of promises. It says WHAT, never HOW.
public interface Exportable {

    // TODO 1:
    String toCsv();

    // TODO 2:
    default void printExport() {
        System.out.println(toCsv());
    }
}