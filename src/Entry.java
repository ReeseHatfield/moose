public class Entry {
    private final int rank;
    private final String name;
    // enum prevents this from being a record unfortunetly
    private final Sex sex;
    private final int occurrences;

    public Entry(int rank, String name, Sex sex, int occurrences) {
        this.rank = rank;
        this.name = name;
        this.sex = sex;
        this.occurrences = occurrences;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getOccurrences() {
        return occurrences;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", occurrences=" + occurrences +
                '}';
    }
}
