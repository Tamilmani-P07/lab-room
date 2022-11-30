public class CalculateBMI {
    private float weight;
    private float height;

    public CalculateBMI() {
        
    }
    
    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getBMI(){
        float bmi=getWeight()/(getHeight());
        //System.out.println(bmi);
        if(bmi<18.5)
        return"---your under Weight---";
        else if(bmi>30)
       return"---your over Weight---";
        else 
       return"---your normal---";
    }
}
