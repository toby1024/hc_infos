package work.variety.hc_infos.entity;

public enum InfoStatusEnum {
    ACTIVE(1), ARCHIVED(0), EXPIRY(-1);

    private int status;

    private InfoStatusEnum(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }

}
