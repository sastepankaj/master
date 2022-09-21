package designpattern.creational.factory;

public interface DatabaseDriver {

    public void connect();

    public void query();

    public void close();

}