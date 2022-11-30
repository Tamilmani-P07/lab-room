class Car{
    public String colour;
    public String brand;
    public int price;
    Car(String c,String b,int p){
        this.colour=c;
        this.brand=b;
        this.price=p;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return " "+colour+" "+brand+" "+price;
    }

}
