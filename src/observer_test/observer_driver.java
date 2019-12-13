package observer_test;


import java.io.Console;
import java.util.ArrayList;

class ConcreteSubject implements Subject
{
    private boolean SubjectState;
    ArrayList<Observer> observers = new ArrayList<Observer>();


    @Override
    public void attach(Observer ob)
    {
        observers.add(ob);
    }

    @Override
    public void detach(Observer ob)
    {
        observers.remove(ob);
    }

    @Override
    public void Notify()
    {
        for (Observer ob :observers)
        {
            ob.update();
        }
    }

    public boolean getSubjectstate()
    {
        return SubjectState;
    }

    public void setSubjectstate(boolean value)
    {
        SubjectState = value;
    }

}

class ConcreteObserver implements Observer
{
    private boolean ObserverState;
    private ConcreteSubject subject;
    public ConcreteObserver(ConcreteSubject subject)
    {
        this.ObserverState = false;
        this.subject = subject;
    }

    @Override
    public void update()
    {
        this.ObserverState = subject.getSubjectstate();
    }

    public boolean getObserverstate()
    {
        return  ObserverState;
    }

    public void setObserverState(boolean value)
    {
        ObserverState = value;
    }

}

public class observer_driver
{
    public static void main(String[] args)
    {
        ConcreteSubject sb1 = new ConcreteSubject();
        ConcreteObserver ob1 = new ConcreteObserver(sb1);
        ConcreteObserver ob2 = new ConcreteObserver(sb1);

        sb1.attach(ob1);
        sb1.attach(ob2);

        ob1.setObserverState(false);
        ob2.setObserverState(false);
        sb1.setSubjectstate(true);

        System.out.println("before:");
        System.out.println("ob1:" + ob1.getObserverstate());
        System.out.println("ob2:" + ob2.getObserverstate());

        sb1.Notify();
        System.out.println("after:");
        System.out.println("ob1:" + ob1.getObserverstate());
        System.out.println("ob2:" + ob2.getObserverstate());

    }
}
