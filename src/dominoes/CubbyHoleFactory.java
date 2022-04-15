package dominoes;

public class CubbyHoleFactory {

    private static CubbyHole cubbyHole = null;

    private CubbyHoleFactory() {

    }

    public static CubbyHole getCubbyHole() {
        if (cubbyHole == null) {
            cubbyHole = new CubbyHole();
        }
        return cubbyHole;
    }
}
