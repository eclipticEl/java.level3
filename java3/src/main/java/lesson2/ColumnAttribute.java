package lesson2;

public class ColumnAttribute {
    private String name;
    private String type;
    private String addOptions;

    public ColumnAttribute(String name, String type, String addOptions) {
        this.name = name;
        this.type = type;
        this.addOptions = addOptions;
    }

    public ColumnAttribute(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAddOptions() {
        return addOptions;
    }
}
