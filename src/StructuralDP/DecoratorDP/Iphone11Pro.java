package StructuralDP.DecoratorDP;

public class Iphone11Pro extends PhoneDecorator{
    public Iphone11Pro(IPhone basicPhone) {
        super(basicPhone);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+ 100;
    }

    @Override
    public String getName() {
        return super.getName()+" 11 pro";
    }
}
