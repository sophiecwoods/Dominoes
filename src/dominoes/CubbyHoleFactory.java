package dominoes;

public class CubbyHoleFactory {

    static CubbyHole cubbyHole = null;

    public static CubbyHole getCubbyHole() {
        if (cubbyHole == null) {
            cubbyHole = new CubbyHole();
        }
        return cubbyHole;
    }

}
