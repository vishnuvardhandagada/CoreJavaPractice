package core.java.dynamic.proxies.model;

public class Circle implements IShape {

    @Override
    public void draw(int xCoordinate, int yCoordinate) {
	System.out.println("Circle -> draw(" + xCoordinate + ", " + yCoordinate + ")");
    }

    @Override
    public void move() {
	System.out.println("Circle -> move()");
    }

    @Override
    public void resize() {
	System.out.println("Circle -> resize()");
    }

}
