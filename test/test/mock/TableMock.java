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

    @Override
    public Bone[] layout() {
        Bone[] var1 = new Bone[this._layout.size()];

        for(int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = (Bone)this._layout.elementAt(var2);
        }

        return var1;
    }

}
