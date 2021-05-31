package userIHM;

public class Equipment {
    private String equip_type;
    private String description;

    public Equipment(String equip_type, String description) {
        this.equip_type = equip_type;
        this.description = description;
    }

    public String getEquip_type() {
        return equip_type;
    }

    public void setEquip_type(String equip_type) {
        this.equip_type = equip_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
