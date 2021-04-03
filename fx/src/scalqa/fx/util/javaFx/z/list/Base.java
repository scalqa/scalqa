package scalqa.fx.util.javaFx.z.list;

import scalqa.val.Stream;

public abstract class Base<A> extends java.util.AbstractList<A> implements javafx.collections.ObservableList<A> {

    public boolean addAll(A... v){ return addStream(null); }
    public boolean addStream(Stream<A> v){ throw new UnsupportedOperationException(); }

    public boolean removeAll(A... v){ return removeStream(null); }
    public boolean removeStream(Stream<A> v){ throw new UnsupportedOperationException(); }
    public void    remove(int v1, int v2){ throw new UnsupportedOperationException(); }

    public boolean setAll(A... v){ return setStream(null); }
    public boolean setStream(Stream<A> v){ throw new UnsupportedOperationException(); }
    public boolean setAll(java.util.Collection<? extends A> v){ throw new UnsupportedOperationException(); }

    public boolean retainAll(A... v){ return retainStream(null); }
    public boolean retainStream(Stream<A> v){ throw new UnsupportedOperationException(); }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/