package work.variety.hc_infos.entity;

public enum UserStatusEnum {
    ACTIVE(1), ARCHIVED(0);

    private int status;

    private UserStatusEnum(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
}
