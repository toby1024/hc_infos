package work.variety.hc_infos.entity;

public enum InfoCategoryEnum {
    REQUEST(1), SERVICE(2);

    private int category;

    private InfoCategoryEnum(int category){
        this.category = category;
    }

    public int getCategory(){
        return category;
    }
}
