package christmas.entity.gift;

public enum Badge {
    STAR("별",5000),
    TREE("트리",10000),
    SANTA("산타",20000);
    private final String name;
    private final Integer min;
    Badge(String name,Integer min){
        this.name = name;
        this.min = min;
    }
    public static Badge publishBadge(Integer totalDiscount){
        Badge badge = null;
        for(Badge i:Badge.values()){
            if(i.min<=totalDiscount){
                badge = i;

            }
        }
        return badge;
    }
    public String getName(){
        return this.name;
    }
}
