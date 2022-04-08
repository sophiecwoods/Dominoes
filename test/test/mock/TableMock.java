package test.mock;

import dominoes.Bone;
import dominoes.Table;

import java.util.Vector;

public class TableMock extends Table {

    Vector _layout;

    public TableMock(Vector layout) {
        _layout = layout;
    }

    @Override
    public int left() {
        return ((Bone)this._layout.firstElement()).left();
    }

    @Override
    public int right() {
        return ((Bone)this._layout.lastElement()).right();
    }

}
