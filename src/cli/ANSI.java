package cli;

public enum ANSI {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m");

    public final String value;

    private ANSI(String value) {
        this.value = value;
    }

}
