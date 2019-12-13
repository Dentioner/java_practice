package observer_test;

import java.util.ArrayList;
import java.util.List;

public interface Subject
{
    void attach(Observer ob);
    void detach(Observer ob);
    void Notify();
}
