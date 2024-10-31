package api;

public class ColorsData {
    public Integer id;
    public String name;
    public Integer year;
    public String color;
    public String pantone_value;

    public ColorsData() {}
    public ColorsData(Integer id, String pantone_value, String name, Integer year, String color) {
        this.id = id;
        this.pantone_value = pantone_value;
        this.name = name;
        this.year = year;
        this.color = color;
    }

    public String getPantone_value() {
        return pantone_value;
    }

    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
